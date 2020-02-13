<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <c:import url="include/header.jsp"/>
</head>

<body>

<!-- Navigation -->
<c:import url="include/navigation.jsp"/>


<!-- Page Content -->
<div class="container">

    <div class="row">

        <!-- Blog Entries Column -->
        <div class="col-md-8">

            <h1 class="my-4">Edit post</h1>

            <div class="card mb-4">
                <form method="post" style="margin: 15px">
                    <label>
                        ID:<input type="text" name="id" style="margin:3px"/>
                    </label><br/>
                    <label>
                        Title:<input type="text" name="title" style="margin:3px"/>
                    </label><br/>
                    <label>
                        Author:<input type="text" name="author" style="margin:3px"/>
                    </label><br/>
                    <label>
                        Content:<br/>
                        <textarea style="margin:3px;padding:10px" name="content"></textarea>
                    </label><br/>
                    <button type="submit">Edit</button>
                </form>
            </div>
        </div>

        <!-- Sidebar Widgets Column -->
        <div class="col-md-4">

            <!-- Admin panel -->
            <c:import url="include/adminPannel.jsp"/>

            <!-- Search Widget -->
            <c:import url="include/searchWidget.jsp"/>

            <!-- Categories Widget -->
            <c:import url="include/categoriesWidget.jsp"/>

            <!-- Side Widget -->
            <c:import url="include/sideWidget.jsp"/>

        </div>

    </div>
    <!-- /.row -->

</div>
<!-- /.container -->

<!-- Footer -->
<c:import url="include/footer.jsp"/>

<!-- Bootstrap core JavaScript -->
<script src="../../Static/vendor/jquery/jquery.min.js"></script>
<script src="../../Static/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>


