<%-- 
    Document   : login
    Created on : Nov 5, 2025, 7:35:40 PM
    Author     : dv15312
--%>

<%-- /jsp/login.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head><title>Login</title></head>
    <body>
        <h2>Login</h2>
    <c:if test="${not empty error}">
        <div style="color:red">${error}</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/login">
        <label>Username: <input type="text" name="username"/></label><br/>
        <label>Password: <input type="password" name="password"/></label><br/>
        <button type="submit"> Login </button>
    </form>
</body>
</html>

