import React, { Component } from 'react'


export default class MyInfo extends Component {
    render() {
        return (

            <div class="d-flex flex-row border rounded">
	  			<div class="p-0 w-50">
	  			    <img src="https://cse.umn.edu/sites/cse.umn.edu/themes/custom/cse/img/person_placeholder.png" className="img-thumbnail border-0" />
	  				
	  			</div>
	  			<div class="pl-3 pt-2 pr-2 pb-2 w-75 border-left">
	  					<h4 class="text-primary">Full Name</h4>
	  					<h5 class="text-info">Email</h5>
	  					<h5 class="text-info">Adress</h5>
                        <h5 class="text-info">city</h5>
				</div>
			</div>
        )
    }
}
