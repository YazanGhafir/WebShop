import React, { Component } from 'react'
import ProductImageCarousel from './product-detail/carousel';
import ProductPrice from './product-detail/product-price';
import ProductName from './product-detail/product-name';
import ProductOffers from './product-detail/product-offers';
import ProductQuantity from './product-detail/product-quantity';
import ProductBuyActions from './product-detail/product-buy-actions';
import ProductSecondaryActions from './product-detail/product-secondary-actions';
import ProductDetail from './product-detail/product-detail';

export default class Details extends Component {



  constructor(props) {
    super(props);
    this.state = {
      name: '',
      images: [],
      price: '',
      offers: [],
      availabilityCode: '',
      features: []
    };
  }


  componentWillMount() {

    var data = require('./data.json');

    let product = data.CatalogEntryView[0];

    this.setState({
      name: product.title,
      images: product.Images[0].AlternateImages,
      price: product.Offers[0].OfferPrice[0].formattedPriceValue,
      offers: product.Promotions,
      availabilityCode: product.purchasingChannelCode,
      features: product.ItemDescription[0].features
    })

  }


  render() {

    return (
      <div className="container">
        <div className="row mx-5 my-5">
          <div className="col-xs-12 col-sm-6">
            <ProductName name={this.state.name} />
            <ProductImageCarousel images={this.state.images} />

          </div>
          <div className="col-xs-12 col-sm-6">
            <ProductPrice price={this.state.price} />
            <ProductOffers promotions={this.state.offers} />
            <ProductQuantity minQuantity={1} maxQuantity={10} />
            <ProductBuyActions availabilityCode={this.state.availabilityCode} />
            <ProductSecondaryActions />
            <ProductDetail features={this.state.features} />
          </div>
        </div>
      </div>
    )
  }
}


/*
            <ProductName name={this.state.name} />
            <ProductImageCarousel images={this.state.images} />



            <ProductPrice price={this.state.price} />
            <ProductOffers promotions={this.state.offers} />
            <ProductQuantity minQuantity={1} maxQuantity={10} />
            <ProductBuyActions availabilityCode={this.state.availabilityCode} />
            <ProductSecondaryActions />
            <ProductDetail features={this.state.features} />

*/