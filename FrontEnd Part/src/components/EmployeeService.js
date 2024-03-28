import axios from "axios";


const REST_API_BASE_URL = 'http://localhost:8080/'

/////////////////////////// GET METHODS //////////////////////////////////////
const REST_GET_API = REST_API_BASE_URL + 'admin/students'
export const listEmployee = () =>{
    return axios.get(REST_GET_API);
}

export const listOfficer = () =>{
    const REST_GET_API = REST_API_BASE_URL + 'admin/placementOfficers'
    return axios.get(REST_GET_API);
}

export const listStaff = () =>{
    const REST_GET_API = REST_API_BASE_URL + 'admin/staff'
    return axios.get(REST_GET_API);
}

export const listArticle = () =>{
    const REST_GET_API = REST_API_BASE_URL + 'admin/articles'
    return axios.get(REST_GET_API);
}

export const listEvent = () =>{
    const REST_GET_API = REST_API_BASE_URL + 'staff/getAllEvents'
    return axios.get(REST_GET_API);
}

export const listApprovedArticle = () =>{
    const REST_GET_API = REST_API_BASE_URL + 'admin/articles'
    return axios.get(REST_GET_API);
}

export const getFilterStudent = (department, backlogs, percentage) => {
    const REST_GET_API = REST_API_BASE_URL + 'placement-officer/getStudentsByFilter/' + department + '/' + backlogs + '/' + percentage;
    return axios.get(REST_GET_API);
}

export const getAllArticles = () => {
    const REST_GET_API = REST_API_BASE_URL + 'students/get-AllArticles'
    return axios.get(REST_GET_API);
}

/////////////////////////// POST/CREATE METHODS //////////////////////////////////////

const REST_POST_API = REST_API_BASE_URL + 'students/register'
export const createStudent = (student) =>{
    return axios.post(REST_POST_API, student);
}

export const createOfficer = (officer) => {
    return axios.post(REST_API_BASE_URL + 'placement-officer/register', officer);
}

export const createStaff = (staff) => {
    return axios.post(REST_API_BASE_URL + 'staff/register', staff);
}

export const createEvent = (name, date, location) => {
    const mobileNumber = window.sessionStorage.getItem("number");
    console.log('from router part (Create event - log)  :- '+mobileNumber)
    return axios.post(REST_API_BASE_URL + 'staff/post-event/' + mobileNumber + '/' + name + '/' + date + '/' + location);
}

export const addArticle = (name, content) => {
    const mobileNumber = window.sessionStorage.getItem("studNumber");
    console.log('from router part (add article from student - log)  :- '+mobileNumber)
    return axios.post(REST_API_BASE_URL + 'students/add-article/' + mobileNumber + '/' + name + '/' + content);
}

/////////////////////////// PUT/UPDATE METHODS //////////////////////////////////////

export const updateStudent = (id, state) =>{
    const REST_PUT_API = REST_API_BASE_URL + '/admin/students/' + id + '/' + state;
    return axios.put(REST_PUT_API);
}

export const updateStaff = (id, state) =>{
    const REST_PUT_API = REST_API_BASE_URL + '/admin/staff/' + id + '/' + state;
    return axios.put(REST_PUT_API);
}

export const updateOfficer = (id, state) =>{
    const REST_PUT_API = REST_API_BASE_URL + '/admin/placementOfficers/' + id + '/' + state;
    return axios.put(REST_PUT_API);
}

export const updateArticle = (id, state) =>{
    const REST_PUT_API = REST_API_BASE_URL + '/admin/articles/' + id + '/' + state;
    return axios.put(REST_PUT_API);
}

/////////////////////////////////////////////////////////////////////////////////////////////////

export const isUserPresent = (mobileNumber, password, role) => {
    console.log('from router part'+mobileNumber+"  "+password+"   "+role)

    if(role == 'admin'){
        return axios.get(REST_API_BASE_URL + 'admin/login/' + mobileNumber + '/' + password);
    }
    else if(role == 'officer'){
        return axios.get(REST_API_BASE_URL + 'placement-officer/login/' + mobileNumber + '/' + password);
    }
    else if(role =='staff'){
        return axios.get(REST_API_BASE_URL + 'staff/login/' + mobileNumber + '/' + password);
    }
    else if(role == 'student'){
        return axios.get(REST_API_BASE_URL + 'students/login/' + mobileNumber + '/' + password);
    }
}



export const storeToken = (token) => {
    return localStorage.setItem('token', token);
}

export const getToken = () => localStorage.getItem('token');