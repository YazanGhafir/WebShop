import React, { Component } from "react";
import '../../css/ShoppingCart.css';
import Form from "react-bootstrap/Form";
import { Link } from 'react-router-dom';



export default class ShoppingCartProduct extends Component {

    handleQuantitySelection(event) {
        console.log(event.target);
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
        const options = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        console.log(this.props.id)
        return (
            <div className="container">
                <div className="row">
                    <Link to={`/details/${this.props.product_id}`} onClick={() => { this.toProductDetails(this.props.id) }}>
                        <div className="column-4">
                            <img src={this.props.img} className="rounded float-left" alt="Responsive image" id="cartImage">
                            </img>

                        </div>
                    </Link>
                    <div className="column-8" id="productDescription">
                        <Link to={`/details/${this.props.product_id}`} style={{ textDecoration: 'none', color: '#000000' }} id="productLink" onClick={() => { this.toProductDetails(this.props.id) }}>
                            <h6>{this.props.title}</h6>
                            <p id="productText">{this.props.subTitle}</p>
                        </Link>
                        <p id="productText">Colour:  {this.props.color}</p>
                        <p id="productText">Size:  {this.props.size}</p>
                        <button className="cartButton btn" onClick={(e) => this.props.handleRemove(e, this.props.id, this.props.size)}>Remove</button>
                    </div>
                    <div className="column-2" id="cartproduct">
                        <div className="row">
                            <Form>
                                <Form.Group controlId="exampleForm.SelectCustom">
                                    <Form.Control as="select" onChange={(e) => this.props.handleSelect(e, this.props.id, this.props.size)} defaultValue={this.props.quantity}>
                                        {options.map(option => {
                                            return <option key={option}>{option}</option>
                                        }
                                        )}
                                    </Form.Control>
                                </Form.Group>
                            </Form>
                        </div>
                        <div className="row">
                            <p className="font-weight-bold">{this.props.price * this.props.quantity}</p>
                        </div>
                    </div>
                </div>
            </div >
        )
    }
}