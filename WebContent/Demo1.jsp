<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function ajaxFunction() {
		var xmlHttp;
		try { // Firefox, Opera 8.0+, Safari
			xmlHttp = new XMLHttpRequest();
		} catch (e) {
			try {// Internet Explorer
				xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
				}
			}
		}

		return xmlHttp;
	}

	 //执行get请求
	function get() {
		//创建xmlhttprequest对象
		var request = ajaxFunction();
		//发送请求
		//	 请求类型：get或者post  服务器上的位置                异步ture同步flase
		request.open("GET","/ajax/Demo1Servlet?name=aa&&age=18",true);
		//获取响应数据。相当于注册监听的意思，当准备的状态发生了改变，就执行=右边的方法
		request.onreadystatechange = function() {
			//4代表请求已完成，且已响应就绪 200代表OK 404代表未找到页面
			if(request.readyState == 4 && request.status == 200){
				//弹出响应的信息
				alert(request.responseText);
			}
		}
		request.send();
	} 
	//执行get请求
	
</script>
</head>
<body>
     <h3><a href="" onclick="get()">使用ajax发送一个请求</a></h3>
</body>
</html>