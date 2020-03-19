import React, { Component } from 'react'
import { withRouter } from 'react-router-dom';
import '../../css/Details.css';
import Select from 'react-select';


class DetailsViewOfProduct extends Component {

  constructor(props) {
    super(props);
    this.state = {
      selectedSize: "",
      product: {
        id: 601,
        colour: "olive",
        customerOrders: [],
        description: "Rubber",
        image: "https://images.pexels.com/photos/267320/pexels-photo-267320.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        label: "Durable Cotton Table",
        price: 88.18856915815326,
        sizeList: []
      },
      availabilityCode: '',
      features: [],
      img: props.ProductImage
    };
  }

  componentDidMount() {
    console.log(this.props.match.id);
    fetch("http://localhost:8080/orm/webshop/clothingItem/" + this.props.match.params.id) 
     .then(res => res.json())
      .then((data) => {
        this.setState({ product: data });
        console.log(data);
      }).catch(console.log);
  }

  calc(nr) {
    var num = nr;
    return num.toString().match(/^-?\d+(?:\.\d{0,2})?/)[0]
  }
  
  handleSelect = (selectedSize) => {
    console.log(selectedSize);
    this.setState({ selectedSize });
  }

  handleAddToCart() {
    console.log('http://localhost:8080/orm/webshop/cart/' + this.state.product.id + '/' + this.state.selectedSize.value);
    console.log(this.state.selectedSize);
    fetch('http://localhost:8080/orm/webshop/cart/' + this.state.product.id + '/' + this.state.selectedSize.value, {
      method: 'POST',
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      },
    })
  }




  render() {
    const options = [
      { value: 'XS', label: 'XS' },
      { value: 'S', label: 'S' },
      { value: 'M', label: 'M' },
      { value: 'L', label: 'L' },
      { value: 'XL', label: 'XL' }];

      const { selectedOption } = this.state;

    return (
      <div>
        <div className="container" className="productDetails">
          <div className="row" >
            <div className="col-5">
              <img className="productImage" src={this.state.product.image} alt="Could not load picture" />
            </div>
            <div className="col-7" className="productDescription">
              <h6 className="label">{this.state.product.label}</h6>
              <p className="priceText">{this.calc(this.state.product.price) + " kr"}</p>
              <p>{this.state.product.description}</p>
              <div className="sizeDropdown">
                <Select options={options} value={selectedOption} placeholder={'Select a size'} onChange={this.handleSelect} />
              </div>
              <button className="addToCartButton btn" onClick={this.handleAddToCart.bind(this)}>Add to cart</button>
            </div>
          </div>
        </div>
      </div >
    )
  }
}

export default withRouter(DetailsViewOfProduct);