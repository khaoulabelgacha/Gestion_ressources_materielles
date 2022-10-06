<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Admin - responsable</title>

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
			<%@ include file="../Layout/leftSideBarRespoStock.jsp" %>
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
					 	<h6 class="text-muted small font-weight-bold py-3 my-4">Striped rows</h6>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Date </th>
                                    <th>type</th>
                                    <th>quantite</th>
                                </tr>
                            </thead>
                            <tbody>
                            
                             <c:forEach var="liste" items="${ listes }">
							      <tr>
                                    <td>${ liste.date }</td>
                                    <td>${ liste.type }</td>
                                    <td>${ liste.qte }</td>
                                    <td>
                                    	<form action="Servlet2" method="post">
                                    	<input type="hidden" name="idoffre" value="${ liste.id_offre }">
											<button value="appeldoffre" name="button" class="btn btn-info" >
												 <i class="sidenav-icon feather icon-check-circle"></i>
												 valider
											</button>
										</form>	
											
                                    	
                                    	
                                    </td>
                                </tr>
							     
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
