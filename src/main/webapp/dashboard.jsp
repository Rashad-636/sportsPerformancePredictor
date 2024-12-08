<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 12/2/24
  To change this template use File | Settings | File Templates.
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
    <div id="content">
      <div class="favorites-dashboard">
        <h2>My Teams</h2>

        <div class="team-cards-container">
          <%-- check if user has any favorite teams ---%>
          <c:if test="${empty favoriteTeams}">
            <p>No favorite teams added yet!</p>
          </c:if>

          <%-- loop and show each of the user's favorite teams in card format ---%>
          <c:forEach var="favorite" items="${favoriteTeams}">
            <div class="team-card">
              <h3>${favorite.team.teamName}</h3>
              <ul class="team-links">
                <li><a href="schedule?team_abv=${favorite.team.teamAbv}">Schedule</a></li>
              </ul>
              <form action="removeFavorite" method="POST">
                <input type="hidden" name="teamId" value="${favorite.team.id}">
                <button type="submit" class="remove-btn">Remove from Favorites</button>
              </form>
            </div>
          </c:forEach>
        </div>

        <div class="add-teams-section">
          <a href="allTeams" class="add-teams-btn">Add More Teams to Favorite List</a>
        </div>
      </div>
    </div>

  <%-- footer jsp --%>
  <c:import url="footer.jsp" />
</div>
</body>
</html>