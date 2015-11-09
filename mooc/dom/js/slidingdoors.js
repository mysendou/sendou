//会在页面或图像加载完成后调用
window.onload = function() {
	//获取容器对象
	var box = document.getElementById('container');

	//获得所有image的集合
	var images = box.getElementsByTagName('img');

	//获取图片的宽度
	var imgWidth = images[0].offsetWidth;

	//设置每张图片暴露出来的宽度
	var exposeWidth = 160;

	//设置容器的总宽度
	var boxWidth = imgWidth + (images.length - 1) * exposeWidth;
	box.style.width = boxWidth + 'px';

	//设置每张图片的初始位置
	function setImagePosition() {
		for (var i = 1, len = images.length; i < len; i++) {
			images[i].style.left = imgWidth + (i - 1) * exposeWidth + 'px';
		}
	}

	//调用setImagePosition
	setImagePosition();

	//计算每次移动的距离
	var translate = imgWidth - exposeWidth;

	//为每张图片添加事件
	for (var i = 0, len = images.length; i < len; i++) {
		//匿名函数立即调用
		(function(i) {
			images[i].onmouseover = function() {
				//复位
				setImagePosition();
				//当鼠标进入这个图片的时候所有左边除了第一个的包括这个图片向左移动translate
				for (var j = 1; j <= i; j++) {
					images[j].style.left = parseInt(images[j].style.left, 10) - translate + 'px';
				}
			}

		})(i)
	}
}