<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 9/18/24
--%>
<div id="header">
    <div id="headerlinks">
        <c:choose>
            <c:when test="${sessionScope.userId == null}">
                <a href="logIn">Sign In</a>
                <a href="index.jsp">Home</a>
                <a href="dailySchedule">NBA Today</a>
            </c:when>
            <c:otherwise>
                <a href="index.jsp">Home</a>
                <a href="dailySchedule">NBA Today</a>
                <a href="dashboard">My Teams</a>
                <a href="signout">Sign Out</a>
                <span style="color: white;">${userName}</span>
            </c:otherwise>
        </c:choose>
    </div>
    <h1>Sports Analytics Pro</h1>
</div>