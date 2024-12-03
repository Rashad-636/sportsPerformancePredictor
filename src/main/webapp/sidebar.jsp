<%--
  Created by IntelliJ IDEA.
  User: rashadadams
  Date: 9/18/24
--%>
<div id="wrap">
    <div id="header">
        <div id="headerlinks">
            <c:choose>
                <c:when test="${sessionScope.userId == null}">
                    <a href="logIn">Sign In</a>
                </c:when>
                <c:otherwise>
                    <a href="dashboard">My Teams</a>
                    <a href="signout">Sign Out</a>
                    <span style="color: white;">${userName}</span>
                </c:otherwise>
            </c:choose>
        </div>
        <h1>Sports Analytics Pro</h1>
    </div>

    <div id="sidebar">
        <h2>NBA</h2>
        <div class="box">
            <ul>
                <li><a href="#">coming soon ...</a></li>
            </ul>
        </div>
    </div>
</div>