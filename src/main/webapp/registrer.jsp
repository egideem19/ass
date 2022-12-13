<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@  taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@  taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>




<%
	if(session.getAttribute("prenom")==null){
		response.sendRedirect("login.jsp");
	}else {	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.1

		response.setHeader("Pragma", "no-cache");//Http 1.0

		response.setDateHeader("Expires", 0);
		
		
	}
%>
    
 <%@ page import="java.io.*" %>

<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Enregistrement d'un utilisateur | OpenAssu</title>
<link href="css/lib/calendar2/pignose.calendar.min.css" rel="stylesheet">
<link href="css/lib/chartist/chartist.min.css" rel="stylesheet">
<link href="css/lib/font-awesome.min.css" rel="stylesheet">
<link href="css/lib/themify-icons.css" rel="stylesheet">
<link href="css/lib/owl.carousel.min.css" rel="stylesheet" />
<link href="css/lib/owl.theme.default.min.css" rel="stylesheet" />
<link href="css/lib/weather-icons.css" rel="stylesheet" />
<link href="css/lib/menubar/sidebar.css" rel="stylesheet">
<link href="css/lib/bootstrap.min.css" rel="stylesheet">
<link href="css/lib/sweetalert/sweetalert.css" rel="stylesheet">

<link href="css/lib/helper.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
</head>
<body>

 
 <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
                    <div class="logo"><a href="index.jsp">
                            <!-- <img src="images/logo.png" alt="" /> --><span>OpenAssu</span></a></div>
                   
                    <li><a  href="index.jsp"><i class="ti-home"></i> Tableau de bord </a></li>

                   <li><a href="<%=request.getContextPath()%>/list"><i class="ti-user"></i> Client </a></li>

                    <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid2 "></i> Assurance <span
                                class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/listA">Assurance maladie</a></li>
                            <li><a href="<%=request.getContextPath()%>/listM">Mutuelle de santé</a></li>
                            <li><a href="#">Autre</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="ti-settings"></i> Paramètres </a></li>
                    <li><a href="#"><i class="ti-link"></i> Autres</a></li>
                   <li><a href="<%=request.getContextPath()%>/listU"><i class="ti-user"></i> Utilisateurs</a></li>
                    <li><a href="logout"><i class="ti-close"></i> Logout</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- /# Fin menu  principal -->

    <!-- /# debut header -->    

    <div class="header">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-12">
                    <div class="float-left">
                        <div class="hamburger sidebar-toggle">
                            <span class="line"></span>
                            <span class="line"></span>
                            <span class="line"></span>
                        </div>
                    </div>
                    <div class="float-right">
                        
                        
                        <div class="dropdown dib">
                            <div class="header-icon" data-toggle="dropdown">
<!-- Inserer username venant du DB    -->    <span class="user-avatar"><%=session.getAttribute("prenom") %>
                                    <i class="ti-angle-down f-s-10"></i>
                                </span>
                                <div class="drop-down dropdown-profile dropdown-menu dropdown-menu-right">
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li>
                                                <a href="#">
                                                    <i class="ti-user"></i>
                                                    <span>Profile</span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#">
                                                    <i class="ti-power-off"></i>
                                                    <span>Logout</span>
                                                </a>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div> 
            </div>
        </div>
    </div>
<!-- /#fin header -->

    <div class="content-wrap">
        <div class="main">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-8 p-r-0 title-margin-right">
                        <div class="page-header">
                            <div class="page-title">
 <!-- Inserer username venant du DB    --> <h1>Hello <%=session.getAttribute("prenom") %>, <span>Bienvenue sur OpenAssu</span></h1>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-l-0 title-margin-left">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.jsp">Tableau de bord</a></li>
                                    <li class="breadcrumb-item active">Enregistrement</li>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                </div>
                <!-- /# row -->
                
           </div>        
           <section id="main-content">          
          <div class="row">
            <div class="col-lg-12">
              <div class="card">
               <c:if test="${user != null}">
                            	<form action="updateU" method="post">
                            </c:if>
                             <c:if test="${user == null }">
                            	<form action="insertU" method="post">
                            </c:if>
                 <div class="inbox-head">
                           <!--  <h3 class="input-text">Enregistrement d'un utilisateur</h3> -->
                            		
                            		<caption>
                                    	<h3>
                                    	<c:if test="${user != null }">
                                    	Modification user
                                    	</c:if>
                                    	<c:if test="${user == null }">
                                    	Ajout user
                                    	    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
                                    	</c:if>
                                    	</h3>
                                    </caption>
                           
                          </div>
               
              
              <!-- /# card -->

     <div class="col-lg-12">
                           
            <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                       
                    
                        <form  method="POST"  class="register-form" >
                           
                            <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
                           <div class="form-group">
                                    <div class="row">
                                                   
                                        <div class="col-sm-6">
                                             <div class="input-group">
                                                   <c:if test="${user != null }"> 
                                                    <input type="hidden" name="idUser"   class="form-control"    value="<c:out value='${user.idUser}' />" />
                                                    </c:if>
                                             </div>
                                                                       
                                         </div>
                                    </div>
                            </div>
                           
                           
                            <div class="form-group">
                                    <div class="row">
                                                   
                                        <div class="col-sm-6">
                                             <div class="input-group">
                                                    <span class="input-group-addon"><i class="ti-user"></i></span>
                                                    <input type="text" name="prenom"   class="form-control"    placeholder="tapez votre prénom"  required   value="<c:out value='${user.prenom}' />" />
                                             </div>
                                                                       
                                         </div>
                                    </div>
                            </div>

                             <div class="form-group ">
                                    <div class="row">
                                                   
                                        <div class="col-sm-6">
                                             <div class="input-group">
                                                    <span class="input-group-addon"><i class="ti-user"></i></span>
                                                    <input type="text"  class="form-control" name="nom" placeholder="tapez votre nom"  required value="<c:out value='${user.nom}' />" />
                                             </div>
                                                                       
                                         </div>
                                    </div>
                            </div>


                             <div class="form-group ">
                                    <div class="row">
                                                   
                                        <div class="col-sm-6">
                                             <div class="input-group">
                                                    <span class="input-group-addon"><i class="ti-email"></i></span>
                                                    <input type="email" name="email"  class="form-control"  placeholder=" tapez votre adresse e-mail"  required value="<c:out value='${user.email}' />" />
                                             </div>
                                                                       
                                         </div>
                                    </div>
                            </div>


                             <div class="form-group ">
                                    <div class="row">
                                                   
                                        <div class="col-sm-6">
                                             <div class="input-group">
                                                    <span class="input-group-addon"><i class="ti-lock"></i></span>
                                                    <input  type="password" name="password"  class="form-control"   placeholder="tapez votre mot de passe"  required value="<c:out value='${user.password}' />" />
                                             </div>
                                                                       
                                         </div>
                                    </div>
                            </div>

                            


                            <div class="row">

                                <div class="col-sm-6">
                                     <div class="input-group">
                                    <span class="input-group-addon"><i class="ti-layers" ></i></span>
                                        <select class="form-control" name="categorie" required >

                                        
                                            		<option><c:out value='${user.categorie}' /></option>
                                                    <option>Administrateur systeme</option>
                                                    <option>Administration</option>
                                                    <option>Facturation</option>
                                                    <option>Client</option>

                                                
                                        </select>
                                        </div>
                                    </div>
                            </div>


                             <div class="form-group ">
                                    <div class="row">
                                                   
                                        <div class="col-sm-6">
                                             <div class="input-group">
                                                    <span class="input-group-addon"><i class="ti-mobile " ></i></span>
                                                    <input type="text" name="telephone" class="form-control" placeholder="tapez numéro de téléphone " required  value="<c:out value='${user.telephone}' />" />
                                             </div>
                                                                       
                                         </div>
                                    </div>
                            </div>


                            
                          <div class="">
                         
                        <button type="submit" name="Enregistrer"  class="btn btn-primary  btn-flat btn-addon m-b-10 m-l-20"><i class="ti-save"></i>Enregistrer</button>
                       
                        <button type="reset" name="Annuler"  class="btn btn-danger btn-flat btn-addon m-b-10 m-l-5"><i class="ti-close"></i>Annuler</button>


                            </div>
                                
                            
                        </form>
                    </div>
                   
                </div>
            </div>
        </section>




                            <!-- /# card -->
                        </div>

            </div>



            <!-- /# column -->
          </div>
          <!-- /# row -->
         
                    


                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer">
                                <p>Copyright © HiB's 2022 <a href="#">hibs-cd.com</a></p>
                            </div>
                        </div>
                    </div>
                </section>
            </div>

        </div>
   

    <!-- jquery vendor -->
    <script src="js/lib/jquery.min.js"></script>
    <script src="js/lib/jquery.nanoscroller.min.js"></script>
    <!-- nano scroller -->
    <script src="js/lib/menubar/sidebar.js"></script>
    <script src="js/lib/preloader/pace.min.js"></script>
    <!-- sidebar -->

    <script src="js/lib/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <!-- bootstrap -->

    <script src="js/lib/calendar-2/moment.latest.min.js"></script>
    <script src="js/lib/calendar-2/pignose.calendar.min.js"></script>
    <script src="js/lib/calendar-2/pignose.init.js"></script>


    <script src="js/lib/weather/jquery.simpleWeather.min.js"></script>
    <script src="js/lib/weather/weather-init.js"></script>
    <script src="js/lib/circle-progress/circle-progress.min.js"></script>
    <script src="js/lib/circle-progress/circle-progress-init.js"></script>
    <script src="js/lib/chartist/chartist.min.js"></script>
    <script src="js/lib/sparklinechart/jquery.sparkline.min.js"></script>
    <script src="js/lib/sparklinechart/sparkline.init.js"></script>
    <script src="js/lib/owl-carousel/owl.carousel.min.js"></script>
    <script src="js/lib/owl-carousel/owl.carousel-init.js"></script>
    <!-- scripit init-->
    <script src="js/dashboard2.js"></script>
    
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script src="js/lib/sweetalert/sweetalert.min.js"></script>
    <script src="js/lib/sweetalert/sweetalert.init.js"></script>
	
	
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if(status == "success"){
		swal("Felicitation", "Le compte a été ajouté avec succès", "success");
	}
	
	</script>
	
    
</body>
</html>