<h1 class="my-4">My Profile</h1>
<div class="list-group">
	
	<security:authorize access="hasAuthority('business')">
		<a href="${contextRoot}/home" class="list-group-item" id="home">
			<span class="fa fa-spinner"></span>  Decode VIN
			<span class="badge badge-pill badge-danger">${userModel.credit}</span>
		</a> 
		
		<a href="${contextRoot}/business/showVinLogs" class="list-group-item" id="showVinLogs">
			<span class="fa fa-book"></span>  Vin Logs
		</a> 
	
		<a href="${contextRoot}/business/profile" class="list-group-item" id="myProfile">
			<span class="fa fa-user"></span> My Profile
		</a> 
		
	</security:authorize>
	
	<security:authorize access="hasAuthority('admin')">
			
		<a href="${contextRoot}/manage/profile" class="list-group-item" id="myProfile">
			<span class="fa fa-user"></span> My Profile
		</a> 
		
		<a href="${contextRoot}/manage/showAdminUsersList" class="list-group-item" id="showAdminUsers">
			<span class="fa fa-users"></span>  Admin Users
		</a> 
		
		<a href="${contextRoot}/home" class="list-group-item" id="showBusinessUsers">
			<span class="fa fa-users"></span>  Business Users
		</a> 

	</security:authorize>
	
	<a href="${contextRoot}/account-logout" class="list-group-item">
		<span class="fa fa-sign-out"></span> Log Out
	</a>
</div>