<%@page contentType="text/html; charset=UTF-8" %>
<html>
	<head>
		<title>发送邮件</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath }/servlet/ShowSucServlet" method="post">
			<hr/>
			邮箱:<input type="text" name="email" value="${formbean.email }">${formbean.errors.email }
			<hr/>
			标题:<input type="text" name="title" value="${formbean.title }">${formbean.errors.title }
			<hr/>
			内容:<input type="text" name="essay" value="${formbean.essay }">${formbean.errors.essay }
			<hr/>
			<input type="submit" value="提交">
			<hr/>
			<input type="reset" value="重置">
			<hr/>
		</form>
		${u }
	</body>
</html>