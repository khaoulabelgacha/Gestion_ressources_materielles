<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Ajouter Fournisseur </title>

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
					 	<h4 class="card-header">Ajouter Fournisseur</h4>
						<div class="card mb-4">
                            
                            
                            <div class="card-body">
                                <form method="post" action="Servlet2">
                                
                                    <h6 class="card-header">Informations Fournisseur </h6><br>
   		                            <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">CIN</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="cinF" placeholder="CIN">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Nom</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="nomF" placeholder="Nom">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Prénom</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="prenomF" placeholder="Prénom">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Email</label>
                                        <div class="col-sm-10">
                                            <input type="email" class="form-control" name="emailF" placeholder="Email">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Tèl</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="phoneF" placeholder="06xxxxxxxx">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div> 
									<div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Société</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control" name="societeF" placeholder="Société">
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>                                   
                                                                                                           
                                    <div class="form-group row">
                                        <div class="col-sm-10 ml-sm-auto">
                                            <button type="submit" name="button" value="ajouterFournisseur" class="btn btn-success">Ajouter</button>
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
</body>

</html>
