<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="layouts/header.jsp" %>
<%@ include file="layouts/navbar.jsp" %>

<div class="container mt-5">

    <div class="row justify-content-center g-4">

        <div class="col-md-4">
            <a href="<c:url value='/utilisateurs'/>" class="text-decoration-none text-dark">
                <div class="card text-center shadow-sm h-100 home-card">
                    <div class="card-body py-5">

                        <!-- ICON PLACEHOLDER -->
                        <img src="<c:url value="/images/users.svg"/>" class="mb-3 fs-1 text-primary" alt="users-icon">

                        <h5 class="card-title fw-semibold">
                            Utilisateurs
                        </h5>

                        <p class="text-muted small">
                            Gérer les utilisateurs du système
                        </p>

                    </div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="<c:url value='/reservations'/>" class="text-decoration-none text-dark">
                <div class="card text-center shadow-sm h-100 home-card">
                    <div class="card-body py-5">

                        <img src="<c:url value="/images/calendar.svg"/>" class="mb-3 fs-1 text-primary" alt="calendar-icon">


                        <h5 class="card-title fw-semibold">
                            Réservations
                        </h5>

                        <p class="text-muted small">
                            Consulter et gérer les réservations
                        </p>

                    </div>
                </div>
            </a>
        </div>

        <div class="col-md-4">
            <a href="<c:url value='/salles'/>" class="text-decoration-none text-dark">
                <div class="card text-center shadow-sm h-100 home-card">
                    <div class="card-body py-5">

                        <img src="<c:url value="/images/warehouse.svg"/>" class="mb-3 fs-1 text-primary" alt="warehouse-icon">

                        <h5 class="card-title fw-semibold">
                            Salles
                        </h5>

                        <p class="text-muted small">
                            Gérer les salles disponibles
                        </p>

                    </div>
                </div>
            </a>
        </div>

    </div>

</div>

<style>
    .home-card {
        transition: all 0.3s ease;
        cursor: pointer;
    }

    .home-card:hover {
        transform: translateY(-8px);
        box-shadow: 0 0.75rem 1.5rem rgba(0, 0, 0, 0.1);
    }
</style>

<%@ include file="layouts/footer.jsp" %>
