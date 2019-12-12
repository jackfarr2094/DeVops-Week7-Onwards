import React from "react";
import { BrowserRouter as Router, Route, Link } from "react-router-dom";
import PRIDEWall from "./PRIDEWall/PRIDEWall";
import MyPRIDEWall from "./MyPRIDE/MyPRIDEWall";
import CreateCard from "./CreateCard/CreateCard";
import "./Homepage.css";

export default class HomePage extends React.Component {
  render() {
    return (
      <div>
        <Router>
          <div className="navbar">
            <Link to="/">Login</Link>
            <Link to="/PRIDEWall">PRIDE Wall</Link>
            <Link to="/CreateCard">Send a PRIDE card</Link>
            <Link to="/MyPRIDEWall">MyPRIDE</Link>
          </div>
          <div
          >
            <Route exact path="/PRIDEWall" component={PRIDEWall} />
            <Route exact path="/MyPRIDEWall" component={MyPRIDEWall} />
            <Route exact path="/CreateCard" component={CreateCard} />
          </div>
        </Router>
      </div>
    );
  }
}
