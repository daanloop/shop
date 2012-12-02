$("#gonext").click(function(){
	if($("#sendType").val() == "add"){
		form.action = "PostDeliveryAddressVP.do";
		return  false;
	}else if($("#sendType").val() == "done"){
		form.action="DeliveryAddressList.do";
		return  false;	
	}
	$("#form").submit();
})

