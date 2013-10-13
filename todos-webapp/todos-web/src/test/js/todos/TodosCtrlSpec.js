(function() {
    describe('TodosCtrl', function() {
        var createController, $scope, $httpBackend,
            INITIAL_TODO_LIST = [{id: 1, title: 'todo1', completed: false}, {id: 2, title: 'todo2', completed: false}];

        beforeEach(module('todosApp'));
        beforeEach(function() {
            todosApp.value('userName', 'testuser');
        });
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
            $httpBackend.expectGET('/api/todos/testuser').respond(INITIAL_TODO_LIST);
            ctrl = createController();
            $httpBackend.flush();
            expect($scope.todos).toEqualData(INITIAL_TODO_LIST);
        }));

        describe('TodosCtrl.addTodo()', function() {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/api/todos/testuser').respond(INITIAL_TODO_LIST);
                ctrl = createController();
                $httpBackend.flush();
            });

            describe("invoked with non-empty newTodo", function() {
                var NEW_ITEM = {id: 8, title: "some"};

                beforeEach(function () {
                    $scope.newTodo = "some";
                    $httpBackend.expectPOST('/api/todos/testuser', {title: "some"}).respond(NEW_ITEM);
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
        });
        describe('TodosCtrl.todoCompleted()', function() {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/api/todos/testuser').respond(INITIAL_TODO_LIST);
                ctrl = createController();
                $httpBackend.flush();
            });

            describe("invoked with an incomplete todo", function() {
                it("should increase remainingCount by one", function() {
                    var todo = {completed: false, $save: angular.noop};
                    spyOn(todo, '$save');
                    $scope.remainingCount = 0;
                    $scope.todoCompleted(todo);
                    expect(todo.$save).toHaveBeenCalled();
                    expect($scope.remainingCount).toEqual(1);
                });
            });
            describe("invoked with a complete todo", function() {
                it("should decrease remainingCount by one", function() {
                    var todo = {completed: true, $save: angular.noop};
                    spyOn(todo, '$save');
                    $scope.remainingCount = 1;
                    $scope.todoCompleted(todo);
                    expect(todo.$save).toHaveBeenCalled();
                    expect($scope.remainingCount).toEqual(0);
                });
            });
        });
        describe('TodosCtrl.editTodo()', function() {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/api/todos/testuser').respond(INITIAL_TODO_LIST);
                ctrl = createController();
                $httpBackend.flush();
            });

            it("should set the editedTodo to todo", function() {
                var todo = {title: "something"};
                $scope.editTodo(todo);
                expect($scope.editedTodo).toEqual(todo);
            });
        });
        describe('TodosCtrl.doneEditing()', function() {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/api/todos/testuser').respond(INITIAL_TODO_LIST);
                ctrl = createController();
                $httpBackend.flush();
            });

            it("should set the editedTodo to null and save the todo with trimmed title", function() {
                var todo = {title: "something ", $save: angular.noop};
                spyOn(todo, '$save');
                $scope.editedTodo = todo;
                $scope.doneEditing(todo);
                expect($scope.editedTodo).toBe(null);
                expect(todo.title).toEqual("something");
                expect(todo.$save).toHaveBeenCalled();
            });
        });
        describe('TodosCtrl.removeTodo()', function() {
            var ctrl;
            beforeEach(function () {
                $httpBackend.expectGET('/api/todos/testuser').respond(INITIAL_TODO_LIST);
                ctrl = createController();
                $httpBackend.flush();
            });

            describe("invoked with todo", function() {
                beforeEach(function () {
                    $httpBackend.expectDELETE('/api/todos/testuser/1').respond("ok");
                    $scope.removeTodo($scope.todos[0]);
                    $httpBackend.flush();
                });
                it("should remove it from todos", function() {
                    var expectedItems = [INITIAL_TODO_LIST[1]];
                    expect($scope.todos).toEqualData(expectedItems);
                });
                it("should decrease remainingCount by 1", function() {
                    expect($scope.remainingCount).toEqual(1);
                });
            });
        });
    });
})();
