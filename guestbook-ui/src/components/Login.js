
import React, { Component } from 'react'
import axios from 'axios'


class Login extends Component
{

    constructor(props){
        super(props)
        this.state = {
            username : '',
            password : '',
            invaliduser : ''
        }
    }

    userNameHandler = (event) => {
        this.setState({username : event.target.value});
    } 
    

    passwordHandler = (event) => {
        this.setState({password : event.target.value});
    } 


    async login(){
        alert('coming')
        let data = {username : this.state.username, password : this.state.password};
        const res = await axios.post('http://localhost:9000/api/signin', data)
            if(res && res.data){
                this.setState({userRole : res.data})
                if( this.state.userRole === "ROLE_ADMIN") {
                    sessionStorage.setItem("username", this.state.username)
                    sessionStorage.setItem("userrole","ROLE_ADMIN")
                    this.props.history.push('/main')
                }else if(this.state.userRole === "ROLE_USER"){
                    sessionStorage.setItem("username", this.state.username)
                    sessionStorage.setItem("userrole","ROLE_USER")
                    this.props.history.push('/addbookentry')
                }else{
                    this.props.history.push('/login')
                    this.setState({invaliduser : true})
                }  
            } 
        }   
     

    render(){
        return(
           <form> 
              <h3>Login</h3><br></br>
           <span> {this.state.invaliduser ? "Invalid user" : "" } </span> 
           <br></br>  
           Username : <input type="text"  name="username" onChange={this.userNameHandler}/>
           <br></br><br></br>
           Password : <input type="password"  name="password" onChange={this.passwordHandler} />
           <br></br><br></br>
           <button onClick={() => this.login() }>Login</button>
           <br></br>
           </form>
        )
     }

}

export default Login
