<html>
    <head>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">

        <%--        import Bootstrap--%>
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">

    </head>
    <body background="${pageContext.request.contextPath}/resources/images/background.jpg">
        <form action="processForm">
            <input type="text" placeholder="Enter Name" name="name"> <br>
            <input type="password" name="password"><br>
            <select name="country" class="form-control" style="width: 12%;">
                <option value="Egypt">Egypt</option>
                <option value="USA">USA</option>
                <option value="Germany">Germany</option>
            </select>
            <label> Preferred Programming Language </label><br>
            <input type="radio" name="language" value="Java" checked> Java
            <input type="radio" name="language" value="C#"> C#
            <input type="radio" name="language" value="PHP"> PHP
            <input type="radio" name="language" value="Ruby"> Ruby <br>

            <label>Preferred Operating System</label><br>
            <input type="checkbox" name="os" value="Linux" checked> Linux
            <input type="checkbox" name="os" value="Mac OS" checked> Mac OS
            <input type="checkbox" name="os" value="MS Windows"> MS Windows
            <br>
            <input type="submit" class="btn btn-danger"> <br>
        </form>
    </body>
</html>