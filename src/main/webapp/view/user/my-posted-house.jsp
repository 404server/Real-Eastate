<%@ include file="../components/taglib.jsp" %> <%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/user.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="../components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container pt-5">
        <div class="d-flex">
          <!-- Sidebar -->
          <aside class="sidebar-user pe-md-3">
            <ul>
              <li>
                <a href="<%= request.getContextPath() %>/user"><i class="fa-solid fa-user"></i> Profile</a>
              </li>
              <li class="active-page">
                <a href="<%= request.getContextPath() %>/user/my-posted-house"><i class="fa-solid fa-house"></i> My Posted House</a>
              </li>
            </ul>
          </aside>

          <!-- Content -->
          <div class="content-wrapper">
            <h2 class="fw-bold mb-3">Posted Houses</h2>
            <!-- Table -->
            <c:if test="${!userHouse.isEmpty()}">
              <div class="table-responsive-md">
                <table class="table table-striped">
                  <!-- Head -->
                  <thead>
                    <tr>
                      <th>Id House</th>
                      <th>Type</th>
                      <th>Info</th>
                      <th>Year</th>
                      <th>Price</th>
                      <th>Status</th>
                      <th></th>
                    </tr>
                  </thead>
                  <!-- Body -->
                  <tbody>
                    <c:forEach items="${userHouse}" var="house">
                      <tr>
                        <td>${house.idHouse}</td>
                        <td>${house.type}</td>
                        <td>${house.info}</td>
                        <td>${house.year}</td>
                        <td>$${house.price}</td>
                        <c:if test="${house.status.equals('ACTIVE')}">
                          <td class="fw-semibold text-primary">${house.status}</td>
                        </c:if>
                        <c:if test="${house.status.equals('DEACTIVE')}">
                          <td class="fw-semibold text-danger">${house.status}</td>
                        </c:if>
                        <c:if test="${house.status.equals('SOLD')}">
                          <td class="fw-semibold text-success">${house.status}</td>
                        </c:if>
                        <c:if test="${house.status.equals('SOLD')}">
                          <td></td>
                        </c:if>
                        <c:if test="${!house.status.equals('SOLD')}">
                          <td>
                            <div>
                              <a class="btn btn-link" href="<%= request.getContextPath() %>/houses/${house.type}/${house.info}/${house.year}/${house.idHouse}">House Details</a>
                              <a class="btn btn-link" href="<%= request.getContextPath() %>/user/edit-posted-house?id=${house.idHouse}">Edit Details</a>
                              <a class="btn btn-link" href="<%= request.getContextPath() %>/user/upload-house-picture?idCar=${house.idHouse}">Edit Picture</a>
                              <c:if test="${house.status.equals('ACTIVE')}">
                                <a class="btn btn-link" href="<%= request.getContextPath() %>/user/deactivate/${house.idHouse}">Deactivate Post</a>
                              </c:if>
                              <c:if test="${house.status.equals('DEACTIVE')}">
                                <a class="btn btn-link" href="<%= request.getContextPath() %>/user/activate/${house.idHouse}">Activate Post</a>
                              </c:if>
                            </div>

                          </td>
                        </c:if>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </c:if>
            <c:if test="${userCar.isEmpty()}">
              <p class="text-secondary">You have not posted anything. Want to sell your apartments?</p>
              <a href="<%= request.getContextPath() %>/user/post-car">
                <button class="btn btn-primary">Get Started</button>
              </a>
            </c:if>
          </div>
        </div>
      </div>
    </main>


  </body>
</html>
