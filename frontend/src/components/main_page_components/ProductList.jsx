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
            { 'name': 'product1', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/15.jpg' },
            { 'name': 'product2', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/14.jpg' },
            { 'name': 'product3', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/12.jpg' },
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



