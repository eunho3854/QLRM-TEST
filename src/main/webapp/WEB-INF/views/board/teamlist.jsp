<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>    

<style>
.btn {
	background-color: green;
}
</style>    
<div class="container">
  <h2>팀 테이블</h2>
  <p>등록된 팀 테이블입니다.</p>             
  <table class="table">
    <thead>
      <tr>
        <th>No</th>
        <th>팀 이름</th>
        <th>구장</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="team" items="${teams}">
      <tr class="teamlist-${team.id}">
        <td>${team.id}</td>
        <td>${team.teamName}</td>
        <td>${team.whereBase.whereName}</td>
        <td><button class="btn" onClick="deleteTeam(${team.id})">팀 삭제</button></td>
      </tr>
    </c:forEach>
      
    </tbody>
  </table>
</div>
<script>
	function deleteTeam(id) {
		$.ajax({
			method:"DELETE",
			url: "/team/"+id
		})
		.done((data) => {
			console.log(data);
			if(data === "delete"){
				$(".teamlist-"+id).remove();
				history.go(0);
			}
		});
		
	}
</script>
</body>
</html>