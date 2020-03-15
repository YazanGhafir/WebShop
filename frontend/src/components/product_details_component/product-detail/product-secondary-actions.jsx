import React, { Component } from 'react'

export default class productsecondaryactions extends Component {

  addToCart(Pid){
    fetch('http://localhost:8080/orm/webshop/sc/' + Pid, {
       method: 'post',
       headers: {'Content-Type':'application/json'},
       body: JSON.stringify({})
    });
  }


  render() {
    return (
      <div className="product-primary-actions">
        <div className="row no-gutter">
          <div className="col-xs-4">
            <button className="btn btn-full" onClick={() => {this.addToCart(this.props.Pid)}}>Add to Cart</button>
          </div>
        </div>
      </div>
    )
  }
}
