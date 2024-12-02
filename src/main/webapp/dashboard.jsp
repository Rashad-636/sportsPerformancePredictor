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
    <div class="favorites-dashboard">
      <h2>My Teams</h2>
      <c:forEach var="team" items="${favoriteTeams}">
        <div class="team-card">
          <h3>${team.teamName}</h3>
          <ul class="team-links">
            <li><a href="schedule?teamId=${team.id}">Schedule</a></li>
            <li><a href="stats?teamId=${team.id}">Stats & Predictions</a></li>
            <li><a href="boxscore?teamId=${team.id}">Box Score</a></li>
          </ul>
        </div>
      </c:forEach>
    </div>
  </div>

  <%-- footer jsp --%>
  <c:import url="footer.jsp" />
</div>
</body>
</html>
