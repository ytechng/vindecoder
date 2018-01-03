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
								<li class="breadcrumb-item active">Admin Users</li>
							</security:authorize>
						</ol>
					</div>
				</div>
				<!-- /breadcrumb component -->
			
				<div id="carouselExampleIndicators" class="carousel slide my-4" 
					data-ride="carousel"></div>

				<div class="row">
					<!-- Search Panel -->
					<div class="col-md-12">
						<div class="card">
							<div class="card-header primary lighten-1 white-text">
								<h4><span class="fa fa-users"></span> Admin Users List</h4>
							</div>
								
							<div class="card-body">	
								<table class="table table-striped table-borderd" id="adminUsersTable">
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
						</div>
					</div>
					<!--/.Search Panel-->
					
					
	
					<div style="padding-bottom: 40%;">
					</div>

				</div><br><br>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>