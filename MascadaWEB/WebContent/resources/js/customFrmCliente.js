/**
 *  
 */


$(document).ready(function() {
	jQuery.fn.getREST = function(url, params, sucess, error) {
		$.ajax({		
			url: url,
	    	contentType: "application/json; charset=utf-8",
	    	data: params,
			dataType: "json",
	        success: function (data, status, jqXHR) {
	        	sucess(data, status, jqXHR);
	         },
	         error: function (jqXHR, status) {
	        	 error(jqXHR, status);
	         }
	     });	
	}
	
	jQuery.fn.toggleClassCustom = function(selector, _class, _bool) {
		if(_bool) {		
			$(selector).removeClass(_class); 
			$(selector).addClass(_class); 
		} else {
			$(selector).removeClass(_class);  
		}
	}
	
	
	$.ajax({		
		url: "http://localhost:8080/MascadaREST/rest/Clientes/all",
    	contentType: "application/json; charset=utf-8",
		dataType: "json",
        success: function (data, status, jqXHR) {
        	$.each(data, function(i, cliente) {
        		var $htmlButton = "<a class=\"botaoLinha btn-floating btn-flat waves-effect waves-light pink accent-2 \" ><i class=\"mdi-editor-border-color\"></i></a>";    		
             		$('<tr><td class="cpf" >' + cliente.cpf + '</td><td>' + 
            		cliente.nome + '</td><td>' + cliente.telefone + '</td><td style="width: 1px; padding: 0;" class="btn-line">' + $htmlButton + '</td></tr>').appendTo("#tbody");
        	});
         },
         error: function (jqXHR, status) {
             alert(status);
         }
     });	
	
	$('#formTable').removeClass('displayNone'); 
	
	$("#tbody").delegate("td", "click", function(e) {
		var myClass = $(this).attr("class");
		if(myClass == 'btn-line') {
			var CPF = $(this).closest('tr').find('td:nth-child(1)').text();
			
			$(this).getREST("http://localhost:8080/MascadaREST/rest/Clientes/cpf", 
					{ param : CPF },
				function(cliente, status, jqXHR) {	
					
					$('#formCliente').find("#formCliente\\:codigo").val(cliente.oid);	
					$(this).toggleClassCustom('#formCliente\\:lbl-codigo', 'active', (typeof cliente.oid !== 'undefined'));
					
					$('#formCliente').find("#formCliente\\:nome").val(cliente.nome);	
					$(this).toggleClassCustom('#formCliente\\:lbl-nome', 'active', (typeof cliente.nome !== 'undefined'));
					
					$('#formCliente').find("#formCliente\\:cpf").val(cliente.cpf);	
					$(this).toggleClassCustom('#formCliente\\:lbl-cpf', 'active', (typeof cliente.cpf !== 'undefined'));
					
					$('#formCliente').find("#formCliente\\:telefone").val(cliente.telefone);	
					$(this).toggleClassCustom('#formCliente\\:lbl-telefone', 'active', (typeof cliente.telefone !== 'undefined'));
					
					$('#formCliente').find("#formCliente\\:email").val(cliente.email);
					$(this).toggleClassCustom('#formCliente\\:lbl-email', 'active', (typeof cliente.email !== 'undefined'));
					
					$.each(cliente.endereco , function(i , endereco ){  
						$('#formCliente').find("#formCliente\\:rua").val(endereco.rua);	
						$(this).toggleClassCustom('#formCliente\\:lbl-rua', 'active', (typeof endereco.rua !== 'undefined'));
						
						$('#formCliente').find("#formCliente\\:numero").val(endereco.numero);
						$(this).toggleClassCustom('#formCliente\\:lbl-numero', 'active', (typeof endereco.numero !== 'undefined'));
						
						$('#formCliente').find("#formCliente\\:complemento").val(endereco.complemento);	
						$(this).toggleClassCustom('#formCliente\\:lbl-complemento', 'active', (typeof endereco.complemento !== 'undefined'));
						
						$('#formCliente').find("#formCliente\\:bairro").val(endereco.bairro);	
						$(this).toggleClassCustom('#formCliente\\:lbl-bairro', 'active', (typeof endereco.bairro !== 'undefined'));
						
						$('#formCliente').find("#formCliente\\:cep").val(endereco.cep);	
						$(this).toggleClassCustom('#formCliente\\:lbl-cep', 'active', (typeof endereco.cep !== 'undefined'));
				    }); 
					
					$('#dlgClienteDetalhe').openModal();
				}, function(jqXHR, status) {
					alert('Error: ' + status);
				} 
			);
		}
	});

	
	
	
});