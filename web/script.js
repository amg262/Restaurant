$(function () {
	//tab functions from 
	// http://jqueryfordesigners.com/jquery-tabs/
    var tabContainers = $('div.tabs > div');
    
    $('div.tabs ul.tabNavigation a').click(function (e) {
        e.preventDefault();
		
		tabContainers.hide().filter(this.hash).show();
        
        $('div.tabs ul.tabNavigation a').removeClass('selected');
        $(this).addClass('selected');
        
        
    }).filter(':first').click();
});


$(document).ready();
