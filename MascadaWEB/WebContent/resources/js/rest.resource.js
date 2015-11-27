$(document).ready(function() {
	var $baseurl = 'http://localhost:8080/MascadaWEBResource/rest/';
	
	jQuery.fn.postREST = function(jsonConfig, jsonData) {
		var $url = $baseurl +  jsonConfig.resourcePath + '/' + jsonConfig.contextMethod;
		alert($url);
		jQuery.ajax({
	         type: "POST",
	         url: $url,
	         data: jsonData.toJsonString(),
	         contentType: "application/json; charset=utf-8",
	         dataType: "json",
	         success: function (data, status, jqXHR) {
	              alert('success' + status);
	         },
	     
	         error: function (jqXHR, status) {            
	        	 alert('error' + status);
	         }

	     });
	}
});	