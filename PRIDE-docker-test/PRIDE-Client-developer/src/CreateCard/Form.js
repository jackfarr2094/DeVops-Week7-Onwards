import React, { Component } from 'react';
import './Form.css';
class Form extends Component {
 render () {
   return (
     <form className="newCardForm">
       <h2>Submit a New Pride Card</h2>
       <input type="text" id="category" readOnly style={{ visibility: "collapse" }}/>
       <div className="form-group">
         <label htmlFor="rempno">To:</label>
         <input id="rempno" placeholder="Their Employee Number"/>
       </div>
       <div className="form-group">
         <label htmlFor="category">Recognising:</label>
         <span className="dropdown"> <button id="P" onClick={() => this.P()} className="button1">P</button> <span className="dropdown-content"> <p>Putting members first.</p></span> </span>
                        <span className="dropdown"> <button id="R" onClick={() => this.R()} className="button1">R</button> <span className="dropdown-content"> <p>Rising to the challenge.</p></span> </span>
                        <span className="dropdown"> <button id="I" onClick={() => this.I()} className="button1">I</button> <span className="dropdown-content"> <p>Inspiring trust.</p></span>  </span>
                        <span className="dropdown"> <button id="D" onClick={() => this.D()} className="button1">D</button> <span className="dropdown-content"> <p>Doing the right thing.</p></span> </span>
                        <span className="dropdown"> <button id="E" onClick={() => this.E()} className="button1">E</button> <span className="dropdown-content"> <p>Excelling at relationships.</p></span> </span>
       </div>
       <div className="form-group">
         <label htmlFor="message">Comment:</label>
         <textarea className="textbox" id="message" placeholder="Your Message"></textarea>
       </div>
       <button type="submit" onClick={() => this.addCard()} className="btn btn-primary">
          Submit New Card
       </button>
     </form>
   )
 }
}
export default Form;