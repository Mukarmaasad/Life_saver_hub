
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Blood Bank Stock</title>
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    <!-- Link to the external JavaScript file -->
    <script type="text/javascript" src="./JS/hospitalcharts.js"></script>
    


    <h2 style="text-align: center;">BloodBank Of Hospitals</h2>

   <section>
      <div class="col-md-3">
                        <label for="Dropdownofhospitals " class="form-label"><b>Hospital Name</b></label>
    
                          <select id="Dropdownofhospitals" class="form-select form-select-sm" name="HOSPITAL_NAME">
                          <option value="">Select Hospital</option>
                            </select>
                    </div>
     </section>

 <div style="width: 50%; margin: auto;">
        <canvas id="bloodChart"></canvas>
    </div>

