(function() {
	var myMap = new AMap.Map('mapContainer');
	//mark
		  	var mark = new AMap.Marker({
					map:myMap,
					draggable:true
				});	
				mark.setPosition(myMap.getCenter());
	
	AMap.event.addListener(mark, 'click',function(){
		info.open(myMap, myMap.getCenter());
	});
	
	var info = new AMap.InfoWindow({
		closeWhenClickMap : true,
		content : '我是窗体'
	});
})();