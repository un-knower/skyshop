/**
 * http://usejsdoc.org/
 */

$(function() {
    $("<link/>", {
        rel : "shortcut icon",
        type : "image/png",
        href : "images/06.jpg"
    }).appendTo("head");
    
    $('.h_back').click(function() {
        history.go(-1);
    });
});