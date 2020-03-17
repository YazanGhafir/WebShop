import React, { Component } from 'react'
import ProductPrice from './product-detail/product-price';
import ProductName from './product-detail/product-name';
import ProductQuantity from './product-detail/product-quantity';
import ProductBuyActions from './product-detail/product-buy-actions';
import ProductSecondaryActions from './product-detail/product-secondary-actions';
import ProductDetail from './product-detail/product-detail';
import ProductImage from './product-detail/Product-Image';
import Row from 'react-bootstrap/Row';
import Product from '../main_page/Product';
import { useParams, withRouter } from 'react-router-dom';

class DetailsViewOfProduct extends Component {

  constructor(props) {
    super(props);
    this.state = {
      product:
        { 'product_id': '1', 'name': 'product4', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg', 'price': '86$' },
      availabilityCode: '',
      features: [],
      img: props.ProductImage
    };
  }

  componentDidMount() {
    
    
    
    fetch("http://localhost:8080/orm/webshop/clothingItem/" + this.props.match.params.id) // I think this is the right address to get the product ID in url also. This also doesnt work = (  + this.state.product_id )
      .then(res => res.json())
      .then((data) => {
        this.setState({ product: data })
      }).catch(console.log);
    //var data = require('./data.json');
    //let product = data.CatalogEntryView[0];
    //this.setState({ availabilityCode: product.purchasingChannelCode });
    //this.setState({ features: product.ItemDescription[0].features });
    

  }

  render() {
    
    return (
      

      <div className="container">
        <div className="row mx-5 my-5">
          <div className="col-xs-12 col-sm-6">
            <div className="product-name">
              <h4>{Product.name}</h4>
              { console.log(this.props.match.params.id)}

            </div>
            <img
              className="d-block w-100"
              src={this.state.product.image} // Not 100% sure this works | Might be that the fetch doesnt work. Only old pic is displayed.
              alt="Could not load picture"
              height="450px"
            />
          </div>
            <div className="col-xs-12 col-sm-6">
              Info here

              {this.state.product.price}
            </div>
        </div>
      </div>
    )
  }
}

export default withRouter(DetailsViewOfProduct);