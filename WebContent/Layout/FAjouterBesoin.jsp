<div class="card mb-4">
      <h6 class="card-header">Ajouter Besoin</h6>
      <div class="card-body">
          <form action="PersonneBesoin?action=ajouterBesoin" method="post">
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