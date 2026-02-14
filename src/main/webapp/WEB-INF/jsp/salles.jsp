<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="layouts/header.jsp" %>
<%@ include file="layouts/navbar.jsp" %>

<div class="container text-start mt-3">
        <div class="row justify-content-md-start mb-4">
            <div class="col">
                <h1 class="fs-2 fw-bold">Salles</h1>
                <p>Consultez et gérez vos salles de fêtes</p>
            </div>
            <div class="col col-lg-2">
                <button type="button" class="grid gap-1 btn btn-primary p-2 rounded-3" data-bs-toggle="modal" data-bs-target="#create-salle">
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
                <th scope="col">Nom</th>
                <th scope="col">Localisation</th>
                <th scope="col">Capacité</th>
                <th scope="col">Disponible</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:choose>
                <c:when test="${not empty salles_liste}">
                    <c:forEach var="item" items="${salles_liste}">
                        <tr>
                            <td>${item.nom}</td>
                            <td>${item.localisation}</td>
                            <td>${item.capacite}</td>
                            <td>
                                <c:choose>
                                    <c:when test="${item.disponible}">
                                        <span class="badge text-bg-success">Disponible</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span class="badge text-bg-warning">Réservé</span>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td>
                                <div class="d-flex flex-row gap-2">
                                    <button
                                            type="button"
                                            class="btn border-0"
                                            data-bs-toggle="modal"
                                            data-bs-target="#update-salle"
                                            data-id="${item.id}"
                                            data-nom="${item.nom}"
                                            data-localisation="${item.localisation}"
                                            data-capacite="${item.capacite}"
                                            data-disponible="${item.disponible}">
                                        <img src="<c:url value="/images/pencil.svg"/>" width="70%" height="70%" alt="edit-icon">
                                    </button>
                                    <button
                                            type="button"
                                            class="btn border-0"
                                            data-bs-toggle="modal"
                                            data-bs-target="#delete-salle"
                                            data-id="${item.id}"
                                            data-nom="<c:out value='${item.nom}'/>"
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
                            Aucune salles, ajoutez-en
                        </td>
                    </tr>
                </c:otherwise>
            </c:choose>
            </tbody>
        </table>
    </div>

<div id="create-salle" class="modal fade " tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="fw-semibold fs-4">Créer une nouvelle salle</h2>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/salles/create" method="POST">
                        <div class="form-group mb-2">
                            <label for="nom">Nom</label>
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Salle Rhéno">
                        </div>

                        <div class="form-group mb-2">
                            <label for="localisation">Localisation</label>
                            <input type="text" class="form-control" id="localisation" name="localisation" placeholder="Akpakpa,Ville Neuve">
                        </div>

                        <div class="form-group mb-3">
                            <label for="capacite">Capacité</label>
                            <input type="number" class="form-control" id="capacite" name="capacite" placeholder="00">
                        </div>
                        <div class="form-group">
                            <button type="submit" class="btn btn-primary rounded-3 py-2 px-3">Créer la salle</button>
                            <button type="button" class="btn btn-secondary rounded-3 p-2" data-bs-dismiss="modal">Annuler</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

<div id="delete-salle" class="modal fade" data-bs-backdrop="static" tabindex="-1" >
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="fw-semibold fs-4">Suppression de salle</h2>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>
                <div class="modal-body">
                    <form method="POST">
                        <p class="mb-3" id="delete-text">Êtes-vous sûr de vouloir supprimer cette salle ? Cette action est irréversible.</p>
                        <div class="text-end">
                            <button type="submit" class="btn btn-danger rounded-3 py-2 px-3">Supprimer</button>
                            <button type="button" class="btn btn-secondary rounded-3 py-2 px-3" data-bs-dismiss="modal">Annuler</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

<div id="update-salle" class="modal fade" tabindex="-1">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h2 class="fw-semibold fs-4">Mise à jour de salle</h2>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <div class="modal-body">
                    <form action="${pageContext.request.contextPath}/salles/update" method="POST">
                        <div class="form-group mb-2">
                            <label for="nom">Nom</label>
                            <input type="text" class="form-control" id="nom" name="nom" placeholder="Salle Rhéno">
                        </div>

                        <div class="form-group mb-2">
                            <label for="localisation">Localisation</label>
                            <input type="text" class="form-control" id="localisation" name="localisation" placeholder="Akpakpa,Ville Neuve">
                        </div>

                        <div class="form-group  mb-2">
                            <label for="capacite">Capacité</label>
                            <input type="number" class="form-control" id="capacite" name="capacite" placeholder="00">
                        </div>
                        <div class="form-check form-switch mb-3">
                            <label for="disponible" class="form-check-label">Disponibilité</label>
                            <input type="checkbox" class="form-check-input" role="switch" id="disponible" name="disponible"/>
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

<script>
        //Update salle
        const updateModal = document.getElementById("update-salle")
        if (updateModal){
            updateModal.addEventListener('show.bs.modal',event=>{
                const button = event.relatedTarget

                const nameInput = updateModal.querySelector("#nom")
                const localisationInput = updateModal.querySelector("#localisation")
                const capacityInput = updateModal.querySelector("#capacite")
                const availabilityInput = updateModal.querySelector("#disponible")

                nameInput.value= button.dataset.nom
                localisationInput.value = button.dataset.localisation
                capacityInput.value = button.dataset.capacite
                availabilityInput.checked = button.dataset.disponible === "true"

                const form = updateModal.querySelector(".modal-body form")

                const contextPath = "${pageContext.request.contextPath}"

                form.action = contextPath+"/salles/update/"+button.dataset.id
            })
        }

        //Delete salle
        const deleteModal = document.getElementById("delete-salle")
        if(deleteModal){
            deleteModal.addEventListener('show.bs.modal',event =>{
                const button = event.relatedTarget

                const form = deleteModal.querySelector(".modal-body form")
                const contextPath = "${pageContext.request.contextPath}"

                form.action = contextPath+"/salles/delete/"+button.dataset.id
            })
        }
    </script>

<%@ include file="layouts/footer.jsp" %>