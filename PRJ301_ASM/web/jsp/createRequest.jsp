<%-- 
    Document   : createRequest
    Created on : Nov 5, 2025, 7:36:25 PM
    Author     : dv15312
--%>

<%-- /jsp/createRequest.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><body>
        <h2> Đơn xin nghỉ</h2>
        <form method="post" action="${pageContext.request.contextPath}/requests/create">
            Title: <input name="title"/><br/>
            From: <input type="date" name="from_date"/><br/>
            To: <input type="date" name="to_date"/><br/>
            Reason:<br/>
            <textarea name="reason"></textarea><br/>
            <button type="submit"> Semd </button>
        </form>
    </body></html>

