<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Acceuil - chef departement </title>

    <%@ include file="../Layout/styles.jsp" %>
</head>

<body>
    <!-- [ Preloader ] Start -->
    <div class="page-loader">
        <div class="bg-primary"></div>
    </div>
    <!-- [ Preloader ] Ebd -->

    <!-- [ Layout wrapper ] Start -->
    <div class="layout-wrapper layout-2">
        <div class="layout-inner">
            <!-- [ Layout sidenav ] Start -->
			<%@ include file="../Layout/leftBarChef.jsp" %>
            <!-- [ Layout sidenav ] End -->
            
            
            <!-- [ Layout container ] Start -->
            <div class="layout-container">
                <!-- [ Layout navbar ( Header ) ] Start -->
				<%@ include file="../Layout/header.jsp" %>
                <!-- [ Layout navbar ( Header ) ] End -->

                <!-- [ Layout content ] Start -->
                <div class="layout-content">
                	<div class="container-fluid flex-grow-1 container-p-y">
                	<!-- [ content ] Start -->
					 	<h6 class="text-muted small font-weight-bold py-3 my-4">Listes des besoins</h6>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Type</th>
                                    <th>Qte</th>
                                    <th>Nom</th>
                                    <th>Etat</th>
                                </tr>
                            </thead>
                            <tbody>
                            
                                 <c:forEach items="${ besoin }" var="c">
                                 <form action="Modifier_Supprimer_Besoin" method="post">
                                  <input type="hidden" name="id_besoin" value="${c.id_besoin }">
								     <tr>
								     <th scope="row">${ c.id_besoin }</th>
								     <td>${ c.type }</td>
								     <td>${ c.getQte() }</td>
								     <td>${ c.cin }</td>
								    
								     <c:if test="${c.getEtat() eq 0 }">
								     <td>non ajoutée</td>
								     <td> 
								     <button name="button" class="btn btn-warning " value="modifier" onclick="return confirm('Etes-vous sur de ajouter ce besoin à la liste finale?');">Approuver</button>
								     </td>
								     </c:if>
								     
								     <c:if test="${c.getEtat() eq 1 }">
								     <td>approuvée</td>
								     </c:if>
								     <td>
								     <button name="button" class="btn btn-danger " value="supprimer" onclick="return confirm('Etes-vous sur de supprimer ce besoin?');">Supprimer</button>
                                     
								     
								     </td>
								     
								     </tr>
								    </form> 
								 </c:forEach>   
								  
                            </tbody>
                        </table>


                    <!-- [ content ] End -->
                	</div>
          
                    <!-- [ Layout footer ] Start -->
                    <nav class="layout-footer footer bg-white">
                       
                    </nav>
                    <!-- [ Layout footer ] End -->

                </div>
                <!-- [ Layout content ] Start -->

            </div>
            <!-- [ Layout container ] End -->
        </div>
        <!-- Overlay -->
        <div class="layout-overlay layout-sidenav-toggle"></div>
    </div>
    <!-- [ Layout wrapper ] end -->

    <!-- Core scripts -->
	<%@ include file="../Layout/scripts.jsp" %>
</body>

</html>
