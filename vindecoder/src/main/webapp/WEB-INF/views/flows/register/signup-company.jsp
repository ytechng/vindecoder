<%@ include file="../shared/flows-header.jsp" %>	
    
  	<div class="container py-5">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center text-white mb-4">User Signup Form</h2>
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
								<h3 class="mb-0"><span class="fa fa-user"></span> Signup - Personal Data</h3>
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
									
									<button type="submit" class="btn btn-info btn-lg float-right">
										Continue <span class="fa fa-arrow-right"></span>
									</button>
									
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
	
	 <!-- Footer -->
    <%@ include file="../shared/flows-footer.jsp" %>

    <!-- JavaScript -->
    <%@ include file="../../shared/scripts.jsp" %>
  
  </body>

</html>