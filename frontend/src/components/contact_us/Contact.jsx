import React, { Component } from 'react'
import { MDBJumbotron, MDBContainer, MDBRow, MDBCol,  MDBCardImage, MDBCardBody} from "mdbreact";
import ContactForm from './ContactForm'

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
                                    <ContactForm></ContactForm>
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