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
					<form action="" method="POST" role="form">
						<!-- <legend><h1 class="page-header">New Article</h1></legend> -->

						<div class="form-group">
							<label for="">Title</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>
						<div class="form-group">
							<label for="">Alias</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>
						<div class="form-group">
							<label for="">Content</label>
							<div id="summernote"></div>
						</div>
						<div class="form-group">
							<label for="">Short content</label> <input type="text"
								class="form-control" id="" placeholder="Input field">
						</div>

						<button type="submit" class="btn btn-primary">Submit</button>
					</form>
				</div>
			</div>
		</div>
		<!-- .page-wrapper -->
	</div>
	<!-- .wrapper -->
</body>
</html>