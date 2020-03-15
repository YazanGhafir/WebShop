import React, { Component } from 'react';
import { MDBContainer, MDBRow, MDBCol, MDBInput, MDBBtn, MDBCard, MDBCardBody } from 'mdbreact';


export default class Signup extends Component {
    render() {
        return (
            <div>

                <form className="px-5">
                    <p className="h4 text-center py-4">Sign up</p>
                    <div className="grey-text">
                        <MDBInput
                            label="Your name"
                            icon="user"
                            group
                            type="text"
                            validate
                            required
                        />
                        <MDBInput
                            label="Your email"
                            icon="envelope"
                            group
                            type="email"
                            validate
                            required
                        />
                        <MDBInput
                            label="Confirm your email"
                            icon="exclamation-triangle"
                            group
                            type="text"
                            validate
                            required
                        />
                        <MDBInput
                            label="Your password"
                            icon="lock"
                            group
                            type="password"
                            validate
                        />
                    </div>
                    <div className="text-center py-4 mt-3">
                        <MDBBtn color="cyan" type="submit">
                            Register
                        </MDBBtn>
                    </div>
                </form>


            </div>
        )
    }
}



