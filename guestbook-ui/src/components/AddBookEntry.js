import React, { Component } from 'react'
import GuestBookService from '../services/GuestBookService'

class AddBookEntry extends Component {

    constructor(props){
        super(props)
        this.state = {
            username : 'sat',
            comment : '' ,
            selectedFile : null,
            entryid : ''
        }
        this.addEntry = this.addEntry.bind(this)
    }

    addEntry(){
        let data = {id : 0, username : 'sat', comments : this.state.comment};
        GuestBookService.addEntry(data);
        alert("Entry added successfully")
    }   

    changeCommentHandler= (event) => {
        this.setState({comment: event.target.value});
    } 

    onFileChange = event => {
        this.setState({ selectedFile: event.target.files[0] });
      };

      onFileUpload = () => {
    
        const formData = new FormData();
    
        formData.append(
          'file',
          this.state.selectedFile
        );

        alert(this.state.selectedFile)

        GuestBookService.uploadfile(formData).then(res => {
           console.log(res.data)
           this.setState({entryid : res.data.id})
       })
        
      };  

render()
{
   return(
        <div>
            <form>
            <table>
                <h2>Welcome Guest!!</h2>
                <br></br>
                <h4>Please add comment or upload image</h4>
                <br></br>
                <tbody>
                <tr>
                    <td> 
                    Comment : <input type="text" value={this.state.commenttxt} name="comment" onChange={this.changeCommentHandler}></input>
                    </td>
                </tr>

                <br></br>

                <tr>
                    <td>
                    <input type="file" onChange={this.onFileChange} />
                    <button onClick={this.onFileUpload}> Upload
                </button>
                    </td>
                </tr>

                <br></br>

                <tr>
                    <td>
                        <button onClick={() => this.addEntry()}>Add Entry</button>
                    </td>
                </tr>
                </tbody>
            </table>

            </form>
        </div>
   )

}
   
}

export default AddBookEntry