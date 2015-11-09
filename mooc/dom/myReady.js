function myReady(fn){
	//对于现代浏览器，对DOMContentLoaded事件的处理采用标准的事件绑定方式
	if(document.addEventListener){
		document.addEventListener("DOMContentLoaded",fn,false);
	}else{
		IEContentLoad(fn);
	}
	
	// IE 模拟DOMContentload
	function IEContentLoad(fn){
		var d = window.document;
		var done = false;
		
		//只执行一次用户定义的回调函数init
		var init = function(){
			if(!done){
				done = true;
				fn();
			}
		};
		
		//匿名函数立即调用
		(function(){
			try{
				// DOM树未创建完之前调用doScroll会抛出错误
				d.documentElement.doScroll('left');
			}catch(e){
				//延迟在加载一次
				setTimeout(arguments.callee, 50);
				return;
			}
		})();
		//监听dom加载状态
		d.onreadystatechange = function(){
			if(d.readyState == 'complete'){
				d.onreadystatechange = null;
				init();
			}
		}
	}
}