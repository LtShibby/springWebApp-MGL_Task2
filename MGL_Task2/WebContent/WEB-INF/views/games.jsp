<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.7.8/angular.min.js"></script>
<script src="resources/js/app.js" /></script>
<script src="resources/js/service/MGL_Task2.service.js"></script>
<script src="resources/js/controller/MGL_Task2.controller.js"></script>

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<title>Mist Library Task 1- Games</title>
<style type="text/css">
body {
	background-image:
		url('https://ak6.picdn.net/shutterstock/videos/1024598666/thumb/1.jpg');
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>

<body ng-app="MGL_Task2_app" class="ng-cloak">
	<nav id="MistLibrary-navbar"
		class="navbar navbar-expand-md navbar-dark bg-dark">
		<a class="navbar-brand" href="home"> <img
			src="resources/images/MGLlogo.png" width="90" height="60" alt="">
		</a> <a class="nav-item nav-link" href="games">Games</a> <a
			class="nav-item nav-link" href="review">Review</a> <a
			class="nav-item nav-link" href="game/list">Game List</a> <br>
	</nav>
	<br>
	<div class="container"
		ng-controller="MGL_Task2_Controller as MGL_T2_ctrl">
		<div class="panel panel-default">
			<div class="panel-heading text-light">
				<span class="lead">Game Registration Form </span>
			</div>
			<div class="formcontainer">
				<form ng-submit="MGL_T2_ctrl.addGame()" name="gameForm"
					class="form-horizontal">
					<!-- <input type="hidden" ng-model="MGL_T2_ctrl.game.game_id" /> -->
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable text-light" for="game_name">Name*</label>
							<div class="col-md-7">
								<input type="text" ng-model="MGL_T2_ctrl.game.game_name"
									id="game_name" class="game_name form-control input-sm"
									placeholder="Enter the name of the new game [required]"
									required ng-minlength="3" />
								<div class="has-error" ng-show="gameForm.$dirty">
									<span ng-show="gameForm.game_name.$error.required">This
										is a required field</span> <span
										ng-show="gameForm.game_name.$error.minlength">Minimum
										length required is 3</span> <span
										ng-show="gameForm.game_name.$invalid">This field is
										invalid </span>
								</div>
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable text-light" for="game_genre">Game
								Genre</label>
							<div class="col-md-7">
								<input type="text" ng-model="MGL_T2_ctrl.game.game_genre"
									id="game_genre" class="form-control input-sm"
									placeholder="Enter the genre of the new game" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable text-light"
								for="game_releaseDate">Game Release Date (yyyy-MM-dd)</label>
							<div class="col-md-7">
								<input type="text" ng-model="MGL_T2_ctrl.game.game_releaseDate"
									id="game_releaseDate" class="form-control input-sm"
									placeholder="Enter relase date of the new game  (yyyy-MM-dd)" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
						<input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<!-- <input type="submit" value="Add" class="btn btn-primary btn-sm"> -->
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<div class="panel-heading text-light">
				<span class="lead">List of all current games</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-dark table-striped text-light">
					<thead>
						<tr>
							<th>Game Id</th>
							<th>Game Name</th>
							<th>Game Genre</th>
							<th>Release Date</th>
							<th width="20%">Actions</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="currentGame in MGL_T2_ctrl.games">
							<td><span ng-bind="currentGame.game_id"></span></td>
							<td><span ng-bind="currentGame.game_name"></span></td>
							<td><span ng-bind="currentGame.game_genre"></span></td>
							<td>
								<span ng-bind="currentGame.game_releaseDate.values[1]"></span>/
								<span ng-bind="currentGame.game_releaseDate.values[2]"></span>/
								<span ng-bind="currentGame.game_releaseDate.values[0]"></span>
							</td>
							<td>
								<button type="button" ng-click="MGL_T2_ctrl.editGame(currentGame)" class="btn btn-success custom-width">Edit</button>  
								<button type="button" ng-click="MGL_T2_ctrl.deleteGame(currentGame.game_id)" class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
				<br> <br> <br>
			</div>
		</div>
	</div>

</body>
<script type="text/javascript"></script>

</html>