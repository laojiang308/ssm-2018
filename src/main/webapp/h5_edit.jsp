<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8">
<title>Demo</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
<!-- 引入jQuery -->
<script src="static/eleditor/jquery.min.js"></script>
<!-- 引入百度上传插件 -->
<script src="static/eleditor/webuploader.min.js"></script>
<!-- 插件核心 -->
<script src="static/eleditor/Eleditor.js"></script>
<style>
* {
	margin: 0;
	padding: 0;
}

#article-body {
	width: 100%;
	min-height: 300px;
	box-sizing: border-box;
	padding: 10px;
	color: #444;
}
</style>
</head>
<body>

	<!-- 内容编辑区域 -->
	<div id="article-body"></div>
	<div>
		
	</div>

	<script>
		/*实例化一个编辑器*/
		var artEditor = new Eleditor({
			el : '#article-body',
			upload : {
				server : 'upload/h5_upload',
				fileSizeLimit : 2
			}
		});
	</script>

</body>
</html>