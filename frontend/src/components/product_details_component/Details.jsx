import React, { Component } from 'react'
import ProductPrice from './product-detail/product-price';
import ProductName from './product-detail/product-name';
import ProductOffers from './product-detail/product-offers';
import ProductQuantity from './product-detail/product-quantity';
import ProductBuyActions from './product-detail/product-buy-actions';
import ProductSecondaryActions from './product-detail/product-secondary-actions';
import ProductDetail from './product-detail/product-detail';
import ProductImage from './product-detail/Product-Image';

export default class Details extends Component {

  constructor(props) {
    super(props);
    this.state = {
      product:
       { 'product_id' : '1', 'name': 'product4', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg', 'price' : '86$' },
      availabilityCode: '',
      features: []
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/orm/webshop/s/v")
      .then(res => res.json())
      .then((data) => {
        this.setState({ product: data })
      }).catch(console.log);

  }


  componentWillMount() {
    var data = require('./data.json');
    let product = data.CatalogEntryView[0];
    this.state.availabilityCode = product.purchasingChannelCode;
    this.state.features = product.ItemDescription[0].features;
  }


  render() {

    return (
      <div className="row mx-5 my-5">
        <div className="col-xs-12 col-sm-6">
          <ProductName name={this.state.product.name} />
          <ProductImage img={this.state.product.img} />
        </div>
        <div className="col-xs-12 col-sm-6">
          <ProductPrice price={this.state.product.price} />
          <ProductQuantity minQuantity={1} maxQuantity={10} />
          <ProductBuyActions availabilityCode={this.state.availabilityCode} />
          <ProductDetail features={this.state.features} />
          <ProductSecondaryActions Pid={this.state.product.product_id} />
        </div>
      </div>
    )
  }
}

