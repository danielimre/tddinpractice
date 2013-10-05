(function() {
    describe('TodosCtrl', function() {
        var createController, $scope, $httpBackend,
            INITIAL_TODO_LIST = [{id: 1, title: 'todo1'}, {id: 2, title: 'todo2'}];

        beforeEach(module('todosApp'));
        beforeEach(inject(function($controller, $rootScope, $injector) {
            $scope = $rootScope.$new();
            $httpBackend = $injector.get('$httpBackend'); //got through the $injector to avoid name collision
            createController = function () {
                return $controller('TodosCtrl', {$scope: $scope});
            }
        }));
        beforeEach(function() {
            this.addMatchers({
                toEqualData: function(expected) {
                    return angular.equals(this.actual, expected);
                }
            });
        });

        afterEach(function() {
            $httpBackend.verifyNoOutstandingExpectation();
            $httpBackend.verifyNoOutstandingRequest();
        });

        it('should query todos', inject(function($httpBackend) {
            var ctrl;
            $httpBackend.expectGET('/api/todo').respond(INITIAL_TODO_LIST);
            ctrl = createController();
            $httpBackend.flush();
            expect($scope.todos).toEqualData(INITIAL_TODO_LIST);
        }));

        describe('TodosCtrl.addTodo()', function() {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/api/todo').respond(INITIAL_TODO_LIST);
                ctrl = createController();
                $httpBackend.flush();
            });

            describe("invoked with non-empty newTodo", function() {
                var NEW_ITEM = {id: 8, title: "some"};

                beforeEach(function () {
                    $scope.newTodo = "some";
                    $httpBackend.expectPOST('/api/todo', {title: "some"}).respond(NEW_ITEM);
                    $scope.addTodo();
                    $httpBackend.flush();
                });

                it("should add it to todos", function() {
                    var expectedItems = [NEW_ITEM];
                    Array.prototype.push.apply(expectedItems, INITIAL_TODO_LIST);
                    expect($scope.todos).toEqualData(expectedItems);
                });
                it("should clear newTodo", function() {
                    expect($scope.newTodo).toEqual("");
                });
                it("should increase remainingCount by 1", function() {
                    expect($scope.remainingCount).toEqual(3);
                });
            });
            describe("invoked with empty newTodo", function() {
                it("shouldn't add newTodo to todos", function() {
                    $scope.newTodo = "  ";
                    $scope.addTodo();
                    expect($scope.todos).toEqualData(INITIAL_TODO_LIST);
                });
            });
        })
    });
})();
