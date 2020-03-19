import React, { Component } from 'react';
import { MDBInput, MDBBtn } from 'mdbreact';


export default class Signup extends Component {

    state = {
        email : "",
        password : "",
        firstName : "",
        lastName : "",
        emailagain : ""
    };


    submitHandler = event => {
        event.preventDefault();
        event.target.className += " was-validated";
    };

    changeHandler = event => {
        this.setState({ [event.target.name]: event.target.value });
    };

    onFormSubmit = e => {
        if (document.getElementById('loginpassword').value.length < 8) {
            alert("your password must containe at least 8 characters.");
        }
        else if (document.getElementById('loginfname').value.length < 3 || document.getElementById('loginlname').value.length < 3) {
            alert("please, write valid first and last name.");
        }
        else if (document.getElementById('loginemail').value != document.getElementById('loginemailagain').value){
            alert("please type the same email in the two feilds");    
        }
        else if (
            document.getElementById('loginfname').checkValidity() &&
            document.getElementById('loginlname').checkValidity() &&
            document.getElementById('loginemail').checkValidity() &&
            document.getElementById('loginemailagain').checkValidity() &&
            document.getElementById('loginpassword').checkValidity()
        ) {
            this.registerAccount();
        } else {
            alert("You need to fix all the wrongs first :) ");
        }
    };

    
    registerAccount() {
        const cInfo = this.state.email + '/' + this.state.password + '/NA/NA/' + this.state.firstName + '/' + this.state.lastName; 
        const url = "http://localhost:8080/orm/webshop/cart/rca/";
        const both = url + cInfo;
        console.log(both);

        fetch(both)
            .then(function(response) {
                if(response.status === 200) {
                    alert("your account as been successfully registered, welcome :). You will now be directed to Mina Sidor");
                    window.location.replace('/minasidor');
                } else {
                    alert("An account with the same email is already registered, try different one please");
                }
            });
    }

    

    render() {

        return (
            <div>

                <form className="px-5"
                className='needs-validation'
                onSubmit={this.submitHandler}
                noValidate
                >
                    <p className="h4 text-center py-4">Sign up</p>
                    <div className="grey-text">
                        <MDBInput
                            label="Your first name "
                            icon="user"
                            group
                            onChange={this.changeHandler}
                            id="loginfname"
                            name="firstName"
                            type="text"
                            validate
                            required
                        />
                        <MDBInput
                            label="Your last name "
                            icon="user"
                            group
                            onChange={this.changeHandler}
                            id="loginlname"
                            name="lastName"
                            type="text"
                            validate
                            required
                        />
                        <MDBInput
                            label="Your email"
                            icon="envelope"
                            group
                            onChange={this.changeHandler}
                            id="loginemail"
                            name="email"
                            type="email"
                            validate
                            required
                        />
                        <MDBInput
                            label="Confirm your email"
                            icon="exclamation-triangle"
                            group
                            onChange={this.changeHandler}
                            id="loginemailagain"
                            name="emailagain"
                            type="text"
                            validate
                            required
                        />
                        <MDBInput
                            label="Your password"
                            icon="lock"
                            group
                            onChange={this.changeHandler}
                            id="loginpassword"
                            name="password"
                            type="password"
                            validate
                        />
                    </div>
                    <div className="text-center py-4 mt-3">
                        <MDBBtn color="cyan"  onClick={() => { this.onFormSubmit() }}>
                            Register
                        </MDBBtn>
                    </div>
                </form>


            </div>
        )
    }
}



