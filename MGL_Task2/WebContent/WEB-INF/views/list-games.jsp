<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

	<head>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
	  <script src="../resources/js/app.js" /></script>
	  <script src="../resources/js/service/MGL_Task2.service.js"></script>
	  <script src="../resources/js/controller/MGL_Task2.controller.js"></script>
	  <!-- Bootstrap CSS -->
	  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	  <title>Mist Library Task 1-Landing</title>
	  <style type="text/css">
	    body {
	      background-image: url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
	      background-repeat: no-repeat;
	      background-size: cover;
	    }
	
	  </style>
	</head>
	
	<body>
	  <nav id="MistLibrary-navbar" class="navbar navbar-expand-md navbar-dark bg-dark">
	    <a class="navbar-brand" href="../home"> <img src="../resources/images/MGLlogo.png" width="90" height="60" alt="">
	    </a>
	    <a class="nav-item nav-link" href="../games">Games</a>
	    <a class="nav-item nav-link" href="../review">Review</a>
	    <a class="nav-item nav-link" href="list">Game List</a>
	    <br>
	  </nav>
	  <br>
	  <div class="container">
	    <div class="panel-heading text-light">
	      <h2>List of all games in your Mist Library</h2>
	      <hr/>
	
	      <input type="button" value="Add Game" onclick="window.location.href='showForm'; return false;" class="btn btn-primary" />
	      <br/>
	      <br/>
	      <div class="panel panel-info">
	        <div class="panel-heading">
	          <div class="panel-title">Game List</div>
	        </div>
	        <div class="panel-body">
	          <table class="table table-dark table-striped text-light">
	            <tr>
	              <th>Game Name</th>
	              <th>Game Genre</th>
	              <th>Release Date (yyyy/mm/dd)</th>
	              <th>Action</th>
	            </tr>
	
	            <!-- loop over and print games -->
	            <c:forEach var="tempGame" items="${games}">
	
	              <!-- construct an "update" link with game id -->
	              <c:url var="updateLink" value="/game/updateForm">
	                <c:param name="game_id" value="${tempGame.game_id}" />
	              </c:url>
	
	              <!-- construct an "delete" link with game id -->
	              <c:url var="deleteLink" value="/game/deleteGame">
	                <c:param name="game_id" value="${tempGame.game_id}" />
	              </c:url>
	
	              <tr>
	                <td>${tempGame.game_name}</td>
	                <td>${tempGame.game_genre}</td>
	                <td>${tempGame.game_releaseDate}</td>
	                <td>
	                  <!-- display the update link --><a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this game?'))) return false">Delete</a>
	                </td>
	
	              </tr>
	
	            </c:forEach>
	
	          </table>
	
	        </div>
	      </div>
	    </div>
	
	  </div>
	</body>

</html>