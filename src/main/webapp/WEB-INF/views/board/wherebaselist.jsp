<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>    

<style>
.btn {
	background-color: green;
}
</style>
    
<div class="container">
  <h2>구장 테이블</h2>
  <p>등록된 구장 테이블입니다.</p>            
  <table class="table">
    <thead>
      <tr>
        <th>No</th>
        <th>구장</th>
        <th>팀</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="wherebase" items="${whereBases}">
      <tr class="wherebaselist-${wherebase.id}">
        <td>${wherebase.id}</td>
        <td>${wherebase.whereName}</td>
        <td>${wherebase.team.teamName}</td>
        <td><button class="btn" onClick="deleteWherebase(${wherebase.id})">구장 삭제</button></td>
      </tr>
     </c:forEach>
      
    </tbody>
  </table>
</div>
<script>
	function deleteWherebase(id) {
		$.ajax({
			method:"DELETE",
			url: "/wherebase/"+id
		})
		.done((data) => {
			console.log(data);
			if(data === "delete"){
				$(".wherebaselist-"+id).remove();
				history.go(0);
			}
		});
		
	}
</script>
</body>
</html>