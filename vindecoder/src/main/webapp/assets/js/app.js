$(function() { 
	// Selecting active menu
	switch (menu) {
	
	case 'Vin Decoder':
		$('#home').addClass('active');
		break;
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


	//-------------------------------------
	// vin search textfield validation
	//-------------------------------------
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
	
	
	//-------------------------------------
	// Validation code for Login Form
	//-------------------------------------
	var $formLogin = $('#formLogin');
	
	if ($formLogin.length) { 
		
		$formLogin.validate({
			rules : {
				email : {
					required: true,
					email: true
				},
				
				password: {
					required: true
				}
			},
			
			messages : {
				email : {
					required : 'Please enter email address!',
					email : 'Please enter a valid email address!'
				},
				
				password : 'Please enter a password'
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});
	} // end vin search validations
	
	
	//-------------------------------------
	// Validation code for Register Form
	//-------------------------------------
	var $formRegister = $('#formRegister'); 
	
	if ($formRegister.length) {
		
		$formRegister.validate({
			rules : {
				firstName: {
					required: true
				},
				lastName: {
					required: true
				},
				companyName: {
					required: true
				},
				companyAddress: {
					required: true
				},
				email : {
					required: true,
					email: true
				},
				phoneNo: {
					required: true,
					number: true,
					minlength: 7
				},
				password: {
					required: true,
					minlength: 8
				}
			},
			
			messages : {
				firstName : {
					required : 'Please enter first name!'
				},
				
				lastName : {
					required : 'Please enter last name!'
				},
				
				companyName : {
					required : 'Please enter company name!'
				},
				
				companyAddress : {
					required : 'Please enter company address!'
				},
				
				email : {
					required : 'Please enter email address!',
					email : 'Please enter a valid email address!'
				},
				
				phoneNo : {
					required : 'Please enter contact phone number!',
					number : 'Please a valid phone number!',
					minlength: 'Phone number must be 7 characters minimum!'
				},
				
				password : {
					required: 'Please enter a password',
					minlength: 'Password must be 6 characters minimum!'
				}
				
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				// add the error element after the input element
				error.insertAfter(element);
			}
		});
	} // end vin search validations
	
});