import React, { Component } from 'react'
import Product from "./Product"
import CarouselPage from "./Carousel";

export default class ProductList extends Component {
    render() {
        return (
            <div>
                <CarouselPage></CarouselPage>
                <Product></Product>
            </div>

        )

    }
}
