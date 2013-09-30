describe("TodosCtrl", function() {
    it("should initialize $scope", function() {
        var $scope = {};
        var ctrl = new TodosCtrl($scope);
        expect($scope.newTodo).toEqual("");
        expect($scope.todos).toEqual([]);
    });
    describe("invoking addTodo on it", function() {
        var $scope = {};
        var ctrl = new TodosCtrl($scope);
        $scope.newTodo = "some";
        $scope.addTodo();
        it("should add newTodo to todos", function() {
            expect($scope.todos).toEqual([{title : "some"}]);
        });
        it("should clear newTodo", function() {
            expect($scope.newTodo).toEqual("");
        });
    });
    describe("invoking addTodo on it with empty newTodo", function() {
        var $scope = {};
        var ctrl = new TodosCtrl($scope);
        $scope.newTodo = "  ";
        $scope.addTodo();
        it("shouldn't add newTodo to todos", function() {
            expect($scope.todos).toEqual([]);
        });
    });
});