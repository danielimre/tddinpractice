<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
  <h1>Todos App</h1>
  <form:form action="/login" method="post">
    <form:label path="username">username: </form:label>
    <form:input path="username" />
    <button id="todos" type="submit">todos</button>
  </form:form>
</body>
</html>
