$(document).ready(function() {				
	jQuery.fn.ajustaTabela = function(data) {
		if (data.status == "success" || data.status == "ready") {
			$("#formTable\\:dataTableID tr td:LAST-CHILD").css({
				'width' : '1px', 
				'padding' : '0'
			})
			.addClass('btn-line');
		}
	}
	
	jQuery.fn.atualizaAoSalvar = function(data) {
		$(this).find('#loader-wrapper').remove();
		
		if (data.status == "success") {
			$('#dlgDetalhe input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					var hasValue = ($.trim($(this).val()).length > 0);
					var labelID = '#' + inputID.replace(':', '\\:lbl-');			
					$(this).toggleClassCustom(labelID, 'active', hasValue);					
				}
			});
			
			$('#formTable\\:selectID').material_select();
			$('.dropdown').prepend("<option value=\"\" disabled selected>Escolha a opcao</option>");
			
			var $carets = $('#divSelect').find('.caret');
			
			if($carets.length > 1) {
				$carets.first().remove();
			}
			
			$(this).ajustaTabela(data);
		}
		
		
	}
	
	jQuery.fn.atualizaModal = function(data) {
		if (data.status == "success") {
			$('#dlgDetalhe input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					var hasValue = ($.trim($(this).val()).length > 0);
					var labelID = '#' + inputID.replace(':', '\\:lbl-');			
					$(this).toggleClassCustom(labelID, 'active', hasValue);					
				}
			}); 
			
			$('#dlgDetalhe').openModal();
			$(this).ajustaTabela(data);
		}
	
	}
	
	jQuery.fn.zeraModal = function(data) {
		if (data.status == "success") {
			$('#dlgDetalhe input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					$(this).val('');
					var labelID = '#' + inputID.replace(':', '\\:lbl-');			
					$(this).toggleClassCustom(labelID, 'active', false);					
				}
			}); 
			$(this).ajustaTabela(data);
		}
	}
	
	jQuery.fn.openModal2 = function(data) {
		if (data.status == "success") {
			$('#dlgDetalhe input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					$(this).val('');	
					var labelID = '#' + inputID.replace(':', '\\:lbl-');		
					$(this).toggleClassCustom(labelID, 'active', false);					
				}
			}); 
			
			
			
			$('#formTable\\:selectID').material_select();
			$('.dropdown').prepend("<option value=\"\" disabled selected>Escolha a opcao</option>");
			
			var $carets = $('#divSelect').find('.caret');
			
			if($carets.length > 1) {
				$carets.first().remove();
			}
			
			$('#dlgDetalhe').openModal();
			$(this).ajustaTabela(data);
		}
	}
	
	jQuery.fn.deletaObjeto = function(data) {
		if (data.status == "success") {
			$('#dlgDeleta input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					$(this).val('');	
					var labelID = '#' + inputID.replace(':', '\\:lbl-');		
					$(this).toggleClassCustom(labelID, 'active', false);					
				}
			}); 
			
			$('#dlgDeleta').openModal();
			$(this).ajustaTabela(data);
		}
	}
	
	jQuery.fn.zeraModal2 = function(data) {
		if (data.status == "success") {
			$('#dlgDeleta input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					$(this).val('');
					var labelID = '#' + inputID.replace(':', '\\:lbl-');			
					$(this).toggleClassCustom(labelID, 'active', false);					
				}
			}); 
			$(this).ajustaTabela(data);
		}
	}
	
	jQuery.fn.toggleClassCustom = function(_selector, _class, _bool) {
		if(_bool) {		
			$(_selector).removeClass(_class); 
			$(_selector).addClass(_class); 
		} else {
			$(_selector).removeClass(_class);  
		}
	}
	
	$(this).ajustaTabela({"status" : "ready"});
	
	$('button').submit(function() {
		$(this).find('#loader-wrapper').remove();
	});

	$("button").trigger('submit');
	
	$("#formTable").validate({
		submitHandler: function(form) {
			alert('submitHandler');
			
		    $(form).ajaxSubmit();
		    $(this).find('#loader-wrapper').remove();
		},
		invalidHandler: function(event, validator) {
			alert('invalidHandler');
			// 'this' refers to the form
			var errors = validator.numberOfInvalids();
			if (errors) {
				var message = errors == 1
				? 'You missed 1 field. It has been highlighted'
				: 'You missed ' + errors + ' fields. They have been highlighted';
				Materialize.toast(message, 4000);
			} else {
			  $("div.error").hide();
			}
		}
	});
});	