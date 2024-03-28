import React, { useState } from "react";
import { createStudent } from "./EmployeeService";
import HeaderForLogin from "./LoginDetails/HeaderForLogin";
import FooterComponent from "./FooterComponent";
import { useNavigate } from "react-router-dom";

const StudentComponent = () => {
  const [username, setUsername] = useState("");
  const [password, setpassword] = useState("");
  const [backlogs, setBacklogs] = useState("");
  const [department, setDepartment] = useState("");
  const [percentage, setPercentage] = useState("");
  const [mobileNumber, setMobileNumber] = useState("");
  const navigator = useNavigate();

  const [error, setError] = useState({
    username: "",
    password: "",
    mobileNumber: "",
    department: "",
    backlogs: "",
    percentage: "",
  });

  function validateForm() {
    let valid = true;
    const errorCopy = { ...error };

    if (username.trim()) {
      errorCopy.username = "";
    } else {
      errorCopy.username = "First Name is Required";
      valid = false;
    }

    if (password.trim()) {
      errorCopy.password = "";
    } else {
      errorCopy.password = "Password is required";
      valid = false;
    }

    if (mobileNumber.trim() && mobileNumber.length == 10) {
      errorCopy.mobileNumber = "";
    } else {
      errorCopy.mobileNumber = "Mobile Number must be 10 digits";
      valid = false;
    }

    if (department.trim()) {
      errorCopy.department = "";
    } else {
      errorCopy.department = "Department is required";
      valid = false;
    }

    if (backlogs.trim() && backlogs > -1) {
      errorCopy.backlogs = "";
    } else {
      errorCopy.backlogs = "Backlog is required";
      valid = false;
    }

    if (percentage.trim() && percentage <= 100) {
      errorCopy.percentage = "";
    } else {
      errorCopy.percentage = "Percentage is required";
      valid = false;
    }

    setError(errorCopy);
    return valid;
  }

  function saveStudent(e) {
    e.preventDefault();
    if (validateForm()) {
      const student = {username, password, backlogs, department, percentage, mobileNumber};
      console.log(student);

      createStudent(student).then((response) => {
        alert("Registration is Done, Waiting for Approval...");
        console.log(response.data);
      });

      navigator("/");
    }
  }

//   const validate = () => {
//     let result = true;
//     if (
//       username === "" ||
//       password === "" ||
//       department === "" ||
//       mobileNumber.length != 10 ||
//       backlogs < 0 ||
//       percentage < 0
//     ) {
//       result = false;
//       alert("Please enter valid Details");
//     }

//     return result;
//   };

  return (
    <div>
      <HeaderForLogin />
      <div className="container">
        <br />
        <br />
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h2>Add New Student</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label"> User Name : </label>
                  <input
                    type="text"
                    placeholder="Enter User Name"
                    name="username"
                    value={username}
                    className={`form-control ${error.username ? 'is-invalid' : ''}`}
                    onChange={(e) => setUsername(e.target.value)}
                  ></input>
                  {error.username && <div className="invalid-feedback">{error.username}</div>}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Password : </label>
                  <input
                    type="password"
                    placeholder="Enter Password"
                    name="password"
                    value={password}
                    className={`form-control ${error.password ? 'is-invalid' : ''}`}
                    onChange={(e) => setpassword(e.target.value)}
                  ></input>
                  {error.password && <div className="invalid-feedback">{error.password}</div>}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Backlogs : </label>
                  <input
                    type="number"
                    placeholder="Enter Total Backlogs"
                    name="backlogs"
                    value={backlogs}
                    className={`form-control ${error.backlogs ? 'is-invalid' : ''}`}
                    onChange={(e) => setBacklogs(e.target.value)}
                  ></input>
                  {error.backlogs && <div className="invalid-feedback">{error.backlogs}</div>}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Department : </label>
                  <input
                    type="text"
                    placeholder="Enter Department"
                    name="department"
                    value={department}
                    className={`form-control ${error.department ? 'is-invalid' : ''}`}
                    onChange={(e) => setDepartment(e.target.value)}
                  ></input>
                  {error.department && <div className="invalid-feedback">{error.department}</div>}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Percentage : </label>
                  <input
                    type="number"
                    placeholder="Enter Percentage"
                    name="percentage"
                    value={percentage}
                    className={`form-control ${error.percentage ? 'is-invalid' : ''}`}
                    onChange={(e) => setPercentage(e.target.value)}
                  ></input>
                  {error.percentage && <div className="invalid-feedback">{error.percentage}</div>}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label"> Mobile Number : </label>
                  <input
                    type="number"
                    placeholder="Enter Mobile Number"
                    name="mobileNumber"
                    value={mobileNumber}
                    className={`form-control ${error.mobileNumber ? 'is-invalid' : ''}`}
                    onChange={(e) => setMobileNumber(e.target.value)}
                  ></input>
                  {error.mobileNumber && <div className="invalid-feedback">{error.mobileNumber}</div>}
                </div>
                <button
                  type="submit"
                  className="btn btn-primary"
                  onClick={saveStudent}
                >
                  Submit
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
      <FooterComponent />
    </div>
  );
};

export default StudentComponent;
