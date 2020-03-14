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
                    <div class="column-8" id="productDescription">
                        <h6>{this.props.title}</h6>
                        <p class="productText">{this.props.subTitle}</p>
                        <p class="productText">Colour:  {this.props.color}</p>
                        <p class="productText">Size:  {this.props.size}</p>
                        <button type="button">
                        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"></link>
                            <span class="glyphicon glyphicon-trash"></span>
                            <span>Remove</span>
                        </button>


                    </div>
                    <div class="column-2 cartproduct">
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
