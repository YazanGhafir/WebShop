import React, { Component } from 'react'
import { MDBCol, MDBRow } from "mdbreact";

export default class SummaryComponent extends Component {
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
