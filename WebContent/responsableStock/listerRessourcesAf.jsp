<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Ressources Affectées </title>
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
					 	<h4 class="card-header">Ressources affectées </h4><br><br>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Ressource </th>
                                    <th>Code</th>
                                    <th>Marque</th>
                                    <th>Durée de garantie </th>
                                    <th>Fournisseur </th>
                                    <th>Nom  </th>
                                    <th>Département </th>
                                    <th>Action </th>
                                </tr>
                            </thead>
                            <tbody>
						      	<c:forEach  items="${ ordiAF }" var="ordin" >
							         <tr>
								        <td>ordinateur</td>
								        <td>${ ordin.getCode() }</td>
								        <td>${ ordin.getMarque() }</td>
								        <td>${ ordin.getDureeGarantie() }</td>
								        <td>${ ordin.getIdF() }</td>
								        <td>${ ordin.getIdEmp() }</td>
								        <td>${ ordin.getIdDep() }</td>
								        
								        <td>
								        	<form  method="Post" action="Servlet2">
								        		<input type="hidden" class="form-control" name="idRessourceO" value="${ ordin.getCode() }">
								        		<button value="modifyAF" name="button" class="btn btn-primary">
									        		<i class="sidenav-icon  feather icon-edit"></i> 
								        		</button>
								        		<button value="delete" name="button" class="btn btn-danger">
									        		<i class="sidenav-icon  feather icon-x-square"></i> 
								        		</button>
								        	</form>
							        	
								        </td>
							      	</tr>
					      		</c:forEach>
					      		<c:forEach  items="${ imprAF }" var="imp" >
							         <tr>
								        <td>imprimante</td>
								        <td>${ imp.getCode() }</td>
								        <td>${ imp.getMarque() }</td>
								        <td>${ imp.getDureeGarantie() }</td>
								        <td>${ imp.getIdF() }</td>
								        <td>${ imp.getIdEmp() }</td>
								        <td>${ imp.getIdDep() }</td>
								        
								        <td>
								        	<form  method="Post" action="Servlet2">
								        		<input type="hidden" class="form-control" name="idRessourceI" value="${ imp.getCode() }">
								        		<button value="modifyAF" name="button" class="btn btn-primary">
									        		<i class="sidenav-icon  feather icon-edit"></i> 
								        		</button>
								        		<button value="delete" name="button" class="btn btn-danger">
									        		<i class="sidenav-icon  feather icon-x-square"></i> 
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
