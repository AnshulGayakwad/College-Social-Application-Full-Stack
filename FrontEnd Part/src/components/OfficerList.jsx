import React, {useEffect, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import { listOfficer, updateOfficer } from './EmployeeService';
import HeaderComponent from './HeaderComponent';

function OfficerList() {
    const [employee, setEmployee] = useState([])
    const navigator = useNavigate();

    useEffect(() =>{
        listOfficer().then((response) =>{
            setEmployee(response.data);
        }).catch(error =>{
            alert(error.message);
        })
    }, [])

    function updateStud(id, state){
        updateOfficer(id, state).then((response) =>{
            alert(response.data);
        })
        window.location.reload();
    }

    function getListofOfficer(){
        navigator('/list-of-officer');
    }
    function getListofStudent(){
        navigator('/list-of-student');
    }
    function getListofStaff(){
        navigator('/list-of-staff');
    }
    function getListofArticles(){
        navigator('/list-of-article');
    }

  return (
    <div>
        <HeaderComponent/>
        <div className='container' style={{textAlign: "center"}}>
        
        <div style={{marginTop : '2%'}}>
            <button style={{marginRight : '1%', }} onClick={getListofOfficer} type="button" className="btn btn-outline-success btn-lg download-button">Get List of Officers</button>
            <button style={{marginRight : '1%'}} onClick={getListofStudent} type="button" className="btn btn-outline-success btn-lg download-button">Get List of Students</button>
            <button style={{marginRight : '1%'}} type="button" onClick={getListofStaff} className="btn btn-outline-success btn-lg download-button">Get List of Staff</button>
            <button type="button" onClick={getListofArticles} className="btn btn-outline-success btn-lg download-button">Get List of Articles</button>
        </div>
        <h1>Officer DataList</h1>
        {/* <button className='btn btn-primary mb-2' onClick={addNewStudent}> Register </button> */}
        <table className='table table-striped' >
            <thead className='table-info'>
                <tr>
                    <th>Officer ID</th>
                    <th>Officer Name</th>
                    <th>Mobile Number</th>
                    <th>Loging Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                {
                    employee.map(student =>
                        <tr  key={student.id}>
                            <td>{student.id}</td>
                            <td>{student.username}</td>
                            <td>{student.mobileNumber}</td>
                            <td>{student.status}</td>
                            <td>
                                <button className='btn btn-success' onClick={() => updateStud(student.mobileNumber, 'APPROVED')} style={{marginRight : '3%'}}>Accept</button>
                                <button className='btn btn-danger' onClick={() => updateStud(student.mobileNumber, 'REJECTED')}>Reject</button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
    </div>
  )
}

export default OfficerList