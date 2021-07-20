import axios from 'axios'

const API_BASE_URL = "http://localhost:9000/api/";
const ADMIN_BASE_URL = "http://localhost:9000/api/admin/";
const GUEST_BASE_URL = 'http://localhost:9000/api/guest/';

class GuestBookService {

    
    getEntries(){
        return axios.get(ADMIN_BASE_URL + "entries")
    }

    deleteEntry(entryId){
        return axios.delete(ADMIN_BASE_URL + "removeentry/"+entryId)
    }

    approveEntry(entryId){
        return axios.put(ADMIN_BASE_URL + "approveentry/"+entryId)
    }

    addEntry(data){
        return axios.post(GUEST_BASE_URL + "addentry", data)
    }

    updateEntry(data){
        return axios.put(ADMIN_BASE_URL + 'editentry', data)
    }

    getEntry(id){
        return axios.get(ADMIN_BASE_URL + "entry/"+ id)
    }

    async getUserType(username){
        const response = await axios.get(API_BASE_URL + "usertype?username="+ username);
        return await response.json();
    }

    uploadfile(formData){
        alert('coming')
        const response = axios.post(API_BASE_URL + "uploadfile", formData, 
        { headers : {'Content-Type': 'multipart/form-data' }})
      return response;
    }
}

export default  new GuestBookService();