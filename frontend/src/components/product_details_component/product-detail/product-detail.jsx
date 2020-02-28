import React, { Component } from 'react'

export default class productdetail extends Component {
  render() {
    let features = this.props.features;

    return (
      <div className="product-detail">
        <h3 className="title">Product Highlights</h3>
        <ul>
          {features.map(function(feature, index) {
            return <li
              key={'feature-' + index}
              dangerouslySetInnerHTML={{__html: feature}}>
            </li>;
          })}
        </ul>
      </div>
    )
  }
}

 