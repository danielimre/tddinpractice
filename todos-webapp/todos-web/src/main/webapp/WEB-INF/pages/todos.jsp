<html lang="en" ng-app="todosApp">
<head>
<%@include file="common/head.jsp"%>
<style>
[ng-cloak] {
  display: none;
}
</style>
</head>
<body>
  <section ng-controller="TodosCtrl" ng-cloak class="container">
    <header id="header" class="page-header">
      <h1>todos <small>${username}</small></h1>
      <form id="todo-form" ng-submit="addTodo()">
        <input id="new-todo" ng-model="newTodo" autofocus class="form-control input-lg" placeholder="Add todo by typing here and hiting Enter...">
      </form>
    </header>
    <section id="main" class="row">
      <ul id="todos-list" class="list-unstyled col-md-6">
        <li ng-repeat="todo in todos">
          <div class="input-group">
            <div class="input-group-addon">
                <input type="checkbox" ng-model="todo.completed" ng-change="todoCompleted(todo)">
            </div>
            <div ng-hide="todo == editedTodo" class="form-control">
              <label ng-dblclick="editTodo(todo)">{{todo.title}}</label>
              <button ng-click="removeTodo(todo)" class="close" rel="tooltip" title="Click to remove todo.">&times;</button>
            </div>
            <form ng-submit="doneEditing(todo)" ng-show="todo == editedTodo" class="form-control">
              <input ng-model="todo.title" class="form-control col-md-12" on-blur="doneEditing(todo)" focus-on="todo == editedTodo">
            </form>
          </div>
        </li>
      </ul>
    </section>
    <footer id="footer" ng-show="todos.length" class="help-block">
      <span id="todos-count">
        <ng-pluralize count="remainingCount" when="{ one: 'one item left', other: '{} items left' }"></ng-pluralize>
      </span>
      <div class="progress">
        <div class="progress-bar progress-bar-info" role="progressbar" style="width: {{(todos.length - remainingCount)/todos.length*100}}%">
          <span>{{todos.length - remainingCount}}</span>
        </div>
        <div class="progress-bar progress-bar-warning" role="progressbar" style="width: {{(remainingCount)/todos.length*100}}%">
          <span>{{remainingCount}}</span>
        </div>
      </div>
      <p>Edit todos by doubleclicking them then hit Enter to save them.</p>
    </footer>
  </section>
  <%@include file="common/foot.jsp"%>
  <script type="text/javascript" src="/assets/lib/angular/angular.min.js"></script>
  <script type="text/javascript" src="/assets/lib/angular/angular-resource.min.js"></script>
  <script type="text/javascript" src="/assets/js/todos/app.js"></script>
  <script type="text/javascript" src="/assets/js/todos/services.js"></script>
  <script type="text/javascript" src="/assets/js/todos/todos-ctrl.js"></script>
  <script type="text/javascript" src="/assets/js/todos/directives.js"></script>
  <script type="text/javascript">
    todosApp.value('userName', '${username}');
  </script>
</body>
</html>