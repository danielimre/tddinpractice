/**
 * Controller for todos page.
 * @param $scope the scope of the controller
 */
function TodosCtrl($scope) {
    $scope.todos = [];
    $scope.newTodo = '';

    $scope.addTodo = function () {
        var newTodo = $scope.newTodo.trim();
        if (newTodo.length === 0) {
            return;
        }
        $scope.todos.push({
            title: newTodo,
            completed: false
        });
        $scope.newTodo = '';
    };
}
