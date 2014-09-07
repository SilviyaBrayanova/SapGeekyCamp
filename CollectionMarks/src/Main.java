import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*Homework Collection of postalMarks
Notice* PostMarks, Anniversary, Series does not have names so they will
return as hashcodes.
 */
public class Main {
	public static ArrayList<Anniversary> AnnList = new ArrayList<Anniversary>();
	public static ArrayList<Series> SeriesL = new ArrayList<Series>();
	public static ArrayList<PostMark> all = new ArrayList<PostMark>();

	public static void main(String[] args) {
		List<PostMark> first = new ArrayList<PostMark>();
		ArrayList<PostMark> second = new ArrayList<PostMark>();
		PostMark j = new PostMark(false, false, 1999, " Russia");
		PostMark i = new PostMark(true, false, 1978, "Holland");
		PostMark b = new PostMark(false, true, 1989, "Mustang");
		PostMark a = new PostMark(true, true, 1973, "USA");
		PostMark ga = new PostMark(false, false, 1999, " Russia");
		PostMark ra = new PostMark(true, false, 1978, "Holland");
		PostMark za = new PostMark(false, true, 1989, "Mustang");
		PostMark da = new PostMark(true, true, 1973, "USA");
		first.add(j);
		first.add(i);
		second.add(b);
		second.add(a);
		all.add(j);
		all.add(i);
		all.add(b);
		all.add(a);
		Anniversary editionA = new Anniversary((ArrayList<PostMark>) first);
		Series editionB = new Series((ArrayList<PostMark>)second);
		/* How things look before using any functions */
		AnnList.add(editionA);
		SeriesL.add(editionB);
	
		/* After using functions */
		AddPostMarkBySeries(true, false, 1978, "Russia", editionB);
		System.out.println("List of post marks is: "+editionB.getList().toString());
		AddPostMarkByAnn(true, false, 1997, "USA", editionA);
		System.out.println("List of post marks is: "+editionA.getList().toString());
		sortByYear();
		sortByCountry();
		removeMarkByAnn(editionA, i);
		System.out.println("List of post marks in Anniversary pack is: "+first.toString());
		removeMarkBySerie(editionB, b);
		System.out.println("List of post in Series pack marks is: "+second.toString());
		AddNewAnniversary(da, za, ra, ga);
		System.out.println("List of Anniversary packs is: "+AnnList.toString());
		AddNewSeries(da, za, ra, ga);
		System.out.println("List of Series pack is: "+SeriesL.toString());
		removeFromAll(a);
		System.out.println("List of all post marks is: "+all.toString());
		
	}

	/*
	 * creates new PostMark with the given params, then gets the list of Series,
	 * loops trough it until finds the one we want, when finds the Serie we want
	 * it gets the list of PostMarks in it and adds our Mark and also add it in
	 * the main list of marks.
	 */
	public static void AddPostMarkBySeries(boolean stamped, boolean blockMark,
			int year, String country, Series serie) {
		PostMark newMark = new PostMark(stamped, blockMark, year, country);
		for (int i = 0; i < SeriesL.size(); i++) {
			if (serie.equals(SeriesL.get(i))) {
				serie.getList().add(newMark);
				all.add(newMark);
			}
		}
	}

	/*
	 * Does the same as "AddPostMarkBySeries" but adds it into Anniversary
	 * packet
	 */
	public static void AddPostMarkByAnn(boolean stamped, boolean blockmark,
			int year, String country, Anniversary anniversaryedition) {
		PostMark newMark = new PostMark(stamped, blockmark, year, country);
		for (int j = 0; j < AnnList.size(); j++) {
			if (anniversaryedition.equals((AnnList.get(j)))) {
				anniversaryedition.getList().add(newMark);
				all.add(newMark);
			}
		}
	}

	/*
	 * Add a new Series object to the list of Series objects "SeriesL"
	 */
	public static void AddNewSeries(PostMark mark1, PostMark mark2,
			PostMark mark3, PostMark mark4) {
		ArrayList<PostMark> newList = new ArrayList<PostMark>();
		newList.add(mark4);
		newList.add(mark3);
		newList.add(mark1);
		newList.add(mark2);
		Series newSerie = new Series(newList);
		SeriesL.add(newSerie);
	}

	/*
	 * Add a new Anniversary packet
	 */
	public static void AddNewAnniversary(PostMark mark1, PostMark mark2,
			PostMark mark3, PostMark mark4) {
		ArrayList<PostMark> newList = new ArrayList<PostMark>();
		newList.add(mark4);
		newList.add(mark3);
		newList.add(mark1);
		newList.add(mark2);
		Anniversary newSerie = new Anniversary(newList);
		AnnList.add(newSerie);
	}

	/*
	 * Makes new ArrayList<String>, loops trough the main list of marks(all
	 * marks are there) and adds their countries in the new ArrayList, then
	 * sorts it and output it on screen
	 */
	public static void sortByCountry() {
		ArrayList<String> countries = new ArrayList<String>();
		for (int i = 0; i < all.size(); i++) {
			countries.add(all.get(i).getCountry());
			Collections.sort(countries);
		}
		System.out.println(countries.toString());
	}

	/* Uses the same logic as for sortByCountry but sorts by year */
	public static void sortByYear() {
		ArrayList<Integer> year = new ArrayList<Integer>();
		for (int i = 0; i < all.size(); i++) {
			year.add(all.get(i).getYear());
			Collections.sort(year);
		}
		System.out.println(year.toString());
	}

	/*
	 * It's the same as the addMarkByAnn but instead of add it deletes the mark
	 */
	public static void removeMarkByAnn(Anniversary AnnName, PostMark postMark) {
		for (int i = 0; i < AnnList.size(); i++) {
			if (AnnName.equals(AnnList.get(i))) {
				for (int j = 0; j < AnnName.getList().size(); j++) {
					if (postMark.equals(AnnName.getList().get(j))) {
						AnnName.getList().remove(postMark);
					}
				}
			}
		}
	}

	/*
	 * Same as above but for Series
	 */

	public static void removeMarkBySerie(Series SerieName, PostMark postMark) {
		for (int i = 0; i < SeriesL.size(); i++) {
			if (SerieName.equals(SeriesL.get(i))) {
				for (int j = 0; j < SerieName.getList().size(); j++) {
					if (postMark.equals(SerieName.getList().get(j))) {
						SerieName.getList().remove(postMark);

					}
				}
			}
		}
	}

	public static void removeFromAll(PostMark postmark) {
		for (int j = 0; j < all.size(); j++) {
			if (postmark.equals(all.get(j))) {
				all.remove(j);
			}
		}
	}
}