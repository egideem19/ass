<%@ page import = "java.sql.PreparedStatement"%>
<%@ page import = "java.sql.DriverManager"%>
<%@ page import ="java.sql.Connection"%>

<%
	
	String prenom = request.getParameter("prenom");
	String nom = request.getParameter("nom");
	String email = request.getParameter("email");
	String password = request.getParameter("password");
	String categorie = request.getParameter("categorie");
	String telephone = request.getParameter("telephone");
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/assur","root","");
		PreparedStatement pst = con.prepareStatement("insert into users(prenom,nom,email,password,categorie,telephone)value(?,?,?,?,?,?)");
		pst.setString(1,prenom);
		pst.setString(2,nom);
		pst.setString(3,email);
		pst.setString(4,password);
		pst.setString(5,categorie);
		pst.setString(6,telephone);
		int x = pst.executeUpdate();
		if(x>0){
			out.println("Client enregsitré");
		}else{
			out.println("Erreur d'enregistrement");
		}
	}catch(Exception e){
		out.println(e);
	}
	

%>