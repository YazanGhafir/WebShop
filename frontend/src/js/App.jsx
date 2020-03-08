import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import '../css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from '../components/single_page_shared_components/Navbar';
import ProductList from '../components/main_page_components/ProductList';
import Details from '../components/product_details_component/Details';
import Login from '../components/login_component/Login';
import Cart from '../components/cart_component/Cart';
import Default from '../components/single_page_shared_components/Default';
import Footer from '../components/single_page_shared_components/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import SideCategory from '../components/single_page_shared_components/SideCategories';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'

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
              <Col md={4} lg={2}>
                <SideCategory />
              </Col>
              <Col md={8} lg={10}>
                <Switch>
                  <Route exact path="/" component={ProductList} />
                  <Route path="/details" component={Details} />
                  <Route path="/cart" component={Cart} />
                  <Route path="/login" component={Login} />
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