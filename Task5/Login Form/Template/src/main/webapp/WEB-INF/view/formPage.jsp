<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body background="${pageContext.request.contextPath}/resources/images/background.jpg">
        <form action="processForm">
            <label>First Name</label> <br>
            <input type="text" placeholder="Enter First Name" name="first_name"> <br>
            <label>Last Name</label> <br>
            <input type="text" placeholder="Enter Last Name" name="last_name"><br>
            <label>Email Address</label><br>
            <input type="text" placeholder="Enter email" name="email_address"><br>
            <label>Date of Birth</label> <br>
            <input type="date" placeholder="DD-MM-YYYY" name="data_of_birth"><br>
            <label>City</label><br>
            <input type="text" placeholder="Enter city" name="city"><br>
            <input type="submit" class="btn btn-danger"> <br>
        </form>
    </body>
</html>