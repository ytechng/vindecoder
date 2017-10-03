<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/sidebar.jsp"%>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<div class="content">
				<!-- breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Profile</li>
							<li class="breadcrumb-item active">Change Password</li>
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
							<div class="card-header primary lighten-1 white-text">
								<h4>CHANGE PASSWORD</h4>
							</div>
							<div class="card-body">

								<table class="table">
									<tr>
										<th>Current Password:</th>
										<td><input class="form-control" type="text"
											name="currentPassword" /></td>
									</tr>
									<tr>
										<th>New Password:</th>
										<td><input class="form-control" type="text"
											name="password" /></td>
									</tr>
									<tr>
										<th>Confirm New Password:</th>
										<td><input class="form-control" type="text"
											name="confirmPassword" /></td>
									</tr>
								</table>

								<div class="col-md-4 mx-auto">
									<button class="form-control btn btn-danger">Change
										Password</button>
									<br>
									<br>
								</div>
							</div>
						</div>
					</div>
					<!--/.Result Panel-->
				</div>
			</div>
			<br>
			<br>
			<br>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>