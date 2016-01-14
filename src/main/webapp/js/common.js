function sukesuke(element) {
  if(!(navigator.appVersion.match(/MSIE/) == "MSIE")){
    return;
  }
  if(!element){
    element = document;
  }
  $A(element.getElementsByTagName("img")).each(function(tag){
    if(tag.src.match(/raw/) || tag.src.match(/\.png(\?.+)?$/)) {
      tag.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(enabled='true',src='" + tag.src + "')";
      tag.style.paddingTop = tag.offsetHeight;
    }
  });
}

function make_hover(element) {
	$A($(element).getElementsByTagName("li")).each(function(tag){
		var tag = $(tag);
		if($A(tag.getElementsByTagName('dl')).first()) {
			tag.observe('mouseover', function() {
				tag.addClassName('hover');
			});
			tag.observe('mouseout', function() {
				tag.removeClassName('hover');
			});
		}
	});
}

function common_on_load() {
	sukesuke(document.body);
	make_hover("menu_bar");
}
