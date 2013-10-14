/*global angular*/
(function() {
"use strict";
angular.module("todosApp-services").factory('Todo', function($resource, userName) {
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
}());
