<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 12/2/24
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<%-- header jsp --%>
<c:import url="head.jsp" />

<body>
<div id="wrap">
    <div id="header">
        <div id="headerlinks">
            <%-- checking session scope for which links to show---%>
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
        <%-- show all teams that can be added to favorites list in card format ---%>
        <div class="available-teams">
            <h2>Available Teams</h2>
            <%-- loop to show all teams ---%>
            <c:forEach var="team" items="${allTeams}">
                <div class="team-card">
                    <h3>${team.teamName}</h3>
                        <%-- option to add to list of favorites ---%>
                    <form action="addFavorite" method="POST">
                        <input type="hidden" name="teamId" value="${team.id}">
                        <button type="submit">Add to Favorites</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <%-- footer jsp --%>
    <c:import url="footer.jsp" />
</div>
</body>
</html>
