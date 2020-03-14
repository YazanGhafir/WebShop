import React, { Component } from 'react'
import { MDBCol, MDBRow, MDBCard, MDBCardBody } from "mdbreact";

export default class Summary_component extends Component {
    render() {
        return (
            <div>
                <hr />
                <MDBRow>
                    <MDBCol sm="8">
                        {this.props.name}
                    </MDBCol>
                    <MDBCol sm="4">
                         {this.props.price}
                    </MDBCol>
                </MDBRow>
            </div>
        )
    }
}
