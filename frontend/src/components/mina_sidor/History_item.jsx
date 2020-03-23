import React, { Component } from 'react'
import Card from 'react-bootstrap/Card';

export default class History_item extends Component {
    render() {
        return (
            <div>
                <Card.Body>
                    <div className="row">
                        <div className="column-4">
                            <img src={this.props.img} className="rounded float-left" alt="Responsive image" id="cartImage"></img>
                        </div>
                        <div className="column-8">
                            {this.props.name} {this.props.price} {this.props.product_id}
                        </div>
                    </div>
                </Card.Body>
            </div>
        )
    }
}
