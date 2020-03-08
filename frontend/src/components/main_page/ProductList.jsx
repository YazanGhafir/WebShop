import React, { Component } from 'react'
import Product from "./Product"
import CarouselPage from "./Carousel";
import FiltersRow from "./FiltersRow";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';

export default class ProductList extends Component {

    constructor(props) {
        super(props);
        this.state = { products: [
            { 'name': 'product1', 'img': 'https://images.pexels.com/photos/637076/pexels-photo-637076.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260' },
            { 'name': 'product2', 'img': 'https://images.pexels.com/photos/1598505/pexels-photo-1598505.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267320/pexels-photo-267320.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267324/pexels-photo-267324.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267330/pexels-photo-267330.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267326/pexels-photo-267326.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267327/pexels-photo-267327.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267328/pexels-photo-267328.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product3', 'img': 'https://images.pexels.com/photos/267329/pexels-photo-267329.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500' },
            { 'name': 'product4', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg' },
            { 'name': 'product5', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14.jpg' },
            { 'name': 'product6', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15.jpg' }
        ] };
    }

    componentDidMount() {
        fetch("http://localhost:8080/orm/webshop/product")
            .then(res => res.json())
            .then((data) => {
                this.setState({ products: data })
            }).catch(console.log);
    }


    render() {
        return (
            <React.Fragment> 

                    <Row>
                        <CarouselPage></CarouselPage>
                    </Row>

                    <Row>
                        <FiltersRow></FiltersRow>
                    </Row>
                    
                    <Row>
                        {this.state.products.map((p, idx) => { return <Product name={p.name} img={p.img} key={idx} /> })}
                    </Row>

            </React.Fragment>
        );
    }
}



