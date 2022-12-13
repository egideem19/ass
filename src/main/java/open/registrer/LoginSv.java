package open.registrer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginSv
 */

public class LoginSv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		//String categorie=request.getParameter("categorie");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con =  DriverManager.getConnection("jdbc:mysql://localhost:3306/assur?useSSL=false","root","");
			PreparedStatement pst = con.prepareStatement("select * from users where email=? and password=?");;
			pst.setString(1, email);
			pst.setString(2, password);
			//pst.setString(1,categorie);
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				session.setAttribute("prenom", rs.getString("prenom"));
				session.setAttribute("nom", rs.getString("nom"));
				dispatcher = request.getRequestDispatcher("index.jsp");
			}
			else{
				request.setAttribute("status","invalid");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			dispatcher.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
