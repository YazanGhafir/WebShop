import React, { Component } from 'react'


export default class MyInfo extends Component {
    render() {
        return (

            <div className="d-flex flex-row border rounded">
	  			<div className="p-0 w-50">
	  			    <img src="https://cse.umn.edu/sites/cse.umn.edu/themes/custom/cse/img/person_placeholder.png" className="img-thumbnail border-0" alt=""/>
	  				
	  			</div>
	  			<div className="pl-3 pt-2 pr-2 pb-2 w-75 border-left">
	  					<h4 className="text-primary">Full Name</h4>
	  					<h5 className="text-info">Email</h5>
	  					<h5 className="text-info">Adress</h5>
                        <h5 className="text-info">city</h5>
				</div>
			</div>
        )
    }
}
