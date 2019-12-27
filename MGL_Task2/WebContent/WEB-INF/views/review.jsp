<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

	<head>
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
	  <script src="resources/js/app.js" /></script>
	  <script src="resources/js/service/MGL_Task2.service.js"></script>
	  <script src="resources/js/controller/MGL_Task2.controller.js"></script>
	  <!-- Bootstrap CSS -->
	  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	
	  <title>Mist Library Task 2 - Submit Review</title>
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
	    <a class="navbar-brand" href="index"> <img src="resources/images/MGLlogo.png" width="90" height="60" alt="">
	    </a>
	    <a class="nav-item nav-link" href="games">Games</a>
	    <a class="nav-item nav-link" href="review">Review</a>
	    <a class="nav-item nav-link" href="game/list">Game List</a>
	    <br>
	  </nav>
	  <br>
	  <div class="container">
	    <div class="panel-heading text-light">
	      <h2>Update Game Form</h2>
	      <div class="panel panel-info">
	        <div class="panel-body">
	        <br/>
	    <form name="submitReviewForm" method="POST" action="addReview">
	      <table class="table table-dark text-light">
	        <tr>
	          <td>
	            <label>Review Body*</label>
	          </td>
	          <td>
	            <textarea name="review_body" class="form-control" placeholder="What did you like/dislike about the game? [required]" required></textarea>
	          </td>
	        </tr>
	        <tr>
	          <td>
	            <label>Author</label>
	          </td>
	          <td>
	            <input type="text" name="review_author" class="form-control" placeholder="Your name (leave black to leave an anonymous review)"></input>
	          </td>
	        </tr>
	        <tr>
	          <td>
	            <label>Rating</label>
	          </td>
	          <td>
	            <select id="ratingSelection" name="review_rating" class="chzn-select" style="width: 100px" required>
	              <option value=1>1</option>
	              <option value=2>2</option>
	              <option value=3>3</option>
	              <option value=4>4</option>
	              <option value=5>5</option>
	            </select>
	          </td>
	        </tr>
	        <tr>
	          <td>
	            <input type="submit" class="btn btn-primary">
	          </td>
	        </tr>
	      </table>
	    </form>
	  </div>
	  </div>
	  </div>
	  </div>
	</body>
	<script type="text/javascript"></script>

</html>
