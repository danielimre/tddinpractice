/*global angular, TodosCtrl */

var todosApp = angular.module('todosApp', [ 'ngResource' ]);
todosApp.controller('TodosCtrl', TodosCtrl);
todosApp.factory('Todo', function($resource, userName) {
    return $resource('/api/todos/:userName/', {
        userName : userName
    });
});
