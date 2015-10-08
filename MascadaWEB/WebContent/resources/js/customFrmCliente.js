/**
 *  
 */


$(document).ready(function() {
	$.ajax({		
		url: "http://localhost:8080/MascadaREST/rest/Clientes/all",
    	contentType: "application/json; charset=utf-8",
		dataType: "json",
        success: function (data, status, jqXHR) {
        	$.each(data, function(i, cliente) {
        		var $position = (i + 1).toString();
        		var $htmlButton = "<ul id=\"dropdown" + $position + "\" class=\"dropdown-content\">" + 
	        		"<li><a href=\"#!\" class=\"-text\">.zip</a></li>" +
	                "<li><a href=\"#!\" class=\"-text\">.tar</a></li>" +
	                "<li><a href=\"#!\" class=\"-text\">.exe</a></li></ul>" +
	                "<a class=\"rowButton dropdown-button btn-floating btn-flat waves-effect waves-light pink white-text\" " + 
	                "data-activates=\"dropdown" + $position + "\"><i class=\"mdi-editor-border-color\"></i></a>";
        		
        		$('<tr><td class="cpf" >' + cliente.cpf + '</td><td>' + 
            		cliente.nome + '</td><td>' + cliente.telefone + '</td><td>' + $htmlButton + '</td></tr>').appendTo("#tbody");
        	});
         },
         error: function (jqXHR, status) {
             alert(status);
         }
     });
	
	$('#formTable').removeClass('displayNone'); 
	
	$(".rowButton").click(function() {
		alert('clicked');
	    var $row = $(this).closest("tr");    // Find the row
	    var $text = $row.find(".cpf").text(); // Find the text

	    alert($text);
	});
});
