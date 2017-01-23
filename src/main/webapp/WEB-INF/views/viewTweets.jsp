<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" type="text/css" href="theme/css/main.css" />
<script src="theme/js/jquery-3.1.1.min.js"></script>
<script src="theme/js/viewTweet.js"></script>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SalesForce Tweets</title>
</head>
<body>
	<center>
		<div class="header"><h2>SalesForce Tweets</h2></div>
	</center>

<div class="tweet-filter">
		<input type="text" name="filter" id="filter" placeholder="Filter" />
</div>
		<div class="tweets-content"></div>

</body>
</html>