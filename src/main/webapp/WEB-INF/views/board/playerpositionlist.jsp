<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
    
<div class="container">
  <h2>포지션별 선수 테이블</h2>
  <p>포지션으로 정리한 선수테이블입니다.</p>            
  <table class="table">
    <thead>
      <tr>
        <th>포지션</th>
        <th>롯데</th>
        <th>엔시</th>
        <th>삼성</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="player" items="${players}">
      	<tr>
      		<td>${player.position}</td>
        	<td>${player.lotte}</td>
        	<td>${player.nc}</td>
        	<td>${player.samsung}</td>
      </tr>
      </c:forEach>
    
    </tbody>
  </table>
</div>

</body>
</html>