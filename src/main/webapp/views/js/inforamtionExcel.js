function getEmptyRoomInformation(policeId,commId,buildId){
    var dataInforamtion = {};
    if(policeId != "" || policeId != undefined || policeId != null){
    	dataInforamtion.poli_id = policeId;
    }
    	
        console.log(policeId);
        console.log(commId);
        console.log(buildId == undefined);
        console.log(buildId);
      if(commId != "" || commId != undefined || commId != null){
    	dataInforamtion.comm_id = commId;
       }
     if(buildId != "" || buildId != undefined || buildId != null){
    	dataInforamtion.buil_id = buildId;
        }
    	$.ajax({
		url: '../room/getEmptyRoom',
		type: 'post',
		dataType: 'json',
		data: dataInforamtion,
		success:function(data){

		var datas = data;
		console.log(datas[0]);
		var informationCaption = $('#informationCaption');
		var informationTittle = $('#informationTittle');
		    informationCaption.html('');
		    var time = new Date();
	        var year = time.getFullYear();
	        var month = time.getMonth()+1;
	        var day = time.getDate();
	        var hour = time.getHours();
	        var minute = time.getMinutes();
	        var second = time.getSeconds();
	        var title='空房间信息列表'
	        informationTittle.text(title + "  " + year + "-" + month + 
	        	"-" + day +" " + hour + "\:" + minute + "\:" + second );
	        informationCaption.html('');
	        informationCaption.text(title);
	        var informationThead = $('#informationThead');
	          informationThead.html('');
	        var thead = '<tr><th>小区名</th><th>楼宇名</th>'+
	        '<th>单元</th><th>楼层</th><th>房间号</th>'+
	        '<th style="display:none">房间子类</th>'+
	        '<th>巡检次数</th><th>最后一次巡检时间</th>'+
	        '</tr>';
	        informationThead.html(thead);
	        var informationTbody = $('#informationTbody');
	         informationTbody.html('');
	         var tbody = '';
	          for(var i=0;i<datas.length;i++){
	          	tbody += '<tr>';
	          	tbody += '<td>'+datas[i].commName+'</td>';
	          	tbody += '<td>'+datas[i].builName+'</td>';
	          	
				
				tbody += '<td>'+datas[i].roomUnit+'单元</td>';
				tbody += '<td>'+datas[i].roomFloor+'层</td>';
				tbody += '<td>'+datas[i].roomNo+'</td>';
				
				if(datas[i].roomSubclass == "0101"){
						tbody += '<td style="display:none">自住住宅</td>'
					}else if(datas[i].roomSubclass == "0102" ){
						tbody += '<td style="display:none">出租住宅</td>'
					}else if(datas[i].roomSubclass == "0201" ){
						tbody += '<td style="display:none">旅馆</td>'
					}else if(datas[i].roomSubclass == "0202" ){
						tbody += '<td style="display:none">废旧金属回收</td>'
					}else if(datas[i].roomSubclass == "0203" ){
						tbody += '<td style="display:none">刻字刻章</td>'
					}else if(datas[i].roomSubclass == "0204" ){
						tbody += '<td style="display:none">典当</td>'
					}else if(datas[i].roomSubclass == "0205" ){
						tbody += '<td style="display:none">网吧</td>'
					}else if(datas[i].roomSubclass == "0301" ){
						tbody += '<td style="display:none">幼儿园</td>'
					}else if(datas[i].roomSubclass == "0302" ){
						tbody += '<td style="display:none">中小学</td>'
					}else if(datas[i].roomSubclass == "0303" ){
						tbody += '<td style="display:none">学生宿舍</td>'
					}else if(datas[i].roomSubclass == "0401" ){
						tbody += '<td style="display:none">足浴</td>'
					}else if(datas[i].roomSubclass == "0402" ){
						tbody += '<td style="display:none">棋牌</td>'
					}else if(datas[i].roomSubclass == "0403" ){
						tbody += '<td style="display:none">KTV</td>'
					}else if(datas[i].roomSubclass == "0405" ){
						tbody += '<td style="display:none">餐饮</td>'
					}else if(datas[i].roomSubclass == "0406" ){
						tbody += '<td style="display:none">药店（医院)</td>'
					}else if(datas[i].roomSubclass == "0407" ){
						tbody += '<td style="display:none">水果店</td>'
					}else if(datas[i].roomSubclass == "0408" ){
						tbody += '<td style="display:none">超市</td>'
					}else if(datas[i].roomSubclass == "0409" ){
						tbody += '<td style="display:none">通讯器材</td>'
					}else if(datas[i].roomSubclass == "0410" ){
						tbody += '<td style="display:none">理发店</td>'
					}else if(datas[i].roomSubclass == "0411" ){
						tbody += '<td style="display:none">福利彩票</td>'
					}else if(datas[i].roomSubclass == "0412" ){
						tbody += '<td style="display:none">寄递</td>'
					}else if(datas[i].roomSubclass == "0413" ){
						tbody += '<td style="display:none">摄影</td>'
					}else if(datas[i].roomSubclass == "0414" ){
						tbody += '<td style="display:none">洗衣店</td>'
					}else if(datas[i].roomSubclass == "0415" ){
						tbody += '<td style="display:none">修车店</td>'
					}else if(datas[i].roomSubclass == "0416" ){
						tbody += '<td style="display:none">图文店</td>'
					}else if(datas[i].roomSubclass == "0417" ){
						tbody += '<td style="display:none">浴场</td>'
					}else if(datas[i].roomSubclass == "0418" ){
						tbody += '<td style="display:none">加油站</td>'
					}else if(datas[i].roomSubclass == "0419" ){
						tbody += '<td style="display:none">五金店</td>'
					}else if(datas[i].roomSubclass == "0501" ){
						tbody += '<td style="display:none">农贸市场</td>'
					}else if(datas[i].roomSubclass == "0502" ){
						tbody += '<td style="display:none">基督教堂</td>'
					}else if(datas[i].roomSubclass == "0503"){
						tbody += '<td style="display:none">其他</td>'
					}else{
						tbody += '<td style="display:none">未知</td>'
					}
				tbody += '<td>'+datas[i].countInspect+'</td>';
				tbody += '<td>'+datas[i].timeLastinspect+'</td>';
			
				tbody += '</tr>';
	          }
	          informationTbody.html(tbody);
	          //excel下载按钮
			var button = $("#informationButton");
			    button.html("");
			    var buttonC = '';
			if(tbody != ""){
                buttonC += '<button class="btn btn-info" type="button" onclick="confirmInforExcel()">'+
                '导出详情到excel表</button>';
			}
			button.append(buttonC);
			

		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
}
function confirmInforExcel(){
	var message = confirm("确定导出数据到excel表吗？");
	if(message == true){
		emptyRoomexcel();
	}

}
function emptyRoomexcel(){
	var title = $("#informationTittle").text();
      $("#informationtable").table2excel({
                  exclude: ".noExl",
                    name: "Excel Document Name",
                    filename: title,
                    exclude_img: true,
                    exclude_links: true,
                    exclude_inputs: true
              });
}