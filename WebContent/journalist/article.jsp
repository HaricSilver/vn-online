<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>New article</title>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script src="../js/jquery-2.1.3.js"></script>
<script src="../js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../js/metisMenu.min.js"></script>
<link href="../css/metisMenu.min.css" rel="stylesheet">

<!-- Admin css/js -->
<link href="../css/sb-admin-2.css" rel="stylesheet">
<script src="../js/sb-admin-2.js"></script>

<link rel="stylesheet" type="text/css"
	href="../css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="../css/summernote.css">
<script type="text/javascript" src="../js/summernote.min.js"></script>

<link href="../css/globalStyle.css" rel="stylesheet">
<script type="text/javascript">
	$(document).ready(function(e) {
		$("#summernote").summernote({
			height : 180,
			minHeight : 90
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../master/admin-dashboard-master.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-md-12">
					<h1 class="page-header">New Article</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<form action="../ArticleServlet?action=create" method="POST" role="form">
						<!-- <legend><h1 class="page-header">New Article</h1></legend> -->

						<div class="form-group">
							<label for="">Title</label> <input type="text"
								class="form-control" name="title" placeholder="Title">
						</div>
						<div class="form-group">
							<label for="">Alias</label> <input type="text"
								class="form-control" name="alias" placeholder="Alias">
						</div>
						<div class="form-group">
							<label for="">Content</label>
							<div id="summernote" name="content"></div>
						</div>
						<div class="form-group">
							<label for="">Short content</label> <input type="text"
								class="form-control" name="shortContent" placeholder="Short content">
						</div>

						<button type="submit" class="btn btn-primary pull-right">Submit</button>
					</form>
				</div>
			</div>
			
			<div class="footer-bottom">
				<div class="row text-center">
					<div class="col-md-12">
						<p class="clear-margin">Copyright &copy; 2015 by XXX{mE}</p>
					</div>
				</div>
			</div>
			<!-- .container -->
		</div>
		<!-- .page-wrapper -->
	</div>
	<!-- .wrapper -->
</body>
</html>