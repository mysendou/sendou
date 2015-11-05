window.onload = function() {
	var list = document.getElementById("list");
	var lis = list.children;
	var time;
	/**
	 * 实现删除功能
	 * @param 获取父节点
	 */
	function removeNode(node) {
		//删除节点，先获取父节点，在调用remoceChild()方法，将要删除的节点作为参数传进去
		node.parentNode.removeChild(node);
	}

	/**
	 * 实现点赞功能
	 * @param box分享当前的容器
	 * @param el点击的元素
	 */
	function praiseBox(box, el) {
		var txt = el.innerHTML;
		var praiseTotal = box.getElementsByClassName('praises-total')[0];
		var oldTotal = praiseTotal.getAttribute('total');
		var newTotal;

		//点击的是 赞
		if (txt == '赞') {
			newTotal = parseInt(oldTotal) + 1;
			praiseTotal.setAttribute('total', newTotal);
			praiseTotal.innerHTML = (newTotal == 1) ? '我觉得很赞' : "我和" + oldTotal + '人觉得很赞';
			el.innerHTML = '取消赞';
		} else { //点击的是 取消赞
			newTotal = oldTotal - 1; //总数减一
			praiseTotal.setAttribute('total', newTotal);
			praiseTotal.innerHTML = (newTotal == 0) ? '' : newTotal + '个人觉得很赞';
			el.innerHTML = '赞';
		}
		praiseTotal.style.display = (newTotal == 0) ? 'none' : 'block';
	}

	function replayBox(box) {
		var textarea = box.getElementsByTagName('textarea')[0];
		var txt = textarea.value;
		var list = box.getElementsByClassName('comment-list')[0];
		var li = document.createElement('div');
		li.className = 'comment-box clearfix';
		li.setAttribute('user', 'self');
		var html = '<img class="myhead" src="images/my.jpg" alt=""/>' +
			'<div class="comment-content">' +
			'<p class="comment-text"><span class="user">我：</span>' + txt + '</p>' +
			'<p class="comment-time">' +
			getReplayTime() +
			'<a href="javascript:;" class="comment-praise" total="" my="0" style="">赞</a>' +
			'<a href="javascript:;" class="comment-operate">删除</a>' +
			'</p>' +
			'</div>';
		li.innerHTML = html;
		list.appendChild(li);
		textarea.value = '';
		textarea.onblur();
	}

	function getReplayTime() {
		var dateTime = new Date();
		var year = dateTime.getFullYear();
		var month = dateTime.getMonth() + 1;
		var day = dateTime.getDate();
		var hour = dateTime.getHours();
		var minutes = dateTime.getMinutes();
		var seconds = dateTime.getSeconds();

		month = month < 10 ? '0' + month : month;
		day = day < 10 ? '0' + day : day;
		hour = hour < 10 ? '0' + hour : hour;
		minutes = minutes < 10 ? '0' + minutes : minutes;
		seconds = seconds < 10 ? '0' + seconds : seconds;

		return year + '-' + month + '-' + day + ' ' + hour + ':' + minutes + ':' + seconds;
	}

	function praiseReply(el) {
		var oldTotal = parseInt(el.getAttribute('total'));
		var my = parseInt(el.getAttribute('my'));
		var newTotal;
		if (my == 0) {
			newTotal = oldTotal + 1;
			el.setAttribute('total', newTotal);
			el.setAttribute('my', 1);
			el.innerHTML = newTotal + ' 取消赞';
		} else {
			newTotal = oldTotal - 1;
			el.setAttribute('total', newTotal);
			el.setAttribute('my', 0);
			el.innerHTML = newTotal == 0 ? '赞' : newTotal + '赞';
		}
		el.style.display = newTotal == 0 ? 'none' : 'block';
	}

	function replayOperate(el){
		var commonBox = el.parentNode.parentNode.parentNode;//获取评论框的元素
		var box = commonBox.parentNode.parentNode.parentNode;//获取整个说说的元素
		var txt = el.innerHTML;
		var userName = commonBox.getElementsByClassName('user')[0].innerHTML;
		var textareaTxt = box.getElementsByTagName('textarea')[0];
		
		if(txt == '回复'){
			textareaTxt.onfocus();
			textareaTxt.value = '回复' + userName;
			textarea.onkeyup();
		}else{
			removeNode(commonBox);
		}
	}
	for (var i = 0; i < lis.length; i++) {
		lis[i].onclick = function(e) {
			//浏览器兼容
			e = e || window.event;
			var el = e.srcElement;
			switch (el.className) {
				case 'close':
					removeNode(el.parentNode);
					break;
				case 'praise':
					praiseBox(el.parentNode.parentNode.parentNode, el);
					break;
				case 'btn btn-off':
					clearTimeout(time);
					break;
				case 'btn':
					replayBox(el.parentNode.parentNode.parentNode);
					break;
				case 'comment-praise':
					praiseReply(el)
					break;
				case 'comment-operate':
					replayOperate(el);
					break;
			}
			console.log(el.className);
		};

		var textarea = lis[i].getElementsByTagName('textarea')[0];
		//获得焦点
		textarea.onfocus = function(e) {
				this.parentNode.className = 'text-box text-box-on';
				this.value = this.value == '评论…' ? '' : this.value;
				this.onkeyup();
			}
			//失去焦点
		textarea.onblur = function(e) {
				var me = this;
				if (this.value == '') {
					//当鼠标离开输入框，延迟使其缩小
					time = setTimeout(function() {
						me.parentNode.className = 'text-box';
						me.value = '评论…';

					}, 500); //设置0.5秒后文本框变小
				}
			}
			//键盘输入完毕
		textarea.onkeyup = function(e) {
			var len = this.value.length; //获取输入的字符个数
			var p = this.parentNode; //获取父节点
			var btn = p.children[1]; //获取按钮
			var word = p.children[2]; //获取显示文字个数
			if (len == 0 || len > 140) {
				btn.className = 'btn btn-off';
			} else {
				btn.className = 'btn';
			}
			word.innerHTML = len + '/140';
		}
	}
}