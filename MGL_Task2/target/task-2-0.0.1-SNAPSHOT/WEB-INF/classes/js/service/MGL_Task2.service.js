'use strict';

angular.module('MGL_Task2_app').factory('MGL_Task2_Service', ['$http', function ($http) {

  var REST_SERVICE_URI = 'http://localhost:8080/MGL_Task2/';

  var factory = {
    fetchAllGames: fetchAllGames,
    createGame: createGame
  };

  return factory;

  function fetchAllGames() {
    return $http.get(REST_SERVICE_URI + 'game/list').then(function (response) {
      return response.data;
    });
  }

  function createGame(game) {
    return $http.post(REST_SERVICE_URI + 'createGame', game).then(function (response) {
      return response.data;
    });
  }

}]);