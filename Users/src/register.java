import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connecting.ConnectionBuilder;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String passa = request.getParameter("pass");
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime()); 
		String sql = "INSERT INTO userdata (username, pass, admin, lastvisit)"
				+ "VALUES (?,?,?,?)";
		try {
			PreparedStatement pstmt = ConnectionBuilder.buildConnection().prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passa);
			pstmt.setBoolean(3, false);
			pstmt.setTimestamp(4,date);
			pstmt.execute();
			System.out.println("Succes");
		} catch (SQLException e) {
			System.out.println("Problem with database");
			e.printStackTrace();
		}
		
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}

}
