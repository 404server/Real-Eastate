<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/admin.css"/>
</head>
<body>

<%@ include file="../components/navbar.jsp" %>


<main>
    <div class="container pt-5">
        <div class="d-flex">
            <!-- Sidebar -->
            <aside class="sidebar-admin pe-md-3">
                <ul>
                    <li>
                        <a href="<%= request.getContextPath() %>/admin"><i class="fa-solid fa-gauge-high"></i> Dashboard</a>
                    </li>
                    <li class="active-page">
                        <a href="<%= request.getContextPath() %>/admin/car-management"><i class="fa-solid fa-car"></i>
                            House Management</a>
                    </li>
                </ul>
            </aside>

            <div class="content-wrapper">

                <h2 class="fw-bold mb-3">House List</h2>
                <div class="table-responsive-md">
                    <table class="table table-striped">
                        <!-- Head -->
                        <thead>
                        <tr>
                            <th>House Id</th>
                            <th>Type</th>
                            <th>DEscription</th>
                            <th>Year</th>
                            <th>Price</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                        </thead>
                        <!-- Body -->
                        <tbody>
                        <c:forEach items="${listHouse}" var="house">
                            <tr>
                                <td>${house.idHouse}</td>
                                <td>${house.type}</td>
                                <td>${house.desc}</td>
                                <td>${house.year}</td>
                                <td>${house.price}</td>
                                <c:if test="${house.status.equals('ACTIVE')}">
                                    <td class="fw-semibold text-primary">${house.status}</td>
                                </c:if>
                                <c:if test="${house.status.equals('DEACTIVE')}">
                                    <td class="fw-semibold text-danger">${house.status}</td>
                                </c:if>
                                <c:if test="${house.status.equals('SOLD')}">
                                    <td class="fw-semibold text-success">${house.status}</td>
                                </c:if>
                                <c:if test="${!house.status.equals('SOLD')}">
                                    <td>
                                        <div class="dropdown">
                                            <button class="btn btn-warning dropdown-toggle" type="button"
                                                    data-bs-toggle="dropdown" aria-expanded="false"><i
                                                    class="fa-regular fa-pen-to-square"></i></button>
                                            <ul class="dropdown-menu dropdown-menu-dark">
                                                <c:if test="${house.status.equals('ACTIVE')}">
                                                    <li>
                                                        <a class="dropdown-item"
                                                           href="<%= request.getContextPath() %>/admin/deactivate/${house.idHouse}">Deactivate
                                                            House Post</a>
                                                    </li>
                                                </c:if>
                                                <c:if test="${house.status.equals('DEACTIVE')}">
                                                    <li>
                                                        <a class="dropdown-item"
                                                           href="<%= request.getContextPath() %>/admin/activate/${house.idHouse}">Activate
                                                            House Post</a>
                                                    </li>
                                                </c:if>
                                            </ul>
                                        </div>
                                    </td>
                                </c:if>
                                <c:if test="${house.status.equals('SOLD')}">
                                    <td></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>

                <h2 class="fw-bold mb-3 mt-5">House Bid</h2>
                <div class="table-responsive-md">
                    <table class="table table-striped">

                        <thead>
                        <tr>
                            <th>House Id</th>
                            <th>Type</th>
                            <th>Info</th>
                            <th>Year</th>
                            <th>Status</th>
                            <th></th>
                        </tr>
                        </thead>

                    </table>
                </div>

            </div>
        </div>
    </div>
</main>

</body>
</html>
