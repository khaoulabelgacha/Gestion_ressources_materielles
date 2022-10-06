<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Admin - Service Maintenance </title>

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
			<%@ include file="../Layout/leftBarMaintenance.jsp" %>
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
                	<form action="ServletPanne" method="post">     
                        <button name="button" class="btn btn-info " value="nontraiteePanne">Pannes Non Traitees</button>
                        <button name="button" class="btn btn-info " value="decidePanne">Pannes décidées</button>
                        </form>
					 	<h6 class="text-muted small font-weight-bold py-3 my-4">Toutes Pannes</h6>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Date</th>
                                    <th>Ressource</th>
                                    <th>Frequence</th>
                                    <th>Type</th>
                                    <th>Constateur</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                 <c:forEach items="${ pannes }" var="panne">
                  <tr>
                    <td>${ panne.date }</td>
                    <td>${ panne.frequence }</td>
                    <td>${ panne.type }</td>
                    <td>${ panne.code_ressource }</td>
                    <td>${ panne.id_emp}</td>

                    <td>
                    <form action="ServletPanne" method="post">     
                        <button name="button" class="btn btn-info " value="infoPanne">info</button>
                        <input type="hidden" name="id_p" value="${panne.id_p }">
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
