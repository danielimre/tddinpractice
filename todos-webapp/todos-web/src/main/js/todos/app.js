/*global angular, TodosCtrl */

var todosApp = angular.module('todosApp', [ 'ngResource' ]);
todosApp.controller('TodosCtrl', TodosCtrl);
todosApp.factory('Todo', function($resource, userName) {
    return $resource('/api/todos/:userName/:id', {
        userName : userName,
        id: '@id'
    }, {
        list : {
            method : 'GET',
            params : {
                todoId : ''
            },
            isArray : true
        }
    });
});
