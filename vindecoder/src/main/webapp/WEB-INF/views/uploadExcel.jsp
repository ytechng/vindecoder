<div class="container">

	<div class="row">
		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/sidebar.jsp"%>
		</div>

		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<div class="content">
				<br>
				<!-- breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Admin</li>
							<li class="breadcrumb-item active">Upload Excel</li>
						</ol>
					</div>
				</div>
				<!-- /breadcrumb component -->
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel"></div>

				<div class="row">
					<!-- Result Panel -->
					<div class="col-md-12">
						<div class="card">
							<form method="POST" action="${contextRoot}/manage/uploadExcelFile" enctype="multipart/form-data">
								<div class="card-header primary lighten-1 white-text">
									<h4><span class="fa fa-book"></span> Upload Excel File</h4>
								</div>
								<div class="card-body">
		
									<div class="col-md-6 mx-auto">
										<input type="file" name="file" accept=".xls,.xlsx" class="form-control" />
									</div><br>
									
									<!-- hidden fields -->
									<input type="hidden" name="id" value="${userModel.id}"/>
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
									<div class="col-md-4 mx-auto">
										<button type="submit" class="form-control btn btn-primary">
											<span class="fa fa-book"></span> Upload the file
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<!--/.Result Panel-->
				</div>
				
				<div style="padding-bottom: 20%;">
				</div>

		</div>
		<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->

</div>