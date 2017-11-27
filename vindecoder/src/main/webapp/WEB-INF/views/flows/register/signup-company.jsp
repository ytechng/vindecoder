<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

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
								<h3 class="mb-0"><span class="fa fa-book"></span> Signup - Company Data</h3>
							</div>
							<div class="card-body">
									
								<sf:form class="form" role="form" id="formPersonal" method="POST" modelAttribute="user">
									
									<div class="form-group">
										<label for="companyName">Business Name</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="companyName"
											id="companyName"/>
									</div>
									<div class="form-group">
										<label for="companyAddress">Business Address</label> 
										<sf:textarea type="text" class="form-control form-control-lg rounded-0" path="companyAddress" 
											id="companyAddress"/>
									</div>
									<div class="form-group">
										<label for="phoneNo">Contact Phone Number</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="phoneNo"
											id="phoneNo"/>
									</div>
									
									<button type="submit" class="btn btn-danger btn-lg float-left" 
										name="_eventId_personal">
										<span class="fa fa-arrow-left"></span> Previous - Personal
									</button>
									
									<button type="submit" class="btn btn-success btn-lg float-right" 
										name="_eventId_confirm">
										Next - Company <span class="fa fa-arrow-right"></span>
									</button>
									
									<!-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> -->
								</sf:form>
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