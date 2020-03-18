import React, { Component } from 'react'
import { MDBCard, MDBCardBody } from "mdbreact";
import SummaryComponent from './SummaryComponent';

export default class Summary extends Component {


  constructor(props) {
    super(props);
    this.state = {
      products:[{ 'name': 'productDefault', 'img': 'https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Vertical/13.jpg', price: '86$' }],
      availabilityCode: '',
      features: []
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/orm/webshop/sc")
      .then(res => res.json())
      .then((data) => {
        this.setState({ products: data })
      }).catch(console.log);
  }

    render() {
        return (
            <div>
                <MDBCard>
                    <MDBCardBody>
                        <h4 className="mb-4 mt-1 h5 text-center font-weight-bold">Summary</h4>
                        {this.state.products.map((p, idx) => { return <SummaryComponent name={p.name} img={p.img} price={p.price} product_id={p.product_id} key={idx} /> })}
                    </MDBCardBody>
                </MDBCard>
            </div>
        )
    }
}

