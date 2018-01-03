<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/sidebar.jsp"%>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<div class="content"><br>
				<!-- breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							
							<security:authorize access="hasAuthority('business')">
								<li class="breadcrumb-item active">VIN Decoder</li>
							</security:authorize>
							
							<security:authorize access="hasAuthority('admin')">
								<li class="breadcrumb-item active">Business Users</li>
							</security:authorize>
						</ol>
					</div>
				</div>
				<!-- /breadcrumb component -->
			
				<div id="carouselExampleIndicators" class="carousel slide my-4" 
					data-ride="carousel"></div>

				<div class="row">
					
					<c:if test="${not empty message}">
						<div class="alert alert-success alert-dismissible col-md-12">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>${message}</strong>
						</div>
					</c:if>
				
					<!-- Search Panel -->
					<div class="col-md-12">
						<div class="card">
							<!-- Display to business users -->
							<security:authorize access="hasAuthority('business')">
								<form method="GET" id="frmVinCheck" action="${contextRoot}/business/decode/">
									<div class="card-header deep-orange lighten-1 white-text">
										VIN DECODER</div>
									<div class="card-body">
										<div class="col-md-6 mx-auto">
											<h4 class="card-title">Vehicle Identification Number</h4>
										</div>
										<p class="card-text">
											<div class="col-md-6 mx-auto">
												<input type="text" class="form-control" name="vin" placeholder="Enter VIN" />
											</div>
										</p>
										
										<!-- hidden fields -->
										<input type="hidden" name="id" value="${userModel.id}"/>
										<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
																			
										<div class="col-md-6 mx-auto">
											<button class="form-control btn btn-info" type="submit">
												<span class="fa fa-search"></span> DECODE VIN
											</button>
										</div>
									</div>
								</form>
							</security:authorize>
							
							<!-- Display to admin users -->
							<security:authorize access="hasAuthority('admin')">
								<div class="card-header primary lighten-1 white-text">
									<h4><span class="fa fa-users"></span> Business Users List</h4>
								</div>
								
								<div class="card-body">	
									<div class="text-right">
										<button type="button" data-toggle="modal" data-target="#addCreditModal" 
											class="btn btn-danger btn-sm" title="Click to credit business user account">
											<span class="fa fa-plus"></span> Add Credit</button>
									</div><br>
										
									<table class="table table-striped table-borderd" id="businessUsersTable">
										<thead>
											<tr>
												<th>Name</th>
												<th>Company Name</th>
												<th>Unit(s)</th>
												<th>Reg Date</th>
												<th>Action</th>
											</tr>
										</thead>
		
										<tbody>
											
											<!-- tbody will get data from jQuery -->
											
										</tbody>
										
										<tfoot>
											<tr>
												<th>Name</th>
												<th>Company Name</th>
												<th>Unit(s)</th>
												<th>Reg Date</th>
												<th>Action</th>
											</tr>
										</tfoot>
									</table>
								</div>
							</security:authorize>
						</div>
					</div>
					<!--/.Search Panel-->
					
					
					<c:if test="${vinResult == null}">
						<div style="padding-bottom: 40%;">
						</div>
					</c:if>
				</div><br><br>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->
	
	<!-- add credit modal -->
	<%@ include file="modals/addCreditModal.jsp" %>

</div>