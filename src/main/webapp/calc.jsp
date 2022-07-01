<%--
  Created by IntelliJ IDEA.
  User: пк
  Date: 03.11.2021
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<form action="/calc" method="post">
<input type="text" name="num1" placeholder="Num 1">
<input type="text" name="num2" placeholder="Num 2"><br/>
Select the operation:<br/>
<input type="radio" name="operation" value="add">Addition
<input type="radio" name="operation" value="sub">Subtraction
<input type="radio" name="operation" value="mul">Multiplication
<input type="radio" name="operation" value="div">Division
</br>
    <button>Submit</button>
    <button>Reset</button>
</form>
<p>Result = ${requestScope.result}</p>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>
