import React, { Component } from 'react'

export default class productbuyactions extends Component {
  isAvailableRetail() {
    let availability = this.props.availabilityCode;
    return (availability === "0" || availability === "2")
  }


  isAvailableOnline() {
    let availability = this.props.availabilityCode;
    return (availability === "0" || availability === "1")
  }


  
  render() {
    let showRetailButton = this.isAvailableRetail();
    let showOnlineButton = this.isAvailableOnline();

    return (
      <div className="product-buy-actions">
        <div className="row no-gutter">
            {showRetailButton &&
              <div className="col-xs-12 col-sm-6">
              <button className="btn btn-secondary btn-lg btn-full">
                Pickup in Store
              </button>
              <div className="caption">Find in a Store</div></div>}
            {showOnlineButton &&
              <div className="col-xs-12 col-sm-6">
                <button className="btn btn-primary btn-lg btn-full">Add to Cart</button>
              </div>}
        </div>
      </div>
    )
  }
}

