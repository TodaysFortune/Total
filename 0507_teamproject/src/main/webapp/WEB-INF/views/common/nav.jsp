<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<title>nav</title>
</head>
<body>
	<div class="container-fluid">
		<a class="navbar-brand" href="/">Home</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarColor03" aria-controls="navbarColor03"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse"
			style="justify-content: space-between">
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#"
					role="button" aria-haspopup="true" aria-expanded="false">community</a>
					<div class="dropdown-menu">
						<a class="dropdown-item" href="/itboard">It 시사</a> <a
							class="dropdown-item" href="/humorboard">유머</a>
						<div class="dropdown-divider"></div>
						<a class="dropdown-item" href="https://opentutorials.org/course/1">생활코딩</a>
					</div></li>

			</ul>


			<form class="d-flex" action="/totalBoard" method="get">
				<div class="btn-group" role="group"
					aria-label="Button group with nested dropdown">
					<input type="button" class="btn btn-primary" id="searchType_view"
						value="전체" /> <input type="hidden" id="searchType"
						name="searchType" value="all" />
					<div class="btn-group" role="group">
						<button id="btnGroupDrop1" type="button"
							class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"></button>
						<div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
							<a class="dropdown-item" href="#" onclick="dropdown(this)"
								id="all">전체</a> <a class="dropdown-item" href="#"
								onclick="dropdown(this)" id="subject">제목</a> <a
								class="dropdown-item" href="#" onclick="dropdown(this)"
								id="content">내용</a> <a class="dropdown-item" href="#"
								onclick="dropdown(this)" id="name">작성자</a>
						</div>
					</div>
				</div>
				<input name="searchText"
					class="form-control ms-sm-2 me-sm-2 board-search" type="text"
					placeholder="검색">
				<button class="btn btn-secondary my-2 my-sm-0" type="submit">Search</button>
			</form>

			<div style="display: flex;">
				<!--  <div id="greet"></div>
	      <form id="logoutForm"></form> -->
				<sec:authorize access="hasRole('ROLE_USER')">
					<div style="margin-right: 10px; font-size: 0.5em">
						<a href="http://www.naver.com"> 
							<img
							src="/images/userlogin.png"
							style="width: 2.5rem; height: 2.5rem;"/>
						</a> 
						<span style="font-size: 0.8rem;"><sec:authentication property="name"/></span>
					</div>
					<form method="post" action="/logout">
						<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Logout</button>
					</form>
				</sec:authorize>
				<sec:authorize access="isAnonymous()">
					<form method="get" action="/login" id="userLogin">
						<button type="submit" class="btn me-sm-1 rounded-pill btn-info">Login</button>
					</form>
					<form method="get" action="/signin" id="userSign">
						<button type="submit" class="btn rounded-pill btn-outline-info">Sign</button>
					</form>
				</sec:authorize>
			</div>
		</div>
	</div>
</body>
</html>