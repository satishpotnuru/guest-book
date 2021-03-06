import React, { Component } from 'react'
import GuestBookService from '../services/GuestBookService'

class GuestbookEntries extends Component {

    constructor(props){
        super(props)
        this.state = {
            entries : []
        }
    }


    deleteEntry(id){
        GuestBookService.deleteEntry(id);
        this.setState({entries: this.state.entries.filter(entry => entry.id !== id)});
    }

    approveEntry(id){
        GuestBookService.approveEntry(id);
        alert("Entry approved successfully.")
    }

    addEntry(){
        this.props.history.push('/addbookentry')
    }

    editEntry(id){
        this.props.history.push(`/editbookentry/${id}`);
    }


    componentDidMount(){
       if(sessionStorage.getItem("username") === null || sessionStorage.getItem("userrole") !== 'ROLE_ADMIN'){
           this.props.history.push('/login');
       }
        GuestBookService.getEntries().then((response) => {
            this.setState({ entries : response.data})
        });
   
    }


    render(){
        return(
            <div className = "row">
                  <br></br>
                  Welcome Admin !
                  <br></br>
                  <table className = "table table-striped table-bordered" width="90%">
                           <thead>
                                <tr>
                                    <th> Guest Name</th>
                                    <th> Comment </th>
                                    <th> File </th>
                                    <th> Actions</th>
                                </tr>
                            </thead>
                         <tbody>
                             {
                                 this.state.entries.map(
                                     entry => 
                                     <tr key = {entry.id}>
                                             <td> {entry.username} </td>   
                                             <td> {entry.comments}</td>
                                             <td> <a href={'http://localhost:9000/api/downloadfile?entryid='+entry.id}>{entry.fileName}</a></td>
                                             <td>
                                                 <button onClick={ () => this.approveEntry(entry.id)} className="btn btn-info" disabled={entry.status==='Approved'}> Approve </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.deleteEntry(entry.id)} className="btn btn-danger" >Delete </button>
                                                 <button style={{marginLeft: "10px"}} onClick={ () => this.editEntry(entry.id)} className="btn btn-info"> Edit </button>
                                             </td>
                                        </tr>

                                 )
                             }
                        </tbody>
                    </table>
            </div>
        )
    }
}

export default GuestbookEntries