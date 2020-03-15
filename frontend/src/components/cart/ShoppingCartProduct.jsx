import React, { Component } from "react";
import '../../css/ShoppingCart.css';


export default class ShoppingCartProduct extends Component {
    render() {
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
                        <button className="cartButton btn">Remove</button>
                    </div>
                    <div className="column-2" id="cartproduct">
                        <div className="row">
                            <button className="btn dropdown-toggle"> 1</button>
                        </div>
                        <div className="row">
                            <p className="font-weight-bold">{this.props.price}</p>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
