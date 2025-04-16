<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
</head>
<body>
    <h2>Login Form</h2>
    <form action="LoginServlet" method="POST">
        <label for="username">Username: </label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password: </label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Login">
        <br>
	 <!-- Link to the signup page -->
    <a href="Signup.jsp">Don't have an account? Sign up here</a>
	
    </form>
</body>
</html>
