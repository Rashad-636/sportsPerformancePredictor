<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<%-- header jsp --%>
<c:import url="head.jsp" />

    <body>
        <div id="wrap">
        <%-- sidebar jsp --%>
            <div id="header">
                <div id="headerlinks">
                    <c:choose>
                        <c:when test="${sessionScope.userId == null}">
                            <a href="logIn">Sign In</a>
                            <a href="dailySchedule">NBA Today</a>
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
            <h2>Mission Statement <span class="post-span"></span></h2>
            <img src="images/analytics.jpg" class="post-img" alt="Bild" />
            <p>Sports Analytics Pro empowers fans to track their favorite team's game schedules,
                predictive analytics, and personalized statistics to enhance their engagement with professional sports.
                While other features and sports are still in the works, feel free to create an account to start tracking your
                favorite nba teams and their schedules!</p>

            <h2>NBA <span class="post-span">powered by: RapidApi</span></h2>
            <img src="images/nba.jpeg" class="post-img" alt="Bild" />
            Features coming soon
            <ul>
                <li>Top news and headlines</li>
                <li>Fantasy point projections</li>
                <li>Real time daily scoreboards </li>
                <li>Team rosters and depth charts for team favorites</li>
                <li>team injury reports</li>
            </ul>

            <h2>NFL <span class="post-span">powered by: RapidApi</span></h2>
            <img src="images/nfl.jpg" class="post-img" alt="Bild" />
            <p>Coming Soon</p>
        </div>

        <%-- footer jsp --%>
        <c:import url="footer.jsp" />
        </div>
    </body>
</html>