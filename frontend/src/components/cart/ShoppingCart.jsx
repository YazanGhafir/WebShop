import React, { Component } from "react";
import '../../css/ShoppingCart.css';
import ShoppingCartProduct from "./ShoppingCartProduct";

import { Link } from "react-router-dom";

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

    componentDidMount() {
        fetch("http://localhost:8080/orm/webshop/cart")
            .then(res => res.json())
            .then(cdata => {
                this.setState({ data: cdata });
            })
            .catch(console.log);
    }


    render() {
        var sumPrice = 0;
        this.state.data.map((product) => {
            return sumPrice += product.price;
        })
        return (

            <div>
                <div className="container" id="shoppingCart">
                    <div className="row" >
                        <div className="col-7" id="cartContent">
                            <h3 id="CartHeader">Shopping Cart ({this.state.data.length} products)</h3>
                            {this.state.data.map((product, id) => {
                                return <ShoppingCartProduct key={"item" + id} img={product.src} title={product.title} subTitle={product.subTitle} price={product.price} size={product.size} color={product.color}></ShoppingCartProduct>
                            })}
                        </div>
                        <div className="col-4" id="cartContent">
                            <h3>Total</h3>
                            <div className="row" id="cartSummary">
                                <p>Subtotal </p>
                                <p className="cartTextAlign text-right">{sumPrice} kr</p>
                            </div>
                            <div className="row" id="cartSummary">
                                <p>Frakt</p>
                                <p className="cartTextAlign text-right">Free</p>
                            </div>
                            <Link to="/checkout">
                                <button className="cartButton btn">Proceed to checkout</button>
                            </Link>
                        </div>
                    </div>
                </div>
            </div>

        )
    }
}