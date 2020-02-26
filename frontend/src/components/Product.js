import React, { Component } from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCardFooter, MDBIcon, MDBTooltip, MDBBtn } from "mdbreact";



export default class Product extends Component {


    render() {
        return (
            <div className="col-md-4 mt-3">
                <MDBCard cascade ecommerce wide>
                    <MDBCardImage
                        cascade
                        top
                        src="https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/shoes%20(2).jpg"
                        waves
                    />
                    <MDBCardBody cascade className="text-center">
                        <MDBCardTitle tag="h5">Category</MDBCardTitle>
                        <MDBCardTitle>
                            <a href="#!">
                                <strong>{this.props.name}</strong>
                            </a>
                        </MDBCardTitle>
                        <MDBCardText>
                            Temporibus autem quibusdam et aut officiis debitis aut rerum
                            necessitatibus saepe eveniet ut et voluptates.
                        </MDBCardText>
                        <MDBCardFooter>
                            <span className="float-left">49$</span>
                            <span className="float-right">
                                <MDBTooltip placement="top">
                                    <MDBBtn tag="a" href="https://mdbootstrap.com" target="_blank" color="transparent" size="lg" className="p-1 m-0 mr-2 z-depth-0" >
                                        <MDBIcon icon="share-alt" />
                                    </MDBBtn>
                                    <div>Share</div>
                                </MDBTooltip>
                                <MDBTooltip placement="top">
                                    <MDBBtn tag="a" color="transparent" size="lg" className="p-1 m-0 z-depth-0" >
                                        <MDBIcon icon="heart" className="red-text" />
                                    </MDBBtn>
                                    <div>Added to Wishlist</div>
                                </MDBTooltip>
                            </span>
                        </MDBCardFooter>
                    </MDBCardBody>
                </MDBCard>
            </div>





        )
    }
}
