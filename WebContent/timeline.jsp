<%@page import="model.persistence.DaoManager"%>
<%@page import="java.util.stream.*"%>
<%@page import="java.util.*"%>
<%@page import="model.javabeans.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<title>Timeline</title>
<meta charset="utf-8">
<link rel="icon" href="Posters/play.png" type="image/x-icon">
<link rel="stylesheet" href="font-awesome-4.4.0/css/font-awesome.min.css" />
<link rel="stylesheet" href="CSS/css.css" />
<script src="JS/controle.js"></script>
</head>
<%
	Map<Integer, List<Data>> map = new DaoManager().readMovies();
	request.setAttribute("map", map);
%>
<body>
	<header>
		<a href="index.jsp" style="float: left;"><i class="fa fa-arrow-left"></i> Back</a>
		<h1>
			TIMELINE <small>(${fn:length(map)})</small>
		</h1>
	</header>
	<section>
		<c:forEach items="${map}" var="item">
			<fieldset>
				<legend>${item.key}
					<small>(${fn:length(item.value)})</small>
				</legend>
				<c:forEach items="${item.value}" var="movie">
					<figure class="Movie">
						<img src="${movie.caminhoPoster}" />
						<figcaption>
							<b>${movie.title}</b>
							<p>${movie.released}</p>
							<p>${movie.rating}</p>
						</figcaption>
					</figure>
				</c:forEach>
			</fieldset>
		</c:forEach>
	</section>
</body>
</html>