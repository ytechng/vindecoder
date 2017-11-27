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
							<div class="card-header text-center">
								<h3 class="mb-0"><span class="fa fa-check"></span> Confirm Signup Data</h3>
							</div>
							<div class="card-body">
							
								<table class="table">
									<tr>
										<th>First Name: </th>
										<td>${registerModel.user.firstName}</td>
									</tr>
									<tr>
										<th>Last Name: </th>
										<td>${registerModel.user.lastName}</td>
									</tr>
									<tr>
										<th>Email Address: </th>
										<td>${registerModel.user.email}</td>
									</tr>	
									<tr>
										<th>Company Name: </th>
										<td>${registerModel.user.companyName}</td>
									</tr>
									<tr>
										<th>Company Address: </th>
										<td>${registerModel.user.companyAddress}</td>
									</tr>	
									<tr>
										<th>Contact Phone Number: </th>
										<td>${registerModel.user.phoneNo}</td>
									</tr>							
								</table>
							
								<a href="${flowExecutionUrl}&_eventId_personal" class="btn btn-danger btn-sm float-left">
									Edit - User Information <span class="fa fa-edit"></span>
								</a>
									
								<a href="${flowExecutionUrl}&_eventId_submit" class="btn btn-primary float-right">
									Confirm
								</a>
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