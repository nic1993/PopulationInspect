function getDangerInformation(policeId,commId,buildId,type){
    var dataInforamtion = {};
    if(policeId != "" && policeId != undefined && policeId != null){
    	dataInforamtion.poli_id = policeId;
    }
    	
       
      if(commId != "" && commId != undefined && commId != null){
    	dataInforamtion.comm_id = commId;
       }
     if(buildId != "" && buildId != undefined && buildId != null){
    	dataInforamtion.buil_id = buildId;
        }
        var title='';
        if(type != "" && type != undefined && type != null){
        	if(type=="1234"){
        		dataInforamtion.isDrug = 1;
        		title += '易制毒信息详情';
        	}
        	if(type=="2134"){
        		dataInforamtion.isBoom = 1;
        		title += '易制爆信息详情';
        	}
        	if(type=="3124"){
        		dataInforamtion.isToxic = 1;
        		title += '剧毒信息详情';
        	}
        	if(type=="4123"){
        		dataInforamtion.isDanger = 1;
        		title += '危险源信息详情';
        	}
        }
     
     dataInforamtion.pers_type = 1;
     console.log(dataInforamtion);
     console.log(title);
    	$.ajax({
		url: '../room/searchRoom',
		type: 'post',
		dataType: 'json',
		data: dataInforamtion,
		success:function(data){

		var dataResult = data;
		
		var informationCaption = $('#informationDrugCaption');
		var informationTittle = $('#informationDrugTittle');
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
	        var informationThead = $('#informationDrugThead');
	          informationThead.html('');
	        var thead ='<tr>'+
			'<th>单位名称</th><th>地址</th>'+
			'<th>负责人</th><th>身份证</th><th>联系方式</th>'+
			
			'</tr>';
	        informationThead.html(thead);
	        var informationTbody = $('#informationDrugTbody');
	         informationTbody.html('');
	         var body = "";
				for(var i=0;i<dataResult.length;i++){
					console.log(dataResult[i].persName);
					body += '<tr>';
					if(dataResult[i].builName == undefined || dataResult[i].builName == "" || 
							dataResult[i].builName == null){
						body += '<td></td>';
					}else{
						 body += '<td>'+dataResult[i].builName+'</td>';
					}
					if(dataResult[i].buil_address == undefined || dataResult[i].buil_address == "" || 
							dataResult[i].buil_address == null){
						body += '<td></td>';
					}else{
						 body += '<td>'+dataResult[i].buil_address+'</td>';
					}
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
	               
	                body += '</tr>';

				}
	          informationTbody.html(body);
	          //excel下载按钮
			var button = $("#informationDrugButton");
			    button.html("");
			    var buttonC = '';
			if(body != ""){
                buttonC += '<button class="btn btn-info" type="button" onclick="confirmdrugInforExcel()">'+
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
function confirmdrugInforExcel(){
	var message = confirm("确定导出数据到excel表吗？");
	if(message == true){
		drugexcel();
	}

}
function drugexcel(){
	var title = $("#informationDrugTittle").text();
      $("#informationDrugtable").table2excel({
                  exclude: ".noExl",
                    name: "Excel Document Name",
                    filename: title,
                    exclude_img: true,
                    exclude_links: true,
                    exclude_inputs: true
              });
}