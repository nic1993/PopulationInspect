/**
 * 获取静态文件的URL前缀
 * @returns {String} 静态文件的URL前缀
 */
function getStaticFileURLPrefix() {
    return "../static/";
}
function formClear(){
	$("#message").html("");
	$("#name").val("");
	$("#tel").val("");
	$("#id-num").val("");
	$('#photo').val('');
	$("#log-r").val("");
	$("#huji").val("");
	$("#juzhu").val("");
	$("#work").val("");
	$("#copy").val("");
}
//显示datetime时间格式
function showTime(roomId,roomNo){
	var logTime = $("#log-t");
	$("#roomId11").text(roomNo);
	$("#hidden").val(roomId);
	var time = new Date();
	var year = time.getFullYear();
	var month = time.getMonth()+1;
	var day = time.getDate();
	var hour = time.getHours();
	var minute = time.getMinutes();
	var second = time.getSeconds();
	logTime.val(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
	
	
}
function showTime1(policeId,roomId){
	$("#policeId").val(policeId);
	$("#roomId").val(roomId);
	var inspectId = $("#inspectId");
	var time = new Date();
	var year = time.getFullYear();
	var month = time.getMonth()+1;
	var day = time.getDate();
	var hour = time.getHours();
	var minute = time.getMinutes();
	var second = time.getSeconds();
	inspectId.val(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
	//console.log(policeId,roomId);
//	if($('#root1 > a').html()){
//		var statName = $('#root1 > a').html();
//	}else{
//		var statName = '';
//	}
	var unitName = $('#root2').html();
	var buildName = $('#root3').html();
	var houseinfo = $("#house-info-u").text();
	var houseNo = $("#house-info-n").text();
	var inspectionMessage = $("#inspectionMessage");
	inspectionMessage.html(unitName+'&nbsp;'+buildName + '&nbsp;'+ houseinfo + '单元&nbsp;' + houseNo + '房间' );
}
//人员详情
function personInformation(personId,room){
	var roomNo = $("#roomNo");
	var username = $("#username");
	var sex = $("#sex");
	var tel = $("#tel");
	var idCard = $("#idCard");
	var logTime = $("#logTime");
	var logReason = $("#logReason");
	var place = $("#place");
	var livePlace = $("#livePlace");
	var workPlace = $("#workPlace");
	var isFocus = $("#isFocus");
	var copy = $("#copy");
	var picture = $("#picture");
	
	$.ajax({
		url:"../person/info",
		type:"POST",
		data:{pers_id:personId},
		dataType:"json",
		success:function(data){
			if(data.resultCode == 1){
				var person = data.person;
				console.log(person);
				if(person.persPhoto){
					picture.attr("src",getStaticFileURLPrefix() + person.persPhoto);
				}
				
				$("#hidden").val(person.roomId);
				$("#hidden2").val(person.persId);

				$("#roomNo").text("房间号：" + room);
				$("#username").text("姓名：" + person.persName);
				$("#name-def").val(person.persName);

				if(person.persSex == true){
					$("#sex").text("性别：" + "  男");
					$("[name='persSex'][value='1']").attr('checked',true);
				}
				if(person.persSex == false){
					$("#sex").text("性别：" + "  女");
					$("[name='persSex'][value='0']").attr('checked',true);
				}
				
				$("#tel").text("电话：" + person.persPhone);
				$("#tel-def").val(person.persPhone);

				$("#idCard").text("身份证号码：" + person.persIdcard);
				$("#id-num").val(person.persIdcard);

				if(person.timeRegister != null){
				  $("#logTime").text("登记时间：" + person.timeRegister);
				  $("#log-t").val(person.timeRegister);
				}

				if(person.whyRegister == 01){
				  logReason.text("登记原因：" + "  自住");
				  $("[name='whyRegister'][value='01']").attr('checked',true);
				}
				if(person.whyRegister == 02){
				  logReason.text("登记原因：" + "  租住");
				  $("[name='whyRegister'][value='02']").attr('checked',true);
				}
				if(person.whyRegister == 03){
				  logReason.text("登记原因：" + "  工作");
				  $("[name='whyRegister'][value='03']").attr('checked',true);
				}

				place.text("户籍所在地：" + person.addrCensus);
				$("#huji").val(person.addrCensus);

				livePlace.text("居住地："+ person.addrLive);
				$("#juzhu").val(person.addrLive);

				workPlace.text("工作地：" + person.addrWork);
				$("#work").val(person.addrWork);

				if(person.isFocus == true){
				  isFocus.text("是否为重点关注对象：" + " 是");
				  $("[name='isFocus'][value='1']").attr('checked',true);
				}
				if(person.isFocus == false){
				  isFocus.text("是否为重点关注对象：" + " 否");
				  $("[name='isFocus'][value='0']").attr('checked',true);
				}

				copy.text("备注：" + person.ramark);
				$("#copy-def").val(person.ramark);

				}
			}
		});
}

//自动巡检
function autoInspection11(policeId,roomId){
	console.log(policeId,roomId);
	var autoInspectionMessage = $("#autoInspectionMessage");
	autoInspectionMessage.html("");
	$.ajax({
		url:"../inspectlog/add.do",
		type:"POST",
		data:{poli_id:policeId,room_id:roomId},
		dataType:"json",
		success:function(data){
			if(data.resultCode == 1){
				$('#autocheck-i').html("自动巡检成功！(2s后窗口自动关闭)")
				
			}else{
				autoInspectionMessage.text("巡检失败，请重新操作");
			}
            console.log(roomId);
			showRoomInfo(roomId);
			setTimeout(function(){
			$('#auto-check').modal('hide');
		},2000);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}
	});
	autoInspectionMessage.text("");
}

//添加巡检日志详情
function addInspectionLog(){
	var inspectId = $("#inspectId").val();
	var subHouse = $("#houseKind").find("option:selected").val();
	var parentHouse = subHouse.substr(0,2);
	var message = $("#textarea1").val();
	var isfocus = $("input[name='isfocus']:checked").val();
	var policeId = $("#policeId").val();
	var roomId = $("#roomId").val();
	var inputInspectionMessage = $("#inputInspectionMessage");
	$.ajax({
		url:"../inspectlog/add.do",
		type:"POST",
		data:{insp_rec:message,poli_id:policeId,room_id:roomId,
			is_focus:isfocus},
		dataType:"json",
		success:function(data){
			
		}
	
	});

	$.ajax({
		url:"../room/class/update.do",
		type:"POST",
		data:{room_id:roomId,room_class:parentHouse,room_subclass:subHouse},
		dataType:"json",
		success:function(data){
			if(data.resultCode == 1){
				inputInspectionMessage.html("");
				inputInspectionMessage.text("提交巡检记录成功(2s后窗口自动关闭)");
				$("#textarea1").val("");
				$("input[name='isfocus']").attr("checked",false);
				
				
			}else{
				inputInspectionMessage.text("提交巡检记录失败");
			}
			showRoomInfo(roomId);
			setTimeout(function(){
			$('#myModal').modal('hide');
		},2000);
		},
		error:function(err){
			alert('发生了错误：'+err.status);
			console.table(err);
		}

	});
}
