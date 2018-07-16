$(function(){
	initMap();		//初始化地图
	window.Markers = [];	//保存分类生成的所有markers

});

//GPS坐标转化为百度坐标
/**
 * 如果不需要坐标转化，可删除这段代码
 */
function translateBaiduArea(points){
	var points_baidu = [];
	var convertor = new BMap.Convertor();
	for(var i=0;i<points.length;i++){
		convertor.translate([points[i]],1,5,function(e){
			// console.log(e);
			if(e.status == 0){
				console.log(e);
				console.log(i);
				points_baidu.push(e.points[0]);
				if(i == points.length){
					console.log(i);
					createArea(points_baidu);
				}
			}else{
				console.log('坐标位置可能出错，请重新刷新网页');
			}
		});
	}
}

function translateBaiduBuiding(point){
	var convertor = new BMap.Convertor();
	convertor.translate([point],1,5,function(e){
		if(e.status == 0){
			var marker = new BMap.Marker(e.points[0]);
			map.addOverlay(marker);
		}
	})
}

//初始化地图
function initMap(){
	var map = new BMap.Map('map');
	var point = new BMap.Point(120.3491890000,30.3224770000);
	map.centerAndZoom(point,16);
	map.enableScrollWheelZoom();

	var sw = new BMap.Point(119.9172830000,30.0935150000);
	var ne = new BMap.Point(120.4600040000,30.4727440000);
	var bounds = new BMap.Bounds(sw,ne);
	//BMapLib.AreaRestriction.setBounds(map,bounds);

	window.map = map;
}

//解析坐标字符串，返回point的数组
function areaParse(localStr){
	var locals = localStr.split('-');
	var points = [];
	var point = null;
	var local = [];
	for(var i=0;i<locals.length;i++){
		local = locals[i].split('|');
		point = new BMap.Point(local[0],local[1]);
		points.push(point);
	}

	return points;
}

/**
 * 登陆时显示的辖区
 * @param  {[String]} data [坐标字符串]
 */
function createJurisdection(data){
	map.clearOverlays();		//清除之前添加的所有覆盖物
	var points = [];
	points = areaParse(data);
	//translateBaiduArea(points);
	
	map.setViewport(points);

	var polygon = new BMap.Polygon(points);
	polygon.setFillColor('#677079');
	polygon.setFillOpacity(0.45);
	polygon.setStrokeColor('#677079');
	polygon.setStrokeWeight(2);

	map.addOverlay(polygon);
}

/**
 * 点击辖区树是对应生成的区域
 * @param  {[String]} data [坐标字符串]
 */
function createArea(data){
	map.clearOverlays();
	var points = [];
	points = areaParse(data);
	map.setViewport(points);

	var polygon = new BMap.Polygon(points);
	polygon.setFillColor('#677079');
	polygon.setFillOpacity(0.45);
	polygon.setStrokeColor('#677079');
	polygon.setStrokeWeight(2);

	map.addOverlay(polygon);
}

function createBuildingName(point,name,id){
	var opts = {
		position: point,
		offset: new BMap.Size(8,-13)
	};
	// console.log(id);
	var label = new BMap.Label(name,opts);
	label.setStyle({
		color: '#000',
		fontSize: '12px',
		paddingRight: '2px',
		height: '16px',
		lineHeight: '16px',
		border: 'none',
		fontWeight: '900',
		backgroundColor: 'rgba(132,222,249,0.6)',
		fontFamily: '微软雅黑'
	});
	map.addOverlay(label);
	addEventBuidInfo(label,id);
}

function createAreaBuildNames(buildings){
	var point = null;
	console.log(buildings[0].builGpse);
	for(var i=0;buildings.length;i++){
		point = new BMap.Point(buildings[i].builGpse,buildings[i].builGpsn);
		createBuildingName(point,buildings[i].builName,buildings[i].builId);
	}
}

/**
 * 点击建筑，标注该建筑
 * @param  {[Float]} buid_lng [建筑经度]
 * @param  {[Float]} buid_lat [建筑纬度]
 */
function createBuiding(buid_lng,buid_lat,buidId){
	map.clearOverlays();
	var point = new BMap.Point(buid_lng,buid_lat);
	var marker = new BMap.Marker(point);
	marker.setZIndex(100);
	map.addOverlay(marker);
	map.panTo(point);
	// createBuildingName(point,buildName);

	addEventBuidInfo(marker,buidId);
}

//为地图上的建筑添加点击事件，显示楼宇的详细信息
function addEventBuidInfo(marker,id){
	marker.addEventListener('click',function(){
		//显示楼宇信息,传入建筑ID
		// console.log(id);
		getUnit(id);
		showBuildInfo();
		getStatisBybuild(id);
	});
}

/**
 * 生成超期未巡检楼宇
 * @param  {[Array]} buildings [未巡检的楼宇信息]
 */
function createOverDueBuilds(buildings){
	// console.log(buildings);
	map.clearOverlays();
	var point;
	var points = [];
	for(var i=0;i<buildings.length;i++){
		point = new BMap.Point(buildings[i].builGpse,buildings[i].builGpsn);
		points.push(point);
		var marker = new BMap.Marker(point);
		marker.setZIndex(100);
		map.addOverlay(marker);
		createBuildingName(point,buildings[i].builName,buildings[i].builId);
		addEventBuidInfo(marker,buildings[i].builId);
	}
	map.setViewport(points);
}

/**
 * 删除取消选择的分类
 * @param  {[Array]} arr [取消选择的楼宇信息]
 */
function deleteMarkers(arr){
	var point;
	// console.log(arr);
	for(var i=0;i<Markers.length;){
		for(var j=0;j<arr.length;j++){
			// console.log(Markers[i]);
			point = Markers[i].point;
			if(point.lng == arr[j].builGpse && point.lat == arr[j].builGpsn){
				map.removeOverlay(Markers[i]);
				for(var k=i;k<Markers.length-1;k++){
					Markers[k] = Markers[k+1];
				}
				Markers.pop();
				break;
			}
		}
		if(j == arr.length){
			i++;
		}
	}
}

/**
 * 添加分类一的建筑标注
 * @param  {[Array]} arr [选择的建筑的信息]
 * @return {[type]}     [description]
 */
function createBuidingTypeOne(arr){
	// console.log(arr);
	var point;
	var points = [];
	var myIcon;
	for(var i=0;i<arr.length;i++){
		point = new BMap.Point(arr[i].builGpse,arr[i].builGpsn);
		createBuildingName(point,arr[i].builName,arr[i].builId);
		points.push(point);
		myIcon = new BMap.Icon('images/icon1.png',new BMap.Size(28,47));
		var marker = new BMap.Marker(point,{icon:myIcon});
		marker.setZIndex(100);
		map.addOverlay(marker);
		Markers.push(marker);
		addEventBuidInfo(marker,arr[i].builId);
	}
	map.setViewport(points);
}

/**
 * 添加分类二的建筑标注
 * @param  {[Array]} arr [选择的建筑的信息]
 * @return {[type]}     [description]
 */
function createBuidingTypeTwo(arr){
	var point;
	var points = [];
	var myIcon;
	for(var i=0;i<arr.length;i++){
		point = new BMap.Point(arr[i].builGpse,arr[i].builGpsn);
		createBuildingName(point,arr[i].builName,arr[i].builId);
		points.push(point);
		myIcon = new BMap.Icon('images/icon2.png',new BMap.Size(35,45));
		var marker = new BMap.Marker(point,{icon:myIcon});
		marker.setZIndex(100);
		map.addOverlay(marker);
		Markers.push(marker);
		addEventBuidInfo(marker,arr[i].builId);
	}
	map.setViewport(points);
}

/**
 * 添加分类三的建筑标注
 * @param  {[Array]} arr [选择的建筑的信息]
 * @return {[type]}     [description]
 */
function createBuidingTypeThree(arr){
	var point;
	var points = [];
	var myIcon;
	for(var i=0;i<arr.length;i++){
		point = new BMap.Point(arr[i].builGpse,arr[i].builGpsn);
		createBuildingName(point,arr[i].builName,arr[i].builId);
		points.push(point);
		myIcon = new BMap.Icon('images/icon3.png',new BMap.Size(38,45));	//20,26
		var marker = new BMap.Marker(point,{icon:myIcon});marker.setZIndex(100);
		marker.setZIndex(100);
		map.addOverlay(marker);
		Markers.push(marker);
		addEventBuidInfo(marker,arr[i].builId);
	}
	map.setViewport(points);
}

/**
 * 添加分类四的建筑标注
 * @param  {[Array]} arr [选择的建筑的信息]
 * @return {[type]}     [description]
 */
function createBuidingTypeFour(arr){
	var point;
	var points = [];
	var myIcon;
	for(var i=0;i<arr.length;i++){
		point = new BMap.Point(arr[i].builGpse,arr[i].builGpsn);
		createBuildingName(point,arr[i].builName,arr[i].builId);
		points.push(point);
		myIcon = new BMap.Icon('images/icon4.png',new BMap.Size(33,48));
		var marker = new BMap.Marker(point,{icon:myIcon});
		marker.setZIndex(100);
		map.addOverlay(marker);
		Markers.push(marker);
		addEventBuidInfo(marker,arr[i].builId);
	}
	map.setViewport(points);
}

/**
 * 添加分类五的建筑标注
 * @param  {[Array]} arr [选择的建筑的信息]
 * @return {[type]}     [description]
 */
function createBuidingTypeFive(arr){
	var point;
	var points = [];
	var myIcon;
	for(var i=0;i<arr.length;i++){
		point = new BMap.Point(arr[i].builGpse,arr[i].builGpsn);
		createBuildingName(point,arr[i].builName,arr[i].builId);
		points.push(point);
		myIcon = new BMap.Icon('images/icon5.png',new BMap.Size(36,49));
		var marker = new BMap.Marker(point,{icon:myIcon});
		marker.setZIndex(100);
		map.addOverlay(marker);
		Markers.push(marker);
		addEventBuidInfo(marker,arr[i].builId);
	}
	map.setViewport(points);
}

/**
 * 添加分类六的建筑标注
 * @param  {[Array]} arr [选择的建筑的信息]
 * @return {[type]}     [description]
 */
function createBuidingTypeSix(arr){
	var point;
	var points = [];
	var myIcon;
	for(var i=0;i<arr.length;i++){
		point = new BMap.Point(arr[i].builGpse,arr[i].builGpsn);
		createBuildingName(point,arr[i].builName,arr[i].builId);
		points.push(point);
		myIcon = new BMap.Icon('images/icon6.png',new BMap.Size(37,54));
		var marker = new BMap.Marker(point,{icon:myIcon});
		marker.setZIndex(100);
		map.addOverlay(marker);
		Markers.push(marker);
		addEventBuidInfo(marker,arr[i].builId);
	}
	map.setViewport(points);
}

function deleteAll(){
	map.clearOverlays();
}