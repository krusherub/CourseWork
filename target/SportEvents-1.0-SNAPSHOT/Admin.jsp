<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Admin</title>

	<meta name="viewport" content="width=device-width, initial-scale=1">

	<link rel="icon" type="image/png" href="https://colorlib.com/etc/lf/Login_v10/images/icons/favicon.ico">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/icon-font.min.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/animate.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/hamburgers.min.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/animsition.min.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/select2.min.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/daterangepicker.css">

	<link rel="stylesheet" type="text/css" href="./Login V10_files/util.css">
	<link rel="stylesheet" type="text/css" href="./Login V10_files/main.css">

	<meta name="robots" content="noindex, follow">

	<style>
		table {
			table-layout: fixed; /* Фиксированная ширина ячеек */
			width: 65%; /* Ширина таблицы */
			text-align: center;
		}
		form{
			display:inline;
		}
		header {
			display: block;
			height: 65px;
			background: #00b0d8 repeat-x center bottom;
		}
	</style>

</head>
<body>
<c:if test="${admin == null}">
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form class="login100-form validate-form flex-sb flex-w" action="AdminServlet" method="post">
<span class="login100-form-title p-b-51">
Login
</span>
					<div class="wrap-input100 validate-input m-b-16" data-validate="Username is required">
						<input class="input100" type="text" name="username" placeholder="Username">
						<span class="focus-input100"></span>
					</div>

					<div class="wrap-input100 validate-input m-b-16" data-validate="Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password">
						<span class="focus-input100"></span>
					</div>

					<div class="flex-sb-m w-full p-t-3 p-b-24">
							${message}
					</div>

					<div class="container-login100-form-btn m-t-17">
						<input class = "login100-form-btn" type="submit" value="Login">
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>

<c:if test="${admin != null}">

	<header>
		<form class="logout" action="Logout">
			<p style="text-align: right"><button>Log out</button>
		</form>
	</header>

	<form action="AddCompetitionServlet" method="post">
		Write the name of the competition <input type="text" name="competitionName" value=""/>
		<input type="submit" value="Add"/> <br>
	</form>

	<table border="1">
	<c:forEach var="competition" items="${allCompetitions}">
		<tr>
			<th>
		<form action="UpdateCompetitionServlet" method="post">
			<input type="text" name="competitionName" value="${competition.getTitle()}" placeholder="Competition Name"/>
			<input type="text" name="competitionResult" value="${competition.getResult()}" placeholder="Competition Result"/>
			<input type='hidden' name='id' value='${competition.getCompId()}' />
			<input type="submit" value="UpdateCompetition"/>
		</form>

		<form action="DeleteCompetitionServlet" method="post" >
			<input type='hidden' name='id' value='${competition.getCompId()}' />
			<input type="submit" value="DeleteCompetition"/>
		</form>

		<form action="AddGameServlet" method="post" >
			<input type='hidden' name='id' value='${competition.getCompId()}' />
			<input type="submit" value="AddGame"/>
		</form>

		<c:forEach var="game" items="${competition.getGames()}">


			<p></p>

		<form action="UpdateGameServlet" method="post" >
			<input type="text" name="gameName" value="${game.getTitle()}" placeholder="Game Name"/>
			<input type="text" name="gameDate" value="${game.getDate()}" placeholder="Date DD/MM/YY"/>
			<input type="text" name="team1" value="${game.getTeam1().getTitle()}" placeholder="Team 1"/>
			<input type="text" name="result" value="${game.getResult()}" placeholder="Result: 's1' - 's2' "/>
			<input type="text" name="team2" value="${game.getTeam2().getTitle()}" placeholder="Team 2"/>
			<input type='hidden' name='id' value='${game.getGameId()}' />

			<input type="submit" value="UpdateGame"/>
		</form>

		<form action="DeleteGameServlet" method="post" >
			<input type='hidden' name='id' value='${game.getGameId()}' />
			<input type="submit" value="DeleteGame"/>
		</form>

		</c:forEach>
			</th>
		</tr>
	</c:forEach>
	</table>


</c:if>





</body>
</html>