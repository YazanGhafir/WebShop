import React, { Component } from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText, MDBCol } from "mdbreact";
import { Link } from 'react-router-dom';
import Col from 'react-bootstrap/Col';
import '../../css/shared.css';


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
            <Col xs={12} sm={6} md={4} >
                <MDBCard className="mt-5">
                    <Link to='/Details'>
                    <MDBCardImage className="d-block w-100" src={this.props.img} height="300px" />
                    </Link>
                    <MDBCardBody>
                        <MDBCardTitle>{this.props.name}</MDBCardTitle>
                        <MDBCardText>
                            Some quick example text to build on the card title and make
                            up the bulk of the card&apos;s content.
                        </MDBCardText>
                        <MDBCardText className="text-right text-primary">
                            86$
                        </MDBCardText>
                        <Link to='/Details' className="btn btn-primary">View</Link>
                    </MDBCardBody>
                </MDBCard>
            </Col>
        )
    }
}
