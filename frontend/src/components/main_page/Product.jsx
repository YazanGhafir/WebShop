import React, { Component } from 'react';
import { MDBCard, MDBCardImage, MDBCardBody, MDBCardTitle, MDBCardText } from "mdbreact";
import { Link } from 'react-router-dom';
import Col from 'react-bootstrap/Col';
import '../../css/shared.css';

//"https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/10.jpg"

export default class Product extends Component {
    constuctor() {

    }

    render() {
        console.log(this.props.id)
        return (

            <Col xs={12} sm={6} md={4} >
                
                <MDBCard className="mt-5">
                    <Link to={`/details/${this.props.id}`}>
                        <MDBCardImage className="d-block w-100" src={this.props.img} height="300px" />
                    </Link>
                    <MDBCardBody>
                        <MDBCardTitle>{this.props.name}</MDBCardTitle>
                        <MDBCardText>
                            {this.props.description}
                        </MDBCardText>
                        <MDBCardText className="text-right text-primary">
                            {this.props.price}
                        </MDBCardText>
                        
                        <Link to={`/details/${this.props.id}`} className="btn btn-primary">                       
                            View
                        </Link>
                    </MDBCardBody>
                </MDBCard>
          
            </Col>
        )
    }
}
