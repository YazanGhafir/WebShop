import React, { Component } from "react";
import '../css/ShoppingCart.css';
import ShoppingCartProduct from "./ShoppingCartProduct"

export default class ShoppingCart extends Component {
    state = {
        data: [
            {
                src: "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/13.jpg",
                title: "iPhone",
                subTitle: "Apple",
                color: "White",
                price: 800,
                size: "M",
                qty: "2"
            },
            {
                src: "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/6.jpg",
                title: "Headphones",
                subTitle: "Sony",
                color: "Red",
                price: 200,
                size: "L",
                qty: "2"
            },
            {
                src: "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/1.jpg",
                title: "iPad Pro",
                subTitle: "Apple",
                color: "Gold",
                price: 600,
                size: "S",
                qty: "1"
            },
        ],
    }




    render() {
        var sumPrice = 0;
        this.state.data.map((product) => {
            return sumPrice += product.price;
        })

        return (
            <div id="shoppingCartBackground">
                <div class="container" id="shoppingCart">
                    <div class="row" >
                        <div class="col-7 cartContent">
                            <h3 class="CartHeader">Shopping Cart ({this.state.data.length} products)</h3>
                            {this.state.data.map((product, id) => {
                                return <ShoppingCartProduct img={product.src} title={product.title} subTitle={product.subTitle} price={product.price} size={product.size} color={product.color}></ShoppingCartProduct>
                            })}
                        </div>
                        <div class="col-4 cartContent">
                            <h3>Total</h3>
                            <p>Subtotal </p>
                            <p class="text-right">{sumPrice} kr</p>
                            <button class="checkoutButton btn">Proceed to checkout</button>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}