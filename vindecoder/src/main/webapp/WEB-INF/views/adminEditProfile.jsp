<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
							<li class="breadcrumb-item active">Edit Profile</li>
						</ol>
					</div>
				</div>
				<!-- /breadcrumb component -->
				
				<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel"></div>

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
					
						<div class="card">
							<div class="card-header primary lighten-1 white-text">
								<h4><span class="fa fa-edit"></span> PROFILE DETAILS</h4>
							</div>
							<div class="card-body">
								<form id="formRegister" action="${contextRoot}/manage/updateProfile" method="GET">
									<table class="table">
										<tr>
											<th>First Name:</th>
											<td><input class="form-control" type="text" name="firstName" value="${userModel.firstName}"/></td>
										</tr>
										<tr>
											<th>Last Name:</th>
											<td><input class="form-control" type="text" name="lastName" value="${userModel.lastName}"/></td>
										</tr>
										<tr>
											<th>Phone Number:</th>
											<td><input class="form-control" type="text" name="phoneNo" value="${userModel.phoneNo}"/></td>
										</tr>
										<tr>
											<th>Company Name:</th>
											<td><input class="form-control" type="text" name="companyName" value="${userModel.companyName}"/></td>
										</tr>
										<tr>
											<th>Company Address:</th>
											<td><textarea class="form-control" name="companyAddress">${userModel.companyAddress}</textarea></td>
										</tr>
										<tr>
											<th>Email Address:</th>
											<td><input class="form-control" type="text" name="email" value="${userModel.email}" readonly/></td>
										</tr>
		
									</table>
									
									<!-- Hidden fields -->
									<input type="hidden" name="id" value="${userModel.id}"/>
									<input type="hidden" name="regDate" value="${userModel.regDate}"/>
									<input type="hidden" name="password" value="${userModel.password}"/>
									<input type="hidden" name="active" value="${userModel.active}"/>
									<input type="hidden" name="role" value="${userModel.role}"/>
									
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
								
									<div class="col-md-3 mx-auto">
										<button type="submit" class="form-control btn btn-danger">
											<span class="fa fa-refresh"></span> Update Profile
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
					<!--/.Result Panel-->
				</div><br><br>
				<!-- /.row -->
			</div>

		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>