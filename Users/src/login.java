
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connecting.ConnectionBuilder;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public login() {
		super();

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String passw = request.getParameter("pass");
		String sql = "SELECT * FROM userdata where username=? AND pass=?";
		try {
			PreparedStatement pstmt = ConnectionBuilder.buildConnection()
					.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, passw);
			if (pstmt.execute()) {
				System.out.println("Succes");
			}
		} catch (SQLException e) {
			System.out.println("Problem with database");
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
