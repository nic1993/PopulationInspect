/**
 * Created by Perfect on 2016/4/27.
 */
function getOverDue(poli_id_my){
    $.ajax({
        url:'../police/inspectlog/overdue',
        type:'POST',
        data:{
            poli_id:poli_id_my,
        },
        success:function(data){
        //console.log(data);
        var datas = eval('('+data+')');
        var overduebox = $('#over-due');
        var p = '';
        p += '<a class="num red-2" href="check.html" target="_blank">'+datas.overdue_num.comm_overinspect+'</a>/';
        p += '<a class="num red-2" href="check.html" target="_blank">'+datas.overdue_num.buil_overinspect+'</a>/';
        p += '<a class="num red-2" href="check.html" target="_blank">'+datas.overdue_num.room_overinspect+'</a>';

        overduebox.html(p);
        },
        error:function(err){
            alert('发生了错误：'+err.status);
            console.log(err);
        }
    });
}
function admin(){
    var datas = JSON.parse(storage.getItem('police-info'));
    // console.log(datas);
    var adminbox = $('#admin');
    var p = '';
    p += '<img src="'+'images/user.jpg'+'" alt="警员照片">';
    p += '<ul class="admin-info">';
    p += '欢迎您！<span>'+datas.police.poliName+'&nbsp;[<i class="num blue b">'+datas.police.poliCode+'</i>]</span>巡检提醒（<i id="over-due" class="num red-2 b"><a class="num red-2" href="javascript:void(0)"></a>/<a class="num red-2" href="javascript:void(0)"></a>/<a class="num red-2" href="javascript:void(0)"></a></i>）'
    p += '</ul><ul class="admin-web">';
    p += '上一次登陆：<span>'+datas.police.timeLastlogin+'&nbsp;&nbsp;[<i class="blue b">'+datas.police.ipLastlogin+'</i>]</span></ul>';
    adminbox.html(p);

    getOverDue(datas.police.poliId);
}
//admin(datas);

function createtree10(poliId,remark,poliDistrict){
    var treebox = $('#tree');
    
    var breadcrumb = $("#breadcrumb");
    breadcrumb.html("");
    treebox.html('');
    var p = '<ul class="folder">';
    p += '<li class="building0" id="station" ><a class="m0" href="javascript:void(0)" onclick="operationCommunity('+poliId+'); treeLevel10('+poliId+');getStatisByPoli('+poliId+','+'\''+remark+'\''+');createJurisdection('+'\''+poliDistrict+'\''+');clearBread();"> 下沙派出所辖区'+remark+'</a><ul class="subfolder" id="menu1-ul"></li>';
    p += '</ul>';

    treebox.prepend(p);
// 面包屑导航 添加辖区
    var ol = '<ol class="breadcrumb" id="breadcrumb1">';
    ol +='<li id="root1">下沙派出所辖区'+remark+'</li>';
    breadcrumb.append(ol);
}

function createtree20(statName,statId){
    var treebox = $('#tree');
    var breadcrumb = $("#breadcrumb");
    breadcrumb.html("");
    treebox.html('');
    var p = '<ul class="folder">';
    p += '<li class="building0" id="station" ><a class="m0" href="javascript:void(0)" onclick="treeLevel20('+statId+');getStatisByStat('+statId+');clearBread();">'+statName+'</a><ul class="subfolder" id="menu1-ul"></li>';
    p += '</ul>';
    //标头添加派出所
    treebox.prepend(p);
    var ol = '<ol class="breadcrumb" id="breadcrumb1">';
    ol +='<li id="root1">' + statName + '</li>';
    breadcrumb.append(ol);
} 

function clearBread(){
    var root1 = $('#root1');
    root1.nextAll().remove();
}

    // 统计表格

function creatCharts(myChart,data,text) {

    var myChart = echarts.init(document.getElementById(myChart));

    var option = {
        title : {
            text:text,
            textStyle:{
                fontSize: 12
            },
            fontFamily:'微软雅黑',
            left: 20,
            top: 0
        },
        tooltip : {
            trigger: 'item',
            formatter: "{b} : {c} ({d}%)",
            position:'inside'
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data: data,
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };
    myChart.setOption(option);
}

//隐藏与显示详细信息
$("#hide-btn2").click(function(){
    if($("#tab").css("display")=="none"){
        $("#tab").show();
        
        $('.map').removeClass('col-lg-12 col-md-12 col-md-12 col-xs-12').addClass('col-lg-8 col-md-8 col-md-8 col-xs-8');

        $('#hide-btn2').html("隐")
    }else{
        $("#tab").hide();

        $('.map').removeClass('col-lg-8 col-md-8 col-md-8 col-xs-8').addClass('col-lg-12 col-md-12 col-md-12 col-xs-12');

        $('#hide-btn2').html("显");
    }
});

// 显示详细信息(右边的整块)
function showBuildInfo(){
    $("#tab").show();
    $('.map').removeClass('col-lg-12 col-md-12 col-md-12 col-xs-12').addClass('col-lg-8 col-md-8 col-md-8 col-xs-8');
    $('#hide-btn2').html("隐");
}
function hideBuildInfo(){
    $("#tab").hide();
    $('.map').removeClass('col-lg-8 col-md-8 col-md-8 col-xs-8').addClass('col-lg-12 col-md-12 col-md-12 col-xs-12');
     $('#hide-btn2').html("显");
}
// 建筑信息的刷新(右边块里的内容)
function buildInfoHid(){
    $('#floor-change').html('');
    $('#roombox').html('');
    hideRoomInfo();
}

function mult(checkId,checkAllId,ButtonText) {
    var $checkId = $(checkId);
    var $checkAllId = $(checkAllId);
    $checkId.multiselect({
        buttonText: function () {
            return ButtonText;
        },
        onChange: function (option, checked, select){
            var classArray = $checkId.val();
            var p = '';
            
            // 判断当前范围（辖区/小区）
            if($('#root2')){
                var comm_id_my = $('#root2').val();
            }else{
                var comm_id_my = null;
            }

            if($(checked)[0]==true){
                if(classArray){
                    for(var i = 0;i < classArray.length;i++){
                    p += classArray[i];
                }
                    console.log(p);
                    getBuildByroomClass($checkAllId.val(),p,comm_id_my);
                }else{
                    $checkAllId.attr('checked',false);
                }
            }else{
                console.log($checkAllId.val(),$(option).val());
                removeBuildByroomClass($checkAllId.val(),$(option).val(),comm_id_my);
            }
            
            
        }
    });
    $checkAllId.change(function () {
        // 判断当前范围（辖区/小区）
        if($('#root2')){
            var comm_id_my = $('#root2').val();
        }else{
            var comm_id_my = null;
        }
        // console.log(comm_id_my);

        if ($checkAllId.prop('checked')) {
            $checkId.multiselect('selectAll', false);
        }
        else {
            $checkId.multiselect('deselectAll', false);
        }

        var roomClassAll = "";
        $("input:checkbox[name='roomclass']:checked").each(function() {
            roomClassAll += $(this).val();
        });
        getBuildByroomClass(roomClassAll,null,comm_id_my);
        // console.log(roomClassAll);
    });
}

function getCommName(comm_id_my,i){
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
            $('#commName-overdue'+i).html(datas.community.commName);
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}

function getBuildName(buil_id_my,i){
    $.ajax({
        url: '../building/buil_id',
        type: 'POST',
        data: {
            buil_id: buil_id_my,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');

            $('#builName-overdue'+i).html(datas.building.builName);
            if(datas.building.commId){
                getCommName(datas.building.commId,'-'+i+'-'+i)
            }
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}

function getCommName2(comm_id_my,i){
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
            $('#commName-overdue2'+i).html(datas.community.commName);
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}

function getBuildName2(buil_id_my,i){
    $.ajax({
        url: '../building/buil_id',
        type: 'POST',
        data: {
            buil_id: buil_id_my,
        },
        success:function(data){
            // console.log(data);
            var datas = eval('('+data+')');

            $('#builName-overdue2'+i).html(datas.building.builName);
            if(datas.building.commId){
                getCommName2(datas.building.commId,'-'+i+'-'+i)
            }
        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    });
}
//重点行业跳转函数
function focusNum(policeId,commId,builId){
	console.log(policeId);
	console.log(commId);
	console.log(commId != undefined);
	console.log(commId != null);
	console.log(builId);
    
    if(policeId != null && policeId != undefined && policeId != ""){
        var focusUl = $('#informationUl');
       focusUl.html('');
       var p = '';
       var searchAll = $('#serachAll');
       searchAll.html('');
       var p1 = '';
        $.ajax({
        url: '../police/jurisdiction/statistics',
        type: 'POST',
        data: {
           poli_id: policeId,
        },
        success:function(dataStatis){
            // console.log(data);
            var datas = eval('('+dataStatis+')');
            var data = datas.room_subclassify_info;
             p1 += '<a class="btn btn-info" target="_blank" href="informationFocus.html?policeId='+policeId+'">查看全部</a>';
        for(var i=0;i<data.length;i++){
        if(data[i].roomsubclass == "0201"){
            p += '<li>旅馆数:  <a target="_blank" href="informationFocus.html?hotel=0201&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0205"){
            p += '<li>网吧数:  <a target="_blank" href="informationFocus.html?internet=0205&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0412"){
            p += '<li>寄递数:  <a target="_blank" href="informationFocus.html?express=0412&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
           if(data[i].roomsubclass == "0417"){
            p += '<li>浴场数:  <a target="_blank" href="informationFocus.html?bath=0417&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass== "0401"){
            p += '<li>足浴数:  <a target="_blank" href="informationFocus.html?footer=0401&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0204"){
            p += '<li>典当数:  <a target="_blank" href="informationFocus.html?diandang=0204&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0203"){
            p += '<li>刻字刻章数:  <a target="_blank" href="informationFocus.html?kezi=0203&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0202"){
            p += '<li>废旧金属回收数:  <a target="_blank" href="informationFocus.html?feijiu=0202&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0416"){
            p += '<li>图文店数:  <a target="_blank" href="informationFocus.html?tuwen=0416&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0418"){
            p += '<li>加油站数:  <a target="_blank" href="informationFocus.html?jiayou=0418&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0419"){
            p += '<li>五金店数:  <a target="_blank" href="informationFocus.html?wujin=0419&policeId='+policeId+'">'+data[i].num+'</a></li>';
         }
       }
              focusUl.html(p);
              searchAll.html(p1);

        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    }); 
    }
    if(commId != null && commId != undefined && commId != ""){
        var focusUl = $('#informationUl');
       focusUl.html('');
       var p = '';
       var searchAll = $('#serachAll');
       searchAll.html('');
       var p1 = '';
     $.ajax({
        url: '../community/statistics',
        type: 'POST',
        data: {
           comm_id: commId,
        },
        success:function(dataStatis){
            // console.log(data);
            var datas = eval('('+dataStatis+')');
            var data = datas.room_subclassify_info;
           
             p1 += '<a class="btn btn-info" target="_blank" href="informationFocus.html?commId='+commId+'">查看全部</a>';
        for(var i=0;i<data.length;i++){
        if(data[i].roomsubclass == "0201"){
            p += '<li>旅馆数:  <a target="_blank" href="informationFocus.html?hotel=0201&commId='+commId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0205"){
            p += '<li>网吧数:  <a target="_blank" href="informationFocus.html?internet=0205&commId='+commId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0412"){
            p += '<li>寄递数:  <a target="_blank" href="informationFocus.html?express=0412&commId='+commId+'">'+data[i].num+'</a></li>';
         }
           if(data[i].roomsubclass == "0417"){
            p += '<li>浴场数:  <a target="_blank" href="informationFocus.html?bath=0417&commId='+commId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0401"){
            p += '<li>足浴数:  <a target="_blank" href="informationFocus.html?footer=0401&commId='+commId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0204"){
            p += '<li>典当数:  <a target="_blank" href="informationFocus.html?diandang=0204&commId='+commId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0203"){
            p += '<li>刻字刻章数:  <a target="_blank" href="informationFocus.html?kezi=0203&commId='+commId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0202"){
            p += '<li>废旧金属回收数:  <a target="_blank" href="informationFocus.html?feijiu=0202&commId='+commId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0416"){
            p += '<li>图文店数:  <a target="_blank" href="informationFocus.html?tuwen=0416&commId='+commId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0418"){
            p += '<li>加油站数:  <a target="_blank" href="informationFocus.html?jiayou=0418&commId='+commId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0419"){
            p += '<li>五金店数:  <a target="_blank" href="informationFocus.html?wujin=0419&commId='+commId+'">'+data[i].num+'</a></li>';
         }
       }
              focusUl.html(p);
              searchAll.html(p1);

        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    }); 
    }
     if(builId != null && builId != undefined && builId != ""){
           var focusUl = $('#informationUl');
       focusUl.html('');
       var p = '';
       var searchAll = $('#serachAll');
       searchAll.html('');
       var p1 = '';
       $.ajax({
        url: '../building/statistics',
        type: 'POST',
        data: {
           buil_id: builId,
        },
        success:function(dataStatis){
            // console.log(data);
            var datas = eval('('+dataStatis+')');
            var data = datas.room_subclassify_info;
            
             p1 += '<a class="btn btn-info" target="_blank" href="informationFocus.html?builId='+builId+'">查看全部</a>';
        for(var i=0;i<data.length;i++){
        if(data[i].roomsubclass == "0201"){
            p += '<li>旅馆数:  <a target="_blank" href="informationFocus.html?hotel=0201&builId='+builId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0205"){
            p += '<li>网吧数:  <a target="_blank" href="informationFocus.html?internet=0205&builId='+builId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0412"){
            p += '<li>寄递数:  <a target="_blank" href="informationFocus.html?express=0412&builId='+builId+'">'+data[i].num+'</a></li>';
         }
           if(data[i].roomsubclass == "0417"){
            p += '<li>浴场数:  <a target="_blank" href="informationFocus.html?bath=0417&builId='+builId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0401"){
            p += '<li>足浴数:  <a target="_blank" href="informationFocus.html?footer=0401&builId='+builId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0204"){
            p += '<li>典当数:  <a target="_blank" href="informationFocus.html?diandang=0204&builId='+builId+'">'+data[i].num+'</a></li>';
         }
          if(data[i].roomsubclass == "0203"){
            p += '<li>刻字刻章数:  <a target="_blank" href="informationFocus.html?kezi=0203&builId='+builId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0202"){
            p += '<li>废旧金属回收数:  <a target="_blank" href="informationFocus.html?feijiu=0202&builId='+builId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0416"){
            p += '<li>图文店数:  <a target="_blank" href="informationFocus.html?tuwen=0416&builId='+builId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0418"){
            p += '<li>加油站数:  <a target="_blank" href="informationFocus.html?jiayou=0418&builId='+builId+'">'+data[i].num+'</a></li>';
         }
         if(data[i].roomsubclass == "0419"){
            p += '<li>五金店数:  <a target="_blank" href="informationFocus.html?wujin=0419&builId='+builId+'">'+data[i].num+'</a></li>';
         }
       }
              focusUl.html(p);
              searchAll.html(p1);

        },
        error:function(err){
        alert('发生了错误：'+err.status);
        console.table(err);
        }
    }); 
    }
           
}
//重点人员跳转函数
function focusNum1(policeId,commId,builId){
	console.log(policeId);
	console.log(commId);
	console.log(builId);
	console.log(policeId != null);
	console.log(policeId != undefined);
	console.log(builId == "");
	console.log(policeId != null && policeId != undefined && policeId != "" && commId =="" && builId == "");
     
    if(policeId != null && policeId != undefined && policeId != "" && commId =="" && builId == ""){
    	 var focusUl = $('#informationPersonUl');
         focusUl.html('');
         var p = '';
         var searchAll = $('#serachPersonAll');
         searchAll.html('');
         var p1 = '';
           $.ajax({
        url:'../person/searchSize.do',
        type:'POST',
        data:{poli_id:policeId,focus_level:1},
        success:function(data){
           console.log(data);
           console.log(p);
            if(data == 0){
                p += '<li>一级关注人员数:  <a>'+data+'</a></li>'; 
            }else{
            	console.log(data);
                 p += '<li>一级关注人员数:  <a target="_blank" href="informationPerson.html?level=1&policeId='+policeId+'">'+data+'</a></li>'; 
            }
            console.log(p);
            $.ajax({
                url:'../person/searchSize.do',
                type:'POST',
               data:{poli_id:policeId,focus_level:2},
                success:function(data1){
                    if(data1 == 0){
                        p += '<li>二级关注人员数:  <a>'+data1+'</a></li>'; 
                    }else{
                         p += '<li>二级关注人员数:  <a target="_blank" href="informationPerson.html?level=2&policeId='+policeId+'">'+data1+'</a></li>'; 
                    }
                    console.log(p);
                    $.ajax({
                        url:'../person/searchSize.do',
                        type:'POST',
                       data:{poli_id:policeId,focus_level:3},
                        success:function(data2){
                            if(data2 == 0){
                                p += '<li>三级关注人员数:  <a>'+data2+'</a></li>'; 
                            }else{
                                 p += '<li>三级关注人员数: <a target="_blank" href="informationPerson.html?level=3&policeId='+policeId+'">'+data2+'</a></li>'; 
                            }
                            console.log(p);
                            focusUl.html(p);
                        },
                        error:function(err){
                            alert('发生了错误：'+err.status);
                            console.table(err);
                        }
                    });
                },
                error:function(err){
                    alert('发生了错误：'+err.status);
                    console.table(err);
                }
            });
        
        },
        error:function(err){
            alert('发生了错误：'+err.status);
            console.table(err);
        }
    });
        
     
     console.log(p);
      p1 += '<a class="btn btn-info" target="_blank" href="informationPerson.html?focus=1&policeId='+policeId+'">查看全部</a>';
      searchAll.html(p1);
    }
     if(commId != null && commId != undefined && commId != "" && builId == ""){
    	 var focusUl = $('#informationPersonUl');
         focusUl.html('');
         var p = '';
         var searchAll = $('#serachPersonAll');
         searchAll.html('');
         var p1 = '';
        $.ajax({
        url:'../person/searchSize.do',
        type:'POST',
        data:{poli_id:policeId,comm_id:commId,focus_level:1},
        success:function(data){
            if(data == 0){
                p += '<li>一级关注人员数:  <a>'+data+'</a></li>'; 
            }else{
                 p += '<li>一级关注人员数:  <a target="_blank" href="informationPerson.html?level=1&commId='+commId+'">'+data+'</a></li>'; 
            }
            $.ajax({
                url:'../person/searchSize.do',
                type:'POST',
               data:{poli_id:policeId,comm_id:commId,focus_level:2},
                success:function(data1){
                    if(data1 == 0){
                        p += '<li>二级关注人员数:  <a>'+data1+'</a></li>'; 
                    }else{
                         p += '<li>二级关注人员数:  <a target="_blank" href="informationPerson.html?level=2&commId='+commId+'">'+data1+'</a></li>'; 
                    }
                    $.ajax({
                        url:'../person/searchSize.do',
                        type:'POST',
                       data:{poli_id:policeId,comm_id:commId,focus_level:3},
                        success:function(data2){
                            if(data2 == 0){
                                p += '<li>三级关注人员数:  <a>'+data2+'</a></li>'; 
                            }else{
                                 p += '<li>三级关注人员数:  <a target="_blank" href="informationPerson.html?level=3&commId='+commId+'">'+data2+'</a></li>'; 
                            }
                            focusUl.html(p);
                        },
                        error:function(err){
                            alert('发生了错误：'+err.status);
                            console.table(err);
                        }
                    });
                },
                error:function(err){
                    alert('发生了错误：'+err.status);
                    console.table(err);
                }
            });
        
        },
        error:function(err){
            alert('发生了错误：'+err.status);
            console.table(err);
        }
    });
       
    
      p1 += '<a class="btn btn-info" target="_blank" href="informationPerson.html?focus=1&commId='+commId+'">查看全部</a>';
      searchAll.html(p1);
    }
     if(builId != null && builId != undefined &&  builId != ""){
    	 var focusUl = $('#informationPersonUl');
         focusUl.html('');
         var p = '';
         var searchAll = $('#serachPersonAll');
         searchAll.html('');
         var p1 = '';
      $.ajax({
        url:'../person/searchSize.do',
        type:'POST',
        data:{poli_id:policeId,buil_id:builId,focus_level:1},
        success:function(data){
            if(data == 0){
                p += '<li>一级关注人员数:  <a>'+data+'</a></li>'; 
            }else{
                 p += '<li>一级关注人员数:  <a target="_blank" href="informationPerson.html?level=1&builId='+builId+'">'+data+'</a></li>'; 
            }
            $.ajax({
                url:'../person/searchSize.do',
                type:'POST',
               data:{poli_id:policeId,buil_id:builId,focus_level:2},
                success:function(data1){
                    if(data1 == 0){
                        p += '<li>二级关注人员数:  <a>'+data1+'</a></li>'; 
                    }else{
                         p += '<li>二级关注人员数:  <a target="_blank" href="informationPerson.html?level=2&builId='+builId+'">'+data1+'</a></li>'; 
                    }
                    $.ajax({
                        url:'../person/searchSize.do',
                        type:'POST',
                       data:{poli_id:policeId,buil_id:builId,focus_level:3},
                        success:function(data2){
                            if(data2 == 0){
                                p += '<li>三级关注人员数:  <a>'+data2+'</a></li>'; 
                            }else{
                                 p += '<li>三级关注人员数:  <a target="_blank" href="informationPerson.html?level=3&builId='+builId+'">'+data2+'</a></li>'; 
                            }
                            focusUl.html(p);
                        },
                        error:function(err){
                            alert('发生了错误：'+err.status);
                            console.table(err);
                        }
                    });
                },
                error:function(err){
                    alert('发生了错误：'+err.status);
                    console.table(err);
                }
            });
        
        },
        error:function(err){
            alert('发生了错误：'+err.status);
            console.table(err);
        }
    });
        
     
     p1 += '<a class="btn btn-info" target="_blank" href="informationPerson.html?focus=1&builId='+builId+'">查看全部</a>';
      
      searchAll.html(p1);
    }
  


}

