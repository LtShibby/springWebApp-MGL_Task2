'use strict';

angular.module('MGL_Task2_app').controller('MGL_Task2_Controller',
		[ 'MGL_Task2_Service', function(MGL_Task2_Service) {
			var self = this;
			self.game = {
				game_id : null,
				game_name : null,
				game_genre : null,
				game_releaseDate : null
			};
			self.games = [];

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
			self.fetchAllGames();

		} ]);
