import React, { Component } from 'react'
import { MDBCol, MDBRow, MDBCard, MDBCardBody } from "mdbreact";

export default class Summary extends Component {
    render() {
        return (
            <div>
               
                <MDBCard>
                    <MDBCardBody>
                        <h4 className="mb-4 mt-1 h5 text-center font-weight-bold">Summary</h4>
                        <hr />
                        <MDBRow>
                            <MDBCol sm="8">
                                MDBootstrap UI KIT (jQuery version) - License 6-10 poeple + unlimited projects
                            </MDBCol>
                            <MDBCol sm="4">
                                $ 2000
                            </MDBCol>
                        </MDBRow>
                        <hr />
                        <MDBRow>
                            <MDBCol sm="8">
                                Premium support - 2 years
                            </MDBCol>
                            <MDBCol sm="4">
                                $ 200
                            </MDBCol>
                        </MDBRow>
                        <hr />
                        <MDBRow>
                            <MDBCol sm="8">
                                MDB Membership - 2 years
                            </MDBCol>
                            <MDBCol sm="4">
                                $ 100
                            </MDBCol>
                        </MDBRow>
                        <hr />
                        <MDBRow>
                            <MDBCol sm="8">
                                <strong>Total</strong>
                            </MDBCol>
                            <MDBCol sm="4">
                                <strong>$ 2300</strong>
                            </MDBCol>
                        </MDBRow>
                    </MDBCardBody>
                </MDBCard>
            </div>
        )
    }
}

