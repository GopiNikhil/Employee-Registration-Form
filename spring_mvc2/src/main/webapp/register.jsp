<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
    <title>Registration Form</title>
    <style>
        .form-container {
            width: 500px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="tel"],
        input[type="password"],
        textarea {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body >
    <div class="form-container">
        <form action="save">
        	<h1>REGISTRATION-FORM</h1>
            <label for="name">Name</label>
            <input type="text" id="name" name="name" required>

            <label for="email">Email</label>
            <input type="email" id="email" name="email" required>

            <label for="phone">Phone</label>
            <input type="tel" id="phone" name="phone" required>

            
            <label for="password">Password</label>
            <input type="password" id="password" name="pwd" required>

            <input type="submit" value="Register">
        </form>
    </div>
</body>
</html>