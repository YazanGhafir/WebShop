import React, { Component } from 'react';
import { MDBCol, MDBContainer, MDBRow, MDBFooter } from "mdbreact";
import { Link } from 'react-router-dom';


export default class Footer extends Component {
    render() {
        return (
            <div>
                <MDBFooter color="blue" className="font-small pt-4 mt-4 ">
                    <MDBContainer fluid className="text-center text-md-left">
                        <MDBRow>
                            <MDBCol md="6">
                                <h5 className="title">Om Oss</h5>
                                <p>
                                Välkommen till en sensation inom kläder och mode. Vem trodde förut att handla snygga och funktionella kläder för sådana galet låga priser skulle vara möjligt? Jo vi på Challando.se!
                                </p>
                            </MDBCol>
                            <MDBCol md="6">
                                <h5 className="title">Links</h5>
                                <ul>
                                    <li className="list-unstyled">
                                    <Link to='/login' className="nav-link">
                                        Login
                                    </Link>
                                    </li>
                                    <li className="list-unstyled">
                                    <Link to='/cart' className="nav-link">
                                        Shopping Cart
                                    </Link>
                                    </li>
                                    <li className="list-unstyled">
                                    <Link to='/Contact_us' className="nav-link">
                                        Contact us
                                    </Link>
                                    </li>
                                    <li className="list-unstyled">
                                    <Link to='/' className="nav-link">
                                        Main page
                                    </Link>
                                    </li>
                                </ul>
                            </MDBCol>
                        </MDBRow>
                    </MDBContainer>
                </MDBFooter>
            </div>
        )
    }
}
