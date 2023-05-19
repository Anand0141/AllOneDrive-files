import axios from "axios";  
const baseUrl="http://localhost:2022/span";
const baseUrl1="http://localhost:2022/span/emp";

class Access{

    createEmployee(employee){
        return axios.post(`${baseUrl}/register`,employee)
    }

    getuser(){
        return axios.get(`${baseUrl}/login`);
    }
    getAllEmployee(){
        return axios.get(`${baseUrl1}/viewall`)
    }
    Update(updateUser){
        return axios.get(`${baseUrl}/update`,updateUser)
    }
    getByempId(empId){
        return axios.get(`${baseUrl}/getId/${empId}`);
    }
}
export default new Access()