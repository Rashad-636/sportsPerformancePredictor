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
            <img src="images/sportsAnalytics.jpeg" class="post-img" alt="Bild" />
            <p>Sports Analytics Pro empowers fans to track their favorite team's game schedules,
                predictive analytics, and personalized statistics to enhance their engagement with professional sports.
                While other features and sports are still in the works, feel free to create an account to start tracking your
                favorite nba teams and their schedules!</p>

            <h2>NBA <span class="post-span">powered by: RapidApi</span></h2>
            <img src="images/nba.jpeg" class="post-img" alt="Bild" />
            <p>Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>

            <h2>NFL <span class="post-span">powered by: RapidApi</span></h2>
            <img src="images/nfl.jpg" class="post-img" alt="Bild" />
            <p>Coming Soon</p>
        </div>

        <%-- footer jsp --%>
        <c:import url="footer.jsp" />
        </div>
    </body>
</html>