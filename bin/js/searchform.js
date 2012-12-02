function sendForm(form){

	var opt = form.searchType;
	var index = opt.selectedIndex;
	var str = opt.options[index].value;
	var act = form.actionValue;
	
	if(str == "all"){
		form.action = "DisplayGlobalsInPublic.do";
	}else if(str == "artists"){
		form.action  = "DisplayArtistsInPublic.do";
	}else if(str == "works"){
		form.action  = "DisplayWorksInPublic.do";
	}else if(str == "news"){
		form.action  = "DisplayNewsInPublic.do";
	}else if(str == "products"){
		form.action  = "DisplayProductsInPublic.do";
	}else{
		form.action = act;
	}
	form.submit();
}

function sendForm2(form,elem,val) {
	var act = form.actionValue.value;

	elem.value=val;
	form.action = act;
	form.submit();
}

function sendForm3(form) {
	var act = form.actionValue;
	form.action = act;
	form.submit();		
}