import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class Default extends Component {
    render() {
        return (
            <div>
                <h3 className="mt-5 mx-5">Page not found!</h3>

                <Link to='/' className="nav-link">
                        <p className="mx-5">Back To The Shop</p>
                </Link>
            </div>
        )
    }
}
