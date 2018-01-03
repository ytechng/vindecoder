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
									
					<h1 th:text="#{message.resetPassword}">reset</h1>
 
					    <label th:text="#{label.user.email}">email</label>
					    <input id="email" name="email" type="email" value="" />
					    <button type="submit" onclick="resetPass()"
					      th:text="#{message.resetPassword}">reset</button>
					 
					<a th:href="@{/registration.html}" th:text="#{label.form.loginSignUp}">
					    registration
					</a>
					<a th:href="@{/login}" th:text="#{label.form.loginLink}">login</a>
					 
					<script src="jquery.min.js"></script>
					<script th:inline="javascript">
					var serverContext = [[@{/}]];
					function resetPass(){
					    var email = $("#email").val();
					    $.post(serverContext + "user/resetPassword",{email: email} ,
					      function(data){
					          window.location.href = 
					           serverContext + "login?message=" + data.message;
					    })
					    .fail(function(data) {
					        if(data.responseJSON.error.indexOf("MailError") > -1)
					        {
					            window.location.href = serverContext + "emailError.html";
					        }
					        else{
					            window.location.href = 
					              serverContext + "login?message=" + data.responseJSON.message;
					        }
					    });
					}
					 
					</script>
					
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
    <%@ include file="./shared/footer.jsp" %>

    <!-- JavaScript -->
    <%@ include file="./shared/scripts.jsp" %>

  </body>

</html>