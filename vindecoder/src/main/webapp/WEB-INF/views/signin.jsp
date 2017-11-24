<div class="container py-5">
	<div class="row">
		<div class="col-md-12">
			<h2 class="text-center text-white mb-4">User Login Form</h2>
			<div class="row">
				<div class="col-md-6 mx-auto">					
					<!-- Display error message if login failed -->
					<c:if test="${not empty errorMsg}">
						<div class="alert alert-danger alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>${errorMsg}</strong>
						</div>
					</c:if>
					
					<!-- form card login -->
					<div class="card rounded-2">
						<div class="card-header">
							<h3 class="mb-0"><span class="fa fa-sign-in"></span> Login</h3>
						</div>
						<div class="card-body">
								
							<form class="form" role="form" autocomplete="off" id="formLogin" 
								action="${contextRoot}/login" method="POST">
								
								<div class="form-group">
									<label for="email">Email Address</label> 
									<input type="text" class="form-control form-control-lg rounded-0" name="email"
										id="email">
								</div>
								<div class="form-group">
									<label for="password">Password</label> 
									<input type="password" class="form-control form-control-lg rounded-0" name="password" 
										id="password">
								</div>
								<div>
									<label class="custom-control custom-checkbox"> 
										<input type="checkbox" class="custom-control-input"> 
										<span class="custom-control-indicator"></span> 
										<span class="custom-control-description small">Remember me on this computer</span>
									</label>
								</div>
								<button type="submit" class="btn btn-info btn-lg float-right">
									<span class="fa fa-sign-in"></span> Login
								</button>
								<a href="${contextRoot}/register" class="btn btn-link btn-lg float-left">
									I want to Register?
								</a>
								
								<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							</form>
						</div>
						<!--/card-block-->
					</div>
					<!-- /form card login -->

				</div>


			</div>
			<!--/row-->

		</div>
		<!--/col-->
	</div>
	<!--/row-->

	<div class="content"></div>

</div>