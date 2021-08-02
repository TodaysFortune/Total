<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>

<html lang="ko">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>레이아웃</title>
        <!-- Bootstrap core CSS , js -->
        <link type="text/css" href="/css/bootstrap.min.css" rel="stylesheet"> 
        <script type="text/javascript" src="/js/bootstrap.js"></script>
        
        <!-- Custom styles for this template -->
        <link type="text/css" href="/css/navbar.css" rel="stylesheet"> 
    </head>
    
<body>
	
    <!--상단 https://bootswatch.com/sketchy/-->
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <jsp:include page="/WEB-INF/views/common/nav.jsp" flush="false"/>
	</nav>
    <!--//상단 -->
 <!--중단-->  
<div class="d-flex gap-md-2 flex-wrap" style="justify-content:center; height:100%; margin-top:1rem;">
	
    <!--중단1 -->
  <div class="card text-white bg-warning" style="width:34%; height:auto;align-item: center; justify-content:center; ">
  	<div class="card-header" style="align-item: center;">New</div>
  	<div class="card-body" style="align-item: center;">
    
    
		<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; align-item: center; margin:1px;">
			  <thead>
			    <tr class="th-user-fonesize">
			      <th scope="col" class="col-2 text-center">분류</th>
			      <th scope="col" class="col-8 text-center">제목</th>
			      <th scope="col" class="col-2 text-center">추천</th>
			    </tr>
			  </thead>
			  <tbody>
			  			<!--                      NEW                        -->
			  	<c:set var="NewList" value="${totalNewList.list}"/>
			  	<c:forEach var="dto" items="${NewList}">
			  		<tr class="table-active td-user-fontsize">
			      		<th scope="row" class="text-center">${dto.url.substring(0,dto.url.length()-5)}</th>
			      		<td onclick="location.href='/moveBoard?bidx=${dto.bidx}&url=${dto.url}'">${dto.subject}</td>
			      		<td class="text-center">${dto.good}</td>
			    	</tr>
			  	</c:forEach>
			  	<c:set var="LeftNewListlength" value="${num-NewList.size()}"/>
			  	<c:forEach begin="1" end="${LeftNewListlength}" step="1">
			  		<tr class="table-active td-user-fontsize">
			  			<th scope="row" class="text-center">&nbsp;</th>
			  			<td>&nbsp;</td>
			      		<td class="text-center">&nbsp;</td>
			  		</tr>
			  	</c:forEach>
			  </tbody>
		</table>
  	</div>
 </div>
 <!--//중단1 -->
 <!--중단2 -->
    
<div class="card text-white bg-danger" style="width:34%; height:auto; align-item: center; justify-content:center;">
  <div class="card-header" style="align-item: center;">Best</div>
  <div class="card-body" style="align-item: center;">
    
    
	<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; margin:1px;">
		  <thead>
		    <tr class="th-user-fonesize">
		      <th scope="col" class="col-2 text-center">분류</th>
		      <th scope="col" class="col-8 text-center">제목</th>
		      <th scope="col" class="col-2 text-center">추천</th>
		    </tr>
		  </thead>
		  <tbody>
		  			<!--                      BEST                        -->
		    	<c:set var="GoodList" value="${totalGoodList.list}"/>
			  	<c:forEach var="dto" items="${GoodList}">
			  		<tr class="table-active td-user-fontsize">
			      		<th scope="row" class="text-center">${dto.url.substring(0,dto.url.length()-5)}</th>
			      		<td onclick="location.href='/moveBoard?bidx=${dto.bidx}&url=${dto.url}'">${dto.subject}</td>
			      		<td class="text-center">${dto.good}</td>
			    	</tr>
			  	</c:forEach>
			  	<c:set var="LeftGoodListlength" value="${num-GoodList.size()}"/>
			  	<c:forEach begin="1" end="${LeftGoodListlength}" step="1">
			  		<tr class="table-active td-user-fontsize">
			  			<th scope="row" class="text-center">&nbsp;</th>
			  			<td>&nbsp;</td>
			      		<td class="text-center">&nbsp;</td>
			  		</tr>
			  	</c:forEach>
		  </tbody>
	</table>
	

  </div>
</div>   
    <!--//중단2 -->
     <!--중단3 -->
  <div class="card text-white bg-info" style="width:34%; height:auto;align-item: center; justify-content:center;">
  	<div class="card-header" style="align-item: center;">IT</div>
  	<div class="card-body" style="align-item: center;">
    
    
		<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; align-item: center; margin:1px;">
			  <thead>
			    <tr class="th-user-fonesize">
			      <th scope="col" class="col-2 text-center">최신글</th>
			      <th scope="col" class="col-8 text-center">제목</th>
			      <th scope="col" class="col-2 text-center">추천</th>
			    </tr>
			  </thead>
			  <tbody>
			  			<!--                      IT                        -->
			    	<c:set var="itList" value="${iTboardList.list}"/>
			  		<c:forEach var="dto" items="${itList}">
				  		<tr class="table-active td-user-fontsize">
				      		<th scope="row" class="text-center">${dto.bidx}</th>
				      		<td onclick="location.href='/moveBoard?bidx=${dto.bidx}&url=${dto.categoryname}'">${dto.subject}</td>
				      		<td class="text-center">${dto.good}</td>
				    	</tr>
			  		</c:forEach>
			    	<c:set var="LeftitListlength" value="${num-itList.size()}"/>
			  		<c:forEach begin="1" end="${LeftitListlength}" step="1">
			  			<tr class="table-active td-user-fontsize">
				  			<th scope="row" class="text-center">&nbsp;</th>
				  			<td>&nbsp;</td>
				      		<td class="text-center">&nbsp;</td>
			  			</tr>
			  		</c:forEach>
			    
			  </tbody>
		</table>
  	</div>
 </div>
 <!--//중단3 -->
 <!--중단4 -->
    
<div class="card text-white bg-success" style="width:34%; height:auto; align-item: center; justify-content:center;">
  <div class="card-header" style="align-item: center;">유머</div>
  <div class="card-body" style="align-item: center;">
    
    
	<table class="table table-hover" style="width:99%; min-height:99%; height:auto; background-color: #fff; border-bottom-left-radius: 7px; border-bottom-right-radius: 7px; margin:1px;">
		  <thead>
		    <tr class="th-user-fonesize">
		      <th scope="col" class="col-2 text-center">최신글</th>
		      <th scope="col" class="col-8 text-center">제목</th>
		      <th scope="col" class="col-2 text-center">추천</th>
		    </tr>
		  </thead>
		  <tbody>
		  			<!--                      Humor                        -->
		    	<c:set var="humorList" value="${humorboardList.list}"/>
			  		<c:forEach var="dto" items="${humorList}">
				  		<tr class="table-active td-user-fontsize">
				      		<th scope="row" class="text-center">${dto.bidx}</th>
				      		<td onclick="location.href='/moveBoard?bidx=${dto.bidx}&url=${dto.categoryname}'">${dto.subject}</td>
				      		<td class="text-center">${dto.good}</td>
				    	</tr>
			  	</c:forEach>
		    	<c:set var="LefthumorListlength" value="${num-humorList.size()}"/>
			  		<c:forEach begin="1" end="${LefthumorListlength}" step="1">
			  			<tr class="table-active td-user-fontsize">
				  			<th scope="row" class="text-center">&nbsp;</th>
				  			<td>&nbsp;</td>
				      		<td class="text-center">&nbsp;</td>
			  			</tr>
			  		</c:forEach>
		  </tbody>
	</table>
	

  </div>
</div>   
    <!--//중단4 -->
 </div>
 <!--//중단-->
 <div style="height:30px;">
 </div>
 <script type="text/javascript" src="/js/common.js"></script>
</body>
</html>
