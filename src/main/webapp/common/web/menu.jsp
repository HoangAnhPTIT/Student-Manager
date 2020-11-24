<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.hoanganh.util.SecurityUtil"%>
<!-- Start menu -->
<section id="mu-menu">
	<nav class="navbar navbar-default" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<!-- FOR MOBILE VIEW COLLAPSED BUTTON -->
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!-- LOGO -->
				<!-- TEXT BASED LOGO -->
				<a class="navbar-brand" href="index.html"><i
					class="fa fa-university"></i><span>School</span></a>
				<!-- IMG BASED LOGO  -->
				<!-- <a class="navbar-brand" href="index.html"><img src="assets/img/logo.png" alt="logo"></a> -->
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul id="top-menu" class="nav navbar-nav navbar-right main-nav">
					<li class="active"><a href="index.html">Home</a></li>
					<li class="dropdown"><a href="<c:url value='dang-ky-mon-hoc'/>">Đăng ký học phần </a>
					<li><a href="gallery.html">Gallery</a></li>

					<li><a href="contact.html">Contact</a></li>



					<security:authorize access="isAnonymous()">
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/dang-nhap'/>"">Đăng nhập</a></li>
						<li class="nav-item"><a class="nav-link" href="#">Đăng ký</a></li>
					</security:authorize>
					<security:authorize access="isAuthenticated()">
						<li class="nav-item"><a class="nav-link" href="#"> <%=SecurityUtil.getPrincipal().getFullName()%></a></li>
						<li class="nav-item"><a class="nav-link"
							href="<c:url value='/thoat'/>">Thoát</a></li>
					</security:authorize>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>
</section>
<!-- End menu -->