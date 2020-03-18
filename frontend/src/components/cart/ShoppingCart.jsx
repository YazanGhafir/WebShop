import React, { Component } from "react";
import '../../css/ShoppingCart.css';
import ShoppingCartProduct from "./ShoppingCartProduct";
import cloneDeep from 'lodash/cloneDeep';

import { Link } from "react-router-dom";

export default class ShoppingCart extends Component {
    state = {
        cart: [
            {
                item: {
                    clothingItem_id: 59,
                    colour: "Black",
                    customerOrders: [],
                    description: "this is the description",
                    image: "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg",
                    label: "Adidas T-Shirt",
                    price: 349.00,
                    sizeList: [],
                },
                quantity: 1,
                size: "L"
            },
            {
                item:
                {
                    clothingItem_id: 50,
                    colour: "White",
                    customerOrders: [],
                    description: "this is the description",
                    image: "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/6.jpg",
                    label: "Adidas T-Shirt",
                    price: 590.99,
                    sizeList: [],
                },
                quantity: 1,
                size: "L"
            }
        ]
    }

    componentDidMount() {
        fetch("http://localhost:8080/orm/webshop/cart")
            .then(res => res.json())
            .then(data => {
                this.setState({ cart: data });
                console.log(data);
            });
    }

    handleSelect(e, id) {
        const value = e.target.value;
        this.setState(prevState => ({
            cart: prevState.cart.map(
                elem => elem.item.clothingItem_id === id ? { ...elem, quantity: value } : elem
            )

        }))
    }

    handleRemove(e, id) {
        console.log("remove clicked")
        console.log(id);
        this.setState({
            cart: this.state.cart.filter(function (elem) {
                return elem.item.clothingItem_id !== id
            })
        });
    }

    render() {
        var sumPrice = 0;
        this.state.cart.map((product) => {
            return sumPrice += (product.item.price * product.quantity);
        })

        console.log(this.state)
        return (

            <div>
                <div className="container" id="shoppingCart">
                    <div className="row" >
                        <div className="col-7" id="cartContent">
                            <h3 id="CartHeader">Shopping Cart ({this.state.cart.length} products)</h3>
                            {this.state.cart.map((product) => {
                                return <ShoppingCartProduct key={product.item.clothingItem_id} img={product.item.image}
                                    title={product.item.label} subTitle={product.item.description} price={product.item.price}
                                    size={product.size} color={product.item.color} quantity={product.quantity} id={product.item.clothingItem_id}
                                    handleSelect={this.handleSelect.bind(this)} handleRemove={this.handleRemove.bind(this)}></ShoppingCartProduct>
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