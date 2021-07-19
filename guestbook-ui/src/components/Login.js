
import React, { Component } from 'react'
import GuestBookService from '../services/GuestBookService'


class Login extends Component
{

    

    constructor(props){
        super(props)
        this.state = {
            username : '',
            password : '',
            usertype : ''
        }
    }

    changeTextHandler = (event) => {
        this.setState({username : event.target.value});
    } 
    

   login(){
  
      GuestBookService.getUserType(this.state.username).then(res => {
        if(res && res.data){
            this.setState({usertype : res.data})
            if( this.state.usertype === "A") {
                this.props.history.push('/home')
               }else{
                this.props.history.push('/addbookentry')  
               }
        } 
      });      
    }

    render(){
        return(
           <form> 
              <h1>Login Page</h1>
           Username : <input type="text"  name="username" onChange={this.changeTextHandler}/>
           <br></br>
           Password : <input type="password"  name="password" />
           <br></br>
           <button onClick={() => this.login() }>Login</button>
           <br></br>
           </form>
        )
     }

}

export default Login
