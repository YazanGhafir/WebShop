import React, { Component } from 'react'
import Card from 'react-bootstrap/Card';

export default class History_item extends Component {
    render() {
        return (
            <div> 
              <Card.Body>{this.props.name} {this.props.img} {this.props.price} {this.props.product_id} </Card.Body>    
            </div>
        )
    }
}
