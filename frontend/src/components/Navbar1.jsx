import React, { Component } from 'react'
import Navb from 'react-bootstrap/Navbar'
import { Link } from 'react-router-dom';



export default class Navbar1 extends Component {
    render() {
        return (
            <div>

                <Navb bg="light">
                    <ul className="navbar-nav align-items-center">
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                                ALLA SVERIGES FAVORITMÄRKEN
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                                FRI FRAKT OCH RETUR*
                            </Link>
                        </li>

                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                                100 DAGARS ÖPPET KÖP
                            </Link>
                        </li>
                    </ul>
                </Navb>


            </div>
        )
    }
}
