<%
	if(session.getAttribute("prenom")==null){
		response.sendRedirect("login.jsp");
	}else {	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.1

		response.setHeader("Pragma", "no-cache");//Http 1.0

		response.setDateHeader("Expires", 0);
		
		
	}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Mutuelle de santé | OpenAssu</title>
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
<!-- Inserer username venant du DB    -->     <span class="user-avatar"><%=session.getAttribute("prenom") %>
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
 <!-- Inserer username venant du DB    --> <h1>Hello <%=session.getAttribute("prenom") %>,<span>Bienvenue sur OpenAssu</span></h1>
                            </div>
                        </div>
                    </div>
                    <!-- /# column -->
                    <div class="col-lg-4 p-l-0 title-margin-left">
                        <div class="page-header">
                            <div class="page-title">
                                <ol class="breadcrumb">
                                    <li class="breadcrumb-item"><a href="index.jsp">Tableau de bord</a></li>
                                    <li class="breadcrumb-item active">Ajout assureur</li>
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
                                 <c:if test="${mutuelle != null}">
                            	<form action="updateM" method="post">
                            </c:if>
                             <c:if test="${mutuelle == null }">
                            	<form action="insertM" method="post">
                            </c:if>
                                <div class="card-title text-center">
                                   <!--  <h3>Ajout d'un client</h3> -->
                                    <caption>
                                    	<h3>
                                    	<c:if test="${mutuelle != null }">
                                    	Modification mutuelle
                                    	</c:if>
                                    	<c:if test="${mutuelle == null }">
                                    	Ajout mutuelle
                                    	    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
                                    	</c:if>
                                    	</h3>
                                    </caption>
                                </div>
                                <div class="card-body">
                                    <div class="horizontal-form">
                                     
                                        <form>
          
            <div class="form-group row">
<!--                 <label for="" class="col-sm-2 col-form-label">MutuelleID*</label> -->
                   <div class="col-sm-2">
                    	<c:if test="${mutuelle != null }">
                        <input type="hidden" class="form-control" name="mutuelleID"  value="<c:out value='${mutuelle.mutuelleID}' />" />
                   		</c:if>
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Nom mutuelle*</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="nomMutuelle"   value="<c:out value='${mutuelle.nomMutuelle}' />" />
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Province*</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control"  name="province"   value="<c:out value='${mutuelle.province}' />" />
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Ville*</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="ville"   required  value="<c:out value='${mutuelle.ville}' />" />
                    </div>
            </div>
          
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Mutuelle couvert*</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control"  name="mutuelleCouvert"    required  value="<c:out value='${mutuelle.mutuelleCouvert}' />" />
                    </div>
            </div>
        
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Date debut*</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control"  name="dateEntre"  required  value="<c:out value='${mutuelle.dateEntre}' />" />
                    </div>
            </div>
             <!-- 
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Date fin</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" id="assureur" placeholder="">
                    </div>
            </div> -->

           
            <div class="m-l-150">
                                
                        <button type="submit" name="Ajouter" class="btn btn-primary btn-flat btn-addon m-b-10 m-l-5"><i class="ti-plus"></i>Ajouter</button>
                        <button type="button" name="Annuler"  class="btn btn-danger btn-flat btn-addon m-b-10 m-l-5"><i class="ti-close"></i>Annuler</button>


                            </div>

                            
        </form> 
                                    </div>
                                </div>
            <br>

            <p>*champs obligatoires</p>



                            </div>
                        </div>
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
