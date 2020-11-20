<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Manager</title>
<!-- Favicon -->
<link rel="shortcut icon"
	href="<c:url value='/template/web/assets/img/favicon.ico'/>"
	type="image/x-icon">

<!-- Font awesome -->
<link href="<c:url value='/template/web/assets/css/font-awesome.css'/>"
	rel="stylesheet">
<!-- Bootstrap -->
<link href="<c:url value='/template/web/assets/css/bootstrap.css'/>"
	rel="stylesheet">
<!-- Slick slider -->
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/web/assets/css/slick.css'/>">
<!-- Fancybox slider -->
<link rel="stylesheet"
	href="<c:url value='/template/web/assets/css/jquery.fancybox.css'/> "
	type="text/css" media="screen" />
<!-- Theme color -->
<link id="switcher"
	href="<c:url value='/template/web/assets/css/theme-color/default-theme.css'/> "
	rel="stylesheet">

<!-- Main style sheet -->
<link href="<c:url value='/template/web/assets/css/style.css'/> "
	rel="stylesheet">


<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,300,300italic,500,700'
	rel='stylesheet' type='text/css'>
</head>
<body>
	<%@ include file="/common/web/header.jsp"%>
	<%@ include file="/common/web/menu.jsp"%>
	
	<dec:body/>

	<%@ include file="/common/web/footer.jsp"%>


	<!-- jQuery library -->
	<script src="<c:url value='/template/web/assets/js/jquery.min.js'/> "></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="<c:url value='/template/web/assets/js/bootstrap.js'/> "></script>
	<!-- Slick slider -->
	<script type="text/javascript"
		src="<c:url value='/template/web/assets/js/slick.js'/> "></script>
	<!-- Counter -->
	<script type="text/javascript"
		src="<c:url value='/template/web/assets/js/waypoints.js'/> "></script>
	<script type="text/javascript"
		src="<c:url value='/template/web/assets/js/jquery.counterup.js'/>"></script>
	<!-- Mixit slider -->
	<script type="text/javascript"
		src="<c:url value='/template/web/assets/js/jquery.mixitup.js'/> "></script>
	<!-- Add fancyBox -->
	<script type="text/javascript"
		src="<c:url value='/template/web/assets/js/jquery.fancybox.pack.js'/>"></script>


	<!-- Custom js -->
	<script src="<c:url value='/template/web/assets/js/custom.js'/> "></script>
</body>
</html>