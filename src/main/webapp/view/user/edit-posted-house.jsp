<%@ include file="../components/taglib.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <%@ include file="../components/header.jsp" %>
    <link rel="stylesheet" href="/css/form.css" />
  </head>
  <body>
    <%@ include file="../components/navbar.jsp" %>

    <main>
      <div class="container d-flex justify-content-center">
        <div class="form-wrapper medium">
          <h2 class="form-header">Edit Posted House</h2>
          <!-- FORM -->
          <form:form action="editHouseProcess" method="POST" modelAttribute="house">
            <form:hidden path="idHouse" />

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

            <button class="btn btn-primary form-button mt-3" type="submit">Save Edit</button>
          </form:form>
        </div>
      </div>
    </main>


  </body>
</html>
