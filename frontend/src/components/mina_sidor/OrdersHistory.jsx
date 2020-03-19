import React, { Component } from 'react';
import History_card from './History_card';
import Accordion from 'react-bootstrap/Accordion';
import MyInfo from './MyInfo';
import { MDBRow, MDBCard, MDBCardBody, MDBContainer, MDBBtn } from "mdbreact";

export default class OrdersHistory extends Component {

    constructor(props) {
        super(props);
        this.state = {
            info:"",
            orders: [
                {
                    'customerorder_id': '1', 'date': '2020-03-11', 'total_payed': '156$', 'productList': [
                        { 'product_id': '1', 'name': 'product4', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg', 'price': '86$' },
                        { 'product_id': '2', 'name': 'product5', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14.jpg', 'price': '60$' },
                        { 'product_id': '3', 'name': 'product6', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15.jpg', 'price': '50$' }
                    ]
                },
                {
                    'customerorder_id': '2', 'date': '2019-11-12', 'total_payed': '198$', 'productList': [
                        { 'product_id': '4', 'name': 'product1', 'img': 'https://images.pexels.com/photos/637076/pexels-photo-637076.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260', 'price': '9$' },
                        { 'product_id': '5', 'name': 'product2', 'img': 'https://images.pexels.com/photos/1598505/pexels-photo-1598505.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '15$' },
                        { 'product_id': '6', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267320/pexels-photo-267320.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '78$' }
                    ]
                },
                {
                    'customerorder_id': '3', 'date': '2019-03-10', 'total_payed': '290$', 'productList': [
                        { 'product_id': '7', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267324/pexels-photo-267324.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '99$' },
                        { 'product_id': '8', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267330/pexels-photo-267330.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '95$' },
                        { 'product_id': '9', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267326/pexels-photo-267326.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '45$' },
                        { 'product_id': '10', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267327/pexels-photo-267327.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '25$' }
                    ]
                },
                {
                    'customerorder_id': '4', 'date': '2018-05-06', 'total_payed': '77$', 'productList': [
                        { 'product_id': '11', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267328/pexels-photo-267328.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '66$' },
                        { 'product_id': '12', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267329/pexels-photo-267329.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '99$' }
                    ]
                }
            ]
        };

        this.eventK = 0;
    }

    componentDidMount() {
        fetch("http://localhost:8080/orm/webshop/cart/customer")
            .then(res => res.json())
            .then((data) => {
                console.log(data)
                this.setState({ info: data })
            }).catch(console.log);

  

        fetch("http://localhost:8080/orm/webshop/cart/history")
            .then(res => res.json())
            .then((data) => {
                this.setState({ orders: data })
            }).catch(console.log);
    }


    getEventKeyAndIncrease() {
        var tmp = this.eventK;
        this.eventK = this.eventK + 1;
        return tmp;
    }

    logout(){
        fetch('http://localhost:8080/orm/webshop/cart/logout')
        .then(function(response) {
            if(response.status === 200) {
                window.location.replace('/');
            } else {
                alert("There is a problem with your logout, please try again later!");
            }
        });
    }

    render() {


        return (
            <div>
                <MDBCard className="mx-5 my-5">
                    <MDBCardBody>
                        <MDBContainer>
                            <MDBRow className="mx-5">
                                <MyInfo></MyInfo>
                            </MDBRow>
                            <MDBRow className="mx-5" style={{display: 'inline-block'}}>
                                <h2 className="my-4"> Previous orders:</h2>
                                <Accordion>
                                    {this.state.orders.map((ord, idx) => {
                                        return <History_card
                                            customerorder_id={ord.customerorder_id}
                                            date={ord.date}
                                            total_payed={ord.total_payed}
                                            productList={ord.productList}
                                            eventKe={this.getEventKeyAndIncrease()}
                                            key={idx}
                                        />
                                    })}
                                </Accordion>
                            </MDBRow>
                            <MDBBtn color="cyan" size="lg" block onClick={() => { this.logout() }}>
                                    Log out
                            </MDBBtn>
                        </MDBContainer>
                    </MDBCardBody>
                </MDBCard>
            </div>
        )
    }
}




/**
 *
 *
 *  'orders' : [ {
                'order1': [
                    { 'product_id': '1', 'name': 'product4', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg', 'price': '86$' },
                    { 'product_id': '2', 'name': 'product5', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14.jpg', 'price': '60$' },
                    { 'product_id': '3', 'name': 'product6', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15.jpg', 'price': '50$' }
                ] }, {
                'order2': [
                    { 'product_id': '4', 'name': 'product1', 'img': 'https://images.pexels.com/photos/637076/pexels-photo-637076.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260', 'price': '9$' },
                    { 'product_id': '5', 'name': 'product2', 'img': 'https://images.pexels.com/photos/1598505/pexels-photo-1598505.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '15$' },
                    { 'product_id': '6', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267320/pexels-photo-267320.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '78$' }
                ] }, {
                'order3': [
                    { 'product_id': '7', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267324/pexels-photo-267324.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '99$' },
                    { 'product_id': '8', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267330/pexels-photo-267330.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '95$' },
                    { 'product_id': '9', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267326/pexels-photo-267326.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '45$' },
                    { 'product_id': '10', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267327/pexels-photo-267327.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '25$' }
                ] }, {
                'order4': [
                    { 'product_id': '11', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267328/pexels-photo-267328.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '66$' },
                    { 'product_id': '12', 'name': 'product3', 'img': 'https://images.pexels.com/photos/267329/pexels-photo-267329.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500', 'price': '99$' }
                ] }
            ]



 */