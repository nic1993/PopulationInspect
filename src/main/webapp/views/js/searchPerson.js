//网页加载完毕显示出警员管辖范围内所有小区名字
function community01(policeId){

	  $.ajax({
		url: '../police/jurisdiction',
		type: 'POST',
		data: {
			poli_id: policeId,
		},
		success:function(data){
				var communityName = $("#communityName");
					communityName.html('');
				var loneBuilding = $("#loneBuilding");
					loneBuilding.html('');
			//console.log(data);
			var datas = eval('('+data+')');
			var p = '<option  class="selected" value="community" selected >请选择小区...</option>';
			var p1 = '<option value="lone" selected >请选择独立建筑...</option>';
			for(var  i=0;i<datas.community.length;i++){
				  p += '<option value="'+datas.community[i].commId+'">' + datas.community[i].commName + '</option>';
			}
			for(var j=0;j<datas.building.length;j++){
				p1 += '<option value="'+datas.building[j].builId+'">' + datas.building[j].builName+ '</option>';
			}
			communityName.append(p);
			loneBuilding.append(p1);
		},
		error:function(err){
		alert('发生了错误：'+err.status);
		console.table(err);
		}
	});

}
function community02(statId){

	  $.ajax({
		url: '../police_station/jurisdiction',
		type: 'POST',
		data: {
			poli_station_id: statId,
		},
		success:function(data){
				var communityName = $("#communityName");
					communityName.html('');
				var loneBuilding = $("#loneBuilding");
					loneBuilding.html('');
			//console.log(data);
			var datas = eval('('+data+')');
			var p = '<option  class="selected" value="community" selected >请选择小区...</option>';
			var p1 = '<option value="lone" selected >请选择独立建筑...</option>';
			for(var  i=0;i<datas.community.length;i++){
				  p += '<option value="'+datas.community[i].commId+'">' + datas.community[i].commName + '</option>';
			}
			for(var j=0;j<datas.building.length;j++){
				p1 += '<option value="'+datas.building[j].builId+'">' + datas.building[j].builName+ '</option>';
			}
			communityName.append(p);
			loneBuilding.append(p1);
		},
		error:function(err){
		alert('发生了错误：'+err.status);
		console.table(err);
		}
	});

}
//根据小区获取建筑名称
function getCommunity1(commId){
	$.ajax({
		url: '../community/building',
		type: 'POST',
		data: {
			comm_id: commId,
		},
		success:function(data){
			var buildingName = $("#buildingName");
				buildingName.html('');
			// console.log(data);
			var datas = eval('('+data+')');
			var p = '<option  class="selected" value="building" selected >请选择楼宇...</option>';
			for(var  i=0;i<datas.building.length;i++){
				  p += '<option value="'+datas.building[i].builId+'">' + datas.building[i].builName + '</option>';
			}
			buildingName.append(p);
			
		},
		error:function(err){
		alert('发生了错误：'+err.status);
		console.table(err);
		}
	});
}
//根据房间分类获取子类
function getRoomSub(roomSelectName){
	var roomSelectSub = $("#roomSelectSub");
		roomSelectSub.html('');
		var p = ' <option value="roomSelectSub" selected>请选择房间子类...</option>';
   if(roomSelectName == "01"){
		p += ' <option value="0101">自住住宅</option>'+
		  '<option value="0102">出租住宅</option>';
   }else if(roomSelectName == "02"){
	  p += '<option value="0201">旅馆</option>' +
		  '<option value="0202">废旧金属回收</option>'+
		  '<option value="0203">刻字刻章</option>'+
		  '<option value="0204">典当</option>'+
		  '<option value="0205">网吧</option>';
		 
   }else if(roomSelectName == "03"){
	p += '<option value="0301">幼儿园</option>'+
		  '<option value="0302">中小学</option>'+
		  '<option value="0303">学生宿舍</option>';
   }else if(roomSelectName == "04"){
	 p += '<option value="0401">足浴</option>'+
		  '<option value="0402">棋牌</option>'+
		  '<option value="0403">KTV</option>'+
		  '<option value="0405">餐饮</option>'+
		  '<option value="0406">药店（医院）</option>'+
		  '<option value="0407">水果店</option>'+
		  '<option value="0408">超市</option>'+
		  '<option value="0409">通讯器材</option>'+
		  '<option value="0410">理发店</option>'+
		  '<option value="0411">福利彩票</option>'+
		  '<option value="0412">寄递</option>'+
		  '<option value="0413">摄影</option>'+
		  '<option value="0414">洗衣店</option>'+
		  '<option value="0415">修车店</option>'+
		  '<option value="0416">图文店</option>'+
		  '<option value="0417">浴场</option>'+
		  '<option value="0418">加油站</option>'+
		  '<option value="0419">五金店</option>';
   }else if(roomSelectName == "05"){
	p += '<option value="0501">农贸市场</option>'+
		  '<option value="0502">基督教堂</option'+
		  '<option value="0503">其他</option>';
   }else if(roomSelectName == "06"){
   }else if(roomSelectName == "roomSelect"){
   	 p += '<option value="0101">自住住宅</option>'+
          '<option value="0102">出租住宅</option>'+
          '<option value="0201">旅馆</option>'+
          '<option value="0202">废旧金属回收</option>'+
          '<option value="0203">刻字刻章</option>'+
          '<option value="0204">典当</option>'+
          '<option value="0205">网吧</option>'+
          '<option value="0301">幼儿园</option>'+
          '<option value="0302">中小学</option>'+
          '<option value="0303">学生宿舍</option>'+
          '<option value="0401">足浴</option>'+
          '<option value="0402">棋牌</option>'+
          '<option value="0403">KTV</option>'+
          '<option value="0405">餐饮</option>'+
          '<option value="0406">药店（医院）</option>'+
          '<option value="0407">水果店</option>'+
          '<option value="0408">超市</option>'+
          '<option value="0409">通讯器材</option>'+
          '<option value="0410">理发店</option>'+
          '<option value="0411">福利彩票</option>'+
          '<option value="0412">寄递</option>'+
		  '<option value="0413">摄影</option>'+
		  '<option value="0414">洗衣店</option>'+
		  '<option value="0415">修车店</option>'+
		  '<option value="0416">图文店</option>'+
		  '<option value="0417">浴场</option>'+
		  '<option value="0418">加油站</option>'+
		  '<option value="0419">五金店</option>'+
          '<option value="0501">农贸市场</option>'+
          '<option value="0502">基督教堂</option>'+
          '<option value="0503">其他</option>';
   }
   roomSelectSub.append(p);
}
//查询人员详情
function searchPersonInfo(policeId){
	var data = {};
	var dataTittle = [];
	data.poli_id = policeId;
  if($("#communityName option:selected").val() != "community"){
	 communityId = $("#communityName option:selected").val();
	 data.comm_id = communityId;
	 dataTittle.push($("#communityName option:selected").text());
  }
  if($("#buildingName option:selected").val() != "building"){
	buildingId = $("#buildingName option:selected").val();
	data.buil_id = buildingId;
	dataTittle.push($("#buildingName option:selected").text())
  }

  if($('#loneBuilding option:selected').val() != "lone"){
	 loneBuildingId = $('#loneBuilding option:selected').val();
	 data.buil_id = loneBuildingId;
	 dataTittle.push($('#loneBuilding option:selected').text());

  }
  if($("#unit").val().replace(/[^0-9]/ig,"") != ""){
	data.room_unit = $("#unit").val().replace(/[^0-9]/ig,"");
	dataTittle.push($("#unit").val());
  }
  if($("#floor").val().replace(/[^0-9]/ig,"") != ""){
	data.room_floor = $("#floor").val().replace(/[^0-9]/ig,"");
	dataTittle.push($("#floor").val());
  }
  if($("#room").val() != ""){
	if($("#room").val().replace(/[^0-9]/ig,"").length == 3){
		data.room_no = "0" + $("#room").val().replace(/[^0-9]/ig,"");
		dataTittle.push($("#room").val());
	}
	if($("#room").val().replace(/[^0-9]/ig,"").length == 4){
		data.room_no = $("#room").val().replace(/[^0-9]/ig,"");
		dataTittle.push($("#room").val());
	}
  }
	if($('#roomSelect option:selected').val() != "roomSelect"){
	 data.room_class = $('#roomSelect option:selected').val();
	 dataTittle.push($('#roomSelect option:selected').text());

  }
   if($('#roomSelectSub option:selected').val() != "roomSelectSub"){
	 data.room_subclass = $('#roomSelectSub option:selected').val();
	 dataTittle.push($('#roomSelectSub option:selected').text());

  }
  //增加是否超期未巡检选择框
  if($('#overDue option:selected').val() != "overDue"){
  	data.is_overdue = $('#overDue option:selected').val();
  	dataTittle.push($('#overDue option:selected').text() + "超期未巡检");
  }
  if($("#name").val() != ""){
	data.pers_name = $("#name").val();
	dataTittle.push($("#name").val());
  }


  if($('#sex option:selected').val() != "sex"){
	 data.pers_sex= $('#sex option:selected').val();
	 dataTittle.push($('#sex option:selected').text());
  }
  
  if($("#card").val() != ""){
	data.pers_idcard = $("#card").val();
	dataTittle.push($("#card").val());
  }
  if($("#phone").val() != ""){
  	data.pers_phone = $("#phone").val();
  	dataTittle.push($("#phone").val());
  }
  if($("#regitsterStart").val() != ""){
  	data.startTime = $("#regitsterStart").val();
  	dataTittle.push($("#regitsterStart").val());
  }
   if($("#registerEnd").val() != ""){
  	data.endTime = $("#registerEnd").val();
  	dataTittle.push($("#registerEnd").val());
  }
  if($('#whyRegister option:selected').val() != "whyRegister"){
	 data.why_register= $('#whyRegister option:selected').val();
	 dataTittle.push($('#whyRegister option:selected').text());
  }
   if($('#isFocus option:selected').val() != "isFocus"){
	 data.is_focus = $('#isFocus option:selected').val();
	 dataTittle.push($('#isFocus option:selected').text() + '重点关注对象');
  }
  var pageSize = "";
  if($('#pageSize').val().replace(/[^0-9]/ig,"") != ""){
      pageSize = $('#pageSize').val().replace(/[^0-9]/ig,"");
  }
   //根据总数来查看是否分页  
  $.ajax({
		url: '../person/searchSize.do',
		type: 'POST',
		data: data,
		success:function(dataResult2){
			console.log(data);
			console.log(dataResult2);
			if(dataResult2 <= 0){
		     var holder = $("#holder");
                 holder.html('');
                 $("#button").html("");
			var captionTittle = $("#captionTittle");
       	    captionTittle.html('');
       	    $("#timeTittle").html("");
       	    $("#personThead").html('');
       	    $("#itemContainer").html('');
       	    $("#message").text("无人员信息，请重新查询");
			}
			//pageSize每页记录数
			if(pageSize != ""){
				console.log(pageSize);
				console.log(dataResult2);
				if(parseInt(dataResult2) >0 && parseInt(dataResult2) <= parseInt(pageSize)){
					console.log(parseInt(dataResult2) <= parseInt(pageSize));
				$("#message").text("");
				   var holder = $("#holder");
                   holder.html('');
				var datas = data;
				searchPerson(datas,dataTittle);

       }
        if(parseInt(dataResult2) > parseInt(pageSize)){
       	$("#message").text("");
       	if(parseInt(pageSize) > 4500){
       		pageSize = 4500;
       		var count = Math.ceil(dataResult2/4500);
       	}else{
       		var count = Math.ceil(dataResult2/pageSize);
       	}
        console.log("测试hello");
        console.log(count);
         var holder = $("#holder");
             holder.html('');
        $('#holder').jqPaginator({
        totalPages: count,
        visiblePages: 8,
        currentPage: 1,
         first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
         prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
         next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
         last: '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
		 page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
       onPageChange: function (num) {
       	   var datas = data;
           datas.page = num;
           datas.size = pageSize;
           //console.log(datas);
          searchPerson(datas,dataTittle);
    }
});

       }
		
  }
  //若pageSize用户不输入，默认每页显示记录8条
  if(pageSize == ""){
  	 if(parseInt(dataResult2) >0 && parseInt(dataResult2) <=8){
				$("#message").text("");
				var datas = data;
				searchPerson(datas,dataTittle);
       }
        if(parseInt(dataResult2) > 8){
       	$("#message").text("");
       	var count = Math.ceil(dataResult2/8);
        console.log("测试hello");
        console.log(count);
         var holder = $("#holder");
             holder.html('');
        $('#holder').jqPaginator({
        totalPages: count,
        visiblePages: 8,
        currentPage: 1,
         first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
         prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
         next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
         last: '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
		 page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
       onPageChange: function (num) {
       	   var datas = data;
           datas.page = num;
           datas.size = 8;
           //console.log(datas);
          searchPerson(datas,dataTittle);
    }
});

       }
		
  }
	
},
		error:function(err){
		alert('发生了错误：'+err.status);
		console.table(err);
		}
	});
 
}
//查询人员
function searchPerson(datas,dataTittle){
	   $.ajax({
		url: '../person/searchPerson.do',
		type: 'POST',
		data: datas,
		success:function(dataResult1){
			var dataResult = eval('('+dataResult1+')');
			//console.log(dataResult.length);
			
	        //表格头标题内容
			var caption = $("#captionTittle");
			var title='';
			for(var i=0;i<dataTittle.length;i++){
				title += dataTittle[i] + ' ';
			}
			caption.text(title + "人员详情");
			//excel表格名称用时间不同区分；
			var timeTittle = $("#timeTittle");
			var time = new Date();
	        var year = time.getFullYear();
	        var month = time.getMonth()+1;
	        var day = time.getDate();
	        var hour = time.getHours();
	        var minute = time.getMinutes();
	        var second = time.getSeconds();
	        timeTittle.text(title + "  " + year + "-" + month + 
	        	"-" + day +" " + hour + "\:" + minute + "\:" + second );
			//表格头内容
			var thead = $("#personThead");
			var head = '<tr>'+
			'<th>姓名</th>'+
			'<th>身份证号</th><th>电话</th>'+
			'<th>人员是否为重点关注</th>'+
			'<th style="display:none">工作地</th>'+
			'<th>人员备注</th>'+
			'<th>小区名</th><th>楼宇</th>'+
			'<th>单元</th><th>楼层</th><th>房间号</th>'+
			'<th style="display:none">房间子类</th>'+
			'<th>巡检次数累计</th><th>上次巡检时间</th>'+
			'<th style="display:none">房间备注</th>'+
			'</tr>';
			thead.html(head);
			//表格body体
			var tbody = $("#itemContainer");
			tbody.html("");
			var body = "";
			for(var i=0;i<dataResult.length;i++){
				console.log(dataResult[i].persName);
				body += '<tr>';
				if(dataResult[i].persName == undefined || dataResult[i].persName == "" || 
						dataResult[i].persName == null){
					body += '<td></td>';
				}else{
					body += '<td>'+dataResult[i].persName+'</td>';
				}
				
				if(dataResult[i].persIdcard == undefined || dataResult[i].persIdcard == "" || 
						dataResult[i].persIdcard == null){
					body += '<td></td>';
				}else{
					 body += '<td>\''+dataResult[i].persIdcard+'</td>';
				}
				if(dataResult[i].persPhone == undefined || dataResult[i].persPhone == "" || 
						dataResult[i].persPhone == null){
					body += '<td></td>';
				}else{
					 body += '<td>'+dataResult[i].persPhone+'</td>';
				}
				
			 //js里如果dataResult[i].persFocus == 0 则dataResult[i].persFocus == ""也成立
				if(dataResult[i].persFocus == undefined ||  
						dataResult[i].persFocus == null){
					body += '<td></td>';
				}else{
					if(dataResult[i].persFocus == 0){
	                	body += '<td>普通</td>';
	                }
	                if(dataResult[i].persFocus == 1){
	                	body += '<td>一级</td>';
	                }
	                if(dataResult[i].persFocus == 2){
	                	body += '<td>二级</td>';
	                }
	                 if(dataResult[i].persFocus == 3){
	                	body += '<td>三级</td>';
	                }
				}
				
				if(dataResult[i].addrWork == undefined || dataResult[i].addrWork == "" || 
						dataResult[i].addrWork == null){
					body += '<td style="display:none"></td>';
				}else{
					 body += '<td style="display:none">'+dataResult[i].addrWork+'</td>';
				}
				if(dataResult[i].persRamark == undefined || dataResult[i].persRamark == "" || 
						dataResult[i].persRamark == null){
					body += '<td></td>';
				}else{
				     
	                body += '<td>'+dataResult[i].persRamark+'</td>';
				}
          


				body += '<td>'+dataResult[i].commName+'</td>';
				body += '<td>'+dataResult[i].builName+'</td>'
				
		
				body += '<td>'+dataResult[i].roomUnit+'单元</td>';
				body += '<td>'+dataResult[i].roomFloor+'层</td>';
				body += '<td>'+dataResult[i].roomNo+'</td>';
				
				if(dataResult[i].roomSubclass == "0101"){
						body += '<td style="display:none">自住住宅</td>'
					}else if(dataResult[i].roomSubclass == "0102" ){
						body += '<td style="display:none">出租住宅</td>'
					}else if(dataResult[i].roomSubclass == "0201" ){
						body += '<td style="display:none">旅馆</td>'
					}else if(dataResult[i].roomSubclass == "0202" ){
						body += '<td style="display:none">废旧金属回收</td>'
					}else if(dataResult[i].roomSubclass == "0203" ){
						body += '<td style="display:none">刻字刻章</td>'
					}else if(dataResult[i].roomSubclass == "0204" ){
						body += '<td style="display:none">典当</td>'
					}else if(dataResult[i].roomSubclass == "0205" ){
						body += '<td style="display:none">网吧</td>'
					}else if(dataResult[i].roomSubclass == "0301" ){
						body += '<td style="display:none">幼儿园</td>'
					}else if(dataResult[i].roomSubclass == "0302" ){
						body += '<td style="display:none">中小学</td>'
					}else if(dataResult[i].roomSubclass == "0303" ){
						body += '<td style="display:none">学生宿舍</td>'
					}else if(dataResult[i].roomSubclass == "0401" ){
						body += '<td style="display:none">足浴</td>'
					}else if(dataResult[i].roomSubclass == "0402" ){
						body += '<td style="display:none">棋牌</td>'
					}else if(dataResult[i].roomSubclass == "0403" ){
						body += '<td style="display:none">KTV</td>'
					}else if(dataResult[i].roomSubclass == "0405" ){
						body += '<td style="display:none">餐饮</td>'
					}else if(dataResult[i].roomSubclass == "0406" ){
						body += '<td style="display:none">药店（医院)</td>'
					}else if(dataResult[i].roomSubclass == "0407" ){
						body += '<td style="display:none">水果店</td>'
					}else if(dataResult[i].roomSubclass == "0408" ){
						body += '<td style="display:none">超市</td>'
					}else if(dataResult[i].roomSubclass == "0409" ){
						body += '<td style="display:none">通讯器材</td>'
					}else if(dataResult[i].roomSubclass == "0410" ){
						body += '<td style="display:none">理发店</td>'
					}else if(dataResult[i].roomSubclass == "0411" ){
						body += '<td style="display:none">福利彩票</td>'
					}else if(dataResult[i].roomSubclass == "0412" ){
						body += '<td style="display:none">寄递</td>'
					}else if(dataResult[i].roomSubclass == "0413" ){
						body += '<td style="display:none">摄影</td>'
					}else if(dataResult[i].roomSubclass == "0414" ){
						body += '<td style="display:none">洗衣店</td>'
					}else if(dataResult[i].roomSubclass == "0415" ){
						body += '<td style="display:none">修车店</td>'
					}else if(dataResult[i].roomSubclass == "0416" ){
						body += '<td style="display:none">图文店</td>'
					}else if(dataResult[i].roomSubclass == "0417" ){
						body += '<td style="display:none">浴场</td>'
					}else if(dataResult[i].roomSubclass == "0418" ){
						body += '<td style="display:none">加油站</td>'
					}else if(dataResult[i].roomSubclass == "0419" ){
						body += '<td style="display:none">五金店</td>'
					}else if(dataResult[i].roomSubclass == "0501" ){
						body += '<td style="display:none">农贸市场</td>'
					}else if(dataResult[i].roomSubclass == "0502" ){
						body += '<td style="display:none">基督教堂</td>'
					}else if(dataResult[i].roomSubclass == "0503"){
						body += '<td style="display:none">其他</td>'
					}else{
						body += '<td style="display:none">未知</td>'
					}
				body += '<td>'+dataResult[i].countInspect+'</td>';
				body += '<td>'+dataResult[i].timeLastinspect+'</td>';
				
				body += '<td style="display:none">'+dataResult[i].roomRamark+'</td>'
               
                body += '</tr>';

			}
			tbody.append(body);
			//excel下载按钮
			var button = $("#button");
			    button.html("");
			    var buttonC = '';
			if(dataResult.length > 0){
                buttonC += '<button class="btn btn-info" type="button" onclick="confirmExcel()">'+
                '导出人员详情到excel表</button>';
			}
			button.append(buttonC);

		},
		error:function(err){
		alert('发生了错误：'+err.status);
		console.table(err);
		}
	});
}
//查询人员总数
function searchAllPersonInfo(policeId){

	var data = {};
	var dataTittle = [];
	data.poli_id = policeId;
  if($("#communityName option:selected").val() != "community"){
	 communityId = $("#communityName option:selected").val();
	 data.comm_id = communityId;
	 dataTittle.push($("#communityName option:selected").text());
  }
  if($("#buildingName option:selected").val() != "building"){
	buildingId = $("#buildingName option:selected").val();
	data.buil_id = buildingId;
	dataTittle.push($("#buildingName option:selected").text())
  }

  if($('#loneBuilding option:selected').val() != "lone"){
	 loneBuildingId = $('#loneBuilding option:selected').val();
	 data.buil_id = loneBuildingId;
	 dataTittle.push($('#loneBuilding option:selected').text());

  }
  if($("#unit").val().replace(/[^0-9]/ig,"") != ""){
	data.room_unit = $("#unit").val().replace(/[^0-9]/ig,"");
	dataTittle.push($("#unit").val());
  }
  if($("#floor").val().replace(/[^0-9]/ig,"") != ""){
	data.room_floor = $("#floor").val().replace(/[^0-9]/ig,"");
	dataTittle.push($("#floor").val());
  }
  if($("#room").val() != ""){
	if($("#room").val().replace(/[^0-9]/ig,"").length == 3){
		data.room_no = "0" + $("#room").val().replace(/[^0-9]/ig,"");
		dataTittle.push($("#room").val());
	}
	if($("#room").val().replace(/[^0-9]/ig,"").length == 4){
		data.room_no = $("#room").val().replace(/[^0-9]/ig,"");
		dataTittle.push($("#room").val());
	}
  }
	if($('#roomSelect option:selected').val() != "roomSelect"){
	 data.room_class = $('#roomSelect option:selected').val();
	 dataTittle.push($('#roomSelect option:selected').text());

  }
   if($('#roomSelectSub option:selected').val() != "roomSelectSub"){
	 data.room_subclass = $('#roomSelectSub option:selected').val();
	 dataTittle.push($('#roomSelectSub option:selected').text());

  }
  //增加是否超期未巡检选择框
  if($('#overDue option:selected').val() != "overDue"){
  	data.is_overdue = $('#overDue option:selected').val();
  	dataTittle.push($('#overDue option:selected').text() + "超期未巡检");
  }
  if($("#name").val() != ""){
	data.pers_name = $("#name").val();
	dataTittle.push($("#name").val());
  }


  if($('#sex option:selected').val() != "sex"){
	 data.pers_sex= $('#sex option:selected').val();
	 dataTittle.push($('#sex option:selected').text());
  }
  
  if($("#card").val() != ""){
	data.pers_idcard = $("#card").val();
	dataTittle.push($("#card").val());
  }
  if($("#phone").val() != ""){
  	data.pers_phone = $("#phone").val();
  	dataTittle.push($("#phone").val());
  }
  if($("#regitsterStart").val() != ""){
  	data.startTime = $("#regitsterStart").val();
  	dataTittle.push($("#regitsterStart").val());
  }
   if($("#registerEnd").val() != ""){
  	data.endTime = $("#registerEnd").val();
  	dataTittle.push($("#registerEnd").val());
  }
  if($('#whyRegister option:selected').val() != "whyRegister"){
	 data.why_register= $('#whyRegister option:selected').val();
	 dataTittle.push($('#whyRegister option:selected').text());
  }
   if($('#isFocus option:selected').val() != "isFocus"){
	 data.is_focus = $('#isFocus option:selected').val();
	 dataTittle.push($('#isFocus option:selected').text() + '重点关注对象');
  }

  $.ajax({
		url: '../person/searchSize.do',
		type: 'POST',
		data: data,
		success:function(dataResult2){
			//大于0小于4500时excel可以导出全部数据不用分页
			if(dataResult2 >0 && dataResult2 <= 4500){
			    $("#message").text("");
				 var holder = $("#holder");
                 holder.html('');
				var datas = data;
				searchPerson(datas,dataTittle);
       } else if(dataResult2 > 4500 ){
       	     $("#message").text("");
       	     var count = Math.ceil(dataResult2/4500);
            var holder = $("#holder");
             holder.html('');
        $('#holder').jqPaginator({
        totalPages: count,
        visiblePages: 8,
        currentPage: 1,
         first: '<li class="first"><a href="javascript:void(0);">首页</a></li>',
         prev: '<li class="prev"><a href="javascript:void(0);">上一页</a></li>',
         next: '<li class="next"><a href="javascript:void(0);">下一页</a></li>',
         last: '<li class="last"><a href="javascript:void(0);">最后一页</a></li>',
		 page: '<li class="page"><a href="javascript:void(0);">{{page}}</a></li>',
       onPageChange: function (num) {
       	   var datas = data;
           datas.page = num;
           datas.size = 4500;
           //console.log(datas);
          searchPerson(datas,dataTittle);
    }
});
       } else {
       	 var holder = $("#holder");
                 holder.html('');
       	 $("#button").html("");
       	var captionTittle = $("#captionTittle");
       	    captionTittle.html('');
       	    $("#timeTittle").html("");
       	    $("#personThead").html('');
       	    $("#itemContainer").html('');
       	    $("#message").text("无人员信息，请重新查询");

       }
   },
		error:function(err){
		alert('发生了错误：'+err.status);
		console.table(err);
		}
	});
 


}
//提示弹出框
function confirmExcel(){
	var message = confirm("确定导出数据到excel表吗？");
	if(message == true){
		excel();
	}

}
//导出excel数据
function excel(){
    var title = $("#timeTittle").text();
      $("#tableExcel").table2excel({
                  exclude: ".noExl",
                    name: "Excel Document Name",
                    filename: title,
                    exclude_img: true,
                    exclude_links: true,
                    exclude_inputs: true
              });
}