<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="layouts/header.jsp" %>
<%@ include file="layouts/navbar.jsp" %>

<div class="container text-start mt-3">
    <div class="row justify-content-md-start mb-4">
        <div class="col">
            <h1 class="fs-2 fw-bold">Réservation</h1>
            <p>Consultez les réservations utilisateurs</p>
        </div>
        <div class="col col-lg-2">
            <button type="button" class="grid gap-1 btn btn-primary p-2 rounded-3" data-bs-toggle="modal" data-bs-target="#create-reservation">
                <img src="<c:url value="/images/plus.svg"/>" height="30%" width="30%" alt="plus-icon"/>
                Créer
            </button>
        </div>
    </div>

    <c:choose>
        <c:when test="${not empty success}">
            <div class="mb-4">
                <div class="alert alert-success alert-dismissible fade show" role="alert">
                    <p>${success}</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>

        </c:when>
    </c:choose>

    <c:choose>
        <c:when test="${not empty error}">
            <div class="mb-4">
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    <p>${error}</p>
                    <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
                </div>
            </div>

        </c:when>
    </c:choose>

    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">Utilisateur</th>
            <th scope="col">Salle</th>
            <th scope="col">Date de réservation</th>
            <th scope="col">Heure de début</th>
            <th scope="col">Heure de fin </th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty reservations_liste}">
                <c:forEach var="item" items="${reservations_liste}">
                    <tr>
                        <td>${item.utilisateur.nom}</td>
                        <td>${item.salle.nom}</td>
                        <td>${item.dateReservation}</td>
                        <td>${item.heureDebut}</td>
                        <td>${item.heureFin}</td>
                        <td>
                            <div class="d-flex flex-row gap-2">
                                <button
                                        type="button"
                                        class="btn border-0"
                                        data-bs-toggle="modal"
                                        data-bs-target="#update-reservation"
                                        data-id="${item.id}"
                                        data-utilisateur="${item.utilisateur.id}"
                                        data-salle="${item.salle.id}"
                                        data-date="${item.dateReservation}"
                                        data-debut="${item.heureDebut}"
                                        data-fin="${item.heureFin}"
                                >
                                    <img src="<c:url value="/images/pencil.svg"/>" width="70%" height="70%" alt="edit-icon">
                                </button>
                                <button
                                        type="button"
                                        class="btn border-0"
                                        data-bs-toggle="modal"
                                        data-bs-target="#delete-reservation"
                                        data-id="${item.id}"
                                >
                                    <img src="<c:url value="/images/trash-2.svg"/>" width="70%" height="70%" alt="delete-icon">
                                </button>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <tr>
                    <td colspan="5" class="text-center text-muted borderless">
                        Aucune réservation faite pour le moment, ajoutez-en
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>

<div id="create-reservation" class="modal fade" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="fw-semibold fs-4">Créer une nouvelle réservation</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/reservations/create" method="POST">

                    <div class="form-group mb-2">
                        <label for="utilisateur">Utilisateur</label>
                        <select class="form-select" name="utilisateur">
                            <c:choose>
                                <c:when test="${not empty users_liste}">
                                    <c:forEach var="user" items="${users_liste}">
                                        <option value="${user.id}">${user.nom}</option>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <option>Aucun utilisateur disponible, créez-en</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="salle">Salle</label>
                        <select class="form-select" name="salle">
                            <c:choose>
                                <c:when test="${not empty salles_liste}">
                                    <c:forEach var="salle" items="${salles_liste}">
                                        <option value="${salle.id}">${salle.nom}</option>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <option>Aucune salle disponible, créez-en</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="dateReservation">Date</label>
                        <input type="date" required class="form-control" id="dateReservation" name="dateReservation">
                    </div>

                    <div class="d-flex flex-row gap-2 mb-3">
                        <div class="form-group">
                            <label for="heureDebut">Heure de début</label>
                            <input type="time" required class="form-control" id="heureDebut" name="heureDebut">
                        </div>

                        <div class="form-group">
                            <label for="heureFin">Heure de fin</label>
                            <input type="time" required class="form-control" id="heureFin" name="heureFin">
                        </div>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary rounded-3 py-2 px-3">Réservé la salle</button>
                        <button type="button" class="btn btn-secondary rounded-3 p-2" data-bs-dismiss="modal">Annuler</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="update-reservation" class="modal fade" tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="fw-semibold fs-4">Mise à jour de réservation</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form method="POST">

                    <div class="form-group mb-2">
                        <label for="utilisateur">Utilisateur</label>
                        <select class="form-select" name="utilisateur" id="utilisateur">
                            <c:choose>
                                <c:when test="${not empty users_liste}">
                                    <c:forEach var="user" items="${users_liste}">
                                        <option value="${user.id}">${user.nom}</option>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <option>Aucun utilisateur disponible, créez-en</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="salle">Salle</label>
                        <select class="form-select" name="salle" id="salle">
                            <c:choose>
                                <c:when test="${not empty salles_liste}">
                                    <c:forEach var="salle" items="${salles_liste}">
                                        <option value="${salle.id}">${salle.nom}</option>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <option>Aucune salle disponible, créez-en</option>
                                </c:otherwise>
                            </c:choose>
                        </select>
                    </div>

                    <div class="form-group mb-2">
                        <label for="dateReservation">Date</label>
                        <input type="date" required class="form-control" id="dateReservation" name="dateReservation">
                    </div>

                    <div class="d-flex flex-row gap-2 mb-3">
                        <div class="form-group">
                            <label for="heureDebut">Heure de début</label>
                            <input type="time" required class="form-control" id="heureDebut" name="heureDebut">
                        </div>

                        <div class="form-group">
                            <label for="heureFin">Heure de fin</label>
                            <input type="time" required class="form-control" id="heureFin" name="heureFin">
                        </div>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary rounded-3 py-2 px-3">Mettre à jour</button>
                        <button type="button" class="btn btn-secondary rounded-3 p-2" data-bs-dismiss="modal">Annuler</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="delete-reservation" class="modal fade" data-bs-backdrop="static" tabindex="-1" >
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="fw-semibold fs-4">Suppression de reservation</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form method="POST">
                    <p class="mb-3" id="delete-text">Êtes-vous sûr de vouloir supprimer cette réservation ? Cette action est irréversible.</p>
                    <div class="text-end">
                        <button type="submit" class="btn btn-danger rounded-3 py-2 px-3">Supprimer</button>
                        <button type="button" class="btn btn-secondary rounded-3 py-2 px-3" data-bs-dismiss="modal">Annuler</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<script>
    //Update reservation
    const updateModal = document.getElementById("update-reservation")
    if (updateModal){
        updateModal.addEventListener('show.bs.modal',event =>{
            const button = event.relatedTarget

            const salleInput = updateModal.querySelector("#salle")
            const userInput = updateModal.querySelector("#utilisateur")
            const reservationDateInput = updateModal.querySelector("#dateReservation")
            const reservationStartInput = updateModal.querySelector("#heureDebut")
            const reservationEndInput = updateModal.querySelector("#heureFin")

            salleInput.value = button.dataset.salle
            userInput.value = button.dataset.utilisateur
            reservationStartInput.value = button.dataset.debut
            reservationDateInput.value = button.dataset.date
            reservationEndInput.value = button.dataset.fin

            const form = updateModal.querySelector(".modal-body form")

            const contextPath = "${pageContext.request.contextPath}"

            form.action = contextPath+"/reservations/update/"+button.dataset.id
        })
    }

    //Delete salle
    const deleteModal = document.getElementById("delete-reservation")
    if(deleteModal){
        deleteModal.addEventListener('show.bs.modal',event =>{
            const button = event.relatedTarget

            const form = deleteModal.querySelector(".modal-body form")
            const contextPath = "${pageContext.request.contextPath}"

            form.action = contextPath+"/reservations/delete/"+button.dataset.id
        })
    }
</script>

<%@ include file="layouts/footer.jsp" %>

