<%@ include file="components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="components/header.jsp" %>
    <link rel="stylesheet" href="/css/view-user.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container">
        <div class="d-flex flex-column justify-content-center mt-5">
          <div class="view-user d-flex pb-4 mb-3">
            <div class="user-image me-4">
              <c:if test="${profile.profilePicture == null}">
                <img src="/images/user/user-default.png" alt="${profile.firstName}" />
              </c:if>
              <c:if test="${profile.profilePicture != null}">
                <img src="data:${profile.profilePicture.fileType};base64,${profile.profilePicture.image}" alt="${profile.firstName}" />
              </c:if>
            </div>
            <div class="user-details pt-3">
              <h5 class="fw-semibold">${profile.firstName} ${profile.lastName}</h5>
              <p class="text-secondary m-0">${profile.phoneNumber}</p>
              <p class="text-secondary m-0">${profile.address}</p>
            </div>
          </div>
          <div class="car-post row">
            <h3 class="fw-bold mb-2">House Sales History</h3>
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
      </div>
    </main>

  </body>
</html>
