<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Constats  </title>
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js"></script>
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
					 	<h4 class="card-header">Constats </h4><br><br>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                	<th>Code ressource </th>
                                    <th>Nom Complet </th> 
                                    <th>Date </th>
                                    <th>Fréquence</th>
                                    <th>Type</th>
                                    <th>Action </th>
                                </tr>
                            </thead>
                            <tbody>
						      	<c:forEach  items="${ panne }" var="panne">
							         <tr>
								        <td>${ panne.date }</td>
                                        <td>${ panne.frequence }</td>
					                    <td>${ panne.type }</td>
					                    <td>${ panne.code_ressource }</td>
					                    <td>${ panne.id_emp}</td>
								        
								        <td>
								        	<form  method="Post" action="Servlet2">
								        		<input type="hidden" name="id_p" value="${panne.id_p }">
								        		<button value="traiter" name="button" class="btn btn-primary">
									        		<i class="sidenav-icon  feather icon-edit"></i> 
									        		Traiter
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
	<Script> 
  $(function() {
        $('#colorselector').change(function(){
            $('.colors').hide();
            $('#' + $(this).val()).show();
        });
    });
</Script>
</body>

</html>
