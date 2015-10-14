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
				function(data, status, jqXHR) {		
					var nome = data.nome;
					
					$('#formCliente').find("input#first_name").val(data.nome);
					if(nome != '')
						$('#lbl-first-name').toggleClass('active');
					
					$('#dlgClienteDetalhe').openModal();
				}, function(jqXHR, status) {
					alert('Error: ' + status);
				} 
			);
		}
	});

	
	
	
});