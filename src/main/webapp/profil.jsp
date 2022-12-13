<%
	if(session.getAttribute("prenom")==null){
		response.sendRedirect("login.jsp");
	}else {	
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");//Http 1.1

		response.setHeader("Pragma", "no-cache");//Http 1.0

		response.setDateHeader("Expires", 0);
		
		
	}
%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@  taglib prefix ="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@  taglib prefix ="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Profil d'utilisateur</title>


    <!-- Common -->
    <link href="css/lib/font-awesome.min.css" rel="stylesheet">
    <link href="css/lib/themify-icons.css" rel="stylesheet">
    <link href="css/lib/menubar/sidebar.css" rel="stylesheet">
    <link href="css/lib/bootstrap.min.css" rel="stylesheet">
    <link href="css/lib/helper.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
  <!-- /# debut menu  principal -->
    <div class="sidebar sidebar-hide-to-small sidebar-shrink sidebar-gestures">
        <div class="nano">
            <div class="nano-content">
                <ul>
                    <div class="logo"><a href="index.jsp">
                            <!-- <img src="images/logo.png" alt="" /> --><span>OpenAssu</span></a></div>
                   
                    <li><a  href="index.jsp"><i class="ti-home"></i> Tableau de bord </a>
                    </li>

                   
                    <li><a href="<%=request.getContextPath() %>/list"><i class="ti-user"></i> Client </a></li>

                    <li><a class="sidebar-sub-toggle"><i class="ti-layout-grid2 "></i> Assurance <span
                                class="sidebar-collapse-icon ti-angle-down"></span></a>
                        <ul>
                            <li><a href="<%=request.getContextPath()%>/listA">Assurance maladie</a></li>
                            <li><a href="<%=request.getContextPath() %>/listM">Mutuelle de santé</a></li>
                            <li><a href="#">Autre</a></li>
                        </ul>
                    </li>
                    <li><a href="#"><i class="ti-settings"></i> Paramètres </a></li>
                    <li><a href="#"><i class="ti-link"></i> Autres</a></li>
                    <li><a href="<%=request.getContextPath() %>/listU"><i class="ti-user"></i> Utilisateurs</a></li>
                       <li><a href="profil.jsp"><i class="ti-user"></i>Profil</a></li>
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
                                                <a href="profile.jsp">
                                                    <i class="ti-user"></i>
                                                    Profile
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
                <div class="card-body">
                  <div class="user-profile">
                    <div class="row">
                      <div class="col-lg-4">
                        <div class="user-photo m-b-30">
                          <img class="img-fluid" src="images/user-profile.jpg" alt="" />
                        </div>
                       
                      
                      </div>
                      <div class="col-lg-8">
                        <div class="user-profile-name"><%=session.getAttribute("prenom") %> <%=session.getAttribute("nom") %></div>
                    
                        <div class="user-job-title"><% out.println("categorie"); %></div>
                        
                        <div class="user-send-message">
                          <button class="btn btn-primary btn-addon" type="button">
                            <i class="ti-email"></i>Send Message</button>
                        </div>
                        <div class="custom-tab user-profile-tab">
                          <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                              <a href="#1" aria-controls="1" role="tab" data-toggle="tab">About</a>
                            </li>
                          </ul>
                          <div class="tab-content">
                            <div role="tabpanel" class="tab-pane active" id="1">
                              <div class="contact-information">
                                <h4>Contact information</h4>
                                <div class="phone-content">
                                  <span class="contact-title">Phone:</span>
                                  <span class="phone-number">+8801629599859</span>
                                </div>
                                <div class="address-content">
                                  <span class="contact-title">Address:</span>
                                  <span class="mail-address">123, Rajar Goli, South Mugda</span>
                                </div>
                                <div class="email-content">
                                  <span class="contact-title">Email:</span>
                                  <span class="contact-email">hello@Admin Board.com <c:out value='${users.email}' /> </span>
                                </div>
                                <div class="website-content">
                                  <span class="contact-title">Website:</span>
                                  <span class="contact-website"> <a href="https://www.hibs-cd.com">www.hibs-cd.com</a></span>
                                </div>
                            
                              </div>
                              <div class="basic-information">
                                <h4>Basic information</h4>
                                <div class="birthday-content">
                                  <span class="contact-title">Birthday:</span>
                                  <span class="birth-date">January 31, 1990 </span>
                                </div>
                                <div class="gender-content">
                                  <span class="contact-title">Gender:</span>
                                  <span class="gender">Male</span>
                                </div>
                              </div>
                            </div>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <!-- /# row -->
          
            <!-- /# column -->
           
            <!-- /# column -->
        
         
        </section> 
</body>

</html>