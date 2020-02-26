import React, { Component } from 'react'
import { Link } from 'react-router-dom';
import logo from '../imgs/logo.png';
import Navb from 'react-bootstrap/Navbar'
import Button from 'react-bootstrap/Button';


export default class Navbar2 extends Component {
    render() {
        return (

            <Navb bg="light">

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

                <Link to="/cart" className="ml-auto">
                    <button>
                        <i className="fas fa-cart-plus" />
                        my cart
                    </button>
                </Link>
            </Navb>


            /*
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
