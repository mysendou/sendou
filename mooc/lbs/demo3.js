(function() {
	//初始化map类
	var map = new AMap.Map('mapContainer');
	map.setZoom(14);

	map.plugin('AMap.Geolocation', function() {
		var geoLocation = new AMap.Geolocation({
			enableHighAccuracy: true, //是否使用高精度定位，默认:true
			convert: true,
			           //自动偏移坐标，偏移后的坐标为高德坐标，默认：true
			panToLocation: true,
			     //定位成功后将定位到的位置作为地图中心点，默认：true
			showMarker: true,
			        //定位成功后在定位到的位置显示点标记，默认：true
			timeout: 10000          //超过10秒后停止定位，默认：无穷大
		});
		geoLocation.getCurrentPosition(); //获取当前位置信息
		AMap.event.addListener(geoLocation, 'complete', function(e) {
			console.log("aaaa");
			console.log(e);
		});
	});

})();