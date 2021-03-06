/*
This function gets loaded when all the HTML, not including the portlets, is
loaded.
*/
AUI().ready(
	function(A){
		var currentDateTime = setInterval("getCurrentDateTime()", 1000);
	}
);

Liferay.Portlet.ready(

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',
	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);

AUI().ready(
		'liferay-hudcrumbs', 'liferay-navigation-interaction',
		function(A) {
			var navigation = A.one('#navigation');

			if (navigation) {
				navigation.plug(Liferay.NavigationInteraction);
			}

			var siteBreadcrumbs = A.one('.site-breadcrumbs');

			if (siteBreadcrumbs) {
				siteBreadcrumbs.plug(A.Hudcrumbs);
			}
		}
);

/*jQuery(document).ready(function(){
	jQuery('#navigation-menu').superfish();
});*/

function getCurrentDateTime(){

	var day_of_week = new Array();
	day_of_week[0] = "Chủ nhật";
	day_of_week[1] = "Thứ hai";
	day_of_week[2] = "Thứ ba";
	day_of_week[3] = "Thứ tư";
	day_of_week[4] = "Thứ năm";
	day_of_week[5] = "Thứ sáu";
	day_of_week[6] = "Thứ bảy";
	
	var month_of_year = new Array();
	month_of_year[0] = "01";
	month_of_year[1] = "02";
	month_of_year[2] = "03";
	month_of_year[3] = "04";
	month_of_year[4] = "05";
	month_of_year[5] = "06";
	month_of_year[6] = "07";
	month_of_year[7] = "08";
	month_of_year[8] = "09";
	month_of_year[9] = "10";
	month_of_year[10] = "11";
	month_of_year[11] = "12";
	
	var now = new Date();   
	var currentYear= now.getYear();     
	var currentMonth = now.getMonth();  
	var currentDate = now.getDate();   
	var currentDay = now.getDay();
	var currentHour = now.getHours();
	var currentMinute = now.getMinutes();
	var currentSecond = now.getSeconds();
	
	if (currentYear < 1000) {
		currentYear = 1900  + currentYear;
	}
	
	if (currentDate < 10) {
		currentDate = "0" + currentDate;
	}  
			
	if (currentHour < 10) {
		currentHour = "0" + currentHour;
	} 
			
	if (currentMinute < 10) {
		currentMinute = "0" + currentMinute;
	} 
			
	if (currentSecond < 10) {
		currentSecond = "0" + currentSecond;
	} 
	
	var currentDateValue = day_of_week[currentDay] + ", Ngày " + currentDate + "/" + month_of_year[currentMonth] + "/" + currentYear + " | " ;
	var currentTimeValue = currentHour + ":" + currentMinute + ":" + currentSecond;
	
	var currentDateWrapper = document.getElementById("portal_egov_date");
	var currentTimeWrapper = document.getElementById("portal_egov_clock");
	
	if(currentDateWrapper){
		currentDateWrapper.innerHTML = currentDateValue;
	}
	
	if(currentTimeWrapper){
		currentTimeWrapper.innerHTML = currentTimeValue;
	}
}
$(document).on("ready",function(){
	$('.journal-content-article [style*="font-size"]').css('font-size', '');
	$('.journal-content-article [style*="line-height"]').css('line-height', '');
	$("#increaseText").on("click", function() {
       	current = parseInt($(".journal-content-article").css("font-size"));
        bc = current + parseInt(1); 
        var currentDesc = parseInt($(".assetdesc-text").css("font-size"));
        var fontSize = currentDesc + parseInt(1); 
        $(".journal-content-article").css({"font-size" : bc});
        $(".assetdesc-text").css({"font-size": fontSize});
	});

	$("#decreaseText").on("click", function() {
        current = parseInt($(".journal-content-article").css("font-size"));
        bc = current - parseInt(1); 
        var currentDesc = parseInt($(".assetdesc-text").css("font-size"));
        var fontSize = currentDesc - parseInt(1); 
        $(".journal-content-article").css({"font-size" : bc});
        $(".assetdesc-text").css({"font-size": fontSize});
	});
	$('input[name=_3_keywords]').attr("placeholder", "Tìm kiếm");
	$(".asset-category-name").hide();
	var isSafari = !!navigator.userAgent.match(/Version\/[\d\.]+.*Safari/);
    var iOS = /iPad|iPhone|iPod/.test(navigator.userAgent) && !window.MSStream;
    
    if (isSafari && iOS) {
    	$(".sub-navigation").css("display","none");
    } else if(isSafari) {
    	$(".sub-navigation").css("display","none");
    }
});
$("#btnSpeak").on("click",function(){
	console.log("Start speaking article content......");
	var content = $(".journal-content-article").text();
	content = content.replace(/\n|\r/g, "");
	//content = content.replace(/[^0-9a-zàáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđ\s]/gi, ' ');
	content = content.replace(/\s+/g, ' ');
	content = content.trim();
	responsiveVoice.speak(content,'Vietnamese Female');
});
// status 1 mo 0 dong
$("#show-menu").on("click", function() {
	var status = $(this).attr("data-status");
	status = parseInt(status);
	if(status == 0){
		$(".sf-navbar").slideDown();
		$(this).attr("data-status",1);
	} else{
		$(".sf-navbar").slideUp();
		$(this).attr("data-status",0);
	}
});
$(".toggle").on("click", function() {
	var id = $(this).attr("id");
	var status = $(this).attr("data-status");
	status = parseInt(status);
	var dropElement = $("#drop-" + id);
	if(status == 0){
		dropElement.slideDown();
		$(this).attr("data-status", 1);
	} else {
		dropElement.slideUp();
		$(this).attr("data-status", 0);
	}
});
jQuery(document).ready(function(){
	var block1 = $(".col-1");
	var block2 = $(".col-2");
    if (jQuery(window).width() < 900) {
    	//customResponse();
    	block2.find(".vbpq-lastest-entry-portlet").remove();
    	block1.find(".vbpq-lastest-entry-portlet").css("display","block");
    }
    else{
    	block1.find(".vbpq-lastest-entry-portlet").css("display","none");
    }
});
function customResponse() {
	var block1 = $("#column-1");
	var append = $("#articlePublisherStyle5");
	var parrentAppend = append.closest(".article-publisher-portlet");
	var parrentId = parrentAppend.attr("id");
	var blockParrent = $("#column-2");
	if(block1.find("#articlePublisherStyle5").length > 0){
		blockParrent.find('[id^="articlePubliserStyle"]').each(function() {
			var parrent = $(this).closest(".article-publisher-portlet");
			var portletId = parrent.attr("id");
			if(portletId != parrentId){
				$("#" + portletId).remove();
				parrentAppend.after(parrent);
			}
		});
	}
}
