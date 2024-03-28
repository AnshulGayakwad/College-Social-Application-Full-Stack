import React from "react";
import './HeaderFooter.css';
import { NavLink } from "react-router-dom";

function HeaderComponent() {
  return (
    <div>
      <header>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <a className="navbar-brand" href="/" style={{paddingLeft : 10}}>
            College Social Media <i className="fas fa-smile"></i>
          </a>
          <div className="navbar-collapse collapse">
            <ul className="navbar-nav">
              <li className="nav-item">
                <NavLink to="" className="nav-link">Home</NavLink>
              </li>
            </ul>
          </div>
          <ul className="navbar-nav">
              <li className="nav-item">
                <NavLink to="/" className="nav-link">Logout
                {window.localStorage.setItem("number", "")}
                
                </NavLink>
              </li>
            </ul>

          {/* <div className="collapse navbar-collapse" id="navbarNav">
            <ul className="navbar-nav ml-auto">
              <li className="nav-item">
                <a className="nav-link" href="#footer">
                  Contact
                </a>
              </li>
              <li className="nav-item">
                <a className="nav-link" href="#features">
                  About
                </a>
              </li>
            </ul>
          </div> */}
        </nav>
      </header>
    </div>
  );
}

export default HeaderComponent;
