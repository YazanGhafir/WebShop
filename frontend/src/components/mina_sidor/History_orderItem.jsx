import React, { Component } from 'react'
import Accordion from 'react-bootstrap/Accordion';
import Card from 'react-bootstrap/Card';
import Button from 'react-bootstrap/Button';

export default class History_orderItem extends Component {
    render() {
        return (
            <div>
                <Card.Header>
                    <Accordion.Toggle as={Button} variant="link" eventKey={this.props.eventKe}>
                        Click me! {this.props.customerorder_id} {this.props.date} {this.props.total_payed}
                    </Accordion.Toggle>
                </Card.Header>
            </div>
        )
    }
}
