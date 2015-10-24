<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Category Manager</title>

<link rel="stylesheet" type="text/css" href="../css/bootstrap.min.css">
<script src="../js/jquery-2.1.3.js"></script>
<script src="../js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="../js/metisMenu.min.js"></script>
<link href="../css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="../css/dataTables.bootstrap.css" rel="stylesheet">
<!-- DataTables Responsive CSS -->
<link href="../css/dataTables.responsive.css" rel="stylesheet">

<!-- DataTables JavaScript -->
<script src="../js/jquery.dataTables.min.js"></script>
<script src="../js/dataTables.bootstrap.min.js"></script>

<!-- Admin css/js -->
<link href="../css/sb-admin-2.css" rel="stylesheet">
<script src="../js/sb-admin-2.js"></script>

<link rel="stylesheet" type="text/css"
	href="../css/font-awesome.min.css">

<link rel="stylesheet" type="text/css" href="../css/globalStyle.css">
<script>
	$(document).ready(function() {
		$('#dataTables').DataTable({
			responsive : true
		});
	});
</script>
</head>
<body>
	<div id="wrapper">
		<jsp:include page="../master/admin-dashboard-master.jsp"></jsp:include>
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">Category Manager</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<label>New category</label>
					<form action="../CategoryServlet?action=create" method="POST"
						class="form-inline" role="form">
						<div class="form-group">
							<label class="sr-only" for="">New category</label> <input
								name="name" type="text" class="form-control"
								placeholder="Category name">
						</div>
						<button type="submit" class="btn btn-primary">Create</button>
					</form>
				</div>
			</div>

			<div class="row">
				<div class="col-lg-12 clear-padding">
					<div class="panel panel-default">
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="dataTable_wrapper">
								<table class="table table-striped table-bordered table-hover"
									id="dataTables">
									<thead>
										<tr>
											<th>#</th>
											<th>Name</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="row" items="${CategoryDao.list()}">
											<tr>
												<td class="center">Trident</td>
												<td>Internet Explorer 4.0</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
		</div>
		<!-- .page-wrapper -->
	</div>
	<!-- .wrapper -->
</body>
</html>