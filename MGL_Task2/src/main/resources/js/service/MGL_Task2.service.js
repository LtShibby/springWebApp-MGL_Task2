'use strict';

angular.module('MGL_Task2_app').factory(
		'MGL_Task2_Service',
		[
				'$http',
				function($http) {

					var REST_SERVICE_URI = 'http://localhost:8080/MGL_Task2/';

					var factory = {
						fetchAllGames : fetchAllGames,
						createGame : createGame,
						updateGame : updateGame,
						fetchAllReviews : fetchAllReviews
					};

					return factory;

					function fetchAllGames() {
						return $http.get(REST_SERVICE_URI + 'game/list').then(
								function(response) {
									return response.data;
								});
					}
					
					function fetchReviewsForGame(game_id) {
						return $http.get(REST_SERVICE_URI + 'fetchReviewsForGame').then(
								function(response) {
									return response.data;
								});
					}

					function createGame(game) {
						return $http
								.post(REST_SERVICE_URI + 'createGame', game)
								.then(function(response) {
									return response.data;
								});
					}

					function updateGame(game) {
						return $http
								.post(REST_SERVICE_URI + 'updateGame', game)
								.then(function(response) {
									return response.data;
								});
					}
					
					function deleteGame(game) {
						return $http
								.post(REST_SERVICE_URI + 'deleteGame', game)
								.then(function(response) {
									return response.data;
								});
					}

				} ]);