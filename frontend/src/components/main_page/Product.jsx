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

    toProductDetails(pid) {
        var url = "http://localhost:8080/orm/webshop/s/v/" + pid
        fetch(url, {
            method: "post",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({})
        });
    }


    render() {
        console.log(this.props.product_id)
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
                            {this.props.price}
                        </MDBCardText>
                        <Link to='/Details' className="btn btn-primary" onClick={() => { this.toProductDetails(this.props.product_id) }}>View</Link>
                    </MDBCardBody>
                </MDBCard>
            </Col>
        )
    }
}
