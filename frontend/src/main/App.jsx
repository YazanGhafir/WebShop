import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import '../css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from '../components/single_page_shared/Navbar';
import Checkout from '../components/checkout/checkout';
import ProductList from '../components/main_page/ProductList';
import Details from '../components/product_details_component/Details';
import Login from '../components/login/Login';
import Cart from '../components/cart/Cart';
import Default from '../components/single_page_shared/Default';
import Order_Succeed from '../components/single_page_shared/Order_Succeed';
import Footer from '../components/single_page_shared/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import SideCategory from '../components/single_page_shared/SideCategories';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Contact from '../components/contact_us/Contact';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
        </header>
        <React.Fragment>
          
          <Container fluid={true} style={{ paddingLeft: 0, paddingRight: 0 }}>
            <Navbar />
          </Container>

          <Container fluid={true} style={{ paddingLeft: 0, paddingRight: 0 }}>
            <Row>
              <Col sm={0} lg={2}>
                <SideCategory />
              </Col>
              <Col sm={12} lg={10}>
                <Switch>
                  <Route exact path="/" component={ProductList} />
                  <Route path="/details" component={Details} />
                  <Route path="/cart" component={Cart} />
                  <Route path="/login" component={Login} />
                  <Route path="/checkout" component={Checkout} />
                  <Route path="/order_succeed" component={Order_Succeed} />
                  <Route path="/Contact_us" component={Contact} />
                  <Route component={Default} />
                </Switch>
              </Col>
            </Row>
          </Container>

          <Container fluid={true} style={{ paddingLeft: 0, paddingRight: 0 }}>
            <Footer />
          </Container>

        </React.Fragment>

      </div>
    );
  }
}

export default App;


/**
 *                   <Route path="/cart" component={Cart} />

 */