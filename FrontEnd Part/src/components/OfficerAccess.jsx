import React, { useState } from 'react'
import HeaderComponent from './HeaderComponent';
import { getFilterStudent } from './EmployeeService';
import { useNavigate } from 'react-router-dom'


function OfficerAccess() {

    const [department, setDepartment] = useState('')
    const [backlogs, setBacklogs] = useState('')
    const [percentage, setPercentage] = useState('')
    const [detail, setdetail] = useState([])
    const navigator = useNavigate()

    function getDetails(e) {
        e.preventDefault();
        console.log(department, backlogs, percentage);

        getFilterStudent(department, backlogs, percentage).then((response) => {
            console.log(response.data);
            setdetail(response.data);
        }).catch((err) => {
            alert("Error: " + err.message);
        });
    }

    function postArticle(){
        navigator('/post-article')
        // have not done//////////////////////////////////////////////////////////////////
    }


    const myStyle = {
        backgroundImage:
            "url('../public/officer3.jpg')",
        height: "100vh",
        marginTop: "-70px",
        fontSize: "50px",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
      };

  return (
    <div>
      <HeaderComponent/>
      <div style={myStyle} >
        <br></br>
        <br></br>
        <div style={{paddingLeft : '30%'}}>
            
            <form>
              <table>
                <tr>
                <td style={{padding : '0'}}> 
                    {/* <input type="text" name="pass" className="form-control" 
                    placeholder=" Enter Department"
                    value={department} onChange={(e) => setDepartment(e.target.value)} required 
                    /> */}
                    <select className='form-control'  onChange={(e) =>  setDepartment(e.target.value)} >
                      <option>Select Department ↆ</option>
                      <option value={'CSE'}>CSE</option>
                      <option value={'Civil'}>Civil</option>
                      <option value={'Mech'}>Mech</option>
                      <option value={'IT'}>IT</option>
                    </select>
                  </td>

                  <td style={{paddingRight : '3%', paddingLeft : '3%'}}>
                    <input type='number' name="uid" className="form-control" 
                    placeholder="Enter Backlogs"
                    value={backlogs} onChange={(e) => setBacklogs(e.target.value)} required 
                    />
                  </td>

                  <td style={{paddingRight : '3%'}}> 
                    <input type="number" name="pass" className="form-control" 
                    placeholder=" Enter Percentage"
                    value={percentage} onChange={(e) => setPercentage(e.target.value)} required 
                    />
                  </td>
                  
                </tr>
                <tr>
                  <td style={{paddingRight : '2%'}}>
                  </td>
                  <td><input type="submit" className="form-control btn btn-outline-success btn-lg download-button" onClick={getDetails}/></td>
                </tr>
                <td></td>
                <td style={{textAlign : 'center'}}><button className=" btn btn-outline-dark btn-lg download-button" onClick={postArticle}>Post Article</button></td>
                <tr>
                    
                </tr>
                
                <tr>
                  {/* <td><a href="Register.jsp" className="register">Don't have account? Register here  <i className=" fas fa-sign-in-alt"></i></a></td> */}
                </tr>
              </table>
            </form>

            
                
        </div>
        <br></br>

        <div className='container' style={{textAlign: "center", fontSize : '50%'}}>
        <h1>Student DataList</h1>
        {/* <button className='btn btn-primary mb-2' onClick={addNewStudent}> Register </button> */}
        <table className='table table-striped table-hover table-borderless' >
            <thead>
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Mobile Number</th>
                    <th>Backlog</th>
                    <th>Department</th>
                    
                </tr>
            </thead>
            <tbody>
                {
                    detail.map(student =>
                        <tr  key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.username}</td>
                            <td>{student.mobileNumber}</td>
                            <td>{student.backlogs}</td>
                            <td>{student.department}</td>
                        </tr>)
                }
            </tbody>
        </table>
    </div>


      </div>
    </div>
  )
}

export default OfficerAccess