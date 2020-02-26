import React, { Component } from 'react'

export default class carouselslide extends Component {
  isActiveSlide(){
    return this.props.index === this.props.currentSlide
  }
  

  render() {
    let activeClassName = (this.isActiveSlide() ? 'is-active' : null)
    return (
      <li className={activeClassName}>
        <img src={this.props.image} />
      </li>
    )

  }

}

