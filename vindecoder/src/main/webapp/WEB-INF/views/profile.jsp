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
							<li class="breadcrumb-item active">My Profile</li>
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
								<h4>PROFILE DETAILS</h4>
							</div>
							<div class="card-body">
	
								<table class="table table-striped">
									<tr>
										<th>First Name:</th>
										<td>Opeyemi</td>
									</tr>
									<tr>
										<th>Last Name:</th>
										<td>Ajayi</td>
									</tr>
									<tr>
										<th>Company Name:</th>
										<td>Whytech Solutions Auto</td>
									</tr>
									<tr>
										<th>Email Address:</th>
										<td>ytechng@gmail.com</td>
									</tr>
									<tr>
										<th>Date Registered:</th>
										<td>28-09-2017</td>
									</tr>
									<tr>
										<th>Model Year</th>
										<td>2003</td>
									</tr>
	
								</table>
	
								<div class="col-md-4 mx-auto">
									<a href="${contextRoot}/editProfile"
										class="form-control btn btn-info">Edit Profile</a>
								</div>
							</div>
							</div>
						</div>
					</div>
					<!--/.Result Panel-->
				</div>
				<br><br>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->

</div>