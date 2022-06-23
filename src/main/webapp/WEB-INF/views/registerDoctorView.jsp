<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Register</title>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>

<h3>Doctor Register Page</h3>
<p style="color: red;">${errorString}</p>


<form method="POST" action="${pageContext.request.contextPath}/registerDoctor">
  <table border="0">
    <tr>
      <td>Name</td>
      <td><input type="text" name="name"/> </td>
    </tr>
    <tr>
      <td>Category</td>
      <td><input type="text" name="category"/> </td>
    </tr>
    <tr>
      <td>Password</td>
      <td><input type="text" name="password"/> </td>
    </tr>
    <tr>
      <td colspan ="2">
        <input type="submit" value= "Submit" />
        <a href="${pageContext.request.contextPath}/">Cancel</a>
      </td>
    </tr>
  </table>
</form>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>