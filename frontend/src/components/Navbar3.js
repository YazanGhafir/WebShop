import React, { Component } from 'react'
import Navb from 'react-bootstrap/Navbar'
import { Link } from 'react-router-dom';



export default class Navbar3 extends Component {
    render() {
        return (
            <div>
                <Navb bg="light">
                    <ul className="navbar-nav align-items-center">
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Get the Look
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Nytt
                            </Link>
                        </li>
                       
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                                Skor
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                                Sport
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Accessoarer
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Beauty
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Designers
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Märken
                            </Link>
                        </li>
                        <li className="nav-item ml-auto ">
                            <Link to='/' className="nav-link">
                            Outlet
                            </Link>
                        </li>
                    </ul>
                </Navb>
            </div>
        )
    }
}
