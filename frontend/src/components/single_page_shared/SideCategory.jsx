import React, { Component } from 'react'
import Button from 'react-bootstrap/Button';

export default class SideCategory extends React.Component {
	render() {
		return (
			<Button variant="light">{this.props.name}</Button> 
		);
	}
}
