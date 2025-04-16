<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup Page</title>
</head>
<body>
    <h2>Signup Form</h2>
    <form action="SignupServlet" method="POST">
    
    <label for="username">Username: </label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="password">Password: </label>
        <input type="password" id="password" name="password" required><br><br>

        <label for="email">Email: </label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="phoneNumber">Phone Number: </label>
        <input type="text" id="phoneNumber" name="phoneNumber" required><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
    