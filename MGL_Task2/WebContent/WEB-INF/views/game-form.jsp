<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="../resources/js/app.js" /></script>
<script src="../resources/js/service/MGL_Task2.service.js"></script>
<script src="../resources/js/controller/MGL_Task2.controller.js"></script>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Mist Library Task 1-Landing</title>
<style type="text/css">
body {
	background-image:
		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>

<body>
	<nav id="MistLibrary-navbar"
		class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="index"> <img
			src="../resources/images/MGLlogo.png" width="90" height="60" alt="">
		</a> <a class="nav-item nav-link" href="games">Games</a> <a
			class="nav-item nav-link" href="review">Review</a> <a
			class="nav-item nav-link" href="gameList">Game list</a> <a
			class="nav-item nav-link" href="list">list-games</a> <a
			class="nav-item nav-link" href="game-form">game-form</a> <br>
	</nav>
div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center"> GAME FORM PAGE</h2>
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Game</div>
    </div>
    <div class="panel-body">
     <form:form action="saveGame" cssClass="form-horizontal"
      method="post" modelAttribute="game">

      <!-- need to associate this data with game id -->
      <form:hidden path="game_id" />

      <div class="form-group">
       <label for="game_name" class="col-md-3 control-label">First
        Name</label>
       <div class="col-md-9">
        <form:input path="game_name" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="game_genre" class="col-md-3 control-label">Last
        Name</label>
       <div class="col-md-9">
        <form:input path="game_genre" cssClass="form-control" />
       </div>
      </div>

      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
       </div>
      </div>

     </form:form>
    </div>
   </div>
  </div>
</body>
</html>