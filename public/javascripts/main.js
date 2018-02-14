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
    $(".update").click(function() {
    	$(this).parent('div').parent('td').siblings().each(function() {
    		$(this).find('div').eq(0).hide();
    		$(this).find('div').eq(1).show();
    	});
    	$(this).siblings('.save').show();
    	$(this).hide();
    });
    
    $(".save").click(function() {
    	var token =  $('input[name="csrfToken"]').attr('value')
    	var id = $(this).attr('data-id')
    	var fname = $(this).parent('div').parent('td').siblings().eq(0).find('div').eq(1).children('input').val();
    	var lname = $(this).parent('div').parent('td').siblings().eq(1).find('div').eq(1).children('input').val();
    	$.ajax({
            method: "PUT",
            url: '/update/customer/'+ id +'/'+ fname +'/'+ lname +'',
            beforeSend: function(xhr) {
            	 xhr.setRequestHeader('Csrf-Token', token);
            }
        })
        .done(function(data) {
        	window.location.reload(true);
        });
    });

})();