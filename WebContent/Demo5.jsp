<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
//text() - 设置或返回所选元素的文本内容 
//html() - 设置或返回所选元素的内容（包括 HTML 标记） 
//val() - 设置或返回表单字段的值 
	function get() {
		 $.get("/ajax/Demo1Servlet",function(data,status){
			    alert("Data: " + data);
				//$("#div01").val(); //val  用于设置 元素里面有values 的属性值 
				//$("#div01").html(data);
				//$("#div01").val(data);
				$("#div01").html("aaa="+data);
				//$("#div01").text(data); // <font>
		 });
	}

</script>
</head>
<body>
	<h3><input type="button" onclick="get()" value="使用JQuery展示get方法"></h3>
	<div id="div01" style="width:100px ; hegiht:100px;border:1px solid red;">
	</div>
</body>
</html>