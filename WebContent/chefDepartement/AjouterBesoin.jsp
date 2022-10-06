<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Acceuil - chef departement </title>

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
			<%@ include file="../Layout/leftBarChef.jsp" %>
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
                      	
                        <div class="card mb-4">
						      <h6 class="card-header">Ajouter Besoin</h6>
						      <div class="card-body">
						          <form action="AjouterBesoin" method="post">
						              <div class="form-group row">
						                  <label class="col-form-label col-sm-2 text-sm-right" >Type</label>
						                  <div class="col-sm-10">
						                      <select id="inputState" class="form-control" name="type" id="type">
										        <option selected>Ordinateur</option>
										        <option>Imprimante</option>
										      </select>
						                      <div class="clearfix"></div>
						                  </div>
						                  
						          
						              </div>
						              <div class="form-group row">
						                  <label class="col-form-label col-sm-2 text-sm-right">Quantite</label>
						                  <div class="col-sm-10">
						                      <input type="number" min="1" class="form-control" name="Qte" id="Qte">
						                      <input type="hidden"  name="CIN" value="${ cin }">
						                      <div class="clearfix"></div>
						                  </div>
						              </div>
						              <div class="form-group row">
						                  <div class="col-sm-10 ml-sm-auto">
						                      <button type="submit" class="btn btn-primary">Ajouter</button>
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
