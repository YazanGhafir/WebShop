import React, { Component } from "react";
import '../../css/ShoppingCart.css';


export default class ShoppingCartProduct extends Component {
    render() {
        return (
            <div class="container">
                <div class="row">
                    <div class="column-4">
                        <img src={this.props.img} class="rounded float-left" alt="Responsive image" id="cartImage">
                        </img>

                    </div>
                    <div class="column-8" id="productDescription">
                        <h6>{this.props.title}</h6>
                        <p id="productText">{this.props.subTitle}</p>
                        <p id="productText">Colour:  {this.props.color}</p>
                        <p id="productText">Size:  {this.props.size}</p>
                        <button class="cartButton btn">Remove</button>
                    </div>
                    <div class="column-2" id="cartproduct">
                        <div class="row">
                            <button class="btn dropdown-toggle"> 1</button>
                        </div>
                        <div class="row">
                            <p class="font-weight-bold">{this.props.price}</p>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
