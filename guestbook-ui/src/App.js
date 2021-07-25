import React, { Component } from 'react'
import GuestbookEntries from './components/GuestbookEntries';
import Login from './components/Login';
import AddBookEntry from './components/AddBookEntry'
import EditBookEntry from './components/EditBookEntry'
import Header from './components/Header'
import { BrowserRouter, Route, Switch } from "react-router-dom";

class App extends Component {

  render() {
    return (
      <div>
      <BrowserRouter>
      <Switch>
      <Route path="/login" component={ Login } />  
      <Route exact path="/home">
            <Header />
            <GuestbookEntries />
      </Route>
      <Route exact path="/addbookentry">
            <Header />
            <AddBookEntry />
      </Route>
      <Route exact path="/editbookentry/:id">
            <Header />
            <EditBookEntry />
      </Route>
      </Switch>
      </BrowserRouter>
      </div>
    );
  }

}


export default App;
