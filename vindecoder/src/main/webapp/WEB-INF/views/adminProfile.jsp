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
							<li class="breadcrumb-item active">Profile</li>
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
								<h4><span class="fa fa-user"></span> PROFILE DETAILS</h4>
							</div>
							<div class="card-body">
	
								<table class="table table-striped">
									<tr>
										<th>First Name:</th>
										<td>${userModel.firstName}</td>
									</tr>
									<tr>
										<th>Last Name:</th>
										<td>${userModel.lastName}</td>
									</tr>
									<tr>
										<th>Phone Number:</th>
										<td>${userModel.phoneNo}</td>
									</tr>
									<tr>
										<th>Company Name:</th>
										<td>${userModel.companyName}</td>
									</tr>
									<tr>
										<th>Company Address:</th>
										<td>${userModel.companyAddress}</td>
									</tr>
									<tr>
										<th>Email Address:</th>
										<td>${userModel.email}</td>
									</tr>
									<tr>
										<th>Date Registered:</th>
										<td>${userModel.regDate}</td>
									</tr>
									<tr>
										<th>Role</th>
										<td>${userModel.role}</td>
									</tr>
	
								</table>
	
								<div class="col-md-3 mx-auto">
									<a href="${contextRoot}/manage/editProfile" class="form-control btn btn-info">
										<span class="fa fa-edit"></span> Edit Profile
									</a>
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