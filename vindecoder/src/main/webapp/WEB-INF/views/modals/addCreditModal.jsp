<%@ taglib prefix="html" uri="http://www.springframework.org/tags/form" %>

<div class="modal fade" id="addCreditModal" role="dialog">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span>&times;</span>
				</button>
				
				<h4 class="modal-title">Adding Credit</h4>
			</div>
			<div class="modal-body">
				<!-- Credit Form -->
				<form id="addCreditForm" action="${contextRoot}/manage/addCredit" method="POST">
					<div class="form-group">
						<label><strong>User Email Address*</strong></label>
						<input type="text" name="email" id="email" class="form-control" placeholder="user@email.com"/>
						<em id="norecord" class="help-block"></em>
					</div>
					<div class="form-group">
						<label><strong>Number of VINs*</strong></label>
						<input type="text" name="credit" id="credit" class="form-control" placeholder="0"/>
					</div>
					<div class="form-group text-left">
						<button type="submit" class="btn btn-info">Add Credit</button>
					</div>
					
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				</form>
			</div>
			<div class="modal-footer">
				<button type="button" data-dismiss="modal" class="btn btn-danger">Close</button>
			</div>
		</div>
	</div>
</div>