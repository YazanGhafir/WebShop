import React, { Component } from 'react'

export default class productImage extends Component {
  render() {
    return (
        <div>
            <img
                className="d-block w-100"
                src="https://images.pexels.com/photos/267330/pexels-photo-267330.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500'"
                alt="First slide"
                height="450px"
              />
        </div>
    )
  }
}
