package open.registrer;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class registrerServelt
 */

public class registrerServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String categorie = request.getParameter("categorie");
		String telephone = request.getParameter("telephone");
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assur?useSSL=false","root","");
			PreparedStatement pst = (PreparedStatement) con.prepareStatement("insert into users(prenom,nom,email,password,categorie,telephone)value(?,?,?,?,?,?)");
			pst.setString(1,prenom);
			pst.setString(2,nom);
			pst.setString(3,email);
			pst.setString(4,password);
			pst.setString(5,categorie);
			pst.setString(6,telephone);
			int rowCount = pst.executeUpdate();
			dispatcher = request.getRequestDispatcher("registrer.jsp");
			if(rowCount > 0 ) {
				request.setAttribute("status","success");
				
			} else {
				request.setAttribute("status","failed");
			}
			dispatcher.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();							
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
