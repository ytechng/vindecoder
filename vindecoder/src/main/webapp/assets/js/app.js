$(function() { 
	// Selecting active menu
	switch (menu) {
	
	case 'Decode VIN':
		$('#home').addClass('active');
		break;
	case 'Vin Logs':
		$('#showVinLogs').addClass('active');
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
		$('#myProfile').addClass('active');
		break;
	case 'Change Password':
		$('#loginas').addClass('active');
		$('#changePassword').addClass('active');
		break;
	case 'Admin Users':
		$('#showAdminUsers').addClass('active');
		break;
	case 'Business Users':
		$('#showBusinessUsers').addClass('active');
		break;
	case 'Upload Excel File':
		$('#showUploadExcelFile').addClass('active');
		break;
		
}
	
	
	//-------------------------------- ALERTS -------------------------------------//
	// dismiss the alert in 3 seconds
	var $alert = $('.alert'); 

	if ($alert.length) {
		setTimeout(function() {
			$alert.fadeOut('slow');
		}, 3000);
	}
	
	
	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header = $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0) {
		
		// set the token header for the ajax request
		$(document).ajaxSend(function(e, xhr, options) {
			xhr.setRequestHeader(header, token);
		});
	}


	//--------------------------- VALIDATIONS -------------------------------------//
	
	//-------------------------------------
	// vin search textfield validation
	//-------------------------------------
	var $frmVinCheck = $('#frmVinCheck');
	
	if ($frmVinCheck.length) { 
		
		$frmVinCheck.validate({
			rules: {
				vin: {
					required: true,
					minlength: 17
				}
			},
			
			messages: {
				vin: {
					required: 'Please enter VIN (e.g WP1ZZZ9PZ3LA80863)!',
					minlength: 'VIN should be 17 characters!'
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

	var $registerForm = $('#formRegister');
	
	if ($registerForm.length) {
		
		$.validate({
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
					number : 'Please a enter valid phone number!',
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
	} // end register form validations
	
	
	//-------------------------------------
	// Change Password Validations
	//-------------------------------------
	var $formCP = $('#formChangePassword'); 
	
	if ($formCP.length) { 
		
		$formCP.validate({
			rules: {
								
				currentPassword: {
					required: true
				},
				
				password: {
					required: true,
					minlength: 6
				},
				
				confirmPassword: {
					required: true,
					equalTo: "#password"
				}
			},
			
			messages: {
				currentPassword: {
					required: 'This field is required!'
				},
				
				password: {
					required: 'This field is required!',
					minlength: 'Password must be 6 characters minimum!'
				},
				
				currentPassword: {
					required: 'This field is required!',
					equalTo: 'These passwords don\'\'t match. Try again?'
				},
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
		});
	} // end Change Password validations
	
	
	//-------------------------------------
	// Change Password Validations
	//-------------------------------------
	var $addCreditForm = $('#addCreditForm'); 
	
	if ($addCreditForm.length) { 
		
		$addCreditForm.validate({
			rules: {
								
				email: {
					required: true
				},
				
				credit: {
					required: true,
					number: true,
					min: 1
				}
			},
			
			messages: {
				email: {
					required: 'This field is required!'
				},
				
				credit: {
					required: 'This field is required!',
					number: 'Please enter an integer value!',
					min: 'credit should be grater than 0!'
				}
			},
			
			errorElement: 'em',
			errorPlacement: function(error, element) {
				// add the class of help-block
				error.addClass('help-block');
				
				error.insertAfter(element);
			}
		});
		
		// check if username exist
		$('#email').blur(function () {
			var email = $(this).val();
			var jsonUrl = window.contextRoot + '/manage/checkUserData';
			
			$.ajax({
				url: jsonUrl,
				method: "POST",
				data: {email:email},
				dataType: "text",
				success: function (html) {
					$('#norecord').html(html);
				}
			})
		})
		
	} // end Change Password validations
	
	
	//--------------------------- BUTTON CLICK -------------------------------------//
	
	//-------------------------------------
	// Update Profile Button Click
	//-------------------------------------
	$('#btnUpdateProfile').click(function() {
		alert('Yes');
	});
	
	

	//--------------------------- jQuery DataTable -------------------------------------//
	//-------------------------------------
	// Vin Logs Table Data
	//-------------------------------------
	var $vinLogsTable = $('#vinLogsTable');
	
	// execute the code below only if the vinLogsTable exist
	if ($vinLogsTable.length) {
		
		var jsonUrl = window.contextRoot + '/carfacts/api/getVinLogs/' + window.userId + '/user';
		//var jsonUrl = 'http://localhost:8080/vindecoder/json/data/getVinLogs/1/user';
		
		$vinLogsTable.DataTable({ 
			
			lengthMenu: [[10, 20, 30, 50, -1], ['10 Records', '20 Records', '30 Records', '50 Records', 'All Records']],
			pageLength: 10,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          {
			        	  data: 'vin'
			          },
			          {
			        	  data: 'make'
			          },
			          {
			        	  data: 'modelYear'
			          },
			          {
			        	  data: 'logDate'
			          }
			         ]
		});
	}
	
	
	//-------------------------------------
	// Business Users Table Data
	//-------------------------------------
	var $businessUsersTable = $('#businessUsersTable');
	
	// execute the code below only if the vinLogsTable exist
	if ($businessUsersTable.length) {
		
		var jsonUrl = window.contextRoot + '/carfacts/api/getBusinessUsers';
		
		$businessUsersTable.DataTable({ 
			
			lengthMenu: [[10, 20, 30, 50, -1], ['10 Records', '20 Records', '30 Records', '50 Records', 'All Records']],
			pageLength: 10,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          {
			        	  data: 'firstName'
			          },
			          {
			        	  data: 'companyName'
			          },
			          {
			        	  data: 'credit'
			          },
			          {
			        	  data: 'regDate'
			          },
			          {
			        	  data: 'active',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  var str = '';
			        		  
			        		  if (window.userRole == 'admin') {
			        			  str += '<label class="switch">';
				        		  
				        		  if (data) {
				        			  str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
				        		  } else {
				        			  str += '<input type="checkbox" value="'+row.id+'" />';
				        		  }
				        		  
				        		  str += '<div class="slider"></div>';
				        		  str += '</label>';
			        		  }
			        		  			        		  
			        		  return str;
			        	  }
			          }
			      ],
			      
			      initComplete: function () {
			    	  var api = this.api();
			    	  
			    	  api.$('.switch input[type="checkbox"]').on('change', function () {
			    		  var checkbox = $(this);
			    		  var checked = checkbox.prop('checked');
			    		  var modalMsg = (checked) ? 
			    				  'Do you want to ACTIVATE the user?' : 
			    				  'Do you want to DEACTIVATE the user?';
			    		  var value = checkbox.prop('value');
			    		  
			    		  bootbox.confirm({
			    			  size: 'medium',
			    			  title: 'Activate/Deactiave User',
			    			  message: modalMsg,
			    			  callback: function (confirmed) {
			    				  if (confirmed) {
			    					  console.log(value);
			    					  
			    					  var userActivationUrl = window.contextRoot + '/manage/user/'+value+'/activation';
			    					  
			    					  $.post(userActivationUrl, function (data) {
			    						  bootbox.alert({
			    							  size: 'medium',
			    							  title: 'Activation Status',
			    							  message: data
			    						  });
			    					  });
			    				  } else {
			    					  checkbox.prop('checked', !checked);
			    				  }
			    			  }
			    		  });
			    	  });
			      }
		});
	}
	
	
	//-------------------------------------
	// Business Users Table Data
	//-------------------------------------
	var $adminUsersTable = $('#adminUsersTable');
	
	// execute the code below only if the vinLogsTable exist
	if ($adminUsersTable.length) {
		
		var jsonUrl = window.contextRoot + '/carfacts/api/getAdminUsers';
		
		$adminUsersTable.DataTable({ 
			
			lengthMenu: [[10, 20, 30, 50, -1], ['10 Records', '20 Records', '30 Records', '50 Records', 'All Records']],
			pageLength: 10,
			ajax: {
				url: jsonUrl,
				dataSrc: ''
			},
			columns: [
			          {
			        	  data: 'firstName'
			          },
			          {
			        	  data: 'companyName'
			          },
			          {
			        	  data: 'credit'
			          },
			          {
			        	  data: 'regDate'
			          },
			          {
			        	  data: 'active',
			        	  bSortable: false,
			        	  mRender: function(data, type, row) {
			        		  var str = '';
			        		  
			        		  if (window.userRole == 'admin') {
			        			  str += '<label class="switch">';
				        		  
				        		  if (data) {
				        			  str += '<input type="checkbox" checked="checked" value="'+row.id+'"/>';
				        		  } else {
				        			  str += '<input type="checkbox" value="'+row.id+'" />';
				        		  }
				        		  
				        		  str += '<div class="slider"></div>';
				        		  str += '</label>';
			        		  }
			        		  			        		  
			        		  return str;
			        	  }
			          }
			      ],
			      
			      initComplete: function () {
			    	  var api = this.api();
			    	  
			    	  api.$('.switch input[type="checkbox"]').on('change', function () {
			    		  var checkbox = $(this);
			    		  var checked = checkbox.prop('checked');
			    		  var modalMsg = (checked) ? 
			    				  'Do you want to ACTIVATE the user?' : 
			    				  'Do you want to DEACTIVATE the user?';
			    		  var value = checkbox.prop('value');
			    		  
			    		  bootbox.confirm({
			    			  size: 'medium',
			    			  title: 'Activate/Deactiave User',
			    			  message: modalMsg,
			    			  callback: function (confirmed) {
			    				  if (confirmed) {
			    					  console.log(value);
			    					  
			    					  var userActivationUrl = window.contextRoot + '/manage/user/'+value+'/activation';
			    					  
			    					  $.post(userActivationUrl, function (data) {
			    						  bootbox.alert({
			    							  size: 'medium',
			    							  title: 'Activation Status',
			    							  message: data
			    						  });
			    					  });
			    				  } else {
			    					  checkbox.prop('checked', !checked);
			    				  }
			    			  }
			    		  });
			    	  });
			      }
		});
	}
	
});