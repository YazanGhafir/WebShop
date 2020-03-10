import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import logo from '../../imgs/logo.png';
import Navb from 'react-bootstrap/Navbar'
import Col from 'react-bootstrap/Col';

export default class Navbar2 extends Component {
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

                    <Col  sm={{ span: 3, offset: 2 }}>
                        <Link to='/'>
                            <img src={logo} alt="store" className="navbar-brand ml-5" />
                        </Link>

                        <Navb.Brand href='/' className="">Challando</Navb.Brand>
                    </Col>

                    
                    <Col sm={{ span: 2, offset: 2 }}>
                        <Link to="/cart">
                            <button>
                                <i className="fas fa-cart-plus" />
                                my cart
                            </button>
                        </Link>
                    </Col>

                    <Col sm={1} >
                        <Link to="/login" >
                            <button>
                                Log in
                            </button>
                        </Link>
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
