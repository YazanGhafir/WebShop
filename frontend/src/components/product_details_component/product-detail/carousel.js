import CarouselSlide from './carousel-slide';
import CarouselControl from './carousel-control';

import React, { Component } from 'react'

export default class carousel extends Component {
  
  constructor(props) {
    super(props);
    this.state = { 
        currentSlide: 0,
        isLeftDisabled: true,
        isRightDisabled: false
    }
  }


  slideChange(newCurrentSlide){
    let isLeftDisabled = (newCurrentSlide === 0)
    let isRightDisabled = (newCurrentSlide === this.props.images.length - 1)

    this.setState({
      isLeftDisabled: isLeftDisabled,
      isRightDisabled: isRightDisabled,
      currentSlide: newCurrentSlide
    })
  }

  
  render() {

    let images = this.props.images;

    return (
      <div className="carousel">
        <ul className="slides list-unstyled">
          {images.map(function(image, index) {
            return(
                <CarouselSlide
                  key={'slide-' + index}
                  image={image.image}
                  index={index}
                  currentSlide={this.state.currentSlide}
                />
            )
          }, this)}
        </ul>

        <CarouselControl
          handleSlideChange={this.slideChange}
          images={images}
          totalSlides={this.props.images.length}
          currentSlide={this.state.currentSlide}
          isLeftDisabled={this.state.isLeftDisabled}
          isRightDisabled={this.state.isRightDisabled}
        />

      </div>

    )
  }
}


