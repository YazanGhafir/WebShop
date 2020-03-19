import React, { Component } from "react";
import './login.css';
import { MDBInput, MDBBtn } from "mdbreact";

class Login extends Component {

    constructor(props) {
        super(props)

        this.state = {
            email:"",
            password:""
        }
    }

    submitHandler = event => {
        event.preventDefault();
        event.target.className += " was-validated";
    };

    changeHandler = event => {
        this.setState({ [event.target.name]: event.target.value });
    };

    onFormSubmit = e => {
        

        if (document.getElementById('loginpassword1').value.length < 8) {
            alert("your password must containe at least 8 characters.");
        }      
        else if (
            document.getElementById('loginemail1').checkValidity() &&
            document.getElementById('loginpassword1').checkValidity()
        ) {
            this.loginToServer();
        } else {
            alert("You need to fix all the wrongs first :) ");
        }
    };

  
    loginToServer(){
        const cCred = this.state.email + '/' + this.state.password;
        const url = 'http://localhost:8080/orm/webshop/cart/auth/';
        const both = url + cCred;
        
        fetch(both)
            .then(function(response) {
                if(response.status === 200) {
                    window.location.replace('/minasidor');
                } else {
                    alert("username or password is invalid");
                }
            });
    }



    render() {

        return (
            <div>
                <form className="px-4"             
                className='needs-validation'
                onSubmit={this.submitHandler}
                noValidate
                >
                    <p className="h4 text-center py-4">Login</p>
                    <div className="grey-text">
                        <MDBInput
                            label="Your email"
                            icon="envelope"
                            group
                            onChange={this.changeHandler}
                            id="loginemail1"
                            name="email"
                            type="email"
                            validate
                            required
                        />
                        <MDBInput
                            label="Password"
                            icon="user"
                            onChange={this.changeHandler}
                            id="loginpassword1"
                            name="password"
                            group
                            type="password"
                            validate
                            required
                        />
                    </div>
                    <div className="text-center py-4 mt-3">
                        <MDBBtn color="cyan" type="submit" onClick={() => { this.onFormSubmit() }}>
                            Login
                        </MDBBtn>
                    </div>
                </form>

            </div>
        )
    }
}

export default Login;


/**
 *  <ControlLabel>Email</ControlLabel>
 *   <HelpBlock>{errors.email}</HelpBlock>

 */