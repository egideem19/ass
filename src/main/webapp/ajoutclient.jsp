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
<title>Ajout client | OpenAssu</title>
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
                                                <a href="logout">
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
                                    <li class="breadcrumb-item active"> <a href="<%= request.getContextPath() %>/list"></a>Client</li>
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
                            <c:if test="${client != null}">
                            	<form action="update" method="post">
                            </c:if>
                             <c:if test="${client == null }">
                            	<form action="insert" method="post">
                            </c:if>
                                <div class="card-title text-center">
                                   <!--  <h3>Ajout d'un client</h3> -->
                                    <caption>
                                    	<h3>
                                    	<c:if test="${client != null }">
                                    	Modification client
                                    	</c:if>
                                    	<c:if test="${client == null }">
                                    	Ajout client
                                    	    <input type="hidden" id="status" value="<%= request.getAttribute("status") %>">
                                    	</c:if>
                                    	</h3>
                                    </caption>
                                </div>
                                <div class="card-body">
                                    <div class="horizontal-form">
                                     
                                      
          
            <div class="form-group row">
              
                    <div class="col-sm-2">
                    	<c:if test="${client != null }">
                        <input type="hidden" class="form-control" name="clientID"  value="<c:out value='${client.clientID}' />" />
                   		</c:if>
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">NationalID</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="nationalID" value="<c:out value='${client.nationalID}' />" />
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">MedicalID</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" name="medicalID"   value="<c:out value='${client.medicalID}' />" />
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Nom*</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="nom"  required  value="<c:out value='${client.nom}' />" />
                    </div>
            </div>
          
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Prenom*</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="prenom"  required  value="<c:out value='${client.prenom}' />" />
                    </div>
            </div>
            
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Pays*</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="pays"  required  value="<c:out value='${client.pays}' />" />
                    </div>
            </div>
                
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Province</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="province" value="<c:out value='${client.province}' />" />
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Ville</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="ville" value="<c:out value='${client.ville}' />" />
                    </div>
            </div>
         
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Quartier</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="quartier" value="<c:out value='${client.quartier}' />" />
                    </div>
            </div>
          
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Territoire</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="territoire" value="<c:out value='${client.territoire}' />" />
                    </div>
            </div>
          
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Groupement</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="groupement" value="<c:out value='${client.groupement}' />" />
                    </div>
            </div>

            
         
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Date de naissance*</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" name="dateNaissance" required  value="<c:out value='${client.dateNaissance}' />" />
                    </div>
            </div> 

        
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Lieu de naissance</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" name="lieuNaissance" value="<c:out value='${client.lieuNaissance}' />" />
                    </div>
            </div>
         
            <div class="row">
                <label class="col-form-label col-sm-2 pt-0">Genre*</label>
                <div class="col-sm-4">
                        <select class="form-control" required  name="genre"  >
                            
                                    <option><c:out value='${client.genre}' /></option>
                                    <option>Homme</option>
                                    <option>Femme</option>
                                    <option>Autre</option>
                                
                                    </select>
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Etat civil*</label>
                    <div class="col-sm-4"   required  >
                        <select class="form-control" name="etatCivil">
                         			 <option><c:out value='${client.etatCivil}' /></option>
                                    <option>Celibataire</option>
                                    <option>Marié</option>
                                    <option>Autre</option>
                                
                                    </select>
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Type d'assurance*</label>
                    <div class="col-sm-4">
                        <select class="form-control" required name="typeAssurance">
                           			<option><c:out value='${client.typeAssurance}' /></option>
                                    <option>Assurance maladie</option>
                                    <option>Mutuelle de santé</option>
                                    <option>Autre</option>
                                
                                    </select>
                    </div>
            </div>
          
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Nom assureur*</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" required name="nomAssureur" value="<c:out value='${client.nomAssureur}' />" />
                    </div>
            </div>
       
             <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Date debut*</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" name="dateDebut"  required   value="<c:out value='${client.dateDebut}' />" />
                    </div>
            </div>
           
            <div class="form-group row">
                <label for="" class="col-sm-2 col-form-label">Date fin</label>
                    <div class="col-sm-4">
                        <input type="date" class="form-control" name="dateFin" required value="<c:out value='${client.dateFin}' />" />
                    </div>
            </div>
 
             <div class="m-l-150  ">
                                
                        <button type="submit"  class="btn btn-primary btn-flat  sweet-success btn-addon m-b-10 m-l-5"><i class="ti-plus"></i>Ajouter</button>
                        <button type="reset" name="Annuler"  class="btn btn-danger btn-flat btn-addon m-b-10 m-l-5"><i class="ti-close"></i>Annuler</button>


                            </div>
                         
                             

                            
        </form> 
                                    </div>
                                </div>




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