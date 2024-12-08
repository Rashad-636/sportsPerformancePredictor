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
                    <th>Game</th>
                    <th>BetMGM</th>
                    <th>Bet365</th>
                    <th>FanDuel</th>
                </tr>
                </thead>
                <tbody>
                    <%-- for each game, show the gameDate, away/home teams---%>
                    <c:forEach var="game" items="${games}">
                    <tr>
                        <td>
                            <fmt:parseDate value="${game.gameDate}" pattern="yyyyMMdd" var="parsedDate"/>
                            <fmt:formatDate value="${parsedDate}" pattern="MMM d, yyyy"/>
                        </td>
                        <td class="matchup">
                                ${game.awayTeam} @ ${game.homeTeam}
                        </td>
                            <%-- for each game, get the first 3 sports books and their odds ---%>
                        <c:forEach var="book" items="${game.sportsBooks}" begin="0" end="2">
                            <td class="odds">
                                <div class="odds-group">
                                    <div class="odds-label">Spreads:</div>
                                    <div>Away: ${book.odds.awayTeamSpread} (${book.odds.awayTeamSpreadOdds})</div>
                                    <div>Home: ${book.odds.homeTeamSpread} (${book.odds.homeTeamSpreadOdds})</div>
                                </div>

                                <div class="odds-group">
                                    <div class="odds-label">Moneyline:</div>
                                    <div>Away: ${book.odds.awayTeamMLOdds}</div>
                                    <div>Home: ${book.odds.homeTeamMLOdds}</div>
                                </div>

                                <div class="odds-group">
                                    <div class="odds-label">Total O/U:</div>
                                    <div>${book.odds.totalOver}</div>
                                    <div>Over: ${book.odds.totalOverOdds}</div>
                                    <div>Under: ${book.odds.totalUnderOdds}</div>
                                </div>
                            </td>
                        </c:forEach>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <c:import url="footer.jsp" />
    </div>
</body>
</html>
