import React from 'react'
import { NavLink } from 'react-router-dom'; 

function HeaderForLogin() {
  return (
    <div>
        <header>
        <nav className="navbar navbar-expand-lg navbar-dark bg-dark">
          <a className="navbar-brand" href="/" style={{paddingLeft : 10}}>
            College Social Media <i className="fas fa-smile"></i>
          </a>
          <a className="navbar-brand" href="/" style={{paddingLeft : 10}}>
            Home<i className="fas fa-smile"></i>
          </a>
          <div className="navbar-collapse collapse">
          </div>
          <ul className="navbar-nav">
              <li className="nav-item">
                <NavLink to="/" className="nav-link">Hii There 👋!</NavLink>
              </li>
            </ul>
        </nav>
      </header>
    </div>
  )
}

export default HeaderForLogin