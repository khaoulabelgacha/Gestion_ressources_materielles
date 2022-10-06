<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Responsable de stock </title>
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
						<h4 class="card-header">Ajouter ressource</h4>
						<div class="card mb-4">
                            
                            
                            <div class="card-body">
                                <form action="Servlet2" method="post">
                                
                                    <h6 class="card-header">Informations Ressource </h6><br>
   		                            <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Ressource</label>
                                        <div class="col-sm-10">
                                            <select id="colorselector" name="typeRessource" class="custom-select form-control">
                                            		<option>Choisir ..</option>
	                                                <option value="imprimante">Imprimante</option>
	                                                <option value="ordinateur">Ordinateur</option>
	                                            </select>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>  
                                 <!-- Form imprimante -->
                                <div id="imprimante" class="colors" style="display:none"> 
   		                            <div  class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Code</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="codeImp" class="form-control" placeholder="Code">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Marque</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="marqueImp" class="form-control" placeholder="Marque">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Vitesse</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="vitesseImp" class="form-control" placeholder="vitesse">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Résolution</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="resolutionImp" class="form-control" placeholder="resolution">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Durée de garantie</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="garantieImp" class="form-control" placeholder="durée">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div> 
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Fournisseur</label>
                                        <div class="col-sm-7">
                                            <select id="colorselector" name="fournisseurImp" class="custom-select form-control">
	                                                <c:forEach items="${ fournisseur }" var="f">
                                                    <option value="${ f.getCin() }">${ f.getNom() } </option></c:forEach>
	                                            </select>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="col-sm-3">
								        	
								        		<input type="hidden" class="form-control" name="id" value="">
								        		 <button type="submit" name="button" value="addFournisseur" class="btn btn-round btn-info">
									        		  <i class="sidenav-icon feather icon-user-plus"></i>
									        		  Nouveau fournisseur
								        		 </button>
								        	                                
                                   		</div>
                                    </div> 
                                </div> 
                                <!-- Form ordinateur -->
                                <div id="ordinateur" class="colors" style="display:none"> 
   		                            <div  class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Code</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="codePC" class="form-control" placeholder="Code">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Marque</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="marquePC" class="form-control" placeholder="Marque">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">CPU</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="cpuPC" class="form-control" placeholder="CPU">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Ecran</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="ecranPC" class="form-control" placeholder="Ecran">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Disque dur</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="disquePC" class="form-control" placeholder="Disque dur">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>       
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Ram</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="ramPC" class="form-control" placeholder="Ram">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>                                                                 
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Durée de garantie</label>
                                        <div class="col-sm-10">
                                            <input type="text" name="garantiePC" class="form-control" placeholder="durée">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div> 
                                    
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Fournisseur</label>
                                        <div class="col-sm-7">
                                            <select id="colorselector" name="fournisseurPC" class="custom-select form-control">
                                              <c:forEach items="${ fournisseur }" var="f">
                                                    <option value="${ f.getCin() }">${ f.getNom() }</option></c:forEach>
	                                            </select>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="col-sm-3">
								        		<input type="hidden" class="form-control" name="id" value="">
								        		 <button type="submit" name="button" value="addFournisseur" class="btn btn-round btn-info">
									        		  <i class="sidenav-icon feather icon-user-plus"></i>
									        		  Nouveau fournisseur
								        		 </button>                                      
                                   		    </div>
                                    </div> 
                                </div>                                   
                                    <div class="form-group row">
                                        <div class="col-sm-10 ml-sm-auto">
                                            <button type="submit" value="AjouterRessource"  name="button" class="btn btn-success">Ajouter</button>
                                        </div>
                                    </div>
                                </form>
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
