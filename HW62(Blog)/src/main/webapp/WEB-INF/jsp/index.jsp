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

            <h1 class="my-4">Page Heading
                <small>Secondary Text</small>
            </h1>
            <!-- Blog post -->

            <div class="card mb-4">
                <img class="card-img-top" src="http://placehold.it/750x300" alt="Card image cap">
                <c:forEach items="${posts}" var="post">
                    <% //for (Post post : posts) { %>
                    <div class="card-body">
                        <h2 class="card-title">${post.getTitle()}</h2>
                        <p class="card-text"> ${post.getContent()}</p>
                        <a href="<%=request.getContextPath()%>/post" class="btn btn-primary">Read More &rarr;</a>
                    </div>
                    <div class="card-footer text-muted">
                            ${post.getPublished()} by
                        <a href="<%=request.getContextPath()%>/"> ${post.getAuthor()}</a>
                    </div>
                </c:forEach>
            </div>


            <!-- Pagination -->
            <ul class="pagination justify-content-center mb-4">
                <li class="page-item">
                    <a class="page-link" href="<%=request.getContextPath()%>/">&larr; Older</a>
                </li>
                <li class="page-item disabled">
                    <a class="page-link" href="<%=request.getContextPath()%>/">Newer &rarr;</a>
                </li>
            </ul>

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

