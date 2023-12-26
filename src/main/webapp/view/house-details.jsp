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

          <aside class="sidebar-car me-sm-4 pt-3">
            <ul class="fw-semibold">
              <li class="ms-1">
                <a href="<%= request.getContextPath() %>/houses"><i class="fa-solid fa-car"></i> House List</a>
              </li>
              <li>
                <a href="<%= request.getContextPath() %>/user/post-house">
                  <button class="btn btn-warning">Post a House</button>
                </a>
              </li>
              <li>
                <p class="ms-1"><i class="fa-solid fa-dollar-sign"></i> Price Range</p>
                <form action="<%= request.getContextPath() %>/house">
                  <input class="form-control mb-3 ps-4 pe-0" type="number" name="low" required placeholder="Minimum price" />
                  <input class="form-control mb-3 ps-4 pe-0" type="number" name="high" required placeholder="Maximum price" />
                  <button type="submit" class="btn btn-secondary">Search</button>
                </form>
              </li>
            </ul>
          </aside>


          <div class="car-list">
            <!-- Search -->
            <form action="<%= request.getContextPath() %>/houses" id="searchForm" class="d-flex">
              <input class="form-control" type="text" name="keyword" required placeholder="Search " />
              <button type="submit" class="btn btn-light">
                <i class="fa-solid fa-magnifying-glass"></i>
              </button>
            </form>

            <div class="mt-4 row">

              <div class="car-image col-12 col-sm-8">
                <img class="img-fluid" alt="${house.type}" src="data:${house.housePicture.fileType};base64,${house.housePicture.image}" />
              </div>
              <!-- Details -->
              <div class="car-details col-12 col-sm-4">
                <h4 class="fw-bold">${house.type} ${house.info} ${house.year}</h4>
                <p class="text-secondary m-0">STARTING PRICE:</p>
                <p class="text-black fs-5">$${house.price}</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>


  </body>
</html>


