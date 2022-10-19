<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>     
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>QNA LIST</title>
</head>
<body>
	<h3> List Page =O.O= </h3>
	
	<div class="list">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">작성자</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>
					<th scope="col">등록일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="qna">
					<tr>
						<td>${qna.num}</td>
						<td>${qna.writer}</td>
						<td>
							<a href="#">${qna.title}</a>
						</td>
						<td>${qna.contents}</td>
						<td>${qna.regDate}</td>
					</tr>
				</c:forEach>
			</tbody>			
		</table>
	</div>
	
	<div class="mb-3">
		<a href="./write" class="btn btn-primary">글쓰기</a>
	</div>
	
	<nav aria-label="Page navigation example">
		  <ul class="pagination">
			  <c:if test="${pager.pre}">
				    <li class="page-item">
				      <a class="page-link" href="./list?page=${pager.startNum-1}" aria-label="Previous">
				        <span aria-hidden="true">&laquo;</span>
				      </a>
				    </li>
			    </c:if>
				
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link" href="./list?page=${i}">${i}</a></li>
				</c:forEach>
			</ul>
		</nav>		
		

<!-- 	<script type="text/javascript">
		let result = '${param.result}';
		if(result != ""){
			if(result == '1'){
			}
			alert('성공 (O.O)9');
		}else {
			alert('실패~,~');
		}			
	</script> -->
	
</body>
</html>