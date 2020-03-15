import React, { Component } from "react";
import { MDBContainer, MDBCol, MDBRow, MDBCard, MDBCardBody } from "mdbreact";
import Summary from './summary';
import CheckoutForum from './checkout_forum';

class eCommercePage extends Component {
 

  render() {

    return (
      <MDBContainer>
        <MDBRow className="my-2" center>
          <MDBCard className="w-100">
            <MDBCardBody>
              <MDBRow>
                <MDBCol lg="8" className="mb-4">
                  <CheckoutForum></CheckoutForum>
                </MDBCol>
                <MDBCol lg="4" className="mb-4">
                  <Summary></Summary>
                </MDBCol>
              </MDBRow>
            </MDBCardBody>
          </MDBCard>
        </MDBRow>
      </MDBContainer>
    );
  }
}

export default eCommercePage;