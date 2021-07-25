import React, { Component } from 'react'

class Header extends Component {

    logOut(){
        sessionStorage.removeItem("username");
        this.props.history.push('/login');
    }

    render(){
        return(        
          <div>  
          <form align="right"> 
          <label class="logoutLblPos">
          <button onClick={() => this.logOut()}>Log out</button>
          </label>
          </form></div>   
        )
    }
}

export default Header