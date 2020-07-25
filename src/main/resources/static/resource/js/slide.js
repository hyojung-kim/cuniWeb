$(document).ready(function(){

    $(".header>.bgn>ul>li").on("mouseover",  function(){
        $(".sub").stop().slideDown();
    });

    $(".header>.bgn>ul>li").on("mouseleave",  function(){
        $(".sub").stop().slideUp();
    });
    
});