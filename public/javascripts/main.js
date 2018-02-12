(function() {
    $(".delete").click(function() {
    	var token =  $('input[name="csrfToken"]').attr('value')
        $.ajax({
                method: "DELETE",
                url: $(this).attr('data-url'),
                beforeSend: function(xhr) {
                	 xhr.setRequestHeader('Csrf-Token', token);
                }
            })
            .done(function(data) {
            	window.location.reload(true);
            });
    });

})();