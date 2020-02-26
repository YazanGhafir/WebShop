import React, { Component } from 'react'

export default class productname extends Component {
  render() {
    return (
      <div className="product-name">
          <h3 className='title text-center'>{this.props.name}</h3>
        </div>
    )
  }
}
