import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import logo from '../../imgs/logo.png';
import Navb from 'react-bootstrap/Navbar'
import Col from 'react-bootstrap/Col';
import { MDBAnimation } from "mdbreact";
import {MDBBtnGroup, MDBIcon } from "mdbreact";
import Button from 'react-bootstrap/Button';

export default class Navbar2 extends Component {



    checkloggingstatus(){
        const url = 'http://localhost:8080/orm/webshop/cart/loginstatus/';
        
        fetch(url.toString())
            .then(function(response) {
                if(response.status === 200) {
                    window.location.replace('/minasidor');
                } else {
                    window.location.replace('/login');
                }
            });
    }

    render() {
        return (
            <Navb bg="light">
                    <Col sm={2}>
                        <ul className="navbar-nav align-items-left">
                            <li className="nav-item ml-auto ">
                                <Link to='/' className="nav-link">
                                    KVINNA
                                </Link>
                            </li>
                            <li className="nav-item ml-auto ">
                                <Link to='/' className="nav-link">
                                    MAN
                                </Link>
                            </li>
                            <li className="nav-item ml-auto ">
                                <Link to='/' className="nav-link">
                                    BARN
                                </Link>
                            </li>
                        </ul>
                    </Col>

                    <Col  sm={{ span: 3, offset: 3 }}>
                        <MDBAnimation type=" tada" duration="5s" delay="0s">
                            <Link to='/'>
                                <img src={logo} alt="store" className="navbar-brand ml-5" />
                            </Link>
                            <Link to='/' >
                                <Navb.Brand>Challando</Navb.Brand>
                            </Link>
                            
                        </MDBAnimation>
                        
                    </Col>


                    <Col sm={{ span: 3, offset: 2 }}>
                            <MDBBtnGroup className="mr-2">
                                <Link to="/cart">
                                <Button variant="outline-dark"><MDBIcon icon="shopping-basket" /></Button>
                                </Link>
                                <div>
                                    <Button variant="outline-dark" onClick={() => {this.checkloggingstatus()}}><MDBIcon far icon="user" /></Button>
                                </div>
                                <Link to="/Contact_us" >
                                    <Button variant="outline-dark"><MDBIcon far icon="envelope" /></Button>
                                </Link>
                            </MDBBtnGroup>
                    </Col>
            </Navb>


            /*



                            <ul className="navbar-nav align-items-left">
                    <li className="nav-item ml-auto ">
                        <Link to='/' className="nav-link">
                            KVINNA
                            </Link>
                    </li>
                    <li className="nav-item ml-auto ">
                        <Link to='/' className="nav-link">
                            MAN
                            </Link>
                    </li>

                    <li className="nav-item ml-auto ">
                        <Link to='/' className="nav-link">
                            BARN
                            </Link>
                    </li>
                </ul>

                <Link to='/'>
                    <img src={logo} alt="store" className="navbar-brand ml-5" />
                </Link>

                <Navb.Brand href='/' className="">Challando</Navb.Brand>


                <ul className="navbar-nav align-items-right">
                    <li className="nav-item ml-auto ">
                        <Link to="/cart">
                            <button className="float-right">
                                <i className="fas fa-cart-plus" />
                                my cart
                            </button>
                        </Link>
                    </li>
                    <li className="nav-item ml-auto ">
                        <Link to="/login" >
                            <button>
                                Log in
                            </button>
                        </Link>
                    </li>
                </ul>








            

            <div className="d-flex justify-content-around">
                <div className="p-2 col-example text-left">ALLA SVERIGES FAVORITMÄRKEN</div>
                <div className="p-2 col-example text-left">FRI FRAKT OCH RETUR*</div>
                <div className="p-2 col-example text-left">100 DAGARS ÖPPET KÖP</div>
            </div>
            



            
            <nav className="navbar navbar-expand-sm bg-primary navbar-dark px-sm-5">
                <Link to='/'>
                    <img src={logo} alt="store" className="navbar-brand" />
                </Link>
                <ul className="navbar-nav align-items-center">
                    <li className="nav-item ml-5">
                        <Link to="/" className="nav-link">
                            products
                </Link>
                    </li>
                </ul>
                <Link to="/cart" className="ml-auto">
                    <button>
                        <i className="fas fa-cart-plus" />
                        my cart
                    </button>
                </Link>
            </nav>
            */
        )
    }
}
