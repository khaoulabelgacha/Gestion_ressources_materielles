<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en" class="material-style layout-fixed">

<head>
    <title>Acceuil - chef departement </title>

    <%@ include file="../Layout/styles.jsp" %>
</head>
<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #000;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

.c {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>

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
					 	<!-- <h6 class="text-muted small font-weight-bold py-3 my-4">Striped rows</h6> -->
                      	<div class="card mb-4">
<form action="AjouterPanne?action=signalerPanne" method="post">
    <h6 class="card-header">Signaler Panne</h6>
    <div class="card-body demo-vertical-spacing-sm">
    	<div class="form-group row">
            <div class="col-sm-12">
                <textarea class="form-control" placeholder="Explication" name="explication" id="explication"></textarea>
                <input type="hidden"  name="CIN" value="REALMADRIR">
            </div>
		        </div>
		        <div class="input-group">
		            <select class="custom-select flex-grow-1" name="frequence" id="frequence">
		                <option>Rare</option>
		                <option>frequemente</option>
		                <option>permanente</option>
		            </select>
		            
		        </div>
		        <div class="input-group">
		            <select class="custom-select flex-grow-1" name="type" id="type">
		                 <option>logiciel_systeme</option>
		                <option>logiciel_utilitaire</option>
		                <option>materiel</option>
		            </select>
		        </div>
		         <div class="input-group">
		            <select class="custom-select flex-grow-1" name="code" id="code">
		                  <c:forEach items="${ ADM }" var="c">
		                     <option>${ c }</option>
						  </c:forEach>
		            </select>
		        </div>
		        <div class="form-group row">
				    <div class="col-sm-10 ml-sm-auto">
				        <button type="submit" class="btn btn-primary">Signaler Panne</button>
				    </div>
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
</body>

</html>
