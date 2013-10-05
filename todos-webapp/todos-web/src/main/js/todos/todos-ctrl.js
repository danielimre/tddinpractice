/*global angular*/
/**
 * Controller for todos page.
 * @param $scope the scope of the controller
 */
function TodosCtrl($scope, Todo) {
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
        if (newTodo.title.length === 0) {
            return;
        }
        newTodo.$save(updateRemainingCount);
        $scope.todos.unshift(newTodo);
        updateRemainingCount();
        $scope.newTodo = '';
    };
}
