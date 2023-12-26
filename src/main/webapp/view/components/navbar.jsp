<nav class="navbar navbar-expand-lg sticky-top p-0">
    <div class="container">
        <!-- Brand Logo or Name -->
        <a class="navbar-brand fw-bold fs-5" href="<%= request.getContextPath() %>/">Apartments</a>


        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>


        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto me-0 me-lg-auto fw-semibold">
                <li class="nav-item me-0 me-lg-3">
                    <a class="nav-link" href="<%= request.getContextPath() %>/">Home</a>
                </li>
                <li class="nav-item me-0 me-lg-3">
                    <a class="nav-link" href="<%= request.getContextPath() %>/houses">Houses</a>
                </li>
                <li class="nav-item me-0 me-lg-3">
                    <a class="nav-link" href="<%= request.getContextPath() %>/user/post-house">Place a House</a>
                </li>
            </ul>

            <!-- Conditional Display Based on Authentication Status -->
            <security:authorize access="!isAuthenticated()">
                <div class="nav-button d-flex flex-column flex-lg-row">
                    <a href="<%= request.getContextPath() %>/login"
                       class="btn btn-outline-secondary me-0 me-lg-3 mb-3 mb-lg-0">Login</a>
                    <a href="<%= request.getContextPath() %>/register" class="btn btn-primary mb-3 mb-lg-0">Register</a>
                </div>
            </security:authorize>

            <!-- User Account Links for Authenticated Users -->
            <security:authorize access="isAuthenticated()">
                <ul class="navbar-nav fw-semibold">
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/user/my-profile">
                            <i class="fa-solid fa-user"></i> Profile
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/user/my-posted-houses">
                            <i class="fa-solid fa-house"></i> My Posted Houses
                        </a>
                    </li>
                    <security:authorize access="hasRole('ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="<%= request.getContextPath() %>/admin/dashboard">
                                <i class="fa-solid fa-gauge-high"></i> Dashboard
                            </a>
                        </li>
                    </security:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="<%= request.getContextPath() %>/logout">
                            <button class="nav-logout btn btn-primary">Logout</button>
                        </a>
                    </li>
                </ul>
            </security:authorize>
        </div>
    </div>
</nav>
