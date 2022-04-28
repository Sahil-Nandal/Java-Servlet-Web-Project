<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        body {
            margin: 80px;
            background-color: rgba(28, 28, 28, 0.598);
        }

        h1 {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif\;

        }

        input {
            margin: 5px;
            padding: 2px;
        }

        button {
            margin-top: 20px;
            padding: 5px;
            width: 150px;
            border-radius: 3px;
            border: 1px solid black;

        }
        .parent{
            display: flex;
        }

        .get{
            width: 50%;
            border: 2px solid rgb(225, 225, 225);
            margin: 20px;
            border-radius: 10px;
            padding: 20px;
            background-color: rgb(225, 225, 225);
        }

        .post{
            width: 50%;
            border: 2px solid rgb(225, 225, 225);
            margin: 20px;
            border-radius: 10px;
            padding: 20px;
            background-color: rgb(225, 225, 225);
        }
    </style>

</head>
<br/>
<a href="hello-servlet">Hello Servlet</a>

<h1 align="center"> <u>  Books' Wishlist for 2022-23 </u> </h1>

<div class="parent">

    <div class="post">


        <form name="libform" action="hello-servlet" method="post" onsubmit="return validateForm()">
            <table>
                <tr>
                    <td>
                        Student Reg. No.:
                    </td>
                    <td>
                        <input type="text" name="id" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Name:
                    </td>
                    <td>
                        <input type="text" name="name" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Name of the Book:
                    </td>
                    <td>
                        <input type="text" name="book_name" required>
                    </td>
                </tr>
                <tr>
                    <td>
                        Author of the book:
                    </td>
                    <td>
                        <input type="text" name="author">
                    </td>
                </tr>
                <tr>
                    <td>
                        Niche of the book:
                    </td>
                    <td>
                        <input type="text" name="niche">
                    </td>
                </tr>
            </table>
            <button type="submit">Submit</button>
        </form>

        <form action="deleteser" method="get">
            <h3>To Delete your choice: </h3>
            Enter your registration number: <input type="text" name="regno">
            <button style="margin-top: 2px;" type="submit">Delete!</button>

        </form>

    </div>

    <div class="get">


        <form action="displayservlet" method="get">
            <h3>To see the details of the students and their books' wishlist: </h3>
            <button style="margin-top: 2px;" type="submit">Display the Wishlist</button>

        </form>

        <form action="booksservlet" method="get">
            <h3>To see the details of the Books Only: </h3>
            <button style="margin-top: 2px;" type="submit">Display the Books</button>

        </form>


    </div>
</div>

<script>
    function validateForm() {
        let reg=/^[0-9]{2}[A-Z]{3}[0-9]{4}$/;
        let x = document.forms["libform"]["id"].value;
        if (!reg.test(x)) {
            alert("Enter valid Reg. No.");
            return false;
        }
        // else if(x.length!=9){
        //     alert("Enter valid Reg. No.");
        //     return false;
        // }

    }
</script>
</body>
</html>
