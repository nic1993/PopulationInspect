function getSpecialInformation(policeId,commId,buildId,roomClass){
    var dataInforamtion = {};
    if(policeId != "" && policeId != undefined && policeId != null){
    	dataInforamtion.poli_id = policeId;
    }
    	
        console.log(policeId);
        console.log(commId);
        console.log(buildId == undefined);
        console.log(buildId == null);
        console.log(buildId == "");
        console.log(buildId);
      if(commId != "" && commId != undefined && commId != null){
    	dataInforamtion.comm_id = commId;
       }
     if(buildId != "" && buildId != undefined && buildId != null){
    	dataInforamtion.buil_id = buildId;
        }
         var title='';
         if(roomClass != "" && roomClass != undefined && roomClass != null){
        	dataInforamtion.room_class = roomClass;
             if(roomClass == "02"){
             	title += "特业信息详情";
             	console.log(title);
             	console.log("特业");
             }
             if(roomClass == "04"){
             	title += "商铺信息详情";
             	console.log(title);
             	console.log("商铺");
             }
        }
    	$.ajax({
		url: '../room/searchRoom',
		type: 'post',
		dataType: 'json',
		data: dataInforamtion,
		success:function(data){

		var dataResult = data;
		console.log(dataResult[0]);
		var informationCaption = $('#informationSpecialCaption');
		var informationTittle = $('#informationSpecialTittle');
		    informationCaption.html('');
		    var time = new Date();
	        var year = time.getFullYear();
	        var month = time.getMonth()+1;
	        var day = time.getDate();
	        var hour = time.getHours();
	        var minute = time.getMinutes();
	        var second = time.getSeconds();
	       
	        informationTittle.text(title + "  " + year + "-" + month + 
	        	"-" + day +" " + hour + "\:" + minute + "\:" + second );
	        informationCaption.html('');
	        informationCaption.text(title);
	        var informationThead = $('#informationSpecialThead');
	          informationThead.html('');
	        var thead = '<tr>'+
			'<th>小区名</th><th>楼宇</th>'+
			'<th>单元</th><th>楼层</th><th>房间号</th>'+
			'<th style="display:none">房间子类</th>'+
			'<th>巡检次数累计</th><th>上次巡检时间</th>'+
			'<th style="display:none">房间备注</th>'+
			'<th>姓名</th>'+
			'<th>身份证号</th><th>电话</th>'+
			'<th>人员重点关注</th>'+
			'<th style="display:none">工作地</th>'+
			'<th>人员备注</th>'+
			'</tr>';
	        informationThead.html(thead);
	        var informationTbody = $('#informationSpecialTbody');
	         informationTbody.html('');
	         var body = "";
				for(var i=0;i<dataResult.length;i++){
					console.log(dataResult[i].persName);
					body += '<tr>';
					
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
					if(dataResult[i].timeLastinspect == undefined || dataResult[i].timeLastinspect == "" || 
							dataResult[i].timeLastinspect == null){
						body += '<td></td>';
					}else{
						body += '<td>'+dataResult[i].timeLastinspect+'</td>';
					}
					
					
					body += '<td style="display:none">'+dataResult[i].roomRamark+'</td>';
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
	          

	               
	                body += '</tr>';

				}
	          informationTbody.html(body);
	          //excel下载按钮
			var button = $("#informationSpecialButton");
			    button.html("");
			    var buttonC = '';
			if(body != ""){
                buttonC += '<button class="btn btn-info" type="button" onclick="confirmSpecialInforExcel()">'+
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
function confirmSpecialInforExcel(){
	var message = confirm("确定导出数据到excel表吗？");
	if(message == true){
		specialexcel();
	}

}
function specialexcel(){
	var title = $("#informationSpecialTittle").text();
      $("#informationSpecialtable").table2excel({
                  exclude: ".noExl",
                    name: "Excel Document Name",
                    filename: title,
                    exclude_img: true,
                    exclude_links: true,
                    exclude_inputs: true
              });
}