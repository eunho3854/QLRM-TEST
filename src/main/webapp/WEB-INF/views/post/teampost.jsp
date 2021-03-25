<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<style>
.form-control {
	width: 20%;
}
</style>

<form action="/team" method="POST">
	<input type="text" placeholder="팀이름" name="teamName" /><br />

	<div class="form-group">
		<select class="form-control" name="whereBaseId">
			<c:forEach var="team" items="${teams}">
				<option value="${team.id}">${team.whereName}</option>
			</c:forEach>
		</select>
	</div>
	<button>팀등록</button>
</form>
</body>
</html>
