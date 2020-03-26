function schedual_report()
{
	var myChart = null;
	var barColorPool = ["#27E288","#FFB575","#3199DD"];
	
	this.init=function()
	{
		if(myChart == null){
			myChart = echarts.init(document.getElementById('histogramDiv'));
		}
		myChart.showLoading();
		$.ajax({
			type: 'GET',
			//url : "http://192.168.168.168/plat/andtv/checkLogin?mobile_no=13713917858&&passwd=1828",
			url : "https://m.danfoo.com/plat/andtv/schedualReport?token=b6cb6f0aa97c30681f1c2cb14f9afbd6",
			async : false,
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			success : function(data) {
				
				if(data.code=="OK")
				{ 
					schedual_report.getData(data.data);
					myChart.hideLoading();
				}

			},
			error : function() {
				//alert('error');
			}
		}); 
	}
	
	this.getData=function(data)
	{
		schedual_report.schedualList(data);
		schedual_report.schedualPie(data);
		schedual_report.schedualHistogram(data);
		
		
	}
	this.schedualList = function(data)
	{
		if(data.machineSchedualList!=null)
		{
			$(".tab_c").html("");
			var tab_cent_html="";
			$.each(data.machineSchedualList,function(i,o){
				var schedule_name=o.schedule_name;
				var current_process_count=o.current_process_count;
				var current_cutting_time=(o.current_cutting_time/60).toFixed(2);
				var rate=o.rate;
				var alarm_state_count=o.alarm_state_count;
				
				tab_cent_html	+=	"<tr class=tab_cent>";
				tab_cent_html	+=		"<td>"+schedule_name+"</td>";
				tab_cent_html	+=		"<td>"+current_process_count+"</td>";
				tab_cent_html	+=		"<td>"+current_cutting_time+"</td>";
				tab_cent_html	+=		"<td>"+alarm_state_count+"</td>";
				tab_cent_html	+=	"</tr>" ;
				
			})
			
			var tab_title="<tr class='tab_title'>"+
								"<th>班次</th>"+
								"<th>产量（件）</th>"+
								"<th>加工时间（H）</th>"+
								"<th>告警次数</th>"+
						  "</tr>";

			var process_count_total=data.process_count_total;
			var current_cutting_time=(data.current_cutting_time/60).toFixed(2);
			var alarm_state_count_total=data.alarm_state_count_total;
			var rate=data.rate;
					  
			var tab_total="<tr class='tab_cent'>"+
								"<td>合计</td>"+
								"<td>"+process_count_total+"</td>"+
								"<td>"+current_cutting_time+"</td>"+
								"<td>"+alarm_state_count_total+"</td>"+
						  "</tr>";
                        
			$(".tab_c").html(tab_title+tab_cent_html+tab_total);
			
			
		}
	}
	
	this.schedualPie=function(data)
	{
	 
		if(data.machineSchedualList!=null)
		{
			var pieDiv = document.getElementById("pieDiv");
			var radius = '50%';
			$.each(data.machineSchedualList,function(i,o){
			 
				var schedule_name = o.schedule_name;
				//运行时间
				var yx_time = o.yx_time;
				yx_time = parseFloat((yx_time/60).toFixed(2));
				//待机时间
				var dj_time = o.current_dj_time;
				dj_time = parseFloat((dj_time/60).toFixed(2));
				//告警时间
				var bj_time = o.current_bj_time;
				bj_time = parseFloat((bj_time/60).toFixed(2));
				
				var index = i + 1;
				var newDivId = "main_" + index;
				var pieChartDiv = document.getElementById(newDivId);
				if(pieChartDiv==undefined || pieChartDiv==null)
				{
					radius=(100/data.machineSchedualList.length)+"%";
					var cssText="width: "+radius+";height: 100%;float: left;margin-top: 10px;";
					pieChartDiv = document.createElement("div");
					pieChartDiv.id = newDivId;
					pieChartDiv.style.cssText=cssText;
					pieDiv.appendChild(pieChartDiv);
				}
				
				var pieChart = echarts.init(document.getElementById(newDivId));
				var option = {
								title : {
									text: schedule_name,
									x:'center',
									textStyle:{		        
										 color:'#65fbf6',				         
										 fontStyle:'normal',
										 fontWeight:'bold',
										 fontSize:15      
									}
								},
								tooltip : {
									trigger: 'item',
									formatter: "{a} <br/>{b} : {c}H ({d}%)"
								},
								series : [
									{
										name: schedule_name,
										type: 'pie',
										radius : radius,
										center: ['50%', '40%'],
										data:[
											 {value:yx_time, name:'运行时间',selected:false,itemStyle:{color:'#22b780'}},
											 {value:dj_time, name:'待机时间',selected:false,itemStyle:{color:'#f6d422'}},
											 {value:bj_time, name:'告警时间',selected:false,itemStyle:{color:'red'}}
										],
										label: {
											normal: {
												show: true,
												position: 'inside',
												formatter:'{d}%'
											}
										}
									}
								]
							};
	 
							pieChart.setOption(option);

			})
		}
    }
	
	
	this.schedualHistogram=function(data)
	{
		if(data.machineSchedualList!=null)
		{
			var data_t=[],data_n=[],color_key=[],schedualNameList=[];
			var tooltipArr = [];
			var index=0;
			$.each(data.machineSchedualList,function(i,o){
			   	var count_json = o.count_json;
				schedualNameList.push(o.schedule_name);
				count_json = eval('(' + count_json + ')');
				$.each(count_json,function(key,z){
					
					data_t.push(key);
					var item = eval('(' + count_json[key] + ')');
					var val = item.current_process_count;
					data_n.push(val);
					color_key.push(index);
					var tarr = key.split(":");
					if(tarr[1]=="30")
						tooltipArr.push(tarr[0]+":"+"00"+"~"+key);
					else if(tarr[1]=="00"){
						if(tarr[0]=="0"||tarr[0]=="00"){
							tooltipArr.push("23"+":"+"30"+"~"+key);
						}else{
							var startHour = parseInt(tarr[0]);
							startHour=startHour-1;
							tooltipArr.push(startHour+":"+"30"+"~"+key);
						}
					}else{
						tooltipArr.push(key);
					}
				})
				index++;
			})
			var graphicItem = schedual_report.echartsGraph(schedualNameList,data.machineSchedualList.length,15,65);
			var barWidth="60%";
			if(data_t.length<=5){
				barWidth="30%";
			}
			debugger;
			var option = {
					graphic: graphicItem,
					tooltip : {
						trigger: 'axis',
						axisPointer : {            
							type : 'shadow'
						},
						formatter:function(params){
		
							var index = params[0].dataIndex;
							var htmlStr = tooltipArr[index];
							
							var value = params[0].value;//y轴值
							var color = params[0].color;//图例颜色
						 
							var seriesName = params[0].seriesName;
							htmlStr += '<div>';
							
							htmlStr += '<span style="margin-right:5px;display:inline-block;width:10px;height:10px;border-radius:5px;background-color:'+color+';"></span>';
							//圆点后面显示的文本
							htmlStr += seriesName + '：' + value;
							htmlStr += '</div>';
							return htmlStr;
						}		        	
						
					},
					grid: {
						left: '3%',
						right: '4%',
						bottom: '3%',
						containLabel: true
					},
					xAxis : [
						{
							type : 'category',
							data:data_t,
							axisTick: {
								alignWithLabel: true
							},
							 axisLine: {
								lineStyle: {
									color: '#a6a6a6',
									width: 1
								}
							}
						}
					],
					yAxis : [
						{
							type : 'value',
							splitLine:{show: false,
								lineStyle:{
									type:'dashed',
									color:'#a6a6a6'
								}
							},
							 axisLine: {
								lineStyle: {
									color: '#a6a6a6',
									width: 1
								}
							}
						}
					],
					series :
						 [
						{
							name:'产量(件)',
							type:'bar',
							barWidth: barWidth,
							data: data_n,    	
							color:function(params){
								var index = params.dataIndex;
								return barColorPool[color_key[index]%(barColorPool.length)];
							}
						}
					]
				};
			myChart.clear();
			myChart.setOption(option);
		}
	}
	
   this.echartsGraph=function(nameList,itemCount,graphwidth,childrenGap){
	var children=[];
	for(var i=0;i<itemCount;i++){
		var shape = {	           
			  type: 'rect',
	          left: 15+i*childrenGap, 
	          top: 0,  
	          shape: {
	              width: graphwidth,
	              height: graphwidth
	          },
	          style: {
	                fill: barColorPool[i%barColorPool.length],
	          }
	    };
		var text = {
	          type: 'text',
	          left: 35+i*childrenGap, 
	          top: 0,
	          style: {
	              fill: barColorPool[i%barColorPool.length],
	              text:nameList[i],				                
	              font:'14px Microsoft YaHei'
	          }
		};
		children.push(shape);
		children.push(text);
	}
	return {
		type: 'group',
        top:35,
		right:50,
		children:children
	}
}
	
}
var  schedual_report = new schedual_report();