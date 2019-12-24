'use strict';

angular.module('MGL_Task2_app').controller('MGL_Task2_Controller',
		[ 'MGL_Task2_Service', function(MGL_Task2_Service) {
			var self = this;
			self.game = {
				game_id : null,
				game_name : null,
				game_genre : null
			};
			self.games = [];

			self.fetchAllGames = function(){
				MGL_Task2_Service.fetchAllGames().then(function(data) {
					self.games = data;
				});
			}

			self.addGame = function(){
				return MGL_Task2_Service.createGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}

			self.gamePage = function(){
				return MGL_Task2_Service.gamePage().then( function() {
				self.fetchAllGames();
				});
			}
			
			self.update = function(game){
				return MGL_Task2_Service.updateGame(self.game).then( function() {
				self.fetchAllGames();
				});
			}
			
			self.fetchAllGames();
			
		} ]);
