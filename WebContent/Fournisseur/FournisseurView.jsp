<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title> Fournisseur</title>

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
			<%@ include file="../Layout/leftBarFournisseur.jsp" %>
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
					 	<h4 class="card-header">Appels d'offres </h4><br><br>
                <div class="layout-content">
                	<div class="container-fluid flex-grow-1 container-p-y">
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
                                    	
											<button value="affect" name="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">
												 <i class="sidenav-icon feather icon-check-circle"></i>
												 Soumettre
											</button>
											
											<!-- The Modal Affecter -->
											<div class="modal" id="myModal">
											  <div class="modal-dialog">
											    <div class="modal-content">
											
											      <!-- Modal Header -->
											      <div class="modal-header">
											        <button type="button" class="close" data-dismiss="modal">&times;</button>
											      </div>
											
											      <!-- Modal body -->
											      <div class="modal-body">
											        <!-- Button to Open the Modal Département -->
											        <form method="post" action="Fournisseur">
											        <input type="hidden" class="form-control" name="id_offre" value="${liste.id_offre }">
												        <div class="form-group row">
											                  <label class="col-form-label col-sm-2 text-sm-right">Prix </label>
											                  <div class="col-sm-10">
											                      <input type="text"  class="form-control" name="prix" id="prix">
											                      <input type="hidden" value="CSJOIZJO" name="cin">
											                      <div class="clearfix"></div>
											                  </div>
											              </div>
												        
												        <button type="submit" name="button" value="interesser" class="btn btn-xl btn-outline-info">Envoyer</button>
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
					</div>
					</div>
				
					
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
