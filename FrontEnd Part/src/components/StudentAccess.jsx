import React, { useEffect, useState } from "react";
import HeaderComponent from "./HeaderComponent";
import { useNavigate } from "react-router-dom";
import { addArticle, getAllArticles, listEvent } from "./EmployeeService";

function StudentAccess() {
  const [approveArticles, setApproveArticles] = useState([]);
  const navigator = useNavigate();
  const [events, setEmployee] = useState([]);
  const [show, setShow] = useState(false);
  const [eventName, setEventName] = useState("");
  const [time, setTime] = useState("");

  const [posts, setPosts] = useState([
    {
      id: 1,
      name: "Post 1",
      personName : "Person 1" ,
      personRole : "Student",
      url: "../public/Posts-images/image1.jpg",
      content:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    },
    {
      id: 2,
      name: "Post 2",
      personName : "Person 2" ,
      personRole : "Officer",
      url: "../public/Posts-images/image2.jpg",
      content:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    },
    {
      id: 3,
      name: "Post 3",
      personName : "Person 3" ,
      personRole : "Officer",
      url: "../public/Posts-images/image3.jpg",
      content:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    },
    {
      id: 4,
      name: "Post 4",
      personName : "Person 4" ,
      personRole : "Student",
      url: "../public/Posts-images/image4.jpg",
      content:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    },
    {
      id: 5,
      name: "Post 5",
      personName : "Person 5" ,
      personRole : "Staff",
      url: "../public/Posts-images/image5.jpg",
      content:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
    },
    {
      id: 6,
      name: "Post 6",
      personName : "Person 6" ,
      personRole : "Admin",
      url: "../public/Posts-images/image6.jpg",
      content:
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, Lorem ipsum dolor sit amet, consecteturLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliquaLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliquasunt in culpa qui officia deserunt mollit anim id est laborum.",
    },
  ]);

  useEffect(() => {
    getAllArticles()
      .then((response) => {
        setApproveArticles(response.data);
      })
      .catch((error) => {
        console.log(error.message);
      });

    listEvent().then((response) => {
      setEmployee(response.data);
    });


  }, []);

  function postEvent(e) {
    e.preventDefault();
    if(validate){
      addArticle(eventName, content).then((response) => {
        console.log(response);
        console.log(time);
        alert(`New Article Added: ${eventName}`);
        window.location.reload();
      })
    } 
    else {
      alert('Please fill out all fields');
    }
    
  }


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
                  placeholder="Enter Article Name"
                  value={eventName}
                  onChange={(e) => setEventName(e.target.value)}
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
            <tr>
            <td>
                <textarea name="" rows="2" cols="20" placeholder="Write your Short Content"
                  value={time} onChange={(e) => setTime(e.target.value)}></textarea>
              </td>
            </tr>
          </table>
        </form>
      </div>
    );
  }

  return (
    <div style={{}}>
      <HeaderComponent />
      <br></br>
      <div className="row">
        <div className="col-8">
          <div
            className="container"
            style={{ textAlign: "center", paddingRight: "3%" }}
          >
            <h3 style={{ textAlign: "left", paddingLeft: "5%" }}>
              Article feed
            </h3>
            <hr></hr>









            <div className="" style={{ textAlign: "left", marginTop: '10px', marginRight: '15%',marginLeft: '15%'}}>
             
                  {posts.map((post) => (
                    <div className="card"  style={{marginBottom : '4%'}}>
                      <div className="row">
                      <div className="col-4">
                      <img className="card-img-top"  src={post.url}></img>
                      </div>

                      <div className="col-8 card-body">
                        {/* <h4>{post.id}</h4> */}
                      <h4>{post.name}</h4>
                      <h6>By - {post.personName}({post.personRole})</h6>
                      <hr></hr>
                      {post.content}
                      </div>
                      </div>
                        
                    </div>
                  ))}

                  
            </div>






          </div>
        </div>
        <div className="col-4">
          <h3>
            <button className=" btn btn-outline-dark btn-lg download-button"
              onClick={() => setShow(!show)}>
              <h3>Add Article</h3>
            </button>
            {show ? getEventForm() : null}

          </h3>
          <h3 style={{ textAlign: "right", paddingRight: "10%" }}>
            Upcoming Events
          </h3>
          <hr></hr>
          <div className="container" style={{paddingRight: "10%"}}>
            <br></br>
            
            <table className="table table-borderless" style={{}}>
              <thead>
                <tr style={{textAlign:"center"}}>
                  <td>Name</td>
                  <td>Time</td>
                  <td>Venue</td>
                </tr>
              </thead>
              <tbody>
                {events.map((event) => (
                  <tr key={event.id} style={{textAlign:"center"}}>
                    <td>{event.eventName}</td>
                    <td>{event.eventDate}</td>
                    <td>{event.eventLocation}</td>
                  </tr>
                ))}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
}

export default StudentAccess;
