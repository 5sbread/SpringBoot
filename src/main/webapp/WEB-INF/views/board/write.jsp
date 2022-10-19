<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Write</title>
	
	<!-- include libraries(jQuery, bootstrap) -->
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- include summernote css/js -->
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>

</head>
<body>
	<h3>Board Write Page</h3>

	<div>
		<form action="./write" method="post" enctype="multipart/form-data">
			<!-- 작성자 제목 내용 -->
			<div class="mb-3">
			   <label for="title" class="form-label">Title</label>
			   <input type="text" class="form-control" id="title" name="title">
			</div>		
			<div class="mb-3">
			   <label for="writer" class="form-label">Writer</label>
			   <input type="text" class="form-control" id="writer" name="writer">
			</div>
			<div class="mb-3">
				<label for="contents" class="form-label">Contents</label>
				<textarea id="summernote" name="contents"></textarea>
			</div>
			<div class="mb-3">
			   <label for="file" class="form-label">File</label>
			   <input type="file" class="form-control" id="file">
			</div>
			<div class="mb-3">
			   <label for="file2" class="form-label">File2</label>
			   <input type="file" class="form-control" id="file2">
			</div>												
			<button type="submit" class="btn btn-primary">Submit</button>			
		</form>
	</div>


	<script type="text/javascript">
		$(document).ready(function() {
			$('#summernote').summernote();
		});
	</script>

</body>
</html>