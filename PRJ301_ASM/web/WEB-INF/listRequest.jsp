<%-- 
    Document   : listRequest
    Created on : Nov 5, 2025, 7:37:26 PM
    Author     : dv15312
--%>

<%-- /jsp/listRequests.jsp --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><body>
<h2>Đơn của tôi</h2>
<table border="1">
<tr><th>Title</th><th>From</th><th>To</th><th>Status</th><th>Action</th></tr>
<c:forEach var="r" items="${mine}">
  <tr>
    <td>${r.title}</td>
    <td>${r.fromDate}</td>
    <td>${r.toDate}</td>
    <td>${r.status}</td>
    <td><a href="${pageContext.request.contextPath}/requests/view?id=${r.id}">View</a></td>
  </tr>
</c:forEach>
</table>

<h2>Đơn của cấp dưới</h2>
<table border="1">
<tr><th>Title</th><th>From</th><th>To</th><th>Created By</th><th>Status</th><th>Action</th></tr>
<c:forEach var="r" items="${sub}">
  <tr>
    <td>${r.title}</td>
    <td>${r.fromDate}</td>
    <td>${r.toDate}</td>
    <td>${r.createdBy}</td>
    <td>${r.status}</td>
    <td>
      <a href="${pageContext.request.contextPath}/requests/view?id=${r.id}">View</a>
    </td>
  </tr>
</c:forEach>
</table>

<a href="${pageContext.request.contextPath}/requests/create">Tạo đơn mới</a>
</body></html>
