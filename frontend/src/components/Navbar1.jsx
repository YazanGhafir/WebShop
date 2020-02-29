import React, { Component } from 'react'
import Navb from 'react-bootstrap/Navbar'
import { Link } from 'react-router-dom';



export default class Navbar1 extends Component {
    render() {
        return (
            <div className="d-flex justify-content-around">
                <div className="p-2 col-example text-left">ALLA SVERIGES FAVORITMÄRKEN</div>
                <div className="p-2 col-example text-left">FRI FRAKT OCH RETUR*</div>
                <div className="p-2 col-example text-left">100 DAGARS ÖPPET KÖP</div>
            </div>
        )
    }
}
