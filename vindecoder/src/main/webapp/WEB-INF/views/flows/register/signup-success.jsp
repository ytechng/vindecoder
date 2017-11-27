<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ include file="../shared/flows-header.jsp" %>	
    
  	<div class="container py-5">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center text-white mb-4">Signup Success</h2>
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
								<h3 class="mb-0"><span class="fa fa-mark"></span> Signup - Success</h3>
							</div>
							<div class="card-body">
							
								<h1>Welcome!</h1>
								<h6>You have successfully signup. You can now <a href="${contextRoot}/login">login</a> by using your email address.</h6>
									
								<div class="col-md-3 mx-auto">
									<a href="${contextRoot}/login" class="btn btn-primary">Login Here</a>
								</div>
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