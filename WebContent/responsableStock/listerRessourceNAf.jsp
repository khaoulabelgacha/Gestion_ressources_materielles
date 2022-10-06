<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Ressources Non Affectées </title>
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
					 	<h4 class="card-header">Ressources Non affectées </h4><br><br>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Ressource </th>
                                    <th>Code</th>
                                    <th>Marque</th>
                                    <th>Durée de garantie </th>
                                    <th>Fournisseur </th>
                                    <th>Action </th>
                                </tr>
                            </thead>
                            <tbody>
						      	<c:forEach  items="${ ordiNAF }" var="ordin" >
							         <tr>
								        <td>ordinateur</td>
								        <td>${ ordin.getCode() }</td>
								        <td>${ ordin.getMarque() }</td>
								        <td>${ ordin.getDureeGarantie() }</td>
								        <td>${ ordin.getIdF() }</td>
								        
								        
								        <td>
								        	<input type="hidden" class="form-control" name="id" value="">
												<button value="affect" name="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">
													 <i class="sidenav-icon feather icon-check-circle"></i>
													 Affecter
												</button>
												
												<!-- The Modal Affecter -->
												<div class="modal" id="myModal">
												  <div class="modal-dialog">
												    <div class="modal-content">
												
												      <!-- Modal Header -->
												      <div class="modal-header">
												        <h4 class="modal-title">Affecter à un :  </h4>
												        <button type="button" class="close" data-dismiss="modal">&times;</button>
												      </div>
												
												      <!-- Modal body -->
												      <div class="modal-body">
												        <!-- Button to Open the Modal Département -->
												        <form method="post" action="Servlet2">
												            <input type="hidden" name="codeOrd" class="form-control" value="${ ordin.getCode() }">
													        <button type="submit" name="button" value="affDepartement" class="btn btn-xl btn-outline-primary">Département</button>
													        <button type="submit" name="button" value="affEnseignant" class="btn btn-xl btn-outline-info">Enseignant</button>
												        </form>
												      </div>
												
												      <!-- Modal footer -->
												      <div class="modal-footer">
												        <button type="button" class="btn btn-danger" data-dismiss="modal">Fermer</button>
												      </div>
												
												    </div>
												  </div>
												</div>	
							        	
								        </td>
							      	</tr>
					      		</c:forEach>
					   
						      	<c:forEach  items="${ imprNAF }" var="imp" >
							         <tr>
								        <td>imprimante</td>
								        <td>${ imp.getCode() }</td>
								        <td>${ imp.getMarque() }</td>
								        <td>${ imp.getDureeGarantie() }</td>
								        <td>${ imp.getIdF() }</td>
								        
								        
								        <td>
								        	<input type="hidden" class="form-control" name="id" value="">
												<button value="affect" name="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">
													 <i class="sidenav-icon feather icon-check-circle"></i>
													 Affecter
												</button>
												
												<!-- The Modal Affecter -->
												<div class="modal" id="myModal">
												  <div class="modal-dialog">
												    <div class="modal-content">
												
												      <!-- Modal Header -->
												      <div class="modal-header">
												        <h4 class="modal-title">Affecter à un :  </h4>
												        <button type="button" class="close" data-dismiss="modal">&times;</button>
												      </div>
												
												      <!-- Modal body -->
												      <div class="modal-body">
												        <!-- Button to Open the Modal Département -->
												        <form method="post" action="Servlet2">
												            <input type="hidden" name="codeImp" class="form-control" value="${ imp.getCode() }">
													        <button type="submit" name="button" value="affDepartement" class="btn btn-xl btn-outline-primary">Département</button>
													        
													        <button type="submit" name="button" value="affEnseignant" class="btn btn-xl btn-outline-info">Enseignant</button>
												        </form>
												      </div>
												
												      <!-- Modal footer -->
												      <div class="modal-footer">
												        <button type="button" class="btn btn-danger" data-dismiss="modal">Fermer</button>
												      </div>
												
												    </div>
												  </div>
												</div>	
							        	
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
