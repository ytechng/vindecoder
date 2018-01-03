<div class="container">

	<div class="row">
		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/sidebar.jsp"%>
		</div>

		<!-- /.col-lg-3 -->
		<div class="col-lg-9">
			<div class="content">
			<br>
				<!-- breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">Vin Logs</li>
						</ol>
					</div>
				</div>
				<!-- /breadcrumb component -->
				<div id="carouselExampleIndicators" class="carousel slide my-4"
					data-ride="carousel"></div>

				<div class="row">
					<!-- Result Panel -->
					<div class="col-md-12">
						<div class="card">
							<div class="card-header primary lighten-1 white-text">
								<h4><span class="fa fa-book"></span> VIN LOGS</h4>
							</div>
							<div class="card-body">
	
								<table class="table table-striped table-borderd" id="vinLogsTable">
									<thead>
										<tr>
											<th>VIN</th>
											<th>Make</th>
											<th>Model Year</th>
											<th>Log Date</th>
										</tr>
									</thead>
	
									<tbody>
										
										<!-- tbody will get data from jQuery -->
										
									</tbody>
									
									<tfoot>
										<tr>
											<th>VIN</th>
											<th>Make</th>
											<th>Model Year</th>
											<th>Log Date</th>
										</tr>
									</tfoot>
								</table>
							</div>
						</div>
					</div>
				</div>
				<!--/.Result Panel-->
			</div>
			<br><br>
			<!-- /.row -->

		</div>
		<!-- /.col-lg-9 -->
	</div>
	<!-- /.row -->

</div>