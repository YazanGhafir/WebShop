import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class Default extends Component {
    render() {
        return (
            <div className="my-5">
                <h3>Your Order has successfully been placed!</h3>

                <Link to='/' className="nav-link">
                        Back To The Shop
                </Link>
            </div>
        )
    }
}
