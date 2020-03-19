import React, { Component } from 'react';
import '../../css/ShoppingCart.css';


export default class Summary extends Component {


  state = {
    sumPrice: 0,
  }

  componentDidMount() {
    fetch("http://localhost:8080/orm/webshop/cart")
      .then(res => res.json())
      .then(data => {
        let sum = 0;
        data.map((product) => {
          return sum += (product.item.price * product.quantity);
        })
        this.setState({ sumPrice: this.calc(sum) });
        console.log(data);
      });
  }

  calc(nr) {
    var num = nr;
    return num.toString().match(/^-?\d+(?:\.\d{0,2})?/)[0]
  }

  render() {
    return (
      <div className="col-11" id="orderSummary">
        <h3>Summary</h3>
        <div className="row" id="cartSummary">
          <p>Subtotal </p>
          <p className="cartTextAlign text-right">{this.state.sumPrice} kr</p>
        </div>
        <div className="row" id="cartSummary">
          <p>Frakt</p>
          <p className="cartTextAlign text-right">Free</p>
        </div>
        <div className="row total" id="cartSummary">
          <p style={{ marginTop: "10px" }}>Total (including taxes)</p>
          <p className="summaryTextAlign text-right">{this.state.sumPrice} kr</p>
        </div>
      </div>
    )
  }
}

