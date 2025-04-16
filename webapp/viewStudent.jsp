<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.login.model.student" %>
<!DOCTYPE html>
<html>
<head>
    <title>View Students</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <style>
        table {
            width: 80%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="text-center">Student Information</h2>
        
        <table class="table table-bordered" id="studentTable">
            <thead>
                <tr>
                    <th><input type="checkbox" id="selectAll"></th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>DOB</th>
                    <th>Gender</th>
                    <th>Blood Group</th>
                    <th>Nationality</th>
                    <th>Admission No</th>
                    <th>Course</th>
                    <th>Department</th>
                    <th>Year</th>
                    <th>Current Year</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<student> students = (List<student>) request.getAttribute("studentList");
                    if (students != null && !students.isEmpty()) {
                        for (student s : students) {
                %>
                <tr data-id="<%= s.getStudentId() %>">
                    <td><input type="checkbox" class="rowCheckbox"></td>
                    
                    <td><%= s.getStudentId() %></td>
                    <td><input type="text" class="editable" value="<%= s.getStudentName() %>" disabled></td>
                    <td><input type="date" class="editable" value="<%= s.getDob() %>" disabled></td>
                    <td><input type="text" class="editable" value="<%= s.getGender() %>" disabled></td>
                    <td><input type="text" class="editable" value="<%= s.getBloodGroup() %>" disabled></td>
                    <td><input type="text" class="editable" value="<%= s.getNationality() %>" disabled></td>
                    <td><input type="text" class="editable" value="<%= s.getAdmissionNumber() %>" disabled></td>
                    <td><input type="text" class="editable" value="<%= s.getCourseName() %>" disabled></td>
                    <td><input type="text" class="editable" value="<%= s.getDepartment() %>" disabled></td>
                    <td><input type="number" class="editable" value="<%= s.getYearOfAdmission() %>" disabled></td>
                    <td><input type="number" class="editable" value="<%= s.getCurrentYear() %>" disabled></td>
                    <td>
                        <button class="btn btn-warning" onclick="enableEdit(this)">Edit</button>
                        <button class="btn btn-success" onclick="saveEdit(this)" style="display:none;">Save</button>
                    </td>
                    <td>
    
    <button class="btn btn-danger" onclick="deleteRow(this)">Delete</button> <!-- New Delete Button -->
</td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="13" class="text-center">No student records found.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <a href="studentdetails.jsp" class="btn btn-primary">Back</a>
    </div>

    <script>
    // Select All Checkbox Functionality
    document.getElementById("selectAll").addEventListener("change", function() {
        let checkboxes = document.querySelectorAll(".rowCheckbox");
        checkboxes.forEach(checkbox => {
            checkbox.checked = this.checked;
        });
    });
        function enableEdit(button) {
            let row = button.closest("tr");
            let inputs = row.querySelectorAll(".editable");

            inputs.forEach(input => input.disabled = false);

            button.style.display = "none";
            row.querySelector(".btn-success").style.display = "inline-block"; // Show "Save"
        }

        function saveEdit(button) {
            let row = button.closest("tr");
            let inputs = row.querySelectorAll(".editable");
            let studentId = row.getAttribute("data-id");

            let data = {
                studentId: studentId,
                studentName: inputs[0].value,
                dob: inputs[1].value,
                gender: inputs[2].value,
                bloodGroup: inputs[3].value,
                nationality: inputs[4].value,
                admissionNumber: inputs[5].value,
                courseName: inputs[6].value,
                department: inputs[7].value,
                yearOfAdmission: inputs[8].value,
                currentYear: inputs[9].value
            };

            fetch('UpdateStudentServlet', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
            .then(response => response.text())
            .then(result => {
                alert(result);
                inputs.forEach(input => input.disabled = true);
                button.style.display = "none";
                row.querySelector(".btn-warning").style.display = "inline-block"; // Show "Edit"
            })
            .catch(error => console.error('Error:', error));
        }
        function deleteRow(button) {
            let row = button.closest("tr"); // Find the closest row (tr)
            row.remove(); // Remove the row from the table
        }
    </script>

</body>
</html>
