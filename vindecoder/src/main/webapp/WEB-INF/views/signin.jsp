<div class="container py-5">
	<div class="row">
		<div class="col-md-12">
			<h2 class="text-center text-white mb-4">Bootstrap 4 Login Form</h2>
			<div class="row">
				<div class="col-md-6 mx-auto">
					<span class="anchor" id="formLogin"></span>

					<!-- form card login -->
					<div class="card rounded-2">
						<div class="card-header">
							<h3 class="mb-0">Login</h3>
						</div>
						<div class="card-body">
							<form class="form" role="form" autocomplete="off" id="formLogin">
								<div class="form-group">
									<label for="uname1">Username</label> 
									<input type="email" class="form-control form-control-lg rounded-0" name="email"
										id="email" required="">
								</div>
								<div class="form-group">
									<label>Password</label> 
									<input type="password" class="form-control form-control-lg rounded-0" name="password" 
										id="password" required="">
								</div>
								<div>
									<label class="custom-control custom-checkbox"> 
										<input type="checkbox" class="custom-control-input"> 
										<span class="custom-control-indicator"></span> 
										<span class="custom-control-description small">Remember me on this computer</span>
									</label>
								</div>
								<a href="${contextRoot}/home" class="btn btn-info btn-lg float-left">Login</a>
								<a href="${contextRoot}/home" class="btn btn-link btn-lg float-right">
									I want to Register?
								</a>
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