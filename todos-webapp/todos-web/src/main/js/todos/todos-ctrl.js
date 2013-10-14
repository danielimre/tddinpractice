/*global angular*/
(function() {
/**
 * Controller for todos page.
 * @param $scope the scope of the controller
 */
angular.module('todosApp-core').controller('TodosCtrl', function TodosCtrl($scope, Todo) {
    "use strict";
    function updateRemainingCount() {
        var rc = 0;
        angular.forEach($scope.todos, function (todo) {
            if (!todo.completed) {
                rc++;
            }
        });
        $scope.remainingCount = rc;
    }

    $scope.todos = Todo.query(updateRemainingCount);
    $scope.newTodo = '';
    $scope.remainingCount = 0;

    $scope.addTodo = function () {
        var newTodo = new Todo({title: $scope.newTodo.trim()});
        if (!newTodo.title) {
            return;
        }
        newTodo.$save();
        $scope.todos.unshift(newTodo);
        $scope.remainingCount++;
        $scope.newTodo = '';
    };

    $scope.todoCompleted = function (todo) {
        $scope.remainingCount += todo.completed ? -1 : 1;
        todo.$save();
    };

    $scope.editTodo = function (todo) {
        $scope.editedTodo = todo;
    };

    $scope.doneEditing = function (todo) {
        $scope.editedTodo = null;
        todo.title = todo.title.trim();
        todo.$save();
    };

    $scope.removeTodo = function (todo) {
        $scope.remainingCount -= todo.completed ? 0 : 1;
        $scope.todos.splice($scope.todos.indexOf(todo), 1);
        todo.$delete();
    };
});
}());
