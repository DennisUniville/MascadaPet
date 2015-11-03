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
});	