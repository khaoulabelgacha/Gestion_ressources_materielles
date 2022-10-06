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
					 	
                      	
                       <form method="post" action="Servlet2">
                           <input type="hidden" name="codeImp" class="form-control" value="${ codeImp }">
                            <input type="hidden" name="codeOrd" class="form-control" value="${ codeOrd }">
	                        <h4 class="card-header">Choisissez un département  </h4><br><br>
	                        <div class="form-group row">
	                               <label class="col-form-label col-sm-2 text-sm-right">Département</label>
	                               <div class="col-sm-5">
	                                   <select id="colorselector" name="departements" class="custom-select form-control">
	                                   		<option>Choisir ..</option>
	                                        <c:forEach items="${ departement }" var="d">
	                                   		<option value="${ d.getIdDep() }">${ d.getNom() } </option>
	                                   		</c:forEach>
	                                    </select>
	                                   <div class="clearfix"></div>
	                               </div>

	                         </div> 
	                        <h4 class="card-header">Choisissez un enseignant  </h4><br><br>
	                        <div class="form-group row">
	                               <label class="col-form-label col-sm-2 text-sm-right">Enseignant</label>
	                               <div class="col-sm-5">
	                                   <select id="colorselector"  name="employee" class="custom-select form-control">
	                                   		<c:forEach items="${ employee }" var="e">
	                                   		<option value="${ e.getCin() }">${ e.getNom() } ${ e.getPrenom() } </option>
	                                   		</c:forEach>
	                                    </select>
	                                   <div class="clearfix"></div>
	                               </div>
	                         </div> <br>
	                         <div class="form-group row">
		                         <div class="col-sm-7"> </div>
		                         <div class="col-sm-3"> 
		                            <button type="submit" name="button" value="affEnseignant1" class="btn btn-success">Affecter</button>
		                         </div>
	                         </div>
                        </form>                       	


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
