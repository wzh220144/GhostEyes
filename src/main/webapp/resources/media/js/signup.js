$(function(){
	
	$("#submit").click(function() {
        var passwd = $("#passwd").val();
        passwd = hex_md5(passwd);
       $("#passwd").val(passwd)
    });
	
});