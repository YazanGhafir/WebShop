import React, { Component } from "react";
import './login.css';
import { isEmail, isEmpty, isLength, isContainWhiteSpace } from './validator';
import { MDBInput, MDBBtn } from "mdbreact";

class Login extends Component {

    constructor(props) {
        super(props)

        this.state = {
            formData: {}, // Contains login form data
            errors: {}, // Contains login field errors
            formSubmitted: false, // Indicates submit status of login form
            loading: false // Indicates in progress state of login form
        }
    }

    handleInputChange = (event) => {
        const target = event.target;
        const value = target.value;
        const name = target.name;

        let { formData } = this.state;
        formData[name] = value;

        this.setState({
            formData: formData
        });
    }

    validateLoginForm = (e) => {

        let errors = {};
        const { formData } = this.state;

        if (isEmpty(formData.email)) {
            errors.email = "Email can't be blank";
        } else if (!isEmail(formData.email)) {
            errors.email = "Please enter a valid email";
        }

        if (isEmpty(formData.password)) {
            errors.password = "Password can't be blank";
        } else if (isContainWhiteSpace(formData.password)) {
            errors.password = "Password should not contain white spaces";
        } else if (!isLength(formData.password, { gte: 6, lte: 16, trim: true })) {
            errors.password = "Password's length must between 6 to 16";
        }

        if (isEmpty(errors)) {
            return true;
        } else {
            return errors;
        }
    }

    login = (e) => {

        e.preventDefault();

        let errors = this.validateLoginForm();

        if (errors === true) {
            alert("You are successfully signed in...");
            window.location.reload()
        } else {
            this.setState({
                errors: errors,
                formSubmitted: true
            });
        }
    }

    render() {

        const { errors, formSubmitted } = this.state;

        return (
            <div>
                <form className="px-4">
                    <p className="h4 text-center py-4">Login</p>
                    <div className="grey-text">
                        <MDBInput
                            label="Your email"
                            icon="envelope"
                            group
                            type="email"
                            validate
                            required
                        />
                        <MDBInput
                            label="Password"
                            icon="user"
                            group
                            type="password"
                            validate
                            required
                        />
                    </div>
                    <div className="text-center py-4 mt-3">
                        <MDBBtn color="cyan" type="submit">
                            Login
                        </MDBBtn>
                    </div>
                </form>

            </div>
        )
    }
}

export default Login;


/**
 *  <ControlLabel>Email</ControlLabel>
 *   <HelpBlock>{errors.email}</HelpBlock>

 */