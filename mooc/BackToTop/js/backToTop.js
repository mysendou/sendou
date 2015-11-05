window.onload = function() {
	var obtn = document.getElementById('btn');
	var time = null;
	var isTop = true;
	//页面显示的高度
	var clientHeight = document.documentElement.clientHeight;
	//当滑轮滚动时触发
	window.onscroll = function() {
		//距离顶部的高度
		var osTop = document.documentElement.scrollTop || document.body.scrollTop;
		if (osTop >= clientHeight) {
			obtn.style.display = "block";
		} else {
			obtn.style.display = "none";
		}

		//		if (!isTop) {
		//			clearInterval(time);
		//		}
		//		isTop = false;
	}

	obtn.onclick = function() {
		//设置定时器
		time = setInterval(function() {
			//获取滚蛋条的高度
			var osTop = document.documentElement.scrollTop || document.body.scrollTop;
			//上下取余
			//若为整数会存在bug
			var isSpeed = Math.floor(-osTop / 6); // 5 / 6 = 0 
			document.documentElement.scrollTop = document.body.scrollTop = osTop + isSpeed; // 5 - 0 =5
			//			isTop = true;
			if (osTop == 0) {
				//清除定时器
				clearInterval(time);
			}
		}, 30)
	}
}