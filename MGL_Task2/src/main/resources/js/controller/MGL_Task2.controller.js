'use strict';

angular.module('MGL_Task2_app').controller('MGL_Task2_Controller', ['MGL_Task2_Service', function (MGL_Task2_Service) {
  var self = this;
  self.game = {
    game_id: '',
    game_name: '',
    game_genre: ''
  };
  self.games = [];

  self.fetchAllGames = function () {
    MGL_Task2_Service.fetchAllGames().then(function (data) {
      self.games = data;
    });
  }

  self.addGame = function () {
    return MGL_Task2_Service.createGame(self.game).then(function () {
      self.fetchAllGames();
    });
  }

  self.fetchAllGames();
}]);
