<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>QNA LIST</title>
</head>
<body>
	<h3> List Page =O.O= </h3>
	
	<div class="list">
		<table>
			<thead>
				<tr>
					<th scope="col">번호</th>
					<th scope="col">제목</th>
					<th scope="col">작성자</th>
					<th scope="col">등록일</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${list}" var="qna">
					<tr>
						<td>${qna.num}</td>
						<td><%-- 
							<c:catch>
								<c:forEach begin="1" end="${qna.depth}">&ensp</c:forEach>
							</c:catch> --%>
							<a href="#">${qna.title}</a>
						</td>
						<td>${qna.writer}</td>
						<td>${qna.regDate}</td>
					</tr>
				</c:forEach>
			</tbody>			
		</table>
	</div>


</body>
</html>