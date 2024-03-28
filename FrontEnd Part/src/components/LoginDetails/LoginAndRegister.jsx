
import React, { useEffect, useState } from 'react'
import FooterComponent from '../FooterComponent'
import HeaderForLogin from './HeaderForLogin'
import { useNavigate } from 'react-router-dom'
import { isUserPresent } from '../EmployeeService'

function LoginAndRegister() {

  const [mobileNumber, setMobileNumber] = useState('')
  const [password, setpassword] = useState('')
  const [role, setRole] = useState('')
  const [detail, setdetail] = useState('')

  const navigator = useNavigate();

  function getLoginDetails(e){
    e.preventDefault();
    if(!validate){
      alert("Please enter valid Details");
      window.location.reload();
    }
    console.log(mobileNumber, password, role)

    isUserPresent(mobileNumber, password, role).then((response) => {
  
      console.log("From LoginAndRegister.jsx " + response)
      setdetail(response.data);
     
      if(role == 'admin'){
        navigator('/admin')
      }else if(role == 'officer'){
        navigator('/officer')
      }else if(role == 'staff'){
        sessionStorage.setItem("number", mobileNumber);
        navigator('/staff')
      }else if(role =='student'){
        navigator('/student')
      } else {
        alert("Invalid Mobile Number or Password")
        navigator('/')
      }
    }).catch((err)=>{
      console.error("Error in getting user details : ", err.message)
      alert("Please enter valid Mobile Number or Password")
    })
  }

  function registerStudent(){
    navigator('/add-student')
  }

  function registerOfficer(){
    navigator('/add-officer')
  }

  function registerStaff(){
    navigator('/add-staff')
  }

  const validate = () => {
    let result = true;
    if(password === '' || mobileNumber.length != 10 || role === ''){
        result = false;
        alert("Please enter valid Details")
    }

    return result;
}

const myStyle = {
  backgroundImage:
      "url('../public/loginBg.png')",
  height: "100vh",
  marginTop: "-70px",
  fontSize: "50px",
  backgroundSize: "cover",
  backgroundRepeat: "no-repeat",
};

  return (
    <div>
      <div>
        <HeaderForLogin />
      </div>
      <div style={myStyle}>
        <div className="row" style={{ paddingLeft: '3%', paddingTop : '10%' }}>
          <div className="col-lg-6">
            <h1 className="big-heading">Get all Insights of College... <span className="bigText-style">Social Network</span></h1>
          </div>
          <div className="col-lg-6 maintext" style={{ paddingLeft: '3%' }}>
            <table>
              <tr>
                <td><a className="nav-link" onClick={registerStudent}><button type="button" className="btn btn-dark btn-lg download-button">Register as Student</button></a></td>
                <td></td>
                <td><a className="nav-link" onClick={registerOfficer}><button type="button" className="btn btn-outline-dark btn-lg download-button"> Register as Officer</button></a></td>
                <td><a className="nav-link" onClick={registerStaff}><button type="button" className="btn btn-dark btn-lg download-button">Register as Staff</button></a></td>
                <td></td>
              </tr>
            </table>
            <br />
            <br />
            <h3 style={{paddingBottom : '2%'}}>Already joined us.....</h3>
            <form>
              <table>
                <tr>
                  <td style={{paddingRight : '2%'}}>
                    <input type='number' name="uid" className="form-control" 
                    placeholder="Enter Mobile Number"
                    value={mobileNumber} onChange={(e) => setMobileNumber(e.target.value)} required 
                    />
                  </td>
                  <td > 
                    <input type="password" name="pass" className="form-control" 
                    placeholder=" Password"
                    value={password} onChange={(e) => setpassword(e.target.value)} required 
                    />
                  </td>
                  
                </tr>
                <tr>
                  <td style={{paddingRight : '2%'}}>
                    <select className='form-control' value={role} onChange={(e) =>  setRole(e.target.value)} >
                      <option>Select Role   ↆ</option>
                      <option value={'admin'}>Admin</option>
                      <option value={'officer'}>Officer</option>
                      <option value={'staff'}>Staff</option>
                      <option value={'student'}>Student</option>
                    </select>
                  </td>
                  <td><input type="submit" className="form-control btn btn-outline-success btn-lg download-button" onClick={getLoginDetails}/></td>
                </tr>
                <tr>

                </tr>
                
                <tr>
                  {/* <td><a href="Register.jsp" className="register">Don't have account? Register here  <i className=" fas fa-sign-in-alt"></i></a></td> */}
                </tr>
              </table>
            </form>
          </div>
        </div>
      </div>
      <div>
      </div>
    </div>
  )
}

export default LoginAndRegister

















// import React, { useEffect, useState } from "react";
// import FooterComponent from "../FooterComponent";
// import HeaderForLogin from "./HeaderForLogin";
// import { useNavigate } from "react-router-dom";
// import { isUserPresent } from "../EmployeeService";

// function LoginAndRegister() {
//   const [mobileNumber, setMobileNumber] = useState("");
//   const [password, setpassword] = useState("");
//   const [role, setRole] = useState("");
//   const [detail, setdetail] = useState("");
//   const navigator = useNavigate();
//   const [error, setError] = useState({
//     role: "",
//     password: "",
//     mobileNumber: ""
//   });

//   function getLoginDetails(e) {
//     e.preventDefault();

//     if (validateForm()) {
//       console.log(mobileNumber, password, role);

//       isUserPresent(mobileNumber, password, role)
//         .then((response) => {
//           console.log("From LoginAndRegister.jsx " + response);
//           setdetail(response.data);
//           window.localStorage.setItem("number", mobileNumber);

//           if (role == "admin") {
//             navigator("/admin");
//           } else if (role == "officer") {
//             navigator("/officer");
//           } else if (role == "staff") {
//             navigator("/staff");
//           } else if (role == "student") {
//             navigator("/student");
//           } else {
//             alert("Invalid Mobile Number or Password");
//             navigator("/");
//           }
//         })
//         .catch((err) => {
//           console.error("Error in getting user details : ", err.message);
//         });
//     }
//   }

//   function registerStudent() {
//     navigator("/add-student");
//   }

//   function registerOfficer() {
//     navigator("/add-officer");
//   }

//   function registerStaff() {
//     navigator("/add-staff");
//   }

//   //   const validate = () => {
//   //     let result = true;
//   //     if(password === '' || mobileNumber.length != 10 || role === ''){
//   //         result = false;
//   //         alert("Please enter valid Details")
//   //     }

//   //     return result;
//   // }

//   function validateForm(){
//     let valid = true;
//     const errorCopy = {...error};

//     if(role.trim()){
//       errorCopy.role = "";
//     }else{
//       errorCopy.role = "Please Select Role";
//       valid = false;
//     }

//     if (password.trim()) {
//       errorCopy.password = "";
//     } else {
//       errorCopy.password = "Password is required";
//       valid = false;
//     }

//     if (mobileNumber.length != 10) {
//       errorCopy.mobileNumber = "";
//     } else {
//       errorCopy.mobileNumber = "Mobile Number must be 10 digits";
//       valid = false;
//     }

//     setError(errorCopy);
//     return valid;
//   }

//   const myStyle = {
//     backgroundImage: "url('../public/loginBg.png')",
//     height: "100vh",
//     marginTop: "-70px",
//     fontSize: "50px",
//     backgroundSize: "cover",
//     backgroundRepeat: "no-repeat",
//   };

//   return (
//     <div>
//       <div>
//         <HeaderForLogin />
//       </div>
//       <div style={myStyle}>
//         <div className="row" style={{ paddingLeft: "3%", paddingTop: "10%" }}>
//           <div className="col-lg-6">
//             <h1 className="big-heading">
//               Get all Insights of College...{" "}
//               <span className="bigText-style">Social Network</span>
//             </h1>
//           </div>
//           <div className="col-lg-6 maintext" style={{ paddingLeft: "3%" }}>
//             <table>
//               <tr>
//                 <td>
//                   <a className="nav-link" onClick={registerStudent}>
//                     <button
//                       type="button"
//                       className="btn btn-dark btn-lg download-button"
//                     >
//                       Register as Student
//                     </button>
//                   </a>
//                 </td>
//                 <td></td>
//                 <td>
//                   <a className="nav-link" onClick={registerOfficer}>
//                     <button
//                       type="button"
//                       className="btn btn-outline-dark btn-lg download-button"
//                     >
//                       {" "}
//                       Register as Officer
//                     </button>
//                   </a>
//                 </td>
//                 <td>
//                   <a className="nav-link" onClick={registerStaff}>
//                     <button
//                       type="button"
//                       className="btn btn-dark btn-lg download-button"
//                     >
//                       Register as Staff
//                     </button>
//                   </a>
//                 </td>
//                 <td></td>
//               </tr>
//             </table>
//             <br />
//             <br />
//             <h3 style={{ paddingBottom: "2%" }}>Already joined us.....</h3>
//             <form>
//               <table>
//                 <tr>
//                   <td style={{ paddingRight: "2%" }}>
//                     <input
//                       type="number"
//                       name="uid"
//                       className={`form-control ${error.mobileNumber ? 'is-valid' : ''}`}
//                       placeholder="Enter Mobile Number"
//                       value={mobileNumber}
//                       onChange={(e) => setMobileNumber(e.target.value)}
//                       required
//                     />
//                     {error.mobileNumber && <div className="invalid-feedback">{error.mobileNumber}</div>}
//                   </td>
//                   <td>
//                     <input
//                       type="password"
//                       name="pass"
//                       className={`form-control ${error.password ? 'is-invalid' : ''}`}
//                       placeholder=" Password"
//                       value={password}
//                       onChange={(e) => setpassword(e.target.value)}
//                       required
//                     />
//                     {error.password && <div className="invalid-feedback"></div>}
//                   </td>
//                 </tr>
//                 <tr>
//                   <td style={{ paddingRight: "2%" }}>
//                     <select
//                       className={`form-control ${error.role ? 'is-invalid' : ''}`}
//                       value={role}
//                       onChange={(e) => setRole(e.target.value)}
//                     >
//                       <option>Select Role ↆ</option>
//                       <option value={"admin"}>Admin</option>
//                       <option value={"officer"}>Officer</option>
//                       <option value={"staff"}>Staff</option>
//                       <option value={"student"}>Student</option>
//                     </select>
//                     {error.role && <div className="invalid-feedback"></div>}
//                   </td>
//                   <td>
//                     <input
//                       type="submit"
//                       className="form-control btn btn-outline-dark btn-lg download-button"
//                       onClick={getLoginDetails}
//                     />
//                   </td>
//                 </tr>
//                 <tr></tr>

//                 <tr>
//                   {/* <td><a href="Register.jsp" className="register">Don't have account? Register here  <i className=" fas fa-sign-in-alt"></i></a></td> */}
//                 </tr>
//               </table>
//             </form>
//           </div>
//         </div>
//       </div>
//       <div></div>
//     </div>
//   );
// }

// export default LoginAndRegister;
