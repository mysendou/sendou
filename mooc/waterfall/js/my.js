window.onload = function() {
    img_location("container", "box");
    /*window.onscroll = function() { //鼠标滚动事件
        if (check_csroll("container", "box")) {
            var dparent = document.getElementById("container");
            for (var i = 0; i < img_data.data.length; i++) {
                var dcontent = document.createElement("div");	//创建图片的容器
                dcontent.className = "box";		//为节点添加类名
                dparent.appendChild(dcontent);	//添加根元素
                var boximg = document.createElement("div");		//创建边框
                boximg.className = "box_img";	//为节点添加类名
                dcontent.appendChild(boximg);	//添加根元素
                var img = document.createElement("img");	//创建图片
                img.src = "images/" + img_data.data[i].src;//图片加载路径
                boximg.appendChild(img);//添加根元素
            }
        }
        img_location("container", "box");
    }*/
}

var addMore = function(){
	     var img_data = {
        "data": [{
            "src": "a.jpg"
        }, {
            "src": "b.jpg"
        }, {
            "src": "c.jpg"
        }, {
            "src": "d.jpg"
        }, {
            "src": "e.jpg"
        }, {
            "src": "f.jpg"
        }, {
            "src": "g.jpg"
        }, {
            "src": "h.jpg"
        }, {
            "src": "i.jpg"
        }, {
            "src": "k.jpg"
        }, {
            "src": "l.jpg"
        }, {
            "src": "m.jpg"
        }, {
            "src": "n.jpg"
        }, {
            "src": "o.jpg"
        }]
    }
	var dparent = document.getElementById("container");
    for (var i = 0; i < img_data.data.length; i++) {
        var dcontent = document.createElement("div");	//创建图片的容器
        dcontent.className = "box";		//为节点添加类名
        dparent.appendChild(dcontent);	//添加根元素
        var boximg = document.createElement("div");		//创建边框
        boximg.className = "box_img";	//为节点添加类名
        dcontent.appendChild(boximg);	//添加根元素
        var img = document.createElement("img");	//创建图片
        img.src = "images/" + img_data.data[i].src;//图片加载路径
        boximg.appendChild(img);//添加根元素
    }
    img_location("container", "box");
}
function check_csroll(parent, content) {
    var dparent = document.getElementById(parent); //获取最外层的容器
    var dcontent = get_child_element(dparent, content);//获得所有的承载图片的容器
    var last_content_height = dcontent[dcontent.length - 1].offsetTop; //获取最后一张图片到顶的距离
    var scroll_top = document.documentElement.scrollTop || document.body.scrollTop; //获取滚动条到顶的距离
    var page_height = document.documentElement.clientHeight || document.body.clientHeight; //获取屏幕高度
    console.log(scroll_top)
    if (last_content_height < scroll_top + page_height) {
        return true;
    }
}

function img_location(parent, content) {
	var dparent = document.getElementById(parent);//获取最外层的容器
	var dcontent = get_child_element(dparent,content);//获得所有的承载图片的容器
	var num = get_num(dparent,dcontent); //一排摆放图片的个数
	var put_image = put_image_local(num,dcontent);
}

function get_child_element(parent, content) { //获得子元素个数
    var content_array = [];
    var all_content = parent.getElementsByTagName("*");//获取容器下所有的子元素
    for(var i = 0; i < all_content.length; i++) {	//遍历所有的子元素
    	if(all_content[i].className == content) {	//判断是否是承载图片的容器
    		content_array.push(all_content[i]);	
    	}
    }

    return content_array;
}

function get_num(dparent, dcontent){
	var img_width = dcontent[1].offsetWidth;//获取第一个图片的宽度
	var win_width = document.documentElement.clientWidth;//屏幕的宽度
	var num = Math.floor(win_width / img_width);//每行的图片个数
	dparent.style.cssText = "width:" + img_width * num + "px;margin:0 auto;";//设置整个外层容器的宽度

	return num;
}
function put_image_local(num, content){
	var height_arr = [];
	for (var i = 0; i < content.length; i++) {
		if(i < num){
			height_arr[i] = content[i].offsetHeight;	//取得第一排图片的高度b并放入数组
			console.log(height_arr);
		} else {
			var min_height = Math.min.apply(null,height_arr);	//获取第一排图片中高度最小的图片的高度
			var min_index = get_min_height_index(min_height, height_arr);	//获取高度最小的图片的索引位置
			content[i].style.position = "absolute";
			content[i].style.top = min_height + "px";
			content[i].style.left = content[min_index].offsetLeft + "px";
			height_arr[min_index] = min_height + content[i].offsetHeight;//最小图片的高度加上在他后面图片的高度
			var addMore = document.getElementById("add-more");
			addMore.style.top = (min_height + 200) + "px";
			addMore.style.left = "-200px";
		}
	};
}

function get_min_height_index(minHeight, arr){
	for (var i in arr) {
		if(arr[i] == minHeight){
			return i;
		}
	}
}
