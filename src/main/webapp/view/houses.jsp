<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/house.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container pt-5">
        <div class="d-flex">
          <!-- Sidebar -->
          <aside class="sidebar-car me-sm-4 pt-3">

              <li class="ms-1">
                <a href="<%= request.getContextPath() %>/houses"><i class="fa-solid fa-house"></i> House List</a>
              </li>
              <li>
                <a href="<%= request.getContextPath() %>/user/post-house">
                  <button class="btn btn-warning">Post a House</button>
                </a>
              </li>
              <li>
                <p class="ms-1"><i class="fa-solid fa-dollar-sign"></i> Price Range</p>
                <form action="<%= request.getContextPath() %>/houses">
                  <input class="form-control mb-3 ps-4 pe-0" type="number" name="low" required placeholder="Minimum price" />
                  <input class="form-control mb-3 ps-4 pe-0" type="number" name="high" required placeholder="Maximum price" />
                  <button type="submit" class="btn btn-secondary">Search</button>
                </form>
              </li>

          </aside>

          <!-- Car List -->
          <div class="car-list">
            <!-- Search -->
            <form action="<%= request.getContextPath() %>/houses" id="searchForm" class="d-flex">
              <input class="form-control" type="text" name="keyword" required placeholder="Search " />
              <button type="submit" class="btn btn-light">
                <i class="fa-solid fa-magnifying-glass"></i>
              </button>
            </form>
            <!-- List -->
            <div class="mt-4 row">
              <c:if test="${!listHouse.isEmpty()}">
                <c:forEach items="${listHouse}" var="house">
                  <c:if test="${house.status.equals('ACTIVE')}">
                    <div class="col-12 col-md-6 col-md-4 col-lg-3 mb-3">
                      <div class="card">
                        <img class="card-img-top" src="data:${house.housePicture.fileType};base64,${house.housePicture.image}" alt="${house.type}" />
                        <div class="card-body">
                          <p class="car-details fw-bold">${house.type} ${house.info} ${house.year}</p>
                          <p class="car-price">$${house.price}</p>
                          <a href="<%= request.getContextPath() %>/houses/${house.type}/${house.info}/${house.year}/${house.idHouse}">
                            <button class="btn btn-primary">House Details</button>
                          </a>
                        </div>
                      </div>
                    </div>
                  </c:if>
                </c:forEach>
              </c:if>
              <c:if test="${listHouse.isEmpty()}">
                <h4 class="fw-bold text-secondary text-center">House not found</h4>
              </c:if>
            </div>
          </div>
        </div>
      </div>
    </main>

  </body>
</html>
