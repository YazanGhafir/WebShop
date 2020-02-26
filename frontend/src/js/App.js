import React, { Component } from 'react';
import { Switch, Route } from 'react-router-dom';
import '../css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from '../components/Navbar';
import ProductList from '../components/ProductList';
import Details from '../components/product_details_component/Details';
import Cart from '../components/Cart';
import Default from '../components/Default';
import Footer from '../components/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import SideCategory from '../components/SideCategories';
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">

          <React.Fragment>
            
            <Navbar />

            <Container>
              <Row>
                <Col md={4} lg={2}>
                  <SideCategory />
                </Col>
                <Col md={8} lg={10}>
                  <Switch>
                    <Route exact path="/" component={ProductList} />
                    <Route path="/details" component={Details} />
                    <Route path="/cart" component={Cart} />
                    <Route component={Default} />
                  </Switch>
                </Col>
              </Row>
            </Container>
         
            <Footer />
          </React.Fragment>

        </header>
      </div>
    );
  }
}

export default App;
