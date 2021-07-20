import React, { Component } from 'react'
import GuestbookEntries from './components/GuestbookEntries';
import Login from './components/Login';
import AddBookEntry from './components/AddBookEntry'
import EditBookEntry from './components/EditBookEntry'
import { BrowserRouter, Route, Switch } from "react-router-dom";

class App extends Component {

  render() {
    return (
      <div>
      <BrowserRouter>
      <Switch>
      <Route path="/login" component={ Login } />
      <Route path="/home" component={ GuestbookEntries }/>
      <Route path="/addbookentry" component={ AddBookEntry } exact />
      <Route path="/editbookentry/:id" component={ EditBookEntry }/>
      </Switch>
      </BrowserRouter>
      </div>
    );
  }

}


export default App;
