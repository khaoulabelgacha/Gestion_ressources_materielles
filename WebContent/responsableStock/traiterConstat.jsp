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
					<div class="card mb-4">
                
	                    <h4 class="card-header">Traiter Constat</h4>
						<div class="card mb-4">
                            <div class="card-body">
                                    <h6 class="card-header">Informations Panne </h6><br>
   		                            <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Code ressource</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="code_resssource" value="${panne.code_ressource  }" disabled></input>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                   <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Type</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="code_resssource" value="${panne.type  }" disabled></input>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Frequence</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="code_resssource" value="${panne.frequence }" disabled></input>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Explication</label>
                                        <div class="col-sm-10">
                                            <input type="text" class="form-control"  name="code_resssource" value="${panne.explication  }" disabled></input>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Constat</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control"  name="constat"  disabled>${ panne.getConstat()  }</textarea>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                   
                            <form action="Servlet2" method="post">         
                                   	<div class="form-group row">
                                        <label class="col-form-label col-sm-2 text-sm-right">Décision</label>
                                        <div class="col-sm-10">
                                            
                                            <select id="colorselector" name="Decision" class="custom-select form-control">
	                                   		<option value="Reparer">Reparer</option>
	                                   		<option value="changer">changer</option>
	                                   		
	                                    </select>
                                            <div class="clearfix"></div>
                                        </div>
                                    </div>
                                     
                            		<div class="form-group row">
                                        <div class="col-sm-10 ml-sm-auto">
                                         
                                            <button name="button" class="btn btn-primary" value="ajouterDecision" >Envoyer</button>
                                             <input type="hidden" name="id_p" value="${panne.id_p }">
                                        </div>
                                    </div>
                            </form>

    
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
