<div class="container">

	<div class="row">

		<div class="col-lg-3">
			<!-- Menus -->
			<%@ include file="./shared/sidebar.jsp"%>

		</div>
		<!-- /.col-lg-3 -->

		<div class="col-lg-9">
			<div class="content">
				<!-- breadcrumb component -->
				<div class="row">
					<div class="col-md-12">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
							<li class="breadcrumb-item active">VIN Decoder</li>
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
							<form method="GET" id="frmVinCheck" action="${contextRoot}/decode/">
								<div class="card-header deep-orange lighten-1 white-text">
									VIN DECODER</div>
								<div class="card-body">
									<h4 class="card-title">Enter the VIN to the decode in the below textbox</h4>
									<p class="card-text">
										<div class="col-md-6 mx-auto">
											<input type="text" class="form-control" name="vin" />
										</div>
									</p>
									<div class="col-md-6 mx-auto">
										<button class="form-control btn btn-info" type="submit">
											DECODE VIN
										</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!--/.Search Panel-->
					
					<c:if test="${vinResult != null}">
	
						<div class="col-md-12">
							<hr>
						</div>
					
						<!-- Result Panel -->
						<div class="col-md-12">
							<div class="card">
								<div class="card-header primary lighten-1 white-text">
									<h4><center>VIN DECODER CHECK RESULT</center></h4>
								</div>
								<div class="card-body">
									<h6 class="card-title">Enter the VIN to the decode in the
										below textbox</h6>
									
									
									<table class="table table-striped">
										<tr>
											<th>VIN</th>
											<td>WP1ZZZ9PZ3LA80863</td>
										</tr>
										<tr>
											<th>Make</th>
											<td>Porsche</td>
										</tr>
										<tr>
											<th>Model Name</th>
											<td>Cayenne</td>
										</tr>
										<tr>
											<th>Model Year</th>
											<td>2003</td>
										</tr>
										<tr>
											<th>Fuel type</th>
											<td>Petrol</td>
										</tr>
										<tr>
											<th>Body Type</th>
											<td>SUV</td>
										</tr>
										<tr>
											<th>Drive Wheels</th>
											<td>All wheel</td>
										</tr>
										<tr>
											<th>Engine Power</th>
											<td>331</td>
										</tr>
										<tr>
											<th>Horse Power</th>
											<td>450</td>
										</tr>
										<tr>
											<th>Curb Weight</th>
											<td>2430</td>
										</tr>
										<tr>
											<th>Gross Vehicle Weight</th>
											<td>2013</td>
										</tr>
										<tr>
											<th>Plant</th>
											<td>Leipzig, Germany</td>
										</tr>
										<tr>
											<th>Gearbox</th>
											<td>Automatic</td>
										</tr>
										<tr>
											<th>Max Payload</th>
											<td>650</td>
										</tr>
										<tr>
											<th>Co2 Emission Mixed Driving</th>
											<td>-</td>
										</tr>
										<tr>
											<th>Fuel Consumption Mixed Driving</th>
											<td>-</td>
										</tr>
		
									</table>
								</div>
							</div>
						</div>
						<!--/.Result Panel-->
					</c:if>
					<c:if test="${vinResult == null}">
						<div style="padding-bottom: 50%;">
						</div>
					</c:if>
				</div><br><br>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>