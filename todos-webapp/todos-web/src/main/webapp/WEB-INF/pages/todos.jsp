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
  <section ng-controller="TodosCtrl" ng-cloak>
    <header id="header">
      <h1>todos @${username}</h1>
      <form id="todo-form" ng-submit="addTodo()">
        <input id="new-todo" ng-model="newTodo" autofocus>
      </form>
    </header>
    <section id="main">
      <ul id="todos-list">
        <li ng-repeat="todo in todos">
          <input type="checkbox" ng-model="todo.completed" ng-change="todoCompleted(todo)">
          {{todo.title}}
        </li>
      </ul>
    </section>
    <footer id="footer" ng-show="todos.length">
      <span id="todos-count">
        <ng-pluralize count="remainingCount" when="{ one: 'one item left', other: '{} items left' }"></ng-pluralize>
      </span>
    </footer>
  </section>
  <%@include file="common/foot.jsp"%>
  <script type="text/javascript" src="/assets/lib/angular/angular.min.js"></script>
  <script type="text/javascript" src="/assets/lib/angular/angular-resource.min.js"></script>
  <script type="text/javascript" src="/assets/js/todos/todos-ctrl.js"></script>
  <script type="text/javascript" src="/assets/js/todos/app.js"></script>
</body>
</html>