import React, {useEffect, useState} from 'react'
import HeaderComponent from "./HeaderComponent";
import { createEvent, listEmployee, listEvent } from "./EmployeeService";
import FooterComponent from './FooterComponent';

function StaffAccess() {
  const [show, setShow] = useState(false);
  const [eventName, setEventName] = useState("");
  const [time, setTime] = useState("");
  const [venue, setVenue] = useState("");
  const [events, setEmployee] = useState([])
  const [employee, setEmp] = useState([])

  useEffect(() =>{
    listEvent().then((response) =>{
        setEmployee(response.data);
    })

    listEmployee().then((response) =>{
      setEmp(response.data);
      console.log(response.data);
  })

}, [])

  function postEvent(e) {
    e.preventDefault();
    if(validate){
      createEvent(eventName, time, venue).then((response) => {
        console.log(response);
        console.log(time);
        alert(`New event created: ${eventName}`);
        window.location.reload();
      })
    } 
    else {
      alert('Please fill out all fields');
    }
    
  }

  const validate = () => {
    let result = true;
    if (eventName == "" || time == null || venue == "") {
      result = false;
      alert("Please enter valid Details");
    }
    return result;
  };

  const myStyle = {
    backgroundImage: "url('../public/staff.jpg')",
    height: "100vh",
    marginTop: "-70px",
    fontSize: "50px",
    backgroundSize: "cover",
    backgroundRepeat: "no-repeat",
  };

  function getEventForm() {
    return (
      <div>
        <form>
          <table>
            <tr>
              <td style={{ paddingRight: "2%" }}>
                <input
                  type="text"
                  name="uid"
                  className="form-control"
                  placeholder="Enter Event Name"
                  value={eventName}
                  onChange={(e) => setEventName(e.target.value)}
                  required
                />
              </td>
              <td>
                <input
                  type="datetime-local"
                  className="form-control"
                  placeholder=" Select Date"
                  value={time}
                  onChange={(e) => setTime(e.target.value)}
                  required
                />
              </td>
            </tr>
            <tr>
              <td style={{ paddingRight: "2%" }}>
                <input
                  type="text"
                  className="form-control"
                  placeholder=" Enter Venue"
                  value={venue}
                  onChange={(e) => setVenue(e.target.value)}
                  required
                />
              </td>
              <td>
                <input
                  type="submit"
                  className="form-control btn btn-outline-dark btn-lg download-button"
                  onClick={postEvent}
                />
              </td>
            </tr>
            <tr></tr>
            <tr>
              {/* <td><a href="Register.jsp" className="register">Don't have account? Register here  <i className=" fas fa-sign-in-alt"></i></a></td> */}
            </tr>
          </table>
        </form>
      </div>
    );
  }

  return (
    <div>
      <HeaderComponent />
      <br></br>
      <div style={myStyle}>
        <br></br>
        <div className="row">
          <div className="col"></div>

          <div className="col" style={{ marginLeft: "15%" }}>
            <h1>Hello welcome</h1>
            <hr></hr>
            <button
              className=" btn btn-outline-dark btn-lg download-button"
              onClick={() => setShow(!show)}
            >
              Add new Event
            </button>
            {show ? getEventForm() : null}




            <div className="container">
              <br></br>
              <h2>Upcomming Events</h2>
              <table
                className="table table-borderless"
                style={{ opacity: "50%", fontSize: "50%" }}
              >
                <thead>
                  <tr>
                    <td>Name</td>
                    <td>Time</td>
                    <td>Venue</td>
                  </tr>
                </thead>
                <tbody>
                  {
                    events.map(event => 
                      <tr  key={event.id}>
                        <td>{event.eventName}</td>
                        <td>{event.eventDate}</td>
                        <td>{event.eventLocation}</td>
                      </tr>
                    )
                  }
                </tbody>
              </table>
            </div>
          </div>
        </div>
      </div>
      <div style={{backgroundColor : "#edf0f1", paddingLeft : '20%', paddingRight : '20%'}}>
      <div className="container" style={{ textAlign: "center"}}>
        <h1>Student DataList</h1>
        {/* <button className='btn btn-primary mb-2' onClick={addNewStudent}> Register </button> */}
        <table className="table table-borderless table-hover" style={{backgroundColor : "#edf0f1"}}>
          <thead className="table">
            <tr style={{backgroundColor : "#edf0f1"}}>
              <th>Student ID</th>
              <th>Student Name</th>
              <th>Mobile Number</th>
              <th>Backlog</th>
              <th>Department</th>
            </tr>
          </thead>
          <tbody style={{backgroundColor : "#edf0f1"}}>
            {employee.map((student) => (
              <tr key={student.id}>
                <td>{student.id}</td>
                <td>{student.username}</td>
                <td>{student.mobileNumber}</td>
                <td>{student.backlogs}</td>
                <td>{student.department}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      </div>
      <FooterComponent/>
    </div>
  );
}

export default StaffAccess;
