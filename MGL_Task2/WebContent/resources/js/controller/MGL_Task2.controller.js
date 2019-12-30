'use strict';

angular.module('MGL_Task2_app').controller('MGL_Task2_Controller',
		[ 'MGL_Task2_Service',  '$window', function(MGL_Task2_Service, $window) {
			var self = this;
			self.game = {
				game_id : null,
				game_name : null,
				game_genre : null,
				game_releaseDate : null
			};
			self.games = [];
			self.reviews = [];

			self.fetchAllGames = function() {
				MGL_Task2_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function() {
				if(self.game.game_id===null){
					return MGL_Task2_Service.createGame(self.game).then(function() {
						self.fetchAllGames();
					});
				}
				else{
					return MGL_Task2_Service.updateGame(self.game).then(function() {
						self.fetchAllGames();
					});
				}
			}

			self.gamePage = function() {
				return MGL_Task2_Service.gamePage().then(function() {
					self.fetchAllGames();
				});
			}

			self.updateGame = function() {
				return MGL_Task2_Service.updateGame(game).then(function() {
					self.fetchAllGames();
				});
			}

			self.editGame = function(game) {
				self.game = angular.copy(game);
			}

			self.deleteGame = function(game_id) {
				return MGL_Task2_Service.deleteGame(game_id).then(function() {
					self.fetchAllGames();
				});
				self.fetchAllGames();
			}
			
			self.fetchAllReviews = function(game_id) {
				console.log("in jscontroller: " + game_id)
				self.reviews = MGL_Task2_Service.fetchAllReviews(game_id);
				console.log("reviews in jscontroller: " + self.reviews);
				$window.location.href = "review?review_game_id="+game_id;
			}

			self.fetchAllGames();

		} ]);
