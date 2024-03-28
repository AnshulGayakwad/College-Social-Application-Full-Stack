import { useState } from 'react'
import './App.css'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import 'bootstrap/dist/css/bootstrap.min.css'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import StudentComponent from './components/StudentComponent'
import RegisterComponent from './components/RegisterComponent'
import LoginAndRegister from './components/LoginDetails/LoginAndRegister'
import OfficerRegister from './components/OfficerRegister'
import StaffRegister from './components/StaffRegister'
import StudentAccess from './components/StudentAccess'
import OfficerList from './components/OfficerList'
import StaffList from './components/StaffList'
import ArticleList from './components/ArticleList'
import OfficerAccess from './components/OfficerAccess'
import StaffAccess from './components/StaffAccess'

function App() {

  return (
    <>
      <BrowserRouter> 
        {/* <HeaderComponent/> */}
        <Routes>
          <Route path='/' element={<LoginAndRegister/>}></Route>
          <Route path='/add-officer' element={<OfficerRegister/>}></Route>
          <Route path='/add-staff' element={<StaffRegister/>}></Route>
          <Route path='/admin' element={<ListEmployeeComponent/>}></Route>
          <Route path='/student' element={<StudentAccess/>}></Route>
          <Route path='/officer' element={<OfficerAccess/>}></Route>
          <Route path='/staff' element={<StaffAccess/>}></Route>
          <Route path='/add-student' element={<StudentComponent/>}></Route>
          <Route path='/list-of-officer' element={<OfficerList/>}></Route>
          <Route path='/list-of-student' element={<ListEmployeeComponent/>}></Route>
          <Route path='/list-of-staff' element={<StaffList/>}></Route>
          <Route path='/list-of-article' element={<ArticleList/>}></Route>
          {/* http://localhost:3000/student-status/1/status */}
          {/* <Route path='/student-status/:id/:state' element={<StudentStatus/>}></Route> */}
          {/* <Route path='/register' element={<RegisterComponent/>}></Route> */}
        </Routes>
        {/* <ListEmployeeComponent/> */}
        {/* <FooterComponent/>  */}
        </BrowserRouter>
    </>
  )
}

export default App
