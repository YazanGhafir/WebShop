import React, { Component } from 'react'
import Navbar1 from './Navbar1';
import Navbar2 from './Navbar2';
import Navbar3 from './Navbar3';
import Container from 'react-bootstrap/Container';
import Row from 'react-bootstrap/Row';


export default class Navbar extends Component {
    render() {
        return (
            <div>
                <Navbar1 />
                <Navbar2 />
                <Navbar3 />
            </div>
        )
    }
}
