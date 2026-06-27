/**
 * 
 */
// Function to filter the table based on Blood Group and Address
    function filterTable() {
        // Get the input values for Blood Group and Address
        var bloodGroupSearch = document.getElementById('bloodGroupSearch').value.toLowerCase();
        var addressSearch = document.getElementById('addressSearch').value.toLowerCase();

        // Get all the rows in the table
        var rows = document.querySelectorAll('#registerTable tbody tr');

        // Loop through each row
        rows.forEach(function(row) {
            // Get the cells in the row
            var cells = row.getElementsByTagName('td');
            
            // Get the Blood Group and Address values from the respective cells
            var bloodGroup = cells[5].textContent.toLowerCase(); // Blood Group is in the 6th column (index 5)
            var address = cells[3].textContent.toLowerCase(); // Address is in the 5th column (index 4)

            // Check if the row matches the search input
            if (bloodGroup.includes(bloodGroupSearch) && address.includes(addressSearch)) {
                row.style.display = ''; // Show the row if it matches
            } else {
                row.style.display = 'none'; // Hide the row if it doesn't match
            }
        });
    }

    // Attach event listeners to the search input fields
    document.getElementById('bloodGroupSearch').addEventListener('input', filterTable);
    document.getElementById('addressSearch').addEventListener('input', filterTable);
    
    
    
 function filterByHospitalAddress() {
    var addressSearch = document.getElementById('HospitaladdressSearch').value.toLowerCase();
    var rows = document.querySelectorAll('#userTable tbody tr');

    rows.forEach(function(row) {
        var addressCell = row.getElementsByTagName('td')[1]; // 👈 Correct index now

        if (addressCell) {
            var address = addressCell.textContent.toLowerCase();
            row.style.display = address.includes(addressSearch) ? '' : 'none';
        }
    });
}

document.getElementById('HospitaladdressSearch').addEventListener('input', filterByHospitalAddress);

    
    