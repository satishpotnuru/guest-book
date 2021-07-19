import React, { Component } from 'react'
import GuestBookService from '../services/GuestBookService'

class EditBookEntry extends Component{

    constructor(props){
        super(props)

        this.state = {
            id: this.props.match.params.id,
            comment : ''
        }
    }

    componentDidMount(){
        GuestBookService.getEntry(this.state.id).then( res => {
            let dbcomment = res.data.comments;
            this.setState({ comment : dbcomment})
        })
    }

    changeCommentHandler= (event) => {
        this.setState({comment : event.target.value});
    } 

    updateEntry(){
        let data = {id : this.state.id, username : 'sat', comments : this.state.comment};
        GuestBookService.updateEntry(data);
        this.props.history.push('/home')
    }

    render()
    {
       return(
            <div>
                <form>
                <table>
                    <tr>
                        <td> 
                        Comment :    <input type="text" value={this.state.comment} name="comment" onChange={this.changeCommentHandler}></input>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button onClick={() => this.updateEntry()}>Update Entry</button>
                        </td>
                    </tr>
    
                </table>
    
                </form>
            </div>
       )
    
    }

}

export default EditBookEntry