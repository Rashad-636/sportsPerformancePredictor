<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

<%-- header jsp --%>
<c:import url="head.jsp" />

    <body>
        <div id="wrap">

            <c:import url="header.jsp" />

        <div id="content">
            <h2>Mission Statement <span class="post-span"></span></h2>
            <img src="images/analytics.jpg" class="post-img" alt="Bild" />
            <div class="features-section">
                <p>Sports Analytics Pro empowers fans to track their favorite team's game schedules,
                predictive analytics, and personalized statistics to enhance their engagement with professional sports.
                Check out the NBA Today link to view a list of today's games with odds updated in real time from BetMGM,
                Bet365 and Fanduel. While other features and sports are still in the works, feel free to create an
                account to start tracking your favorite nba teams and their schedules!</p>
            </div>

            <div class="nba-section">
                <h2>NBA <span class="post-span">powered by: RapidApi</span></h2>
                <img src="images/nba.jpeg" class="post-img" alt="Bild" />
                <div class="features-section">
                    <p class="features-heading">Features coming soon:</p>
                    <ul class="features-list">
                        <li>Top news and headlines</li>
                        <li>Fantasy point projections</li>
                        <li>Real time daily scoreboards</li>
                        <li>Team rosters and depth charts for team favorites</li>
                        <li>Team injury reports</li>
                    </ul>
                </div>
            </div>

            <h2>NFL <span class="post-span">powered by: RapidApi</span></h2>
            <img src="images/nfl.jpg" class="post-img" alt="Bild" />
            <p>Coming Soon</p>
        </div>

        <%-- footer jsp --%>
        <c:import url="footer.jsp" />
        </div>
    </body>
</html>