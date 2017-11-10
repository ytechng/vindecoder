$(function() {
	// Selecting active menu
	switch (menu) {
	
	case 'Vin Decoder':
		$('#home').addClass('active');
		brea;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'My Profile':
		$('#loginas').addClass('active');
		$('#myProfile').addClass('active');
		break;	
	case 'Edit Profile':
		$('#loginas').addClass('active');
		$('#editProfile').addClass('active');
		break;
	case 'Change Password':
		$('#loginas').addClass('active');
		$('#changePassword').addClass('active');
		break;
		
	}
	
	
	// vin search textfield validation
	var $frmVinCheck = $('#frmVinCheck');
	
	if ($frmVinCheck.length) {
		
		$frmVinCheck.validate({
			rules: {
				vin: {
					required: true,
				}
			},
			
			messages: {
				vin: {
					required: 'Please enter the VIN to decode!'
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
		});
	} // end vin search validations
	
});