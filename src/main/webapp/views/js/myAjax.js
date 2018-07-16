//所长二级目录请求数据---派出所-->小区/独立建筑
function treeLevel20(stat_id_my){
	$.ajax({
		url:'../police_station/jurisdiction',
		type:'POST',
		data:{
			poli_station_id:stat_id_my,
		},
		success:function(data){
		 //console.log(data);
			var tree_datas = eval('('+data+')');
			var buildingbox = $('#menu1-ul');
		    // buildingbox.html('');
		    if(buildingbox.html()){
		    	buildingbox.toggle();
		    }else{
		    	var p = '';
			    for (var i = 0; i < tree_datas.community.length; i++) {
			    	//为了使用离线删除createJurisdection('+'\''+tree_datas.community[i].commGpslist+'\''+');
			        p += '<li class="building1" id="commId'+tree_datas.community[i].commId+'" ><a class="m0" href="javascript:void(0)" onclick="treeLevel21(' + tree_datas.community[i].commId + ','+'\''+tree_datas.community[i].commName+'\''+');createJurisdection('+'\''+tree_datas.community[i].commGpslist+'\''+');getStatisByComm('+tree_datas.community[i].commId+');showBuilByCommId('+tree_datas.community[i].commId+');return false;">'+tree_datas.community[i].commName+'</a><ul class="file" id="file'+tree_datas.community[i].commId+'"></ul></li>';
			        
			    }
			   
			    for (var j = 0; j < tree_datas.building.length; j++) {
			        p += '<li class="building2" id="building'+tree_datas.building[j].builId+'"><a class="m1" href="javascript:void(0)" onclick="getStatisBybuild('+tree_datas.building[j].builId+ ');breadBuild('+'\''+tree_datas.building[j].builName+'\''+');createBuiding('+tree_datas.building[j].builGpse+','+tree_datas.building[j].builGpsn+','+tree_datas.building[j].builId+','+'\''+tree_datas.building[j].builName+'\''+')">'+tree_datas.building[j].builName+'</a></li>';
			        
			    }

			    p += '</ul>';

			    buildingbox.append(p);
		    }
		   
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
//三级目录请求数据----小区-->建筑
function treeLevel21(Comm_id_my,name){
	 //标头添加小区
	var breadcrumb1 = $("#breadcrumb1");
	var root1 = $("#root1");
	root1.nextAll().remove();
	var root2 = '<li id="root2" value="'+Comm_id_my+'">' + name + '</li>';
	breadcrumb1.append(root2);
	$.ajax({
		url:'../community/building',
		type:'POST',
		data:{
			comm_id:Comm_id_my,
		},
		success:function(data){
			//console.log(data);
			var datas = eval('('+data+')');
			// console.log(nodeId_my);
			
		    var buildingbox = $('#file'+Comm_id_my);
		    // buildingbox.html('');
		    if(buildingbox.html()){
		    	 buildingbox.toggle();
		    	}else{
		    		var p = '';
				    for (var i = 0; i < datas.building.length; i++) {
				    	
				        p += '<li class="building2" id="building'+datas.building[i].builId+'"><a href="javascript:void(0)" onclick="bulidingEdit22('+datas.building[i].builId+');getStatisBybuild('+datas.building[i].builId+');breadBuild('+'\''+datas.building[i].builName+'\''+');createBuiding('+datas.building[i].builGpse+','+datas.building[i].builGpsn+','+datas.building[i].builId+','+'\''+datas.building[i].builName+'\''+');showBuilByCommId('+Comm_id_my+');">'+datas.building[i].builName+'</a></li>';
				    }

				    buildingbox.prepend(p);
		    	}
		    
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}

//一般警员一级目录数据请求---辖区建筑-->小区/独立建筑
function treeLevel10(poli_id_my,name){

	$.ajax({
		url:'../police/jurisdiction',
		type:'POST',
		data:{
			poli_id:poli_id_my,
		},
		success:function(data){
		console.log(data);
			var tree_datas = eval('('+data+')');

			var buildingbox = $('#menu1-ul');
		    // buildingbox.html('');
		    if(buildingbox.html()){
		    	buildingbox.toggle();
		    }else{
		    	var p = '';
			    for (var i = 0; i < tree_datas.community.length; i++) {
			    	
			        p += '<li class="building1" id="commId'+tree_datas.community[i].commId+'" ><a class="m0" href="javascript:void(0)" onclick="communityEdit('+poli_id_my+',' + tree_datas.community[i].commId + ','+'\''+tree_datas.community[i].commName+'\''+');treeLevel21(' + tree_datas.community[i].commId + ','+'\''+tree_datas.community[i].commName+'\''+');getStatisByComm('+tree_datas.community[i].commId+');createJurisdection('+'\''+tree_datas.community[i].commGpslist+'\''+');showBuilByCommId('+tree_datas.community[i].commId+');return false;">'+tree_datas.community[i].commName+'</a><ul class="file" id="file'+tree_datas.community[i].commId+'"></ul></li>';
			        
			    }
			    
			    for (var j = 0; j < tree_datas.building.length; j++) {
			        p += '<li class="building2" id="building'+tree_datas.building[j].builId+'"><a class="m1" href="javascript:void(0)" onclick="bulidingEdit22('+tree_datas.building[j].builId+');getStatisBybuild('+tree_datas.building[j].builId+');breadBuild1('+'\''+tree_datas.building[j].builName+'\''+');createBuiding('+tree_datas.building[j].builGpse+','+tree_datas.building[j].builGpsn+','+tree_datas.building[j].builId+','+'\''+tree_datas.building[j].builName+'\''+')">'+tree_datas.building[j].builName+'</a></li>';
			    }

			    p += '</ul>';

			    buildingbox.append(p);
		    }
		    
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}

//警员二级目录数据请求----点击小区获取建筑
//调用treelevel20();
//统计信息---警员登录时加载全部统计信息
function getStatisByPoli(poli_id_my,remark){
	$('.loading').css({'display':'block'});
	$.ajax({
		url:'../police/jurisdiction/statistics',
		type:'POST',
		data:{
			poli_id:poli_id_my,
		},
		success:function(data){
		 //console.log(data);
			var datas = eval('('+data+')');
			var datasNum = datas.room_subclassify_info;
			console.log(datasNum);
			var num1 = 0;
			var num2 = 0;
			var num3 = 0;
			var num4 = 0;
			var num5 = 0;
			var num6 = 0;
			var num7 = 0;
			var num8 = 0;
			var num9 = 0;
			var num10 = 0;
			var num11 = 0;
			for(var i=0;i<datasNum.length;i++){
				
				if(datasNum[i].roomsubclass == "0201"){
				 num1 = datasNum[i].num;
				 console.log(num1);
				}
				
				if(datasNum[i].roomsubclass == "0205"){
					num2 = datasNum[i].num;
					console.log(num2);
				}
				
				if(datasNum[i].roomsubclass == "0412"){
					 num3 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0417"){
					 num4 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0401"){
					 num5 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0204"){
					 num6 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0203"){
					 num7 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0202"){
					 num8 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0416"){
					num9 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0418"){
					num10 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0419"){
					 num11 = datasNum[i].num;
				}
			}
			
			var dataNumSum = parseInt(num1) + parseInt(num2) + parseInt(num3) + parseInt(num4) + parseInt(num5) + parseInt(num6) + parseInt(num7) + parseInt(num8) + parseInt(num9) + parseInt(num10) + parseInt(num11);
             var roomClassNum = datas.room_classify_info;
             var special = 0;
             var shop = 0;
             for(var i=0;i<roomClassNum.length;i++){
                
                if(roomClassNum[i].roomclass == "02"){
                	special = roomClassNum[i].num;
                	
                }
                
                if(roomClassNum[i].roomclass == "04"){
                	shop = roomClassNum[i].num;
                	
                }
             }
             special1 = parseInt(special);
             shop1 = parseInt(shop);
			var statisticsBox = $('#info-t-box');
			statisticsBox.html('');
			var p = '';
			p += '<li class="info-t"><span class="icomoon">&#xe904;</span> 下沙派出所辖区'+remark+'</li>'
			p += '<ul><li>小区数：'+datas.community_number+'</li><li>超期未巡检小区数：'+datas.over_due_community_number+'</li><li>重点关注小区数：'+datas.focus_community_number+'</li></ul>';
			p += '<ul><li>楼宇数：'+datas.building_number+'</li><li>超期未巡检楼宇数：'+datas.over_due_building_number+'</li><li>重点关注楼宇数：'+datas.focus_building_number+'</li></ul>';
			p += '<ul><li>房间总数：'+datas.room_number+'</li><li>空房间数： <a target="_blank" href="informationExcel.html" style="color:blue;">'+datas.empty_room_number+'</a></li><li>超期未巡检房间数：'+datas.over_due_room_number+'</li>'+
			     '<li>重点关注房间数：'+datas.focus_room_number+'</li>';
			     if(dataNumSum == 0){
			     	p += '<li>重点行业:  <a style="color:blue;">'+dataNumSum+'</a></li></ul>';
			     }else{
			     	p += '<li>重点行业:  <a target="_blank" href="alert.html?policeId='+poli_id_my+'"  style="color:blue;">'+dataNumSum+'</a></li></ul>';
			     }
			p += '<ul>';
			if(special == 0){
				p += '<li>特业数： <a style="color:blue;">'+special+'</a><li>';
			}else{
				p += '<li>特业数： <a style="color:blue" target="_blank" href="specialInformation.html?roomclass=02&policeId='+poli_id_my+'">'+special+'</a><li>';
			}
			if(shop == 0){
				p += '<li>商铺数： <a style="color:blue;">'+shop+'</a><li>';
			}else{
				p += '<li>商铺数： <a style="color:blue" target="_blank" href="specialInformation.html?roomclass=04&policeId='+poli_id_my+'">'+shop+'</a><li>';
			}
			p += '<li>学校数：1</li></ul>';
			p += '<ul>';
			if(num2 == 0){
				p += '<li>网吧数： <a style="color:blue">'+num2+'</a></li>'
			}else{
				p += '<li>网吧数:  <a style="color:blue" target="_blank" href="informationFocus.html?roomSubClass=0205&policeId='+poli_id_my+'">'+num2+'</a></li>'
			}
			if(num5 == 0){
				p += '<li>足浴数： <a style="color:blue">'+num5+'</a></li>'
			}else{
				p += '<li>足浴数:  <a style="color:blue" target="_blank" href="informationFocus.html?roomSubClass=0401&policeId='+poli_id_my+'">'+num5+'</a></li>'
			}
			
			p += '</ul>';
			
			p += '<ul>';
			if(datas.focus_drug_unit == 0){
				p += '<li>易制毒单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>易制毒单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=1234&policeId='+poli_id_my+'">'+datas.focus_drug_unit+'</a></li>';
			}
			if(datas.focus_boom_unit == 0){
				p += '<li>易制爆单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>易制爆单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=2134&policeId='+poli_id_my+'">'+datas.focus_boom_unit+'</a></li>';
			}
			if(datas.focus_toxic_unit == 0){
				p += '<li>剧毒单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>剧毒单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=3124&policeId='+poli_id_my+'">'+datas.focus_toxic_unit+'</a></li>';
			}
			if(datas.focus_danger_unit == 0){
				p += '<li>危险源单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>危险源爆单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=4123&policeId='+poli_id_my+'">'+datas.focus_danger_unit+'</a></li>';
			}
			p += '</ul>';
				p += '<ul><li>总人数：'+datas.person_number+'</li>';
			if(datas.focus_person_number == 0){
				p += '<li>重点人数： <a style="color:blue">'+datas.focus_person_number+'</a></li></ul>';
			}else{
				p += '<li>重点人数:  <a target="_blank" href="alertPerson.html?policeId='+poli_id_my+'"  style="color:blue;">'+datas.focus_person_number+'</a></li></ul>';
			}

			statisticsBox.prepend(p);
			
			$('.charts').css({'display':'none'});
			$('.loading').css({'display':'none'});
			commchart2(datas);
			roomchart(datas);
			peoplechart(datas);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
//点击小区时，显示小区统计信息
function getStatisByComm(comm_id_my){
	var commName = $('#commId'+comm_id_my+">:first-child").text();
	$.ajax({
		url:'../community/statistics',
		type:'POST',
		data:{
			comm_id:comm_id_my,
		},
		success:function(data){
		 //console.log(data);
			var datas = eval('('+data+')');
            var datasNum = datas.room_subclassify_info;
            var num1 = 0;
            var num2 = 0;
            var num3 = 0;
            var num4 = 0;
            var num5 = 0;
        	var num6 = 0;
        	var num7 = 0;
        	var num8 = 0;
        	var num9 = 0;
        	var num10 = 0;
        	var num11 = 0;
			for(var i=0;i<datasNum.length;i++){
				
				if(datasNum[i].roomsubclass == "0201"){
				 num1 = datasNum[i].num;
				 console.log(num1);
				}
				
				if(datasNum[i].roomsubclass == "0205"){
					num2 = datasNum[i].num;
					console.log(num2);
				}
				
				if(datasNum[i].roomsubclass == "0412"){
					 num3 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0417"){
					 num4 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0401"){
					 num5 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0204"){
					 num6 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0203"){
					 num7 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0202"){
					 num8 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0416"){
					num9 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0418"){
					num10 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0419"){
					 num11 = datasNum[i].num;
				}
			}
			var dataNumSum = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10 + num11;
             var roomClassNum = datas.room_classify_info;
             var special = 0;
             var shop = 0;
             for(var i=0;i<roomClassNum.length;i++){
                
                if(roomClassNum[i].roomclass == "02"){
                	special = roomClassNum[i].num;
                }
             
                if(roomClassNum[i].roomclass == "04"){
                	shop = roomClassNum[i].num;
                }
             }
			var statisticsBox = $('#info-t-box');
			statisticsBox.html('');
			var p = '';
			p += '<li class="info-t"><span class="icomoon">&#xe904;</span>'+commName+'</li>'
			p += '<ul><li>楼宇数：'+datas.building_number+'</li><li>超期未巡检楼宇数：'+datas.over_due_building_number+'</li><li>重点关注楼宇数：'+datas.focus_building_number+'</li></ul>';
			p += '<ul><li>房间总数：'+datas.room_number+'</li><li>空房间数:<a target="_blank" href="informationExcel.html?commId='+comm_id_my+'" style="color:blue;">'+datas.empty_room_number+'</a></li>'+
			'<li>超期未巡检房间数：'+datas.over_due_room_number+'</li>'+
			'<li>重点关注房间数：'+datas.focus_room_number+'</li>';
			if(dataNumSum == 0){
			 p += '<li>重点行业:  <a style="color:blue;">'+dataNumSum+'</a></li></ul>';
			}else{
				p += '<li>重点行业:  <a target="_blank" href="alert.html?commId='+comm_id_my+'"  style="color:blue;">'+dataNumSum+'</a></li></ul>';
			}
			
				p += '<ul>';
			if(special == 0){
				p += '<li>特业数： <a style="color:blue;">'+special+'</a><li>';
			}else{
				p += '<li>特业数： <a style="color:blue" target="_blank" href="specialInformation.html?roomclass=02&commId='+comm_id_my+'">'+special+'</a><li>';
			}
			if(shop == 0){
				p += '<li>商铺数： <a style="color:blue;">'+shop+'</a><li>';
			}else{
				p += '<li>商铺数： <a style="color:blue" target="_blank" href="specialInformation.html?roomclass=04&commId='+comm_id_my+'">'+shop+'</a><li>';
			}
			p += '<li>学校数：1</li></ul>';
			p += '<ul>';
			if(num2 == 0){
				p += '<li>网吧数： <a style="color:blue">'+num2+'</a></li>'
			}else{
				p += '<li>网吧数:  <a style="color:blue" target="_blank" href="informationFocus.html?roomSubClass=0205&commId='+comm_id_my+'">'+num2+'</a></li>'
			}
			if(num5 == 0){
				p += '<li>足浴数： <a style="color:blue">'+num5+'</a></li>'
			}else{
				p += '<li>足浴数:  <a style="color:blue" target="_blank" href="informationFocus.html?roomSubClass=0401&commId='+comm_id_my+'">'+num5+'</a></li>'
			}
			p += '</ul>';
			p += '<ul>';
			if(datas.focus_drug_unit == 0){
				p += '<li>易制毒单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>易制毒单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=1234&commId='+comm_id_my+'">'+datas.focus_drug_unit+'</a></li>';
			}
			if(datas.focus_boom_unit == 0){
				p += '<li>易制爆单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>易制爆单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=2134&commId='+comm_id_my+'">'+datas.focus_boom_unit+'</a></li>';
			}
			if(datas.focus_toxic_unit == 0){
				p += '<li>剧毒单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>剧毒单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=3124&commId='+comm_id_my+'">'+datas.focus_toxic_unit+'</a></li>';
			}
			if(datas.focus_danger_unit == 0){
				p += '<li>危险源单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>危险源爆单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=4123&commId='+comm_id_my+'">'+datas.focus_danger_unit+'</a></li>';
			}
			p += '</ul>';
		   	p += '<ul><li>总人数：'+datas.person_number+'</li>';
			if(datas.focus_person_number == 0){
				p += '<li>重点人员： <a style="color:blue">'+datas.focus_person_number+'</a></li></ul>';
			}else{
				p += '<li>重点人员:  <a target="_blank" href="alertPerson.html?commId='+comm_id_my+'"  style="color:blue;">'+datas.focus_person_number+'</a></li></ul>';
			}

			statisticsBox.prepend(p);
			$('.charts').css({'display':'none'});
			roomchart(datas);
			peoplechart(datas);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
//点击建筑 获取建筑统计信息
function getStatisBybuild(buil_id_my){
	var builName = $('#building'+buil_id_my+">:first-child").text();
	$.ajax({
		url:'../building/statistics',
		type:'POST',
		data:{
			buil_id:buil_id_my,
		},
		success:function(data){
			var datas = eval('('+data+')');
			var datasNum = datas.room_subclassify_info;
			var num1 = 0;
			var num2 = 0;
			var num3 = 0;
			var num4 = 0;
			var num5 = 0;
			var num6 = 0;
			var num7 = 0;
			var num8 = 0;
			var num9 = 0;
			var num10 = 0;
			var num11 = 0;
			for(var i=0;i<datasNum.length;i++){
				
				if(datasNum[i].roomsubclass == "0201"){
				 num1 = datasNum[i].num;
				 console.log(num1);
				}
				
				if(datasNum[i].roomsubclass == "0205"){
					num2 = datasNum[i].num;
					console.log(num2);
				}
				
				if(datasNum[i].roomsubclass == "0412"){
					 num3 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0417"){
					 num4 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0401"){
					 num5 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0204"){
					 num6 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0203"){
					 num7 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0202"){
					 num8 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0416"){
					num9 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0418"){
					num10 = datasNum[i].num;
				}
				
				if(datasNum[i].roomsubclass == "0419"){
					 num11 = datasNum[i].num;
				}
			}
			var dataNumSum = num1 + num2 + num3 + num4 + num5 + num6 + num7 + num8 + num9 + num10 + num11;
			var roomClassNum = datas.room_classify_info;
			var special = 0;
			   var shop = 0;
             for(var i=0;i<roomClassNum.length;i++){
                
                if(roomClassNum[i].roomclass == "02"){
                	special = roomClassNum[i].num;
                }
             
                if(roomClassNum[i].roomclass == "04"){
                	shop = roomClassNum[i].num;
                }
             }
			//console.log(datas);
			var statisticsBox = $('#info-t-box');
			statisticsBox.html('');
			var p = '';
			p += '<li class="info-t"><span class="icomoon">&#xe904;</span> '+builName+'</li>'
			p += '<ul><li>房间总数：'+datas.room_number+'</li>'+
			'<li>空房间数：<a target="_blank" href="informationExcel.html?builId='+buil_id_my+'" style="color:blue;" >'+datas.empty_room_number+'</a></li>'+
			'<li>超期未巡检房间数：'+datas.over_due_room_number+'</li>'+
			'<li>重点关注房间数：'+datas.focus_room_number+'</li>';
			if(dataNumSum == 0){
				p += '<li>重点行业:  <a style="color:blue;">'+dataNumSum+'</a></li></ul>';
			}else{
				p += '<li>重点行业:  <a target="_blank" href="alert.html?builId='+buil_id_my+'"  style="color:blue;">'+dataNumSum+'</a></li></ul>';
			}
			
				p += '<ul>';
			if(special == 0){
				p += '<li>特业数： <a style="color:blue;">'+special+'</a><li>';
			}else{
				p += '<li>特业数： <a style="color:blue" target="_blank" href="specialInformation.html?roomclass=02&builId='+buil_id_my+'">'+special+'</a><li>';
			}
			if(shop == 0){
				p += '<li>商铺数： <a style="color:blue;">'+shop+'</a><li>';
			}else{
				p += '<li>商铺数： <a style="color:blue" target="_blank" href="specialInformation.html?roomclass=04&builId='+buil_id_my+'">'+shop+'</a><li>';
			}
			p += '<li>学校数：1</li></ul>';
			p += '<ul>';
			if(num2 == 0){
				p += '<li>网吧数： <a style="color:blue">'+num2+'</a></li>'
			}else{
				p += '<li>网吧数:  <a style="color:blue" target="_blank" href="informationFocus.html?roomSubClass=0205&builId='+buil_id_my+'">'+num2+'</a></li>'
			}
			if(num5 == 0){
				p += '<li>足浴数： <a style="color:blue">'+num5+'</a></li>'
			}else{
				p += '<li>足浴数:  <a style="color:blue" target="_blank" href="informationFocus.html?roomSubClass=0401&builId='+buil_id_my+'">'+num5+'</a></li>'
			}
			p += '</ul>';
			p += '<ul>';
			if(datas.focus_drug_unit == 0){
				p += '<li>易制毒单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>易制毒单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=1234&builId='+buil_id_my+'">'+datas.focus_drug_unit+'</a></li>';
			}
			if(datas.focus_boom_unit == 0){
				p += '<li>易制爆单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>易制爆单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=2134&builId='+buil_id_my+'">'+datas.focus_boom_unit+'</a></li>';
			}
			if(datas.focus_toxic_unit == 0){
				p += '<li>剧毒单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>剧毒单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=3124&builId='+buil_id_my+'">'+datas.focus_toxic_unit+'</a></li>';
			}
			if(datas.focus_danger_unit == 0){
				p += '<li>危险源单位数:  <a style="color:blue">0</a></li>';
			}else{
				p += '<li>危险源爆单位数:  <a style="color:blue" target="_blank" href="drugInformation.html?type=4123&builId='+buil_id_my+'">'+datas.focus_danger_unit+'</a></li>';
			}
			p += '</ul>';
			p += '<ul><li>总人数：'+datas.person_number+'</li>';
			if(datas.focus_person_number == 0){
				p += '<li>重点人员：<a style="color:blue">'+datas.focus_person_number+'</a></li></ul>';
			}else{
				p += '<li>重点人员:<a target="_blank" href="alertPerson.html?builId='+buil_id_my+'"  style="color:blue;">'+datas.focus_person_number+'</a></li></ul>';
			}
			

			statisticsBox.prepend(p);
			$('.charts').css({'display':'none'});
			roomchart(datas);
			peoplechart(datas);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
//所长
function commchart(datas){
	//console.log(datas);
	var chart_data_comm = [];
	chart_data_comm.push({value:datas.indebuilding,name:'独立建筑'},
						{value:datas.building_number-datas.indebuilding,name:'小区建筑'});

	$('#chart1').css({display: 'block'});

	creatCharts('chart1',chart_data_comm,'楼宇/建筑统计:');
}
//一般警员
function commchart2(datas){
	//console.log(datas);
	var chart_data_comm = [];
	chart_data_comm.push({value:datas.indebuliding_number,name:'独立建筑'},
						{value:datas.building_number-datas.indebuliding_number,name:'小区建筑'});

	$('#chart1').css({display: 'block'});

	creatCharts('chart1',chart_data_comm,'楼宇/建筑统计:');
}

//统计信息---所长登录时加载全部统计信息
function getStatisByStat(stat_id_my){
	$.ajax({
		url:'../police_station/jurisdiction/statistics',
		type:'POST',
		data:{
			poli_station_id:stat_id_my,
		},
		success:function(data){
			var datas = eval('('+data+')');
			// console.log(datas);
			var statisticsBox = $('#info-t-box');
			statisticsBox.html('');
			var p = '';
			p += '<li class="info-t"><span class="icomoon">&#xe904;</span> 派出所辖区</li>'
			p += '<ul><li>警员数：'+datas.police_number+'</li></ul>'
			p += '<ul><li>小区数：'+datas.community_number+'</li><li>超期未巡检小区数：'+datas.over_due_community_number+'</li><li>重点关注小区数：'+datas.focus_community_number+'</li></ul>';
			p += '<ul><li>楼宇数：'+datas.building_number+'</li><li>超期未巡检楼宇数：'+datas.over_due_building_number+'</li><li>重点关注楼宇数：'+datas.focus_building_number+'</li></ul>';
			p += '<ul><li>房间总数：'+datas.room_number+'</li><li>空房间数：'+datas.empty_room_number+'</li><li>超期未巡检房间数：'+datas.over_due_room_number+'</li><li>重点关注房间数：'+datas.focus_room_number+'</li></ul>';
			p += '<ul><li>总人数：'+datas.person_number+'</li><li>重点人数：'+datas.focus_person_number+'</li></ul>';

			statisticsBox.prepend(p);

			$('.charts').css({'display':'none'});
			commchart(datas);
			roomchart(datas);
			peoplechart(datas);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
//房间分类统计
function roomchart(datas){
	var chart_data_room = [];
	for (var i = 0; i < datas.room_classify_info.length; i++) {
		if(datas.room_classify_info[i].roomclass==01){
			chart_data_room.push({value:datas.room_classify_info[i].num, name:'住宅'}) ;	
		}else if(datas.room_classify_info[i].roomclass==02){
			chart_data_room.push({value:datas.room_classify_info[i].num, name:'特业'});
		}else if(datas.room_classify_info[i].roomclass==03){
			chart_data_room.push({value:datas.room_classify_info[i].num, name:'学校'});
		}else if(datas.room_classify_info[i].roomclass==04){
			chart_data_room.push({value:datas.room_classify_info[i].num, name:'商铺'});
		}else if(datas.room_classify_info[i].roomclass==05){
			chart_data_room.push({value:datas.room_classify_info[i].num, name:'其他'});
		}else if(datas.room_classify_info[i].roomclass==06){
			chart_data_room.push({value:datas.room_classify_info[i].num, name:'重点关注'});
		}else{
			//alert('数据有误！');
		}
		
	}
	$('#chart2').css({display: 'block'});

	creatCharts('chart2',chart_data_room,'房间分类统计:');
}
//人员居住原因统计
function peoplechart(datas){
	var chart_data_people = [];
	for (var i = 0; i < datas.person_classify_info.length; i++) {
		if (datas.person_classify_info[i].why==01) {
			chart_data_people.push({value:datas.person_classify_info[i].num, name:'自住'});
		}else if (datas.person_classify_info[i].why==02) {
			chart_data_people.push({value:datas.person_classify_info[i].num, name:'租住'});
		}else if (datas.person_classify_info[i].why==03){
			chart_data_people.push({value:datas.person_classify_info[i].num, name:'工作'});
		}else{
			//alert('数据有误！');
		}
	}
	$('#chart3').css({display: 'block'});

	creatCharts('chart3',chart_data_people,'人员居住原因统计:');
}

// 面包屑导航 --->建筑
function breadBuild(name){
	var breadcrumb1 = $("#breadcrumb1");
	var root2 = $("#root2");
	root2.nextAll().remove();
	var root3 = '<li id="root3" >' + name + '</li>';
	breadcrumb1.append(root3);
}
//独立建筑面包屑导航
function breadBuild1(name){
	var breadcrumb1 = $("#breadcrumb1");
	var root1 = $("#root1");
	root1.nextAll().remove();
	var root3 = '<li id="root3" >' + name + '</li>';
	breadcrumb1.append(root3);
}
// 获取小区的名字
function getCommNameOnBread(comm_id_my){
    $.ajax({
        url: '../community/comm_id',
        type: 'POST',
        data: {
            comm_id: comm_id_my,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');
            // console.log(datas.community.commName,i);
            $('#breadcrumb1').prepend('<li id="root2" value="'+datas.community.commId+'">'+datas.community.commName+'</li>');
            if($('#station > a').html()){
            	$('#breadcrumb1').prepend('<li id="root1">'+$('#station > a').html()+'</li>');
            }
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}
// 获取建筑的名字
function getBuildNameOnBread(buil_id_my){
    $.ajax({
        url: '../building/buil_id',
        type: 'POST',
        data: {
            buil_id: buil_id_my,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');
            $('#breadcrumb1').html('')
            $('#breadcrumb1').prepend('<li id="root3">'+datas.building.builName+'</li>');
            if(datas.building.commId){
            	getCommNameOnBread(datas.building.commId);
            }else{
            	//单独建筑需另外特殊处理
            	if($('#station > a').html()){
            	$('#breadcrumb1').prepend('<li id="root1">'+$('#station > a').html()+'</li>');
            }
            }
            
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}
//点击建筑获取单元信息
function getUnit(buil_id_my){
	buildInfoHid();
	$.ajax({
		url:'../building/unit',
		type:'POST',
		data:{
			buil_id:buil_id_my,
		},
		success:function(data){
			// console.log(data);
			var datas = eval('('+data+')');

			var tabbox = $('#myTab');
			tabbox.html('');
			if(datas.unit.length&&datas.unit.length<4){
				var p = '<li class="active"><a class="tab-d" onclick="hideRoomInfo();getfloor('+buil_id_my+','+datas.unit[0]+');" href="javascript:void(0)" data-toggle="tab">' + datas.unit[0] + '单元</a></li>';
			    for (var i = 1; i < datas.unit.length; i++) {
			        p += '<li><a class="tab-d" onclick="hideRoomInfo();getfloor('+buil_id_my+','+datas.unit[i]+');" href="javascript:void(0)" data-toggle="tab">' + datas.unit[i] + '单元</a></li>';

		    	}

		    	tabbox.prepend(p);
		    	getfloor(buil_id_my,datas.unit[0]);

		    	// 路径导航---建筑
		    	getBuildNameOnBread(buil_id_my);
//单元数超过4个其余为下拉菜单
			}else if(datas.unit.length&&datas.unit.length>3){
				var p = '<li class="active"><a class="tab-d" onclick="hideRoomInfo();getfloor('+buil_id_my+','+datas.unit[0]+');" href="javascript:void(0)" data-toggle="tab">' + datas.unit[0] + '单元</a></li>';
			    for (var i = 1; i < 4; i++) {
			        p += '<li><a class="tab-d" onclick="hideRoomInfo();getfloor('+buil_id_my+','+datas.unit[i]+');" href="javascript:void(0)" data-toggle="tab">' + datas.unit[i] + '单元</a></li>';

		    	}

		    	p += '<li class="dropdown"><a class="tab-d" id="dLabel" href="javascript:void(0)" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他</a>';

  				p += '<ul class="dropdown-menu" aria-labelledby="dLabel">';
  				for (var j = 4; j < datas.unit.length; j++) {
  					p += '<li><a class="tab-d" onclick="hideRoomInfo();getfloor('+buil_id_my+','+datas.unit[j]+');" href="javascript:void(0)" data-toggle="tab">' + datas.unit[j] + '单元</a></li>'
  				}
  				p += '</ul></li>';

  				$('.dropdown-toggle').dropdown();

		    	tabbox.prepend(p);
		    	getfloor(buil_id_my,datas.unit[0]);

		    	// 路径导航---建筑
		    	getBuildNameOnBread(buil_id_my);

			}else{
				//没有单元信息时标头也应该改变
				getBuildNameOnBread(buil_id_my);
				tabbox.prepend('没有单元信息');
			}
		    
		    
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
// 根据建筑和单元 获取楼层信息
function getfloor(builId,unit){
	$.ajax({
		url:'../building/unit/floor',
		type:'POST',
		data:{
			buil_id:builId,
			unit_num:unit,
		},
		success:function(data){
			// console.log(data);
			var datas = eval('('+data+')');
			var floor_change = $('#floor-change');
			floor_change.html('');
			var p = '';
			p += '<li class="previous"><a id="lastfl" href="javascript:void(0)"><img src="images/lastfloor.png" alt="上"></a></li>';
			p += '<li class="floor-num"><span class="orange-2">第</span>&nbsp;&nbsp;<input class="floor-input" type="text" class="form-control input-sm" id="floor-num" >&nbsp;&nbsp;<span class="orange-2">层</span>';
			p += '&nbsp;&nbsp;<a id="fl-go" class="btn btn-xs" href="javascript:void(0)"><img class="btn-go" src="images/btn-go.png" style="width:20px;height:20px;line-height:20px;margin-bottom:5px;" alt="跳转"></a><span class="maxfloor orange-2">（共'+datas.floor[datas.floor.length-1]+'层）</span></li>';
			p += '<li class="next"><a id="nextfl" href="javascript:void(0)"><img src="images/nextfloor.png" alt="下"></a></li>';

			floor_change.prepend(p);
			$('#floor-num').val(datas.floor[0]);
			getroom(builId,unit,datas.floor[0]);

			$("#lastfl").bind("click", function(){
				lastFloor(builId,unit,datas);
			});
			$("#fl-go").bind("click", function(){
				gotoFloor(builId,unit,datas);
			});
			$("#nextfl").bind("click", function(){
				nextFloor(builId,unit,datas);
			});
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}

//点击单元 获取楼层及房间信息
function getroom(builId,unit_num,floor_num){
	$.ajax({
		url:'../building/unit/floor/room',
		type:'POST',
		data:{
			buil_id:builId,
			unit_num:unit_num,
			floor_num:floor_num,
		},
		success:function(data){
		// console.log(data);
		storage.setItem('room-info',data);
		var datas = eval('('+data+')');
		var roombox = $('#roombox');
		var q = '';
		roombox.html('');

		for (var i = 0; i < datas.room.length; i++) {
			// 有人 未超期 关注
        	if(datas.room[i].roomStatis.personNum>0 &&!(datas.room[i].roomStatis.isOverDue) && datas.room[i].isFocus){
            	q += '<button id="r'+datas.room[i].roomId+'" onclick="showRoomInfo('+datas.room[i].roomId+');getPersonInfo('+datas.room[i].roomId+');houseShow();" type="button" class="btn-h col-lg-2 col-md-2 col-xs-2 col-sm-2 btn btn-danger">'+datas.room[i].roomStatis.personNum+'<span class="badge-my badge-danger">'+datas.room[i].roomNo+'</span></button>';
			}
			//有人 未超期 不关注
			else if(datas.room[i].roomStatis.personNum>0 &&!(datas.room[i].roomStatis.isOverDue) && !(datas.room[i].isFocus)){

            	q += '<button id="r'+datas.room[i].roomId+'" onclick="showRoomInfo('+datas.room[i].roomId+');getPersonInfo('+datas.room[i].roomId+');houseShow();" type="button" class="btn-h col-lg-2 col-md-2 col-xs-2 col-sm-2 btn btn-success">'+datas.room[i].roomStatis.personNum+'<span class="badge-my badge-success">'+datas.room[i].roomNo+'</span><img src="" class="room-icon" /></button>';
			}
	        //有人 超期 关注
	        else if(datas.room[i].roomStatis.personNum>0 &&datas.room[i].roomStatis.isOverDue && datas.room[i].isFocus){
	            q += '<button id="r'+datas.room[i].roomId+'" onclick="showRoomInfo('+datas.room[i].roomId+');getPersonInfo('+datas.room[i].roomId+');houseShow();" type="button" class="btn-h col-lg-2 col-md-2 col-xs-2 col-sm-2 btn btn-danger">'+datas.room[i].roomStatis.personNum+'<span class="badge-my">'+datas.room[i].roomNo+'</span><img src="" class="room-icon" /></button>';
			}
	        //有人 超期 不关注
	        else if(datas.room[i].roomStatis.personNum>0 &&datas.room[i].roomStatis.isOverDue && !(datas.room[i].isFocus)){
				q += '<button id="r'+datas.room[i].roomId+'" onclick="showRoomInfo('+datas.room[i].roomId+');getPersonInfo('+datas.room[i].roomId+');houseShow();" type="button" class="btn-h col-lg-2 col-md-2 col-xs-2 col-sm-2 btn btn-success">'+datas.room[i].roomStatis.personNum+'<span class="badge-my">'+datas.room[i].roomNo+'</span><img src="" class="room-icon" /></button>';
	        }
	        // 没人
	        else if(datas.room[i].roomStatis.personNum==0){
				q += '<button id="r'+datas.room[i].roomId+'" onclick="showRoomInfo('+datas.room[i].roomId+');getPersonInfo('+datas.room[i].roomId+');houseShow();" type="button" class="btn-h col-lg-2 col-md-2 col-xs-2 col-sm-2 btn btn-default">'+datas.room[i].roomStatis.personNum+'<span class="badge-my badge-success">'+datas.room[i].roomNo+'</span><img src="" class="room-icon" /></button>';
			}else{}
				
		}
		
		q += '</p>';

    	roombox.prepend(q);

    	//房间分类
		for (var j = 0; j < datas.room.length; j++){
			if(datas.room[j].roomClass == 01){
				// console.log("011111",datas.room[j].roomsubClass);
				$("#r"+datas.room[j].roomId).find("img").attr("src","images/r01.png");
			}else if(datas.room[j].roomClass == 02){
				$("#r"+datas.room[j].roomId).find("img").attr("src","images/r02.png");
			}else if(datas.room[j].roomClass == 03){
				$("#r"+datas.room[j].roomId).find("img").attr("src","images/r03.png");
			}else if(datas.room[j].roomClass == 04){
				$("#r"+datas.room[j].roomId).find("img").attr("src","images/r04.png");
			}else if(datas.room[j].roomClass == 05){
				$("#r"+datas.room[j].roomId).find("img").attr("src","images/r05.png");
			}else if(datas.room[j].roomClass == 06){
				$("#r"+datas.room[j].roomId).find("img").attr("src","images/r06.png");
			}else{

			}
		}
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
function houseShow(){
	$('#house-info').css({"display":"block"});
	$('.people-info').css({"display":"block"});
}

// 切换到下一层

function floorindatasA(flnow,datas){
	for(var i = 0;i<datas.floor.length;i++){
		if(flnow==datas.floor[i]){
			return i;
		}
		else if(flnow<datas.floor[i]){
			return i;
		}
	}
}
// 切换到上一层
function floorindatasR(flnow,datas){
	for(var i = datas.floor.length-1;i>=0;i--){
		if(flnow==datas.floor[i]){
			return i;
		}
		else if(flnow>datas.floor[i]){
			return i;
		}
	}
}

function lastFloor(builId,unit,datas){
	var flnow_my = $('#floor-num').val();
	var i = 0;
	flnow_my--;
	if(datas.floor[0]<=flnow_my){
		i = floorindatasR(flnow_my,datas);

		$('#floor-num').val(datas.floor[i]);

		getroom(builId,unit,datas.floor[i]);
		
	}else{
		alert("楼层不存在！");
	}
}
// 切换到下一层
function nextFloor(builId,unit,datas){
	var flnow_my = $('#floor-num').val();
	var i = 0;
	flnow_my++;
	if(datas.floor[datas.floor.length-1]>=flnow_my){
		//console.log(flnow_my);
		i = floorindatasA(flnow_my,datas);
		//console.log(i);
		$('#floor-num').val(datas.floor[i]);

		getroom(builId,unit,datas.floor[i]);
		
	}else{
		alert("楼层不存在！");
	}
}
// 切换到指定楼层
function gotoFloor(builId,unit,datas){
	var flnow_my = $('#floor-num').val();
	var i = 0;
	if(datas.floor[datas.floor.length-1]>=flnow_my&&datas.floor[0]<=flnow_my){

		i = floorindatasA(flnow_my,datas);

		$('#floor-num').val(datas.floor[i]);

		getroom(builId,unit,datas.floor[i]);
		
	}else{
		alert("楼层不存在！");
	}
}
// 点击单元隐藏房间和人员信息
function hideRoomInfo(){
	$('#house-info').css({'display': 'none'});
	$('.people-info').css({'display': 'none'});
}
//房间信息展示
function showRoomInfo(room_id_my){
	$.ajax({
        url:'../room/id',
        type:'POST',
        data:{
            room_id:room_id_my,
        },
        success:function(data){
	         console.log(data);
	        var datas = eval('('+data+')');
	        console.log(room_id_my);
	        console.log(roomSubclass);
	        console.log(roomsubclass);
	        var roomsubclass = '',
			    roomSubclass = '',
			idFocus = '';
			if($('#root1').html()){
				var statName = $('#root1').html();
			}else{
				var statName = '';
			}
			
			if($('#root2').html()){
				var unitName = $('#root2').html();
			}else{
				var unitName = '';
			}
			if($('#root3').html()){
				var buildName = $('#root3').html();
			}else{
				var buildName = '当前房间';
			}
			
			// console.log(datas);
			$('#house-info-c-b').html(statName+'&nbsp;'+unitName+'&nbsp;'+buildName);
			if(datas.room.ramark){
				$('#remark').html('房间名：'+datas.room.ramark);
			}else{
				$('#remark').html('');
			}
			$('#house-info-u').html(datas.room.roomUnit);
			$('#house-info-f').html(datas.room.roomFloor);
			$('#house-info-n').html(datas.room.roomNo);
			//添加人员
			var peopleAdd = $("#peopleAdd");
			peopleAdd.unbind("click").bind("click",function(){
				showTime(datas.room.roomId,datas.room.roomNo);
				formClear();
				// console.log(datas.room.roomNo);
				
			});
			//自动巡检事件
			
			var autoInspection = $("#autoInspection");
			var dataPolices = JSON.parse(storage.getItem('police-info'));
			var policeId = dataPolices.police.poliId;
			var roomId = datas.room.roomId;
			autoInspection.unbind("click").bind("click",function(){
				autoInspection11(policeId,roomId);
			});
			
			// 手动巡检事件
			
			var manualInspection = $("#manualInspection");
			manualInspection.unbind("click").bind("click",function(){
				//console.log(policeId,roomId);
				showTime1(policeId,roomId);
			});
			//修改房间信息事件
			var roomEditInformation = $('#roomEditInformation');
			    roomEditInformation.unbind('click').bind("click",function(){
			    	showRoomInformation(roomId);
			    })
			
			if(datas.room.roomClass==01){
				roomsubclass = '住宅';
				if (datas.room.roomSubclass=="0101") {
					roomSubclass = '自住住宅';
				}else if (datas.room.roomSubclass=="0102") {
					roomSubclass = '出租住宅';
				}else{
					roomSubclass = '未知';
				} 
			}else if(datas.room.roomClass==02){
				roomsubclass = '特业';
				if (datas.room.roomSubclass=="0201") {
					roomSubclass = '旅馆';
				}else if (datas.room.roomSubclass=="0202") {
					roomSubclass = '废旧金属回收';
				}else if (datas.room.roomSubclass=="0203") {
					roomSubclass = '刻字刻章';
				}else if (datas.room.roomSubclass=="0204") {
					roomSubclass = '典当';
				}else if (datas.room.roomSubclass=="0205") {
					roomSubclass = '网吧';
				}else{
					roomSubclass = '未知';
				}
			}else if(datas.room.roomClass==03){
				roomsubclass = '学校';
				if (datas.room.roomSubclass=="0301") {
					roomSubclass = '幼儿园';
				}else if (datas.room.roomSubclass=="0302") {
					roomSubclass = '中小学';
				}else if (datas.room.roomSubclass=="0303") {
					roomSubclass = '学生宿舍';
				}else{
					roomSubclass = '未知';
				} 
			}else if(datas.room.roomClass==04){
				roomsubclass = '商铺';
				if (datas.room.roomSubclass=="0401") {
					roomSubclass = '足浴';
				}else if (datas.room.roomSubclass=="0402") {
					roomSubclass = '棋牌';
				}else if (datas.room.roomSubclass=="0403") {
					roomSubclass = 'KTV';
				}else if (datas.room.roomSubclass=="0404") {
					roomSubclass = '网吧';
				}else if (datas.room.roomSubclass=="0405") {
					roomSubclass = '餐饮';
				}else if (datas.room.roomSubclass=="0406") {
					roomSubclass = '药店（医院）';
				}else if (datas.room.roomSubclass=="0407") {
					roomSubclass = '水果店';
				}else if (datas.room.roomSubclass=="0408") {
					roomSubclass = '超市';
				}else if (datas.room.roomSubclass=="0409") {
					roomSubclass = '通讯器材';
				}else if (datas.room.roomSubclass=="0410") {
					roomSubclass = '理发店';
				}else if (datas.room.roomSubclass=="0411") {
					roomSubclass = '福利彩票';
				}else if (datas.room.roomSubclass=="0412") {
					roomSubclass = '寄递';
				}else if (datas.room.roomSubclass=="0413") {
					roomSubclass = '摄影';
				}else if (datas.room.roomSubclass=="0414") {
					roomSubclass = '洗衣店';
				}else if (datas.room.roomSubclass=="0415") {
					roomSubclass = '修车店';
				}else if (datas.room.roomSubclass=="0416") {
					roomSubclass = '图文店';
				}else if (datas.room.roomSubclass=="0417") {
					roomSubclass = '浴场';
				}else if (datas.room.roomSubclass=="0418") {
					roomSubclass = '加油站';
				}else if (datas.room.roomSubclass=="0419") {
					roomSubclass = '五金店';
				}else{
					roomSubclass = '未知';
				} 
			}else if(datas.room.roomClass==05){
				roomsubclass = '其他';
				if (datas.room.roomSubclass=="0501") {
					roomSubclass = '农贸市场';
				}else if (datas.room.roomSubclass=="0502") {
					roomSubclass = '基督教堂';
				}else if (datas.room.roomSubclass=="0503") {
					roomSubclass = '其他';
				}else{
					roomSubclass = '未知';
				} 
			}else if(datas.room.roomClass==06){
				    roomsubclass = '重点关注';
					roomSubclass = '未知';
				 
			}else{
				roomsubclass = '未知';
			}

			$('#house-info-cl').html(roomsubclass);
			$('#house-info-scl').html(roomSubclass);
			$('#due-num').html(datas.room.countInspect);
			$('#due-time').html(datas.room.timeLastinspect.substr(0,10));

			var checkInfoLa = '<a href="javascript:void(0)"data-toggle="modal" data-target="#check-info" onclick="showCheckInfo('+'\''+datas.room.recLastinspect+'\''+')">点击查看</a>';
			if(datas.room.recLastinspect){
				$('#due-last').html(checkInfoLa);
			}else{
				$('#due-last').html(checkInfoLa);
			}
			
			if (datas.room.isFocus==true) {
				isFocus = '是';
			} else {
				isFocus = '否';
			}
			$('#house-focus').html(isFocus);

        },
        error:function(err){
            alert('发生了错误：'+err.status);
            console.table(err);
        }
    });
	
	
}
//房间上一次巡检记录
function showCheckInfo(datas){
    if(datas&&datas!='undefined'){
        $('#check-i').html(datas);
    }else{
        $('#check-i').html('记录为空！（自动巡检）');
    }
    
}
function getStaticFileURLPrefix() {
    return "../static/";
}
function getPersonInfo(room_id){
	$.ajax({
		url:'../room/person',
		type:'POST',
		data:{
			room_id:room_id,
		},
		success:function(data){
			// console.log(data);
			var datas = eval('('+data+')');
			var peoplebox = $('#people-info');
			peoplebox.html('');
          
			
		    var p = '';
		    for (var i = 0; i < datas.length; i++) {
		    	
		    	
		    	p += '<div class="media people-info-sub">';
		    	if(datas[i].persPhoto){
		    		p += '<a class="pull-left" href="javascript:void(0)"><img class="media-object" src="'+getStaticFileURLPrefix()+datas[i].persPhoto+'" alt="照片"></a>';
		    	}else{
		    		p += '<a class="pull-left" href="javascript:void(0)"><img class="media-object" src="images/user-def.jpg" alt="照片"></a>';

		    	}
		        p += '<div class="media-body">';

		        if(datas[i].persName.length<6){
		        	p += '<span class="col-lg-3 col-md-3 col-xs-3 col-sm-3 name blue">'+datas[i].persName+'</span>';	
		        }else{
		        	p += '<span class="col-lg-5 col-md-5 col-xs-5 col-sm-5 name blue">'+datas[i].persName+'</span>';
		        }

		        if(datas[i].persSex){
		        	p += '<span class="col-lg-1 col-md-1 col-xs-1 col-sm-1 sex blue">男</span>'
		        }else{
		        	p += '<span class="col-lg-1 col-md-1 col-xs-1 col-sm-1 sex blue">女</span>'
		        }
		        if(datas[i].persName.length<6){
		        	p += '<span class="col-lg-8 col-md-8 col-xs-8 col-sm-8 id-num">'+datas[i].persIdcard+'</span>';		        	
		        }else{
		        	p += '<span class="col-lg-6 col-md-6 col-xs-6 col-sm-6 id-num">'+datas[i].persIdcard+'</span>';

		        }
		        p += '<span class="col-lg-2 col-md-2 col-xs-2 col-sm-2 h"><img src="images/phone.png" alt=""></span>';
		        p += '<span class="col-lg-6 col-md-6 col-xs-6 col-sm-6 tel num h orange">'+datas[i].persPhone+'</span>';
		        if (datas[i].isFocus){
		        	p += '<span class="text-right col-lg-4 col-md-4 col-xs-4 col-sm-4 red h">重点关注</span>';
		        } else {
		        	p += '<span class="text-right col-lg-4 col-md-4 col-xs-4 col-sm-4 green h">非重点关注</span>';
		        }

		        if(datas[i].timeRegister){
		        	p += '<span class="col-lg-7 col-md-7 col-xs-7 col-sm-7 time gray">登记时间：'+datas[i].timeRegister.substr(0,10)+'</span>';
		        }else{
		        	p += '<span class="col-lg-7 col-md-7 col-xs-7 col-sm-7 time gray">登记时间：未知</span>';
		        }
		        
		        if (datas.whyRegister==01) {
		        	p += '<span class="col-lg-2 col-md-2 col-xs-2 col-sm-2 ident blue">自住</span>';
		        } else if (datas.whyRegister==02){
		        	p += '<span class="col-lg-2 col-md-2 col-xs-2 col-sm-2 ident blue">租住</span>';
		        }else{
		        	p += '<span class="col-lg-2 col-md-2 col-xs-2 col-sm-2 ident blue">工作</span>';
		        }
		        ///
		        //
		        //跳转页面的同时绑定info.html
		        var root2 = $("#house-info-n").text();
		        p += '<a  href="people_info.html?persId='+datas[i].persId+'&room='+root2+'"  target="_blank" class=" btn btn-xs btn-info col-lg-3 col-md-3 col-xs-3 col-sm-3">详情</a>';

		        p += '</div></div>'
		    }

		    peoplebox.prepend(p);
		    
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}


//根据房间分类/子类返回建筑列表
function getBuildByroomClass(roomClass,roomSubclass,comm_id){
	var datas = JSON.parse(storage.getItem('police-info'));
	var poli_id_my = datas.police.poliId;
	$.ajax({
		url: '../building/roomClass',
		type: 'post',
		dataType:'json',
		data: {
			poli_id: poli_id_my,
			comm_id: comm_id,
			roomClass: roomClass,
			roomsubClass: roomSubclass,
		},
		success:function(data){
			// console.log(data);
			deleteAll();
			if(data['01']){
				createBuidingTypeOne(data['01']);
			}
			if(data['02']){
				createBuidingTypeTwo(data['02']);
			}
			if(data['03']){
				createBuidingTypeThree(data['03']);
			}
			if(data['04']){
				createBuidingTypeFour(data['04']);
			}
			if(data['05']){
				createBuidingTypeFive(data['05']);
			}
			if(data['06']){
				createBuidingTypeSix(data['06']);
			}
			
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
	
}
//移除地图上的标记
function removeBuildByroomClass(roomClass,roomSubclass){
	var datas = JSON.parse(storage.getItem('police-info'));
	var poli_id_my = datas.police.poliId;
	$.ajax({
		url: '../building/roomClass',
		type: 'post',
		dataType:'json',
		data: {
			poli_id: poli_id_my,
			roomClass:roomClass,
			roomsubClass:roomSubclass,
		},
		success:function(data){
			// console.log(data);
			if(roomClass==01){
				deleteMarkers(data['01']);
			}else if(roomClass==02){
				deleteMarkers(data['02']);
			}else if(roomClass==03){
				deleteMarkers(data['03']);
			}else if(roomClass==04){
				deleteMarkers(data['04']);
			}else if(roomClass==05){
				deleteMarkers(data['05']);
			}else if(roomClass==06){
				deleteMarkers(data['06']);
			}else{
				console.log('子分类还没完成！')
			}
			
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
	
}
//根据房间分类/子类返回建筑列表
function getBuildByroomsubClass(roomsubClass,roomSubclass,comm_id){
	var datas = JSON.parse(storage.getItem('police-info'));
	var poli_id_my = datas.police.poliId;
	$.ajax({
		url: '../building/roomsubClass',
		type: 'post',
		dataType:'json',
		data: {
			poli_id: poli_id_my,
			comm_id: comm_id,
			roomsubClass: roomsubClass,
			roomsubClass: roomSubclass,
		},
		success:function(data){
			// console.log(data);
			deleteAll();
			if(data['01']){
				createBuidingTypeOne(data['01']);
			}
			if(data['02']){
				createBuidingTypeTwo(data['02']);
			}
			if(data['03']){
				createBuidingTypeThree(data['03']);
			}
			if(data['04']){
				createBuidingTypeFour(data['04']);
			}
			if(data['05']){
				createBuidingTypeFive(data['05']);
			}
			if(data['06']){
				createBuidingTypeSix(data['06']);
			}
			
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
	
}
//移除地图上的标记
function removeBuildByroomsubClass(roomsubClass,roomSubclass){
	var datas = JSON.parse(storage.getItem('police-info'));
	var poli_id_my = datas.police.poliId;
	$.ajax({
		url: '../building/roomsubClass',
		type: 'post',
		dataType:'json',
		data: {
			poli_id: poli_id_my,
			roomsubClass:roomsubClass,
			roomsubClass:roomSubclass,
		},
		success:function(data){
			// console.log(data);
			if(roomsubClass==01){
				deleteMarkers(data['01']);
			}else if(roomsubClass==02){
				deleteMarkers(data['02']);
			}else if(roomsubClass==03){
				deleteMarkers(data['03']);
			}else if(roomsubClass==04){
				deleteMarkers(data['04']);
			}else if(roomsubClass==05){
				deleteMarkers(data['05']);
			}else if(roomsubClass==06){
				deleteMarkers(data['06']);
			}else{
				console.log('子分类还没完成！')
			}
			
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
	
}
// 超期未巡检
function getOverDueBuild(){
	var datas = JSON.parse(storage.getItem('police-info'));
	// console.log(datas);
	$.ajax({
		url: '../building/OverDate',
		type: 'post',
		dataType: 'json',
		data: {
			poli_id: datas.police.poliId,
		},
		success:function(data){
			// console.log(data);
			if($('.outdate').val()){
				createOverDueBuilds(data.building);
				$('.outdate').val(0);
			}else{
				deleteMarkers(data.building);
				$('.outdate').val(1);
			}
			

		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
// 取出所有的建筑
function getAllBuild(poli_id_my){
	$.ajax({
		url: '../building/roomsubClass',
		type: 'post',
		dataType:'json',
		data: {
			poli_id: poli_id_my,
			roomsubClass: '010203040506'
		},
		success:function(data){
			console.log(data);
			if(data['01']){
				createOverDueBuilds(data['01']);
			}else if(data['02']){
				createOverDueBuilds(data['02']);
			}else if(data['03']){
				createOverDueBuilds(data['03']);
			}else if(data['04']){
				createOverDueBuilds(data['04']);
			}else if(data['05']){
				createOverDueBuilds(data['05']);
			}else if(data['06']){
				createOverDueBuilds(data['06']);
			}
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
	
}

function showBuilByCommId(comm_id_my){
	$.ajax({
		url:'../community/building',
		type:'POST',
		data:{
			comm_id:comm_id_my,
		},
		success:function(data){
			var datas = eval('('+data+')');
			
			
			createAreaBuildNames(datas.building);
			
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});	
}