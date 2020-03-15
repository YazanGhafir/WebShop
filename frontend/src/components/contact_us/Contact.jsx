import React, { Component } from 'react'
import { MDBJumbotron, MDBBtn, MDBContainer, MDBRow, MDBCol,  MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText } from "mdbreact";
import Contact_Form from './Contact_Form'

export default class Contact extends Component {
    render() {
        return (
            <div>
                <MDBContainer className="mt-5 text-center">
                    <MDBRow>
                        <MDBCol>
                            <MDBJumbotron className="p-0">
                                <MDBCardImage
                                    className="img-fluid"
                                    src="https://mdbootstrap.com/img/Photos/Slides/img%20(134).jpg"
                                />
                                <MDBCardBody>
                                    <Contact_Form></Contact_Form>
                                </MDBCardBody>
                            </MDBJumbotron>
                        </MDBCol>
                    </MDBRow>
                </MDBContainer>
            </div>
        )
    }
}


/**
 * 
 * <MDBBtn color="warning" outline type="submit">
                    Send
                    <MDBIcon far icon="paper-plane" className="ml-2" />
                  </MDBBtn>
 */