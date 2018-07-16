$(function(){
	loadMap();	//加载地图
	initMap();

});

//加载地图
function loadMap(){
	var map = new BMap.Map('map');
	var point = new BMap.Point(120.3491890000,30.3224770000);		//模拟杭电为中心
	map.centerAndZoom(point,16);
	map.enableScrollWheelZoom();

	window.map = map;
}

function updateCenterAndZoom(lng,lat){
	var point = new BMap.Point(lng,lat);
	map.setCenter(point);
	map.panTo(point);	
}

//根据权限初始化地图
function initMap(){
	//异步获取数据
	/**
	 * [sussece description]
	 * @param  {[type]} data){		}                                                     [description]
	 * @param  {[type]} error:function(err){			console.log('发生错误：'+err.status);		}	} [description]
	 * @return {[type]}                                                                 [description]
	$.ajax({
		url:'',
		type: '',
		sussece:function(data){

		},
		error:function(err){
			console.log('发生错误：'+err.status);
		}
	});
	*/
	createJurisdiction();
}

//在地图上标注辖区
function createJurisdiction(data){
	var areaData = area;

	var points = [];
	var point = null;
	var lng = 0,
		lat = 0;	//记录地图中心的经纬度

	for(var i=0;i<areaData.length;i++){
		point = new BMap.Point(areaData[i].lng,areaData[i].lat);
		points.push(point);
		lng += areaData[i].lng;
		lat += areaData[i].lat;
	}

	lng /= areaData.length;
	lat /= areaData.length;
	updateCenterAndZoom(lng,lat);
	map.setViewport(points);

	var polygon = new BMap.Polygon(points);
	polygon.setFillColor('#677079');
	polygon.setFillOpacity(0.45);
	polygon.setStrokeColor('#677079');
	polygon.setStrokeWeight(2);

	map.addOverlay(polygon);
}

//在地图上标注建筑
function createBuidings(){

}

//在地图上标注小区
function createResidentialArea(){

}

//为楼宇添加事件
function addBuidingsEvent(marker){
	buidingClick(marker);
	buidingMouseOver(marker);
	buidingMouseOut(marker);
}

//建筑点击事件
function buidingClick(marker){
	marker.addEventListener('click',function(e){

	});
}

//建筑鼠标悬浮事件
function buidingMouseOver(marker){
	marker.addEventListener('mouseover',function(){

	});
}

//建筑鼠标移开事件
function buidingMouseOut(marker){
	marker.addEventListener('mouseout',function(){

	});
}

//测试数据
function test(){
	$.ajax({
		url:'http://localhost:8080/PopulationInspect/police/login',
		type:'POST',
		data:{
			poli_code:'010001',
			poli_pwd:'pwd123',
			ip:'123'
		},
		success:function(data){
			alert('请求数据已成功，请在控制台查看具体数据');
			console.log(data);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}