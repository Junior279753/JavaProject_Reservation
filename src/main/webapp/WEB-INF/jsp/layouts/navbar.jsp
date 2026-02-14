<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<nav class="navbar navbar-expand-lg bg-white shadow-sm sticky-top">
    <div class="container">

        <a class="navbar-brand fw-bold fs-4 text-primary" href="<c:url value='/'/>">
            Reserv
        </a>

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse"
                data-bs-target="#mainNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-center" id="mainNavbar">
            <ul class="navbar-nav gap-3">

                <li class="nav-item">
                    <a class="nav-link fw-semibold"
                       href="<c:url value='/'/>">
                        Accueil
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link fw-semibold"
                       href="<c:url value='/salles'/>">
                        Salles
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link fw-semibold"
                       href="<c:url value='/utilisateurs'/>">
                        Utilisateurs
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link fw-semibold"
                       href="<c:url value='/reservations'/>">
                        Réservations
                    </a>
                </li>

            </ul>
        </div>

    </div>
</nav>
