(function() {
    function initScope() {
        var $scope = {},
            ctrl = new TodosCtrl($scope);
        return $scope;
    }

    describe("TodosCtrl", function() {
        var $scope = initScope();
        it("should initialize $scope", function() {
            expect($scope.newTodo).toEqual("");
            expect($scope.todos).toEqual([]);
            expect($scope.remainingCount).toEqual(0);
        });
    });
    describe("TodosCtrl.addTodo()", function() {
        describe("invoked with non-empty newTodo", function() {
            var $scope = initScope();
            it("invoked with non-empty newTodo should add it to todos", function() {
                $scope.newTodo = "some";
                $scope.addTodo();
                expect($scope.todos).toEqual([{title : "some", completed: false}]);
            });
            it("should clear newTodo", function() {
                expect($scope.newTodo).toEqual("");
            });
            it("should increase remainingCount by 1", function() {
                expect($scope.remainingCount).toEqual(1);
            });
        });
        describe("invoked with empty newTodo", function() {
            var $scope = initScope();
            it("shouldn't add newTodo to todos", function() {
                $scope.newTodo = "  ";
                $scope.addTodo();
                expect($scope.todos).toEqual([]);
            });
        });
    });
    describe("TodosCtrl.todoCompleted()", function() {
        describe("invoked with an incomplete todo", function() {
            var $scope = initScope();
            $scope.remainingCount = 0;
            $scope.todoCompleted({completed: false});
            it("should increase remainingCount by one", function() {
                expect($scope.remainingCount).toEqual(1);
            });
        });
        describe("invoked with a complete todo", function() {
            var $scope = initScope();
            it("should decrease remainingCount by one", function() {
                $scope.remainingCount = 1;
                $scope.todoCompleted({completed: true});
                expect($scope.remainingCount).toEqual(0);
            });
        });
    });
})();