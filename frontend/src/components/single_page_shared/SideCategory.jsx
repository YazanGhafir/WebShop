import React, { Component } from 'react'
import { MDBBtn } from "mdbreact";


export default class SideCategory extends React.Component {
	render() {
		return (
			<MDBBtn rounded outline color="info">{this.props.name}</MDBBtn>
		);
	}
}
