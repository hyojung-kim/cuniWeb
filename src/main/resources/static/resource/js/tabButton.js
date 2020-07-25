$(document).ready(function(){

    $('#contents>.con1>.dt>a').on('click',function(e){
        e.preventDefault();
        $('#contents>.con1>.dt').removeClass('on');
        $('#contents>.con1>.dd').removeClass('on');

        $(this).parent('.dt').addClass('on');
        $(this).parent('.dt').next('.dd').addClass('on');
    });
    
 
    
});