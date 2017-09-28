<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/categories.jsp"%>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<div class="content">
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