<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="card mb-4">
<form action="PersonneBesoin?action=signalerPanne" method="post">
    <h6 class="card-header">Signaler Panne</h6>
    <div class="card-body demo-vertical-spacing-sm">
    	<div class="form-group row">
            <div class="col-sm-12">
                <textarea class="form-control" placeholder="Explication" name="explication" id="explication"></textarea>
            </div>
        </div>
        <div class="input-group">
            <select class="custom-select flex-grow-1" name="frequence" id="frequence">
                <option>rare</option>
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
            	<c:forEach var="liste" items="${ listes }">
				      <option><c:out value="${ liste }"></c:out></option>	    
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