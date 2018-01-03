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
								<h3 class="mb-0"><span class="fa fa-user"></span> User Signup Form</h3>
							</div>
							<div class="card-body">
									
								<sf:form class="form" role="form" id="" method="POST" modelAttribute="user">
									
									<div class="form-group">
										<label for="email">First Name</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="firstName"
											id="firstName" name="firstName"/>
										
										<!-- <sf:errors path="firstName" cssClass="help-block" element="em"/> -->
									</div>
									<div class="form-group">
										<label for="lastName">Last Name</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="lastName" 
											id="lastName"/>
									</div>									
									<div class="form-group">
										<label for="companyName">Company Name</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="companyName"
											id="companyName"/>
									</div>
									<div class="form-group">
										<label for="companyAddress">Company Address</label> 
										<sf:textarea type="text" class="form-control form-control-lg rounded-0" path="companyAddress" 
											id="companyAddress"/>
									</div>
									<div class="form-group">
										<label for="phoneNo">Contact Phone Number</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="phoneNo"
											id="phoneNo"/>
									</div>
									<div class="form-group">
										<label for="email">Email Address</label> 
										<sf:input type="text" class="form-control form-control-lg rounded-0" path="email"
											id="email"/>
									</div>
									<div class="form-group">
										<label for="password">Password</label> 
										<sf:input type="password" class="form-control form-control-lg rounded-0" path="password" 
											id="password"/>
									</div>
									
									<button type="submit" class="btn btn-info btn-lg float-right" 
										name="_eventId_confirm">
										Continue <span class="fa fa-arrow-right"></span>
									</button>
									
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
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