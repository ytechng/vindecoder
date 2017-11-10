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
					<c:if test="${decoder != null}">
	
						<div class="col-md-12">
							<hr>
						</div>
					
						<!-- Result Panel -->
						<div class="col-md-12">
							<div class="card">
								<div class="card-header primary lighten-1 white-text">
									<h4><center>VIN DECODER CHECK RESULT</center></h4>
									<p>${vinResult}</p>
								</div>
								<div class="card-body">
									<h6 class="card-title">Enter the VIN to the decode in the
										below textbox</h6>
									
									
									<table class="table table-striped">
										<tr>
											<th>VIN</th>
											<td>${decoder.vin}</td>
										</tr>
										<tr>
											<th>Make</th>
											<td>${decoder.make}</td>
										</tr>
										<tr>
											<th>Model Name</th>
											<td>${decoder.modelName}</td>
										</tr>
										<tr>
											<th>Model Year</th>
											<td>${decoder.modelYear}</td>
										</tr>
										<tr>
											<th>Fuel type</th>
											<td>${decoder.fuelType}</td>
										</tr>
										<tr>
											<th>Body Type</th>
											<td>${decoder.bodyType}</td>
										</tr>
										<tr>
											<th>Drive Wheels</th>
											<td>${decoder.driveWheels}</td>
										</tr>
										<tr>
											<th>Engine Power</th>
											<td>${decoder.enginePower}</td>
										</tr>
										<tr>
											<th>Horse Power</th>
											<td>${decoder.horsePower}</td>
										</tr>
										<tr>
											<th>Curb Weight</th>
											<td>${decoder.curbWeight}</td>
										</tr>
										<tr>
											<th>Gross Vehicle Weight</th>
											<td>${decoder.grossVehicleWeight}</td>
										</tr>
										<tr>
											<th>Plant</th>
											<td>${decoder.plant}</td>
										</tr>
										<tr>
											<th>Gearbox</th>
											<td>${decoder.gearBox}</td>
										</tr>
										<tr>
											<th>Max Payload</th>
											<td>${decoder.maxPayload}</td>
										</tr>
										<tr>
											<th>Co2 Emission Mixed Driving</th>
											<td>${decoder.co2EmissionMixedDriving}</td>
										</tr>
										<tr>
											<th>Fuel Consumption Mixed Driving</th>
											<td>${decoder.fuelConsumptionMixedDriving}</td>
										</tr>
		
									</table>
									
								</div>
							</div>
						</div>
						<!--/.Result Panel-->
					</c:if>	
					
					<c:if test="${errorMsg != null}">
												
						<!-- Result Panel -->
						<div class="col-md-12">							
							<h3><div class="alert alert-danger alert-dismissible">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									${errorMsg}
								</div>
							</h3>
						</div>
						<!--/.Result Panel-->
					</c:if>
					
					<c:if test="${vinResult == null}">
						<div style="padding-bottom: 40%;">
						</div>
					</c:if>
					
					<div class="col-md-3 mx-auto">
						<a href="${contextRoot}/home" class="btn btn-primary">Check another VIN</a>
					</div>
					
				</div><br><br>
				<!-- /.row -->
			</div>
		</div>
		<!-- /.col-lg-9 -->

	</div>
	<!-- /.row -->

</div>