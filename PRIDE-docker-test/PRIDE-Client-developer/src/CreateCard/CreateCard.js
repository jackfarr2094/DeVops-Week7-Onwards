import React, { Component } from 'react';
import moment from 'moment';

export default class CreateCard extends Component {
    constructor() {
        super()
        this.state = {
            users: []
        };
    }

    addCard() {
        let checkRempno = document.getElementById("rempno").value;
        // let checkRmempno = document.getElementById("rmempno").value;
        let checkSempno = document.getElementById("sempno").value;
        let checkCategory = document.getElementById("category").value;
        let checkMessage = document.getElementById("message").value;

        if (checkRempno.search(/^[PCT][0-9]{5,6}$/) == -1) {
            document.getElementById("rempnoErr").innerHTML = "Employee numbers must begin with P (Permanent) or C (Contractor) or T (Temp) and be followed by 5 or 6 digits"
            document.getElementById("rempno").style.border = "2px solid red";
        }

        else if (checkSempno == "") {
            alert("Your employee number has not been found. Please restart app and try again.");
        }
        else if (checkCategory.length !== 1) {
            document.getElementById("P").style.backgroundColor = "#ed1c24";
            document.getElementById("R").style.backgroundColor = "#ed1c24";
            document.getElementById("I").style.backgroundColor = "#ed1c24";
            document.getElementById("D").style.backgroundColor = "#ed1c24";
            document.getElementById("E").style.backgroundColor = "#ed1c24";
            alert("Please ensure you have selected one of the PRIDE values.");
        }
        else if (checkMessage.length<1){
            alert("Please ensure you are writing a message to explain why the card is being submitted, up to 500 characters.")
            document.getElementById("message").style.border = "2px solid red";
        }
        else {
            let data = {
                "rempno": checkRempno,
                // "rname": "Dummy Data Receiver", //document.getElementById("rname").value,
                "rmempno": "P123456", //document.getElementById("rmempno").value,
                "sempno": document.getElementById("sempno").value,
                // "sname": "Dummy Data Sender", //document.getElementById("sname").value,
                "category": document.getElementById("category").value,
                "senddate": moment().format("YYYY-MM-DD"),
                "message": document.getElementById("message").value,
                "picurl": "www.pic.co.uk/dummydata" //document.getElementById("picurl").value
            }
            fetch(`http://localhost:5000/cards/newCard`, {
                method: 'Post',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(data)
            })
                .then(response => response.json())
                .then(data => alert(JSON.stringify(data.response)))
                .catch(error => alert(error))
            window.location.reload();
        }
    }




    /*PRIDE buttons remain #303030 once clicked */
    P() {
        document.getElementById("P").style.backgroundColor = "#303030";
        document.getElementById("category").value = "P";
        document.getElementById("R").style.backgroundColor = "#004a8f";
        document.getElementById("I").style.backgroundColor = "#004a8f";
        document.getElementById("D").style.backgroundColor = "#004a8f";
        document.getElementById("E").style.backgroundColor = "#004a8f";
    }
    R() {
        document.getElementById("P").style.backgroundColor = "#004a8f";
        document.getElementById("R").style.backgroundColor = "#303030";
        document.getElementById("category").value = "R";
        document.getElementById("I").style.backgroundColor = "#004a8f";
        document.getElementById("D").style.backgroundColor = "#004a8f";
        document.getElementById("E").style.backgroundColor = "#004a8f";
    }
    I() {
        document.getElementById("P").style.backgroundColor = "#004a8f";
        document.getElementById("R").style.backgroundColor = "#004a8f";
        document.getElementById("I").style.backgroundColor = "#303030";
        document.getElementById("category").value = "I";
        document.getElementById("D").style.backgroundColor = "#004a8f";
        document.getElementById("E").style.backgroundColor = "#004a8f";

    }
    D() {
        document.getElementById("P").style.backgroundColor = "#004a8f";
        document.getElementById("R").style.backgroundColor = "#004a8f";
        document.getElementById("I").style.backgroundColor = "#004a8f";
        document.getElementById("D").style.backgroundColor = "#303030";
        document.getElementById("category").value = "D";
        document.getElementById("E").style.backgroundColor = "#004a8f";
    }
    E() {
        document.getElementById("P").style.backgroundColor = "#004a8f";
        document.getElementById("R").style.backgroundColor = "#004a8f";
        document.getElementById("I").style.backgroundColor = "#004a8f";
        document.getElementById("D").style.backgroundColor = "#004a8f";
        document.getElementById("E").style.backgroundColor = "#303030";
        document.getElementById("category").value = "E";
    }

    render() {
        return (
            <div style={{position: "relative"}}>
                <input type="text" id="category" readOnly style={{ visibility: "collapse" }} />
                <input type="text" id="sempno" readOnly style={{ visibility: "collapse" }} value="P654321" />
                <table id="table" className="table" >
                    <tbody>
                        <tr><td>To: <input id="rempno" placeholder="Their Employee Number"></input><span id="rempnoErr"></span></td></tr>
                        <tr><td>Recognising:
                        <span className="dropdown"> <button id="P" onClick={() => this.P()} className="button1">P</button> <span className="dropdown-content"> <p>Putting members first.</p></span> </span>
                            <span className="dropdown"> <button id="R" onClick={() => this.R()} className="button1">R</button> <span className="dropdown-content"> <p>Rising to the challenge.</p></span> </span>
                            <span className="dropdown"> <button id="I" onClick={() => this.I()} className="button1">I</button> <span className="dropdown-content"> <p>Inspiring trust.</p></span>  </span>
                            <span className="dropdown"> <button id="D" onClick={() => this.D()} className="button1">D</button> <span className="dropdown-content"> <p>Doing the right thing.</p></span> </span>
                            <span className="dropdown"> <button id="E" onClick={() => this.E()} className="button1">E</button> <span className="dropdown-content"> <p>Excelling at relationships.</p></span> </span>
                        </td></tr>
                        <tr><td>
                            Comment: <textarea className="textbox" id="message" placeholder="Your Message"></textarea></td></tr>
                        <tr>
                            <td><button id="newbutton" onClick={() => this.addCard()}>Create New Card</button></td>
                        </tr>
                    </tbody>
                </table>
            </div >
        )
    }
}
