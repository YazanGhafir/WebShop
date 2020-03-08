import React, { Component } from 'react'
import ListGroup from 'react-bootstrap/ListGroup';


export default class SideCategory extends React.Component {
	render() {
		return (
            <ListGroup.Item className="bg-light">{this.props.name}</ListGroup.Item>
		);
	}
}
