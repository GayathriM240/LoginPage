<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Information Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
  .container {
    margin-top: 30px;
  }
  .section-title {
    margin-top: 30px;
    color: #007bff;
    font-size: 22px;
    font-weight: bold;
  }
  label {
    font-weight: bold;
  }
  input, select, textarea {
    margin-bottom: 10px;
  }
  .btn-section {
    margin-top: 20px;
  }
</style>
</head>
<body>

<div class="container">
  <h2 class="text-center">Student Information Form</h2>
  
  <!-- Form Starts -->
  <form action="student" method="post">



  <input type="hidden" name="hiddenStudentId" id="hiddenStudentId">
  
    <!-- 1. Student Details Section -->
    <div class="section-title">1. Student Details</div>
    <div class="row">
      <div class="col-md-4">
        <label>Student Name:</label>
        <input type="text" class="form-control" name="studentName" required>
      </div>
      <div class="col-md-4">
        <label>Date of Birth:</label>
        <input type="date" class="form-control" name="dob" required>
      </div>
      <div class="col-md-4">
        <label>Gender:</label>
        <select class="form-control" name="gender" required>
          <option>Male</option>
          <option>Female</option>
          <option>Other</option>
        </select>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4">
        <label>Blood Group:</label>
        <input type="text" class="form-control" name="bloodGroup" required>
      </div>
      <div class="col-md-4">
        <label>Nationality:</label>
        <input type="text" class="form-control" name="nationality" required>
      </div>
      <div class="col-md-4">
        <label>Student ID / Roll Number:</label>
        <input type="text" class="form-control" name="studentId" required>
      </div>
    </div>
    
    <div class="row">
      <div class="col-md-4">
        <label>Admission Number:</label>
        <input type="text" class="form-control" name="admissionNumber" required>
      </div>
      <div class="col-md-4">
        <label>Course Name:</label>
        <input type="text" class="form-control" name="courseName" required>
      </div>
      <div class="col-md-4">
        <label>Department:</label>
        <input type="text" class="form-control" name="department" required>
      </div>
    </div>

    <div class="row">
      <div class="col-md-4">
        <label>Year of Admission:</label>
        <input type="number" class="form-control" name="yearOfAdmission" required>
      </div>
      <div class="col-md-4">
        <label>Current Year/Semester:</label>
        <input type="text" class="form-control" name="currentYear" required>
      </div>
    </div>

    <!-- 2. Parent/Guardian Details Section -->
  <!--   <div class="section-title">2. Parent/Guardian Details</div>
    <div class="row">
      <div class="col-md-4">
        <label>Parent/Guardian Name:</label>
        <input type="text" class="form-control" name="guardianName" required>
      </div>
      <div class="col-md-4">
        <label>Relationship to Student:</label>
        <input type="text" class="form-control" name="relationship" required>
      </div>
      <div class="col-md-4">
        <label>Contact Number:</label>
        <input type="text" class="form-control" name="guardianContact" required>
      </div>
    </div>

  <!--   <div class="row">
      <div class="col-md-4">
        <label>Email ID:</label>
        <input type="email" class="form-control" name="guardianEmail">
      </div>
      <div class="col-md-4">
        <label>Occupation:</label>
        <input type="text" class="form-control" name="occupation">
      </div>
      <div class="col-md-4">
        <label>Address:</label>
        <textarea class="form-control" name="guardianAddress" rows="2"></textarea>
      </div>
    </div>

    <!-- 3. Fee and Financial Details Section -->
  <!--  <div class="section-title">3. Fee and Financial Details</div>
    <div class="row">
      <div class="col-md-4">
        <label>Tuition Fees Status:</label>
        <input type="text" class="form-control" name="feesStatus" required>
      </div>
      <div class="col-md-4">
        <label>Scholarship Details (if applicable):</label>
        <input type="text" class="form-control" name="scholarship">
      </div>
      <div class="col-md-4">
        <label>Hostel Fee / Mess Fee:</label>
        <input type="text" class="form-control" name="hostelFee">
      </div>
    </div>

    <!-- 4. Additional Details Section -->
   <!-- <div class="section-title">4. Additional Details</div>
    <div class="row">
      <div class="col-md-4">
        <label>Hostel Details:</label>
        <input type="text" class="form-control" name="hostelDetails">
      </div>
      <div class="col-md-4">
        <label>Transportation Details:</label>
        <input type="text" class="form-control" name="transportDetails">
      </div>
      <div class="col-md-4">
        <label>Library Card Number:</label>
        <input type="text" class="form-control" name="libraryCard">
      </div>
    </div> 

    <!-- Submit and Reset Buttons -->
    <div class="text-center btn-section">

      <button type="button" class="btn btn-primary" onclick="viewStudents()">View</button>


      <button type="submit" class="btn btn-success" name="action" value="save">Save</button>
    
    </div>
  </form>
</div>

<!-- JavaScript to handle View Action -->
<script>
function viewStudents() {
    window.location.href = "student?action=view";
}
</script>

</body>
</html>
