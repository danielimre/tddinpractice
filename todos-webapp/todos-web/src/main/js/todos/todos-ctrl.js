/**
 * Controller for todos page.
 * @param $scope the scope of the controller
 */
function TodosCtrl($scope) {
    $scope.todos = [];
    $scope.newTodo = '';
    $scope.remainingCount = 0;

    $scope.addTodo = function () {
        var newTodo = $scope.newTodo.trim();
        if (newTodo.length === 0) {
            return;
        }
        $scope.todos.push({
            title: newTodo,
            completed: false
        });
        $scope.remainingCount++;
        $scope.newTodo = '';
    };

    $scope.todoCompleted = function (todo) {
        $scope.remainingCount += todo.completed ? -1 : 1;
    };
}
