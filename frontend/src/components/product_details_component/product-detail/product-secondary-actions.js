import React, { Component } from 'react'

export default class productsecondaryactions extends Component {
  render() {
    return (
      <div className="product-secondary-actions">
        <div className="row no-gutter">
          <div className="col-xs-4">
            <button className="btn btn-full">Add to Registry</button>
          </div>
          <div className="col-xs-4">
            <button className="btn btn-full">Add to List</button>
          </div>
          <div className="col-xs-4">
            <button className="btn btn-full">Share</button>
          </div>
        </div>
      </div>
    )
  }
}
