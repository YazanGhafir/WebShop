import React, { Component } from 'react'

export default class productquantity extends Component {
 
  constructor(props) {
    super(props);
    this.state = { 
      quantity: 1,
      isMinQuantity: true
    }
  }
 
  
  isMinQuantity(quantity){
    return (quantity === this.props.minQuantity)
  }

  

  isMaxQuantity(quantity){
    return (quantity === this.props.maxQuantity)
  }

  /**
   * Increment and set State Quantity by 1
   */
  addQuantity() {
    let quantity = this.state.quantity + 1;
    this.setState({
      quantity: quantity,
      isMinQuantity: this.isMinQuantity(quantity),
      isMaxQuantity: this.isMaxQuantity(quantity)
    });
  }

 
  decQuantity() {
    let quantity = this.state.quantity - 1;

    this.setState({
      quantity: quantity,
      isMinQuantity: this.isMinQuantity(quantity),
      isMaxQuantity: this.isMaxQuantity(quantity)
    })

  }

  render() {
    return (
      <div className="product-quantity">
        <div className="label">Quantity</div>
        <div className="controls">
          <button
          disabled={this.state.isMinQuantity}
          onClick={this.decQuantity}>
            &#8722;
          </button>
          <strong>{this.state.quantity}</strong>
          <button
          disabled={this.state.isMaxQuantity}
          onClick={this.addQuantity}>
            &#43;
          </button>
        </div>
      </div>
    )
  }
}

  