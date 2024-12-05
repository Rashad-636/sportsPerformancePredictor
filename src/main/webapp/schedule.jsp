<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 12/2/24
--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<%-- header jsp --%>
<c:import url="head.jsp" />

<body>
<div id="wrap">
    <div id="header">
        <div id="headerlinks">
            <c:choose>
                <c:when test="${sessionScope.userId == null}">
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
        <h1>Sports Analytics Pro</h1>
    </div>

    <div id="content">
        <div class="schedule-container">
            <h2>${team.teamName} Schedule</h2>
            <table class="schedule-table">
                <thead>
                <tr>
                    <th>Game Date</th>
                    <th>Home Team</th>
                    <th>Away Team</th>
                    <th>Game Time</th>
                </tr>
                </thead>
                <tbody>
                <%--access teamSchedule object from Teams --%>
                <c:forEach var="gameEntry" items="${team.teamSchedule}">
                    <tr>
                        <td>${gameEntry.value.gameDate}</td>
                        <td>${gameEntry.value.home}</td>
                        <td>${gameEntry.value.away}</td>
                        <td>${gameEntry.value.gameTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <%-- footer jsp --%>
    <c:import url="footer.jsp" />
</div>
</body>
</html>
