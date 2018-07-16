//增加小区的操作
function operationCommunity(policeId){
  var pullRight = $('#pull-right');
  pullRight.html('');
  var p = '';
  p += '<li><label class="">'+
  '<a onclick="addPoliceid('+policeId+')" class="check-log-btn" href="#" data-toggle="modal" data-target="#myModal001">'+
  '<i class="icomoon" aria-hidden="true">&#xe90c;</i></a></label></li>';
  pullRight.append(p);
}

function addPoliceid(policeId){
	console.log(policeId);
	$('#policeIdhidden').val(policeId);
}
//修改小区，删除小区，增加楼宇的操作

function communityEdit(policeId,commId,commName){
	$('#communityNamehidden').val(commName);
  var pullRight = $('#pull-right');
  pullRight.html('');
  var p = '';
   p += '<li><label class="">'+
  '<a onclick="addBuildingValue('+policeId+','+commId+')"class="check-log-btn" href="#" data-toggle="modal" data-target="#myModal002">'+
  '<i class="icomoon" aria-hidden="true">&#xe90c;</i></a></label></li>';
   p += '<li><label class="">'+
  '<a onclick="editCommunity1('+commId+')" class="check-log-btn" href="#" data-toggle="modal" data-target="#myModal001edit">'+
  '<i class="icomoon" aria-hidden="true">&#xe906;</i></a></label></li>';
  // p += '<li><label class="">'+
  // '<a onclick="editCommunity('+commId+')" class="check-log-btn" href="#" data-toggle="modal" data-target="#myModal001edit">'+
  // '<i class="icomoon" aria-hidden="true">&#xe906;</i></a></label></li>';
  pullRight.append(p);
}

function editCommunity1(commId){
	console.log(commId);
	   $.ajax({
        url: '../community/comm_id',
        type: 'POST',
        data: {
            comm_id: commId,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');
            console.log(datas);
           $('#hiddenPoliceId1').val(datas.community.poliId);
			$('#hiddenCommId').val(datas.community.commId);
			$('#xiaoquName1').val(datas.community.commName);
			$('#jingdu1').val(datas.community.commGpslist);
			$('#userSign1').val(datas.community.ramark);
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}
function addBuildingValue(policeId,commId){
	$('#buildingPoliceId').val(policeId);
	$('#buildingCommId').val(commId);
	
}
//点击楼宇增加房间，修改楼宇
function bulidingEdit22(buildingId){
var pullRight = $('#pull-right');
  pullRight.html('');
  var p = '';
    p += '<li><label class="">'+
  '<a onclick="addRoomValue('+buildingId+')"class="check-log-btn" href="#" data-toggle="modal" data-target="#myModal003">'+
  '<i class="icomoon" aria-hidden="true">&#xe90c;</i></a></label></li>';
   p += '<li><label class="">'+
  '<a onclick="editbuilding1('+buildingId+')" class="check-log-btn" href="#" data-toggle="modal" data-target="#myModal002edit">'+
  '<i class="icomoon" aria-hidden="true">&#xe906;</i></a></label></li>';
   pullRight.append(p);
}

function editbuilding1(buildingId){
	  $.ajax({
        url: '../building/buil_id',
        type: 'POST',
        data: {
            buil_id: buildingId,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');
            console.log(datas);
           $('#buildingPoliceId').val(datas.building.poliId);
			$('#buidingCommunityId').val(datas.building.commId);
			$('#buildingIdhidden').val(datas.building.builId);
			$('#louyuName1').val(datas.building.builName);
			$('#jingdu4').val(datas.building.builGpse);
			$('#weidu4').val(datas.building.builGpsn);
			$('#typeList option').each(function(){
                if($(this).val() == datas.building.builType){
                	$(this).attr("selected",true);
                }
			});
			$('#userSign4').val(datas.building.ramark);
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}
function addRoomValue(buildId){
	$('#roomBuildId').val(buildId);
}

function showRoomInformation(roomId){
	 $.ajax({
        url: '../room/id',
        type: 'POST',
        data: {
            room_id: roomId,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');
            console.log(datas);
           $('#roomEditunitName').val(datas.room.roomUnit);
			$('#roomEditId').val(datas.room.roomId);
			$('#roomBuildId11').val(datas.room.builId);
			$('#roomEditFloor').val(datas.room.roomFloor);
			$('#roomEditNo').val(datas.room.roomNo);
			$('#roomEditType option').each(function(){
                if($(this).val() == datas.room.roomClass){
                	$(this).attr("selected",true);
                }
			});
			$('#roomEditTypeSub option').each(function(){
                if($(this).val() == datas.room.roomSubclass){
                	$(this).attr("selected",true);
                }
			});
			$('#roomEditFocus option').each(function(){
                if($(this).val() == datas.room.isFocus){
                	$(this).attr("selected",true);
                }
			});
			$('#roomEditRemark').val(datas.room.ramark);
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}