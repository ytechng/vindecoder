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
						<!-- Display error message if login failed -->
						<c:if test="${not empty successMsg}">
							<div class="alert alert-success alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>${successMsg}</strong>
							</div>
						</c:if>
						<c:if test="${not empty errorMsg}">
							<div class="alert alert-danger alert-dismissible">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>${errorMsg}</strong>
							</div>
						</c:if>
					
						<div class="card">
							<div class="card-header primary lighten-1 white-text">
								<h4><span class="fa fa-key"></span> CHANGE PASSWORD</h4>
							</div>
							<div class="card-body">
								<form method="GET" id="formChangePassword" action="${contextRoot}/business/updatePassword">
									<table class="table">
										<tr>
											<th>Current Password:</th>
											<td><input class="form-control" type="password"
												name="currentPassword" id="currentPassword"/></td>
										</tr>
										<tr>
											<th>New Password:</th>
											<td><input class="form-control" type="password"
												name="password" id="password"/></td>
										</tr>
										<tr>
											<th>Confirm Password:</th>
											<td><input class="form-control" type="password"
												name="confirmPassword" id="confirmPassword"/></td>
										</tr>
									</table>
									
									<!-- hidden fields -->
									<input type="hidden" name="id" value="${userModel.id}"/>
									<input type="hidden" name="oldPassword" value="${userModel.password}"/>
									
									<!-- CSRF token -->
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

									<div class="col-md-3 mx-auto">
										<button type="submit" class="form-control btn btn-danger">
											<span class="fa fa-refresh"></span> Change Password
										</button>
										<br>
										<br>
									</div>
								</form>
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