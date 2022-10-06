<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Besoins </title>
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
					 	<h4 class="card-header">Les soumissions des fournisseurs	 </h4><br><br>
                      	<table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Ressource </th>
                                    <th>Quantité</th>
                                    <th>prix</th>
                                    <th>Nom fournisseur  </th>
                                    <th>Alistesction </th>
                                </tr>
                            </thead>
                            <tbody>
						      	<c:forEach  items="${ listes }" var="l">
							         <tr>
								        <td>${ l.getType() }</td>
								        <td>${ l.getQte() }</td>
								        <td>${ l.getPrix() }</td>
								        <td>${ l.getId_fournisseur() }</td>
								        
								        <td>
								        	
							        		<input type="hidden" class="form-control" name="id" value="">
							        		<button value="eliminerFournisseur" name="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">
								        		<i class="sidenav-icon  feather icon-x-square"></i> 
								        		Eliminer
							        		</button>
							        		<button value="eliminerFournisseur" name="button" class="btn btn-success" data-toggle="modal" data-target="#myModal2">
								        		<i class="sidenav-icon  feather icon-x-square"></i> 
								        		accepter
							        		</button>
							        		<!-- The Modal Affecter -->
											<div class="modal" id="myModal">
											  <div class="modal-dialog">
											    <div class="modal-content">
											
											      <!-- Modal Header -->
											      <div class="modal-header">
											        <h4 class="modal-title">Motif d'élimination </h4>
											        <button type="button" class="close" data-dismiss="modal">&times;</button>
											      </div>
											
											      <!-- Modal body -->
											      <div class="modal-body">
											        <!-- Button to Open the Modal Département -->
													<form action="Servlet2" method="post">
					                                    <div class="form-group row">
					                                        <label class="col-form-label col-sm-2 text-sm-right">Message</label>
					                                        <div class="col-sm-10">
					                                            <input type="hidden" name="idSoumission" value="${ l.getId_soumission() }">
					                                            <input type="hidden" name="idF" value="${ l.getId_fournisseur() }">
					                                            <textarea class="form-control" name="messageElim" placeholder="Message"></textarea>
					                                        </div>
					                                    </div>                                    
					                                                                    
					                                    <div class="form-group row">
					                                        <div class="col-sm-10 ml-sm-auto">
					                                            <button value="eliminerFournisseur" name="button" type="submit" class="btn btn-info">Envoyer</button>
					                                        </div>
					                                    </div>
					                                </form>
											      </div>
											
											      <!-- Modal footer -->
											      <div class="modal-footer">
											        <button type="button" class="btn btn-danger" data-dismiss="modal">Fermer</button>
											      </div>
											
											    </div>
											  </div>
											</div>
										<!-- The Modal Affecter -->
											<div class="modal" id="myModal2">
											  <div class="modal-dialog">
											    <div class="modal-content">
											
											      <!-- Modal Header -->
											      <div class="modal-header">
											        <h4 class="modal-title">message d'acceptation </h4>
											        <button type="button" class="close" data-dismiss="modal">&times;</button>
											      </div>
											
											      <!-- Modal body -->
											      <div class="modal-body">
											        <!-- Button to Open the Modal Département -->
													<form action="Servlet2" method="post">
					                                    <div class="form-group row">
					                                        <label class="col-form-label col-sm-2 text-sm-right">Message</label>
					                                        <div class="col-sm-10">
					                                            <input type="hidden" name="idSoumission" value="${ l.getId_soumission() }">
					                                            <input type="hidden" name="idF" value="${ l.getId_fournisseur() }">
					                                            <textarea class="form-control" name="messageElim" placeholder="Message"></textarea>
					                                        </div>
					                                    </div>                                    
					                                                                    
					                                    <div class="form-group row">
					                                        <div class="col-sm-10 ml-sm-auto">
					                                            <button type="submit" name="button" value="accepterSoumi" class="btn btn-info">Envoyer</button>
					                                        </div>
					                                    </div>
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
