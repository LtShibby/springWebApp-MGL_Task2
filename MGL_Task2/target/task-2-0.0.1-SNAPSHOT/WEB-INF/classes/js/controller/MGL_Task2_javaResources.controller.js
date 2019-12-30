'use strict';

angular.module('MGL_Task2_app').controller('MGL_Task2_javaResources_Controller',
		[ 'MGL_Task2_Service', function(MGL_Task2_Service) {
			var self = this;
			self.game = {
				game_id : null,
				game_name : null,
				game_genre : null,
				game_releaseDate : null
			};
			self.games = [];
			self.review = {
				review_id : null,
				review_body : null,
				review_author : null,
				review_rating : null
			};
			self.reviews = [];

			formatDate = function(date) {
				var dateOut = new Date(date);
				return dateOut;
			};

			self.fetchAllGames = function() {
				MGL_Task2_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function() {
				return MGL_Task2_Service.createGame(self.game).then(function() {
					self.fetchAllGames();
				});
			}

			self.updateGame = function() {
				return MGL_Task2_Service.updateGame(self.game).then(function() {
					self.fetchAllGames();
				});
			}

			self.deleteGame = function() {
				return MGL_Task2_Service.deleteGame(self.game).then(function() {
					self.fetchAllGames();
				});
			}
			
			self.fetchReviewsForGame = function() {
				MGL_Task2_Service.fetchAllReviews(self.game,game_id).then(function(data) {
					self.reviews = data;
				});
			}
			
			self.fetchAllGames();

		} ]);
