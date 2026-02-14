<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<%@ include file="layouts/header.jsp" %>
<%@ include file="layouts/navbar.jsp" %>

<div class="container text-start mt-3">
    <div class="row justify-content-md-start mb-4">
        <div class="col">
            <h1 class="fs-2 fw-bold">Utilisateurs</h1>
            <p>Consultez et gérez les utilisateurs de la plateforme</p>
        </div>
        <div class="col col-lg-2">
            <button type="button" class="grid gap-1 btn btn-primary p-2 rounded-3" data-bs-toggle="modal" data-bs-target="#create-utilisateur">
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
            <th scope="col">Email</th>
            <th scope="col">Rôle</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:choose>
            <c:when test="${not empty utilisateurs_liste}">
                <c:forEach var="item" items="${utilisateurs_liste}">
                    <tr>
                        <td>${item.nom}</td>
                        <td>${item.email}</td>
                        <td>
                            <c:choose>
                                <c:when test="${item.role == 'admin'}">
                                    <span class="badge text-bg-danger">Administrateur</span>
                                </c:when>
                                <c:otherwise>
                                    <span class="badge text-bg-primary">Utilisateur</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>
                            <div class="d-flex flex-row gap-2">
                                <button
                                        type="button"
                                        class="btn border-0"
                                        data-bs-toggle="modal"
                                        data-bs-target="#update-utilisateur"
                                        data-id="${item.id}"
                                        data-nom="${item.nom}"
                                        data-email="${item.email}"
                                        data-role="${item.role}">
                                    <img src="<c:url value="/images/pencil.svg"/>" width="70%" height="70%" alt="edit-icon">
                                </button>
                                <button
                                        type="button"
                                        class="btn border-0"
                                        data-bs-toggle="modal"
                                        data-bs-target="#delete-utilisateur"
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
                        Aucune salles, ajoutez-en
                    </td>
                </tr>
            </c:otherwise>
        </c:choose>
        </tbody>
    </table>
</div>

<div id="create-utilisateur" class="modal fade " tabindex="-1" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="fw-semibold fs-4">Créer un nouvel utilisateur</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/utilisateurs/create" method="POST">
                    <div class="form-group mb-2">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="John Doe">
                    </div>

                    <div class="form-group mb-2">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="johndoe@mail.com">
                    </div>

                    <div class="form-group mb-3">
                        <label for="role">Rôle</label>
                        <select class="form-select" name="role">
                            <option value="admin">Administrateur</option>
                            <option value="user">Utilisateur</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <button type="submit" class="btn btn-primary rounded-3 py-2 px-3">Créer l'utilisateur</button>
                        <button type="button" class="btn btn-secondary rounded-3 p-2" data-bs-dismiss="modal">Annuler</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="delete-utilisateur" class="modal fade" data-bs-backdrop="static" tabindex="-1" >
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="fw-semibold fs-4">Suppression d' utilisateur</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <div class="modal-body">
                <form method="POST">
                    <p class="mb-3" id="delete-text">Êtes-vous sûr de vouloir supprimer cet utilisateur? Cette action est irréversible.</p>
                    <div class="text-end">
                        <button type="submit" class="btn btn-danger rounded-3 py-2 px-3">Supprimer</button>
                        <button type="button" class="btn btn-secondary rounded-3 py-2 px-3" data-bs-dismiss="modal">Annuler</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<div id="update-utilisateur" class="modal fade" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h2 class="fw-semibold fs-4">Mise à jour d'utilisateur</h2>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <div class="modal-body">
                <form method="POST">
                    <div class="form-group mb-2">
                        <label for="nom">Nom</label>
                        <input type="text" class="form-control" id="nom" name="nom" placeholder="John Doe">
                    </div>

                    <div class="form-group mb-2">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="johndoe@mail.com">
                    </div>

                    <div class="form-group mb-3">
                        <label for="role">Rôle</label>
                        <select class="form-select" id="role" name="role">
                            <option value="admin">Administrateur</option>
                            <option value="user">Utilisateur</option>
                        </select>
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
    const updateModal = document.getElementById("update-utilisateur")
    if (updateModal){
        updateModal.addEventListener('show.bs.modal',event=>{
            const button = event.relatedTarget

            const nameInput = updateModal.querySelector("#nom")
            const emailInput = updateModal.querySelector("#email")
            const roleInput = updateModal.querySelector("#role")

            nameInput.value= button.dataset.nom
            emailInput.value= button.dataset.email
            roleInput.value = button.dataset.role

            const form = updateModal.querySelector(".modal-body form")

            const contextPath = "${pageContext.request.contextPath}"

            form.action = contextPath+"/utilisateurs/update/"+button.dataset.id
        })
    }

    //Delete salle
    const deleteModal = document.getElementById("delete-utilisateur")
    if(deleteModal){
        deleteModal.addEventListener('show.bs.modal',event =>{
            const button = event.relatedTarget

            const form = deleteModal.querySelector(".modal-body form")
            const contextPath = "${pageContext.request.contextPath}"

            form.action = contextPath+"/utilisateurs/delete/"+button.dataset.id
        })
    }
</script>

<%@ include file="layouts/footer.jsp" %>
