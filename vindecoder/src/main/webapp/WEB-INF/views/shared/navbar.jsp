<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${contextRoot}/home"><img alt="CARFACTS"
			src="${images}/logo.png"></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item" id="home">
					<a class="nav-link" href="${contextRoot}/home">Vin Decoder
						<span class="sr-only">(current)</span>
					</a>
				</li>
				
				<security:authorize access="isAnonymous()">
					<li class="nav-item" id="loginas">
						<a class="nav-link" href="${contextRoot}/login">Login</a>
					</li>
					
					<li class="nav-item" id="loginas">
						<a class="nav-link" href="${contextRoot}/register">Register</a>
					</li>
				</security:authorize>
				
				<security:authorize access="isAuthenticated()">
					<li class="nav-item" id="loginas">
						<span class="nav-link text-white badge badge-pill badge-danger"><strong>Hello: </strong></span>
					</li>
					<li>
						<div class="btn-group">
							 <button type="button" class="btn btn-default dropdown-toggle" 
							  	data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							    ${userModel.fullName}
							 </button>
							 <div class="dropdown-menu" id="cartDetails">		
							 						
								<security:authorize access="hasAuthority('business')">
									<a class="dropdown-item" href="${contextRoot}/business/profile">
										<span class="fa fa-user"> My Profile</span>									
									</a>
									
									<a class="dropdown-item" href="${contextRoot}/home">
										<span class="fa fa-spinner"> Check VIN </span>	
										<span class="badge badge-pill badge-danger">${userModel.credit}</span>								
									</a>
									
									<a class="dropdown-item" href="${contextRoot}/business/showVinLogs">
										<span class="fa fa-book"> VIN Check History</span>							
									</a>
								</security:authorize>
								
								<security:authorize access="hasAuthority('admin')">
									<a class="dropdown-item" href="${contextRoot}/manage/profile">
										<span class="fa fa-user"> My Profile</span>									
									</a>
								</security:authorize>
									
								<div class="dropdown-divider"></div>
							    
							    <a class="dropdown-item" href="${contextRoot}/account-logout">
							    	<span class="fa fa-sign-out" style="color:red;"></span> 
							    	<span class="badge badge-pill badge-danger">LogOut</span>
							    </a>
							 </div>
						</div>
					</li>
				</security:authorize>
			</ul>
		</div>
	</div>
</nav>