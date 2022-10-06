<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix ="c" %> 
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Modifier Ressources </title>
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
					 	
                      	<h4 class="card-header">Modifier Affectation</h4> <br><br>
						<div class="card mb-4">
                            
                            
                            <div class="card-body">
                            <h6 class="card-header">Informations Ressource </h6> <br>
                                <form method="post" action="Servlet2" >
   		                            <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Ressource</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" value="${ ress }" disabled="disabled">
                                            <input type="hidden" name="ress" class="form-control" value="${ ress }" >
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>		
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Code</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" value="${ ressource.getCode() }" disabled="disabled">
                                            <input type="hidden" name="codeR" class="form-control" value="${ ressource.getCode() }" >
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>	
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Marque</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" value="${ ressource.getMarque() }" disabled="disabled">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Durée de garantie</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" value="${ ressource.getDureeGarantie() }" disabled="disabled">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right" value="">Fournisseur</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" value="${ ressource.getIdF() }" disabled="disabled">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>						
                                                                       
                                     
                                    <hr>
                                    <h6 class="card-header">Informations demandeur </h6>
   		                            <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Employee</label>
                                        <div class="col-sm-10">
                                            <select id="colorselector"  name="employee" class="custom-select form-control">
	                                   		<c:forEach items="${ employee }" var="e">
	                                   		<option value="${ e.getCin() }">${ e.getNom() } ${ e.getPrenom() } </option>
	                                   		</c:forEach>
	                                        </select>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Département</label>
                                        <div class="col-sm-10">
                                            <select id="colorselector" name="departements" class="custom-select form-control">
	                                   		<option>Choisir ..</option>
	                                        <c:forEach items="${ departement }" var="d">
	                                   		<option value="${ d.getIdDep() }">${ d.getNom() } </option>
	                                   		</c:forEach>
	                                        </select>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>  
                                    </div>                                                                        
                                    <div class="form-group row">
                                        <div class="col-sm-10 ml-sm-auto">
                                            <button type="submit" class="btn btn-warning" name="button" value="modifierAfectation">Modifier</button>
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
