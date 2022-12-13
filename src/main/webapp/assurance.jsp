
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@  taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@  taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%
	if(session.getAttribute("prenom")==null){
		response.sendRedirect("login.jsp");
	}
	else {	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.1

		response.setHeader("Pragma", "no-cache");//Http 1.0

		response.setDateHeader("Expires", 0);
		
		
	}
%>
    
    


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Assurance | OpenAssu </title>
<link href="css/lib/calendar2/pignose.calendar.min.css" rel="stylesheet">
<link href="css/lib/chartist/chartist.min.css" rel="stylesheet">
<link href="css/lib/font-awesome.min.css" rel="stylesheet">
<link href="css/lib/themify-icons.css" rel="stylesheet">
<link href="css/lib/owl.carousel.min.css" rel="stylesheet" />
<link href="css/lib/owl.theme.default.min.css" rel="stylesheet" />
<link href="css/lib/weather-icons.css" rel="stylesheet" />
<link href="css/lib/menubar/sidebar.css" rel="stylesheet">
<link href="css/lib/bootstrap.min.css" rel="stylesheet">
<link href="css/lib/helper.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/lib/sweetalert/sweetalert.css" rel="stylesheet">
</head>

<%@ page import="java.io.*" %>

<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<body>
    <!-- /# debut menu  principal -->
    <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
                    <div class="logo"><a href="index.jsp">
                            <!-- <img src="images/logo.png" alt="" /> --><span>OpenAssu</span></a></div>
                   
                    <li><a  href="index.jsp"><i class="ti-home"></i> Tableau de bord </a></li>

                     <li><a href="<%=request.getContextPath() %>/list"><i class="ti-user"></i> Client </a></li>

                    <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid2 "></i> Assurance <span
                                class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/listA">Assurance maladie</a></li>
                            <li><a href="<%=request.getContextPath()%>/listM">Mutuelle de santé</a></li>
                            <li><a href="#">Autre</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="ti-settings"></i> Paramètres </a></li>
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
<!-- Inserer username venant du DB    -->   <span class="user-avatar"><%=session.getAttribute("prenom") %>
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
 <!-- Inserer username venant du DB    --> <h1>Hello <%=session.getAttribute("prenom") %> <span>Bienvenue sur OpenAssu</span></h1>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-l-0 title-margin-left">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.jsp">Tableau de bord</a></li>
                                    <li class="breadcrumb-item active">Assurance maladie</li>
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
                 <div class="inbox-head">
                            <h3 class="input-text">Assurance maladie</h3>
                            <form action="#" class="pull-right position">
                              <div class="input-append inner-append">
                                <input type="text" class="sr-input" placeholder="tapez l'assuranceID">
                                <button class="btn sr-btn append-btn" type="button"><i class="fa fa-search"></i></button>
                              </div>
                            </form>
                          </div>
                <div class="card-body">
                  <div class="row">
                    <div class="col-lg-3">
                      <a href="<%=request.getContextPath()%>/newA"   class="btn btn-lg btn-primary btn-block waves-effect waves-light">
                        <i class="fa fa-plus"></i> Nouvel assurance
                      </a>
                     
                   
                    </div>
                   
                  
                </div>
              </div>
              
              <!-- /# card -->

     <div class="col-lg-12">
                            <div class="card">
                                <div class="card-title">
                                    <h4>Liste des assurances</h4>
                                    
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-hover ">
                                            <thead>
                                                <tr>
                                                    <th>AssuranceID</th>
                                                    <th>Nom assureur</th>
                                                    
                                                    <th>Assurance couvert</th>
                                                      <th>Date debut</th>
                                                        <th>Date fin</th>
                                                    <th>Action</th>
                                                    
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                            	<c:forEach var="assurance" items="${listAssurance}" >
                                                <tr>
                                                    <td><c:out value="${assurance.assuranceID}"/></td>
                                                	<td><c:out value="${assurance.nomAssureur}"/></td>
                                                
                                                	<td><c:out value="${assurance.assuranceCouvert}"/></td>
                                                	<td><c:out value="${assurance.dateDebut}"/></td>
                                                	<td><c:out value="${assurance.dateFin}"/></td>
                                                	
                                                	<td><a href="editA?assuranceID=<c:out value='${assurance.assuranceID}'/>">Modifier</a>
                                                		&nbsp; &nbsp; &nbsp; &nbsp; 
                                                		<a href="deleteA?assuranceID=<c:out value='${assurance.assuranceID}'/>">Supprimer</a>
                                                	 </td>
                                                </tr>
                                                  </c:forEach>
                                             
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
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
</body>

</html>