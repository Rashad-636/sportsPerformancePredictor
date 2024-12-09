<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 12/2/24
  To change this template use File | Settings | File Templates.
  all nba teams
--%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<%-- header jsp --%>
<c:import url="head.jsp" />

<body>
<div id="wrap">

    <c:import url="header.jsp" />

    <div id="content">
        <%--- show all teams that can be added to favorites list in card format ---%>
        <div class="available-teams">
            <h2>Available Teams</h2>
            <%--- loop to show all teams ---%>
            <c:forEach var="team" items="${allTeams}">
                <%--- preset isAlreadyFavorite to false ---%>
                <c:set var="isAlreadyFavorite" value="false"/>
                <%--- loop through user favorite teams ---%>
                <c:forEach var="favorite" items="${userFavorites}">
                    <%--- if user favorite teamID equals the teamID ---%>
                    <%--- set isAlreadyFavorite to true and do nothing ---%>
                    <c:if test="${favorite.team.id == team.id}">
                        <c:set var="isAlreadyFavorite" value="true"/>
                    </c:if>
                </c:forEach>

                <%--- if they do not equal, show team card the page ---%>
                <c:if test="${!isAlreadyFavorite}">
                    <div class="team-card">
                        <h3>${team.teamName}</h3>
                            <%-- option to add to list of favorites ---%>
                        <form action="addFavorite" method="POST">
                            <input type="hidden" name="teamId" value="${team.id}">
                            <button type="submit">Add to Favorites</button>
                        </form>
                    </div>
                </c:if>
            </c:forEach>
        </div>
    </div>

    <%-- footer jsp --%>
    <c:import url="footer.jsp" />
</div>
</body>
</html>
