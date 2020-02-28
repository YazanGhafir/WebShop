import React, { Component } from 'react'

export default class carouselcontrol extends Component {
  
  
  constructor(props) {
    super(props);
    this.state = { 
      controlWidth: '',
      controlOffset: 0
    }
  }

 
  thumbWidth(){
      return 66;
  }


  componentWillReceiveProps (newProps) {
    let width = (newProps.totalSlides * this.thumbWidth());
    this.setState({
      controlWidth: width
    });
  }


  getControlOffset (index) {
    let thumbWidth = this.thumbWidth();
    let offset = -(index * thumbWidth);
    let isSecondToFirst = (index === -1);
    let isSecondToLast = (index === this.props.totalSlides - 2);

    if (isSecondToFirst || isSecondToLast) {
      return false;
    }

    return offset;
  }

  isActiveSlide (index){
    return index === this.props.currentSlide
  }


  className (index){
    if (this.isActiveSlide(index))
      return 'is-active'
  }

  slideNext (){
    this.slideChange(this.props.currentSlide + 1);
  }


  slidePrev(){
    this.slideChange(this.props.currentSlide - 1);
  }


 
  slideChange(index){

    this.props.handleSlideChange(index);

    this.setState({
      controlOffset: this.getControlOffset(index - 1)
    });

  }



  render() {

    let images = this.props.images;
    let firstClassName = this.props.isLeftDisabled ? 'is-first' : '';
    let lastClassName = this.props.isRightDisabled ? 'is-last' : '';

    let className = ['controls', firstClassName, lastClassName].join(' ')

    let style = {
          width: this.state.controlWidth,
          transform: `translateX(${this.state.controlOffset}px)`,
          WebkitTransition: 'transform .25s ease-in-out'
        }

    return(
      <div className="slide-control list-inline">
        <button
          className="btn btn-direction"
          disabled={this.props.isLeftDisabled}
          onClick={this.slidePrev}>
            &lsaquo;
        </button>
        <div className="controls-wrapper">
          <ul className={className} style={style}>
            {images.map(function(image, index) {
              return(
                <li key={'slide-' + index} className={this.className(index)}>
                  <a tabIndex="-1"
                    href="javascript:void(0)"
                    onClick={this.slideChange.bind(null, index)}>
                    <img
                      src={image.image} />
                  </a>
                </li>
              )
            }, this)}
          </ul>
        </div>
        <button
          className="btn btn-direction"
          disabled={this.props.isRightDisabled}
          onClick={this.slideNext}>
            &rsaquo;
        </button>
      </div>
    )
  }
}


