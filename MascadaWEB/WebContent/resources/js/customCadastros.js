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
	
	jQuery.fn.ajustaSelect = function(data) {
		if(document.getElementById('formTable:selectID')) {
			var option = "Escolha a opcao";
			var selected = ""; 
			
			$("#formTable\\:selectID").material_select();
			
			return;
			if(data.action = 'inserir') {		
				selected = "selected=\"\""; 
				$("#formTable\\:selectID" ).val("");				
				$("#formTable\\:selectID option" )
					.removeClass("active")
					.removeAttr( "selected")
			} else if(data.action = 'alterar') {
				var optionSelected = $("#formTable\\:selectID option:selected" );
				var optionSelectedVal = $("#formTable\\:selectID").val();
				
				
			}
			
			$('#formTable\\:selectID')
				.prepend("<option value=\"\" disabled=\"\" >" + option + "</option>");
			
			$('#dlgDetalhe')
				.find(".select-wrapper ul")
				.prepend("<li class=\"disabled\"><span>" + option + "</span></li>");			
			
			$('#dlgDetalhe')
				.find(".select-wrapper input").val(option);
			
			$('#formTable\\:selectID').material_select();
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

			$(this).ajustaSelect({"action" : "alterar"}, $(this));
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
				
				$(this).removeClass("valid");
				$(this).removeClass("invalid");
				
				if(typeof inputID !== 'undefined') {
					$(this).val('');	
					var labelID = '#' + inputID.replace(':', '\\:lbl-');		
					$(this).toggleClassCustom(labelID, 'active', false);					
				}
			}); 

			$(this).ajustaSelect({"action" : "inserir"});
			$('#dlgDetalhe').openModal();
			$(this).ajustaTabela(data);
		}
	}

	jQuery.fn.deletaObjeto = function(data) {
		if (data.status == "success") {
			
			$('#dlgDeleta input').each(function() {						
				var inputID = $(this).attr('id');
				
				if(typeof inputID !== 'undefined') {
					var labelID = '#' + inputID.replace(':', '\\:lbl-');		
					$(this).toggleClassCustom(labelID, 'active', true);					
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
	
	jQuery.fn.submitForm = function(refElement, event) {
		var $set = $('#formTable input');
		var len = $set.length;
		var errors = 0;
		
		$set.each(function(index, element) {	
			var errorMessage = element.validationMessage;
			
			if(errorMessage !== '') {				
				$(this).next("label").attr("data-error", errorMessage );
				$(this).removeClass("valid");
				$(this).addClass("invalid");
				errors++;
			} 
				
			if (index == len - 1) {
				if(errors < 1) {
					$( "#formTable\\:btnSubmit" ).trigger( "click" );
					$('#dlgDetalhe').closeModal(); 		
				}
	        }
		});
		
		return false;
	}
		
	$(this).ajustaTabela({"status" : "ready"}); 
	
	
});	