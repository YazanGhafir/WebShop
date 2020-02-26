import React, { Component } from 'react'
import Product from "./Product"
import CarouselPage from "./Carousel";
import FiltersRow from "./FiltersRow";
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';

export default class ProductList extends Component {

    constructor(props) {
        super(props);
        this.state = { products: [{ 'name': 'product1' }, { 'name': 'product2' }, { 'name': 'product3' }, { 'name': 'product4' }, { 'name': 'product5' }, { 'name': 'product6' }] };
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
                <Container>
                    <Row>
                        <CarouselPage></CarouselPage>
                    </Row>
                        <FiltersRow></FiltersRow>
                    <Row>
                        {this.state.products.map((p, idx) => { return <Product name={p.name} key={idx} /> })}
                    </Row>
                </Container>
            </React.Fragment>
        );
    }
}



