<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-with, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/login.css">
<link rel="stylesheet" type="text/css" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link href="css/lib/sweetalert/sweetalert.css" rel="stylesheet">
<title>Connexion à OpenAssu</title>
</head>
<body>
<input type="hidden" id="status" value="<%= request.getAttribute("status") %>"> 
<div class="container">
    <div class="form-container  sign-in-container">
        <form action="LoginSv" method="post">
        
        
    <h1 style="text-align: center;" >Connectez-vous à<br>votre compte</h1>
    
    <div class="input-box">
        <input type="email" spellcheck="false" name="email" id="email" required />
        <label for="">Email</label>

    </div>
    <br>
    <div class="input-box">
        
        <input type="password" spellcheck="false" name="password" id="id_password" required />
        <label for="">Mot de passe</label>
        
         <i class="uil-eye" id="togglePassword"></i>


    </div>
    <div>
    <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" /> <span>remember-me</span>
    </div>
    <br>

        
                            
       <button type="submit" name="Connexion"> Connexion</button>
       <button type="reset" style="background-color: #E44E4C; border-color:#E44E4C"> Annuler</button>

       </form>
    </div>

    <div class="overlay-container">
    <div class="overlay">
     
      <div class="overlay-panel overlay-right">
        <h1>Bienvenue sur OpenAssu</h1>
        <p>Entrez vos données personnelles pour accéder à OpenAssu</p>
           
      </div>
    </div>
  </div>



 </div>



    
    
<script>
    
const togglePassword = document.querySelector('#togglePassword');
  const password = document.querySelector('#id_password');

  togglePassword.addEventListener('click', function (e) {
    // toggle the type attribute
    const type = password.getAttribute('type') === 'password' ? 'text' : 'password';
    password.setAttribute('type', type);
    // toggle the eye slash icon
    this.classList.toggle('uil-eye-slash');

});



</script>
	 <script src="js/lib/jquery.min.js"></script>
	 <script src="js/lib/jquery.nanoscroller.min.js"></script>
	 <script src="js/lib/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>

 	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	<script src="js/lib/sweetalert/sweetalert.min.js"></script>
    <script src="js/lib/sweetalert/sweetalert.init.js"></script>
	
	
	<script type="text/javascript">
	
	var status = document.getElementById("status").value;
	if(status == "invalid"){
		swal("Desolé", "Mot de passe ou email incorrect", "error");
	}
	
	</script>

</body>
</html>