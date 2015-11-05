(function() {
	var items = [];
	var pois = e.poiList.pois;
	var n = pois.length > 5 ? 5 : pois.length;
	for (var i = 0; i < n; i++) {
		items.push(pois[i]['name']);
	}
	new Render(items).showUI();

	var render = function(items) {
		this.items = items;
		this.list = document.getElementById("items_list");
	};

	Render.prototype = {
		_addItem: function(data, i) {
			var el = document.createElement('div');
			el.className = 'mar_top15 item_' + i;
			el.innerHTML = data;
			this.list.appendChild(el);
		},

		//show the list
		showUI: function(items) {
			for (var i = 0, n = (this.items.length > 5 ? 5 : this.items.length); i < n; i++) {
				this._addItem(this.items[i], i + 1);
			}
		}
	};

})();