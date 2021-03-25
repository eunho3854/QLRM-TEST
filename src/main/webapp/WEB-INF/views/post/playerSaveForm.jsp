<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<style>
.form-control {
	width: 20%;
}
</style>

<form action="/player" method="POST">
	<input type = "text" placeholder="선수이름" name="name"/><br/>
	<input type = "text" placeholder="포지션" name="position"/><br/>
	<div class="form-group">
	  			<select class="form-control" name="teamId">
	  				<c:forEach var="team" items="${team}">
	  					<option value="${team.id}">${team.teamName}</option>
					</c:forEach>
	  			</select>
	  		</div>
	<button>선수등록</button>
</form>
</body>
</html> 