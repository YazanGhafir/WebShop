import React, { Component } from 'react'
import { MDBRow, MDBCard, MDBCardBody, MDBContainer, MDBCol } from "mdbreact";
import Login from './Login';
import Signup from './Signup';

export default class LoginContainer extends Component {
    render() {
        return (
            <div>
                <MDBCard className="mx-5 my-5 w-40">
                    <MDBCardBody>
                        <MDBContainer >
                            <MDBRow>

                                <MDBCol lg="6" className="mb-4 coldevider" >
                                    <Signup></Signup>
                                </MDBCol>

                                <MDBCol lg="6" className="mb-4 mt-5" >
                                    <Login></Login>
                                </MDBCol>

                            </MDBRow>
                        </MDBContainer>

                    </MDBCardBody>
                </MDBCard>
            </div>
        )
    }
}


/*

*/
