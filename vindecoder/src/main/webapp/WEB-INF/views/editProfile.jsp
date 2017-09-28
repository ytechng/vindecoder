<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/categories.jsp"%>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<div class="content">
				<div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel"></div>

				<div class="row">
					
					<!-- Result Panel -->
					<div class="col-md-12">
						<div class="card">
							<div class="card-header primary lighten-1 white-text">
								<h4>PROFILE DETAILS</h4>
							</div>
							<div class="card-body">
								
								<table class="table">
									<tr>
										<th>First Name:</th>
										<td><input class="form-control" type="text" name="firstName" value="Opeyemi" /></td>
									</tr>
									<tr>
										<th>Last Name:</th>
										<td><input class="form-control" type="text" name="firstName" value="Ajayi" /></td>
									</tr>
									<tr>
										<th>Company Name:</th>
										<td><input class="form-control" type="text" name="companyName" value="Whytech Solution Auto" /></td>
									</tr>
									<tr>
										<th>Email Address:</th>
										<td><input class="form-control" type="text" name="firstName" value="ytechng@gmail.com" readonly /></td>
									</tr>
									<tr>
										<th>Date Registered:</th>
										<td><input class="form-control" type="text" name="firstName" value="28-09-2017" readonly /></td>
									</tr>
			
	
								</table>
								
								<div class="col-md-4 mx-auto">
									<button class="form-control btn btn-danger">
										Update Profile
									</button>
								</div>
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