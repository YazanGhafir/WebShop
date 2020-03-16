import React, { Component } from 'react'
import History_orderItem from './History_orderItem'
import History_item from './History_item'
import Card from 'react-bootstrap/Card';
import Accordion from 'react-bootstrap/Accordion';
import Button from 'react-bootstrap/Button';

export default class History_card extends Component {
    render() {
        console.log(this.props.eventKe);


        return (
            <div>
                <Card>

                    <Card.Header>
                        <Accordion.Toggle as={Button} variant="link" eventKey={this.props.eventKe}>
                            Order {this.props.customerorder_id} {this.props.date} {this.props.total_payed}
                        </Accordion.Toggle>
                    </Card.Header>


                    <Accordion.Collapse eventKey={this.props.eventKe}>
                        <Card.Body>

                            {this.props.productList.map((p, idx) => {
                                return <History_item
                                    name={p.name}
                                    img={p.img}
                                    price={p.price}
                                    product_id={p.product_id}
                                    key={idx}
                                />
                            })}

                        </Card.Body>
                    </Accordion.Collapse>
                </Card>



            </div>
        )
    }
}



/**
 *
 *
 *         <History_orderItem
                        customerorder_id={this.props.customerorder_id}
                        date={this.props.date}
                        total_payed={this.props.total_payed}
                        eventKe={this.props.eventKe}
                    >
                    </History_orderItem>




 */



