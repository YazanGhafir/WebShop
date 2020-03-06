import React, { Component } from "react";


export default class ShoppingCartProduct extends Component {



    render() {
        return (
            <div class="container">
                <div class="row">
                    <div class="column-4">
                        <img src={this.props.img} class="rounded float-left" alt="Responsive image" id="cartImage">
                        </img>

                    </div>
                    <div class="column-4" id="productDescription">
                        <h6>{this.props.title}</h6>
                        <p>{this.props.subTitle}</p>
                        <br></br>
                        <p class="productText">Colour: {this.props.color}</p>

                        <p>Size: {this.props.size}</p>

                    </div>
                    <div class="column-4">
                        <button class="float-right">Remove</button>
                        <p class="font-weight-bold">{this.props.price}</p>
                    </div>
                </div>
            </div>
        )
    }
}
