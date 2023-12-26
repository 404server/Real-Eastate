<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/home.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <main>
      <div class="container-fluid jumbotron">
        <div class="container d-flex justify-content-center align-items-center">
          <div class="jumbotron-content pt-4">
            <form id="searchForm" action="houses.jsp" class="d-flex">
              <input class="form-control" type="text" name="keyword" required placeholder="Search by Type, Info, or Year" />
              <button type="submit" class="btn btn-light">
                <i class="fa-solid fa-magnifying-glass"></i>
              </button>
            </form>

            <div class="jumbotron-text">
              <h2 class="fw-bolder m-0">Affordable</h2>
              <h2 class="fw-bolder">and Like New</h2>
            </div>
            <a href="<%= request.getContextPath() %>/houses">
              <button class="btn-search btn btn-outline-light text-uppercase mt-3">Search Houses</button>
            </a>
          </div>
        </div>
      </div>
      >
      <div class="container mt-4 p-3">
        <div class="d-flex justify-content-between">
          <h2 class="fw-bolder">Featured Houses</h2>
          <a class="text-decoration-none" href="<%= request.getContextPath() %>/houses">See all houses</a>
        </div>
        <div class="wrapper row">
          <c:forEach items="${listHouse}" var="house">
            <div class="col-12 col-md-6 col-lg-4 mb-3">
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
          </c:forEach>
        </div>
      </div>
    </main>

  </body>
</html>
