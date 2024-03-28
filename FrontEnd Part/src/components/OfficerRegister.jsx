import React, { useState } from 'react'
import HeaderForLogin from './LoginDetails/HeaderForLogin'
import FooterComponent from './FooterComponent'
import { createOfficer } from './EmployeeService'
import { useNavigate } from 'react-router-dom'

function OfficerRegister() {
    const [username, setUsername] = useState('')
    const [password, setpassword] = useState('')
    const [mobileNumber, setMobileNumber] = useState('')
    const navigator = useNavigate();

    function saveOfficer(e){
        e.preventDefault();
        const officer = {username, password, mobileNumber}
        console.log(officer)

        createOfficer(officer).then((response) =>{
            alert("Registration is Done, Waiting for Approval...");
            console.log(response.data)
        }).catch(error => {
            console.error(error);
        })
        navigator('/')
    }
    
    const myStyle = {
        backgroundImage:
            "url('../public/officerRegister.png')",
        height: "100vh",
        marginTop: "-70px",
        fontSize: "50px",
        backgroundSize: "cover",
        backgroundRepeat: "no-repeat",
      };

  return (
    <div>
        <HeaderForLogin/>
        <div >
            <br/><br/>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <h2>Add New  Placement Officer</h2>
                    <div className='card-body'>
                        <form >
                            <div className='form-group mb-2'>
                                <label className='form-label'> User Name : </label>
                                <input type='text' placeholder='Enter User Name' name='username' value={username}
                                    className='form-control' onChange={(e) => setUsername(e.target.value)} required
                                ></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'> Password : </label>
                                <input type='password' placeholder='Enter Password' name='password' value={password}
                                    className='form-control' onChange={(e) => setpassword(e.target.value)} required
                                ></input>
                            </div>
                            <div className='form-group mb-2'>
                                <label className='form-label'> Mobile Number : </label>
                                <input type='number' placeholder='Enter Mobile Number' name='mobileNumber' value={mobileNumber}
                                    className='form-control' onChange={(e) => setMobileNumber(e.target.value)} required max={10} min={10}
                                ></input>
                            </div>
                            <button type='submit' className='btn btn-primary' onClick={saveOfficer}>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
  )
}

export default OfficerRegister