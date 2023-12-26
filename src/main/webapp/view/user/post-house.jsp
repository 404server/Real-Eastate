<%@ include file="../components/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/form.css" />
  </head>
  <body>
    <!-- Navbar -->
    <%@ include file="../components/navbar.jsp" %>

    <!-- Main -->
    <main>
      <div class="container d-flex justify-content-center">
        <div class="form-wrapper medium">
          <h2 class="form-header">Post House</h2>
          <!-- FORM -->
          <form:form action="postHouseProcess" method="POST" enctype="multipart/form-data" modelAttribute="house">
            <label class="form-label">Type</label>
            <div>
              <form:errors path="type" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="type" cssErrorClass="form-control error-border" />

            <label class="form-label">Info</label>
            <div>
              <form:errors path="info" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="info" cssErrorClass="form-control error-border" />

            <label class="form-label">Year</label>
            <div>
              <form:errors path="year" cssClass="error" />
            </div>
            <form:input class="form-control" type="text" path="year" cssErrorClass="form-control error-border" />

            <label class="form-label">Price</label>
            <div>
              <form:errors path="price" cssClass="error" />
            </div>
            <form:input class="form-control" type="number" path="price" cssErrorClass="form-control error-border" />

            <label class="form-label">House Picture</label>
            <div>
              <span class="error">${fileError}</span>
            </div>
            <input class="form-control" type="file" name="imageFile" />

            <button class="btn btn-primary form-button mt-3" type="submit">Post House</button>
          </form:form>
        </div>
      </div>
    </main>


  </body>
</html>
