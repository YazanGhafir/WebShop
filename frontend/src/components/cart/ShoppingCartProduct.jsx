import React, { Component } from "react";
import '../../css/ShoppingCart.css';
import Form from "react-bootstrap/Form";


export default class ShoppingCartProduct extends Component {

    handleQuantitySelection(event) {
        console.log(event.target);

        //this.setState({quantity: event.data})
    }




    render() {
        const options = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
        console.log(this.props.id)
        return (
            <div className="container">
                <div className="row">
                    <div className="column-4">
                        <img src={this.props.img} className="rounded float-left" alt="Responsive image" id="cartImage">
                        </img>

                    </div>
                    <div className="column-8" id="productDescription">
                        <h6>{this.props.title}</h6>
                        <p id="productText">{this.props.subTitle}</p>
                        <p id="productText">Colour:  {this.props.color}</p>
                        <p id="productText">Size:  {this.props.size}</p>
                        <button className="cartButton btn" onClick={(e) => this.props.handleRemove(e, this.props.id)}>Remove</button>
                    </div>
                    <div className="column-2" id="cartproduct">
                        <div className="row">
                            <Form>
                                <Form.Group controlId="exampleForm.SelectCustom">
                                    <Form.Control as="select" onChange={(e) => this.props.handleSelect(e, this.props.id)} defaultValue={this.props.quantity}>
                                        {options.map( option => {
                                            return <option key={option}>{option}</option>
                                        }
                                        )}
                                    </Form.Control>
                                </Form.Group>
                            </Form>
                        </div>
                        <div className="row">
                            <p className="font-weight-bold">{this.props.price*this.props.quantity}</p>
                        </div>
                    </div>
                </div>
            </div >
        )
    }
}