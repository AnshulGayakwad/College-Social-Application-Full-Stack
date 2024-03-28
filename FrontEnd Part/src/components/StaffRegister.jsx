import React, { useState } from 'react'
import HeaderForLogin from './LoginDetails/HeaderForLogin'
import FooterComponent from './FooterComponent'
import { createStaff } from './EmployeeService';
import { useNavigate } from 'react-router-dom'

function StaffRegister() {
    const [username, setUsername] = useState('')
    const [password, setpassword] = useState('')
    const [mobileNumber, setMobileNumber] = useState('')
    const navigator = useNavigate();

    function saveStaff(e){
        e.preventDefault();
        const staff = {username, password, mobileNumber}
        console.log(staff)

        createStaff(staff).then((response) =>{
            alert("Registration is Done, Waiting for Approval...");
            console.log(response.data)
        }).catch(error => {
            console.error(error);
        })
        navigator('/')
    }

  return (
    <div>
        <HeaderForLogin/>
        <div className='container'>
            <br/><br/>
            <div className='row'>
                <div className='card col-md-6 offset-md-3 offset-md-3'>
                    <h2>Add New Staff</h2>
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
                            <button type='submit' className='btn btn-primary' onClick={saveStaff}>Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <FooterComponent/>
    </div>
  )
}

export default StaffRegister