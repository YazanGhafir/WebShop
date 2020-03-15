import React, { Component } from 'react'
import { Link } from 'react-router-dom';

export default class MessageSent extends Component {
    render() {
        return (
            <div>
                <h3 className="mt-5 mx-5">Your Message has been sent successfully! We will contact you as soon as possible :) </h3>

                <Link to='/' className="nav-link">
                        <p className="mx-5">Back To The Shop</p>
                </Link>
            </div>
        )
    }
}
