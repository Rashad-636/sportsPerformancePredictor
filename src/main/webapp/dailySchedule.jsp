<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 12/6/24
  Time: 4:38 PM
--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<c:import url="head.jsp" />

<body>
<div id="wrap">
    <div id="header">
        <div id="headerlinks">
            <c:choose>
                <c:when test="${sessionScope.userId == null}">
                    <a href="index.jsp">Home</a>
                    <a href="logIn">Sign In</a>
                </c:when>
                <c:otherwise>
                    <a href="index.jsp">Home</a>
                    <a href="dashboard">My Teams</a>
                    <a href="signout">Sign Out</a>
                    <span style="color: white;">${userName}</span>
                </c:otherwise>
            </c:choose>
        </div>
        <h1>Today's Games</h1>
    </div>

    <div id="content">
        <table class="schedule-table">
            <thead>
            <tr>
                <th>Date</th>
                <th>Home Team</th>
                <th>Away Team</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="game" items="${games}">
                <tr>
                    <td><fmt:parseDate value="${game.gameDate}" pattern="yyyyMMdd" var="parsedDate"/>
                        <fmt:formatDate value="${parsedDate}" pattern="MMM d, yyyy"/></td>
                    <td>${game.homeTeam}</td>
                    <td>${game.awayTeam}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <c:import url="footer.jsp" />
</div>
</body>
</html>
