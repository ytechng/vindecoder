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
									<div class="col-md-6 mx-auto">
										<h4 class="card-title">Enter VIN in the textbox below</h4>
									</div>
									<p class="card-text">
										<div class="col-md-6 mx-auto">
											<input type="text" class="form-control" name="vin" placeholder="VIN" />
										</div>
									</p>
									<div class="col-md-6 mx-auto">
										<button class="form-control btn btn-info" type="submit">
											<span class="fa fa-search"></span> DECODE VIN
										</button>
									</div>
								</div>
							</form>
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

</div>