<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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

        <c:import url="header.jsp" />

    <div id="content">
        <div class="schedule-container">
            <h2>${team.teamName} Schedule</h2>
            <table class="schedule-table" id="scheduleTable">
                <thead>
                <tr>
                    <th>Game Date</th>
                    <th>Home Team</th>
                    <th>Away Team</th>
                    <th>Game Time</th>
                </tr>
                </thead>
                <tbody>
                <%--access teamSchedule object from Teams, and order by key (gameID) by comparison --%>
                <%--new chronologicial schedule converted into sortedGames variable to be iteraited below --%>
                <c:set var="sortedGames" value="${team.teamSchedule.entrySet().stream().sorted((a,b) -> a.key.compareTo(b.key)).toList()}"/>

                <%--- loop through mapped list variable sortedGames like in our test --%>
                <c:forEach var="game" items="${sortedGames}"> <%-- for each game in the new sortedGames schedule --%>
                    <tr>
                        <td><fmt:parseDate value="${game.value.gameDate}" pattern="yyyyMMdd" var="parsedDate"/>
                            <fmt:formatDate value="${parsedDate}" pattern="MMM d, yyyy"/></td>
                        <td>${game.value.home}</td>
                        <td>${game.value.away}</td>
                        <td>${game.value.gameTime}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <script>
                $(document).ready(function() {
                    $('.schedule-table').DataTable();
                });
            </script>
        </div>
    </div>

    <%-- footer jsp --%>
    <c:import url="footer.jsp" />
</div>
</body>
</html>
