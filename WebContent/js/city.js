$(function() {
	//找省份
	$("#province").change(function() {
		var pid = $(this).val();
		
		$.post("/ajax/FindCityServlet",{pid:pid},function(data,status){
//            alert("回来数据了:"+data);
			
			/*//先清空以前的值：
			$("#city").html("<option value='' >-请选择-")
			//遍历： 
			//从data数据里面找出所有的city  ， 然后遍历所有的city。
			//遍历一个city，就执行一次function方法
			$(data).find("city").each(function() {

				// 遍历出来的每一个city，取它的孩子。 id , cname
				var id = $(this).children("id").text();
				var cname = $(this).children("name").text();
				//将元素放入option
				$("#city").append("<option value='" + id + "' >" + name)
			});*/
            $("#city").html("<option value='' >-请选择-")
            $(data).find("city").each(function(){
            	var id = $(this).children("id").text();
            	var name = $(this).children("name").text();
            	
            	$("#city").append("<option value='"+id+"'>"+name)
            	alert(id+"----"+name);
            });
		});
	});
	
});