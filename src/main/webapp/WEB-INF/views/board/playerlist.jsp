<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<style>
.btn {
	background-color: green;
}
</style>

<div class="container">
  <h2>선수 테이블</h2>
  <p>등록된 선수들입니다.</p>            
  <table class="table">
    <thead>
      <tr>
        <th>No</th>
        <th>이름</th>
        <th>포지션</th>
        <th>팀</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="player" items="${players}">
      	<tr class="playerlist-${player.id}">
      		<td>${player.id}</td>
        	<td>${player.name}</td>
        	<td>${player.position}</td>
        	<td>${player.team.teamName}</td>
        	<td><button class="btn" onClick="deletePlayer(${player.id})">선수 삭제</button></td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
</div>
<script>
	function deletePlayer(id) {
		$.ajax({
			method:"DELETE",
			url: "/player/"+id
		})
		.done((data) => {
			console.log(data);
			if(data === "delete"){
				$(".playerlist-"+id).remove();
				history.go(0);
			}
		});
		
	}
</script>
</body>
</html>