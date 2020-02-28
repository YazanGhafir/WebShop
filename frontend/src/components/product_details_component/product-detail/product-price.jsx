import React, { Component } from 'react'

export default class productprice extends Component {
  render() {
    return (
      <div className="product-price">
        <h3>{this.props.price} <span className="lead">online price</span></h3>
      </div>
    )
  }
}
