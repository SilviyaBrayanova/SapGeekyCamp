public class PostMark {
	boolean stamped;
	public boolean isStamped() {
		return stamped;
	}
	public void setStamped(boolean stamped) {
		this.stamped = stamped;
	}
	public boolean isBlockmark() {
		return blockmark;
	}
	public void setBlockmark(boolean blockmark) {
		this.blockmark = blockmark;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public PostMark(boolean stamped, boolean blockmark, int year, String country) {
		super();
		this.stamped = stamped;
		this.blockmark = blockmark;
		this.year = year;
		this.country = country;
	}
	boolean blockmark;
	int year;
	String country;
}
