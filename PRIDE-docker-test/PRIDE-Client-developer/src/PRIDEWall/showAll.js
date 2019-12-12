import React, { Component } from "react";
import './PRIDEWall.css'


export default class ShowAllThisMonth extends Component {
  constructor() {
    super();
    this.state = {
      records: []
    };
  }

  componentDidMount = () => {
    fetch("http://localhost:5000/cards/home")
      .then(response => response.json())
      .then(data => {
        this.setState({
          records: data
        });
      });
  };

  render() {
    return (
      <div>
        <div className="container">
          <div className="row">
            {this.state.records.map(each => {
              return (
                <div className="col-4" key={each.rempno + each.sempno + each.senddate + each.category}>
                  <div className="card mb-3 new-card">
                    <div className="row no-gutters">
                      <div className="col-md-4">
                        <img
                          src="female-silhouette.png"
                          height="60px"
                          width="40px"
                          className="card-img employee-image"
                          alt="Manager"
                        />
                        <div className="prideletter">
                          <h1>
                            <b>{each.category}</b>
                          </h1>
                        </div>
                      </div>
                      <div className="col-md-8">
                        <div className="card-body">
                          <h5 className="card-title">
                            <b>{each.rempno}</b>
                          </h5>
                          <p className="card-text">{each.message}</p>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              );
            })}
          </div>
        </div>
      </div>
    );
  }
}
