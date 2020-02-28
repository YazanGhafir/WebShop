import React, { Component } from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCol } from "mdbreact";
import { Link } from 'react-router-dom';

//"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/10.jpg"

export default class Product extends Component {
    constuctor() {
    }

    addToCart(props) {

    }

    toProductDetails() {

    }


    render() {
        return (
            <MDBCol sm={6} md={4} mt={1}>
                <MDBCard style={{ width: "19rem" }} onClick={this.toProductDetails}>
                    <MDBCardImage className="img-fluid" src={this.props.img} />
                    <MDBCardBody>
                        <MDBCardTitle>{this.props.name}</MDBCardTitle>
                        <MDBCardText>
                            Some quick example text to build on the card title and make
                            up the bulk of the card&apos;s content.
                            </MDBCardText>
                            <Link to='/Details' className="btn btn-primary"></Link>
                    </MDBCardBody>
                </MDBCard>
            </MDBCol>
        )
    }
}
