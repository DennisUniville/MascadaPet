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
					
					$('#formCliente').find("input#codigo").val(cliente.oid);	
					$(this).toggleClassCustom('#lbl-codigo', 'active', (typeof cliente.oid !== 'undefined'));
					
					$('#formCliente').find("input#nome").val(cliente.nome);	
					$(this).toggleClassCustom('#lbl-nome', 'active', (typeof cliente.nome !== 'undefined'));
					
					$('#formCliente').find("input#cpf").val(cliente.cpf);	
					$(this).toggleClassCustom('#lbl-cpf', 'active', (typeof cliente.cpf !== 'undefined'));
					
					$('#formCliente').find("input#telefone").val(cliente.telefone);	
					$(this).toggleClassCustom('#lbl-telefone', 'active', (typeof cliente.telefone !== 'undefined'));
					
					$('#formCliente').find("input#email").val(cliente.email);
					$(this).toggleClassCustom('#lbl-email', 'active', (typeof cliente.email !== 'undefined'));
					
					$.each(cliente.endereco , function(i , endereco ){  
						$('#formCliente').find("input#rua").val(endereco.rua);	
						$(this).toggleClassCustom('#lbl-rua', 'active', (typeof endereco.rua !== 'undefined'));
						
						$('#formCliente').find("input#numero").val(endereco.numero);
						$(this).toggleClassCustom('#lbl-numero', 'active', (typeof endereco.numero !== 'undefined'));
						
						$('#formCliente').find("input#complemento").val(endereco.complemento);	
						$(this).toggleClassCustom('#lbl-complemento', 'active', (typeof endereco.complemento !== 'undefined'));
						
						$('#formCliente').find("input#bairro").val(endereco.bairro);	
						$(this).toggleClassCustom('#lbl-bairro', 'active', (typeof endereco.bairro !== 'undefined'));
						
						$('#formCliente').find("input#cep").val(endereco.cep);	
						$(this).toggleClassCustom('#lbl-cep', 'active', (typeof endereco.cep !== 'undefined'));
				    }); 
					
					$('#dlgClienteDetalhe').openModal();
				}, function(jqXHR, status) {
					alert('Error: ' + status);
				} 
			);
		}
	});

	
	
	
});