$(function() {
	$("#province").change(function() {
		var pid = $(this).val();
		

		$.post("CityServlet02", {
			pid : pid
		}, function(data, status) {

			// 先清空
			$("#city").html("<option value='' >-请选择-");
			// 再遍历，追加
			$(data).each(function(index, c) {
				$("#city").append("<option value='" + c.id + "' >" + c.name)
			});
		}, "json");
	});
});