import React from "react";
import { MDBRow, MDBCol, MDBBtn, MDBNav, MDBNavItem, MDBNavLink, MDBTabPane, MDBTabContent, MDBInput } from "mdbreact";
import { Link } from 'react-router-dom';

class FormsPage extends React.Component {
    state = {    
        fname: "Mark",
        lname: "Otto",
        email: "",
        city: "",
        state: "",
        zip: "",
        radio: "",
    };

    onClick = nr => () => {
        this.setState({
            radio: nr
        });
    }

    submitHandler = event => {
        event.preventDefault();
        event.target.className += " was-validated";
    };

    changeHandler = event => {
        this.setState({ [event.target.name]: event.target.value });
    };

    onFormSubmit = e => {
        if (
            document.getElementById('materialFormRegisterfName').checkValidity() &&
            document.getElementById('materialFormRegisterlname').checkValidity() &&
            document.getElementById('materialFormRegisterEmail').checkValidity() &&
            document.getElementById('materialFormRegistercity').checkValidity() &&
            document.getElementById('materialFormRegisterstate').checkValidity() &&
            document.getElementById('materialFormRegisterZip').checkValidity() &&
            this.state.radio == 1 || this.state.radio == 2 || this.state.radio == 3 &&
            document.getElementById('cc-name').checkValidity() &&
            document.getElementById('cc-number').checkValidity() &&
            document.getElementById('cc-exp').checkValidity() &&
            document.getElementById('cc-cvv').checkValidity() 
        ) {
            this.placeOrder();
            JSON.stringify(this.state);
            window.open('/order_succeed');
        } else {
            alert("You need to fix all the wrongs first :)");
        }
    };


    placeOrder() {
        fetch("http://localhost:8080/orm/webshop/o")
            .then(console.log)
            .catch(console.log);
    }

    render() {

        const { activePill } = this.state;

        return (
            <div>
                <MDBNav pills color="primary" className="nav-justified">
                    <MDBNavItem>
                        <MDBNavLink to="#" className={activePill === "1" ? "active" : ""} onClick={() => this.togglePills("1")}>
                            <strong>1. Billing</strong>
                        </MDBNavLink>
                    </MDBNavItem>
                    <MDBNavItem>
                        <MDBNavLink to="#" className={activePill === "2" ? "active" : ""} onClick={() => this.togglePills("2")}>
                            <strong>2. Payment</strong>
                        </MDBNavLink>
                    </MDBNavItem>
                </MDBNav>

                <MDBTabContent className="pt-4" activeItem={activePill}>
                    <form
                        className='needs-validation'
                        onSubmit={this.submitHandler}
                        noValidate
                    >
                        <MDBRow>
                            <MDBCol md='4'>
                                <MDBInput
                                    icon='user'
                                    value={this.state.fname}
                                    name='fname'
                                    onChange={this.changeHandler}
                                    type='text'
                                    id='materialFormRegisterfName'
                                    label='First name'
                                    outline
                                    required
                                >
                                    <div className='valid-feedback ml-3 pl-3'>Looks good!</div>
                                </MDBInput>
                            </MDBCol>
                            <MDBCol md='4'>
                                <MDBInput
                                    icon='address-card'
                                    value={this.state.lname}
                                    name='lname'
                                    onChange={this.changeHandler}
                                    type='text'
                                    id='materialFormRegisterlname'
                                    label='Last name'
                                    outline
                                    required 
                                >
                                    <div className='valid-feedback ml-3 pl-3'>Looks good!</div>
                                </MDBInput>
                            </MDBCol>
                            <MDBCol md='4'>
                                <MDBInput
                                    icon='envelope-open'
                                    value={this.state.email}
                                    onChange={this.changeHandler}
                                    type='email'
                                    id='materialFormRegisterEmail'
                                    name='email'
                                    label='Your Email address'
                                    outline
                                >
                                    <small id='emailHelp' className='form-text text-muted'>
                                        We'll never share your email with anyone else.
                                        </small>
                                </MDBInput>
                            </MDBCol>
                        </MDBRow>
                        <MDBRow>
                            <MDBCol md='4'>
                                <MDBInput
                                    icon='city'
                                    value={this.state.city}
                                    onChange={this.changeHandler}
                                    type='text'
                                    id='materialFormRegistercity'
                                    name='city'
                                    label='City'
                                    outline
                                    required
                                >
                                    <div className='    -feedback ml-3 pl-3'>
                                        Please provide a valid city.
                                        </div>
                                    <div className='valid-feedback ml-3 pl-3'>Looks good!</div>
                                </MDBInput>
                            </MDBCol>
                            <MDBCol md='4'>
                                <MDBInput
                                    icon='map-marked-alt'
                                    value={this.state.state}
                                    onChange={this.changeHandler}
                                    type='text'
                                    id='materialFormRegisterstate'
                                    name='state'
                                    label='State'
                                    outline
                                    required
                                >
                                    <div className='invalid-feedback ml-3 pl-3'>
                                        Please provide a valid state.
                                        </div>
                                    <div className='valid-feedback ml-3 pl-3'>Looks good!</div>
                                </MDBInput>
                            </MDBCol>
                            <MDBCol md='4'>
                                <MDBInput
                                    icon='location-arrow'
                                    value={this.state.zip}
                                    onChange={this.changeHandler}
                                    type='text'
                                    id='materialFormRegisterZip'
                                    name='zip'
                                    label='Zip'
                                    outline
                                    required
                                >
                                    <div className='invalid-feedback ml-3 pl-3'>
                                        Please provide a valid zip.
                                        </div>
                                    <div className='valid-feedback ml-3 pl-3'>Looks good!</div>
                                </MDBInput>
                            </MDBCol>
                        </MDBRow>

                        <hr className="mb-4" />


                    <div className="d-block my-3 ">
                        <div className="mb-2 ml-4">
                            <input name="group2" type="radio" className="form-check-input with-gap" id="radioWithGap4" onClick={this.onClick(1)} checked={this.state.radio===1 ? true : false} required />
                            <label className="form-check-label" htmlFor="radioWithGap4">Credit card</label>
                        </div>
                        <div className="mb-2 ml-4">
                            <input name="group2" type="radio" className="form-check-input with-gap" id="radioWithGap5" onClick={this.onClick(2)} checked={this.state.radio===2 ? true : false} required />
                            <label className="form-check-label" htmlFor="radioWithGap5">Debit card</label>
                        </div>
                        <div className="mb-2 ml-4">
                            <input name="group2" type="radio" className="form-check-input with-gap" id="radioWithGap6" onClick={this.onClick(3)} checked={this.state.radio===3 ? true : false} required />
                            <label className="form-check-label" htmlFor="radioWithGap6">Paypal</label>
                        </div>
                        <MDBRow>
                            <MDBCol md="6" className="mb-3">
                                <label htmlFor="cc-name123">Name on card</label>
                                <input type="text" className="form-control" id="cc-name" required />
                                <small className="text-muted">Full name as displayed on card</small>
                                <div className="invalid-feedback">
                                    Name on card is required
                          </div>
                            </MDBCol>
                            <MDBCol md="6" className="mb-3">
                                <label htmlFor="cc-number123">Credit card number</label>
                                <input type="text" className="form-control" id="cc-number" required />
                                <div className="invalid-feedback">
                                    Credit card number is required
                          </div>
                            </MDBCol>
                        </MDBRow>
                        <MDBRow>
                            <MDBCol md="3" className="mb-3">
                                <label htmlFor="cc-name123">Expiration</label>
                                <input type="text" className="form-control" id="cc-exp" required />
                                <div className="invalid-feedback">
                                    Expiration date is required
                          </div>
                            </MDBCol>
                            <MDBCol md="3" className="mb-3">
                                <label htmlFor="cc-cvv123">CVV</label>
                                <input type="text" className="form-control" id="cc-cvv" required />
                                <div className="invalid-feedback">
                                    Security code is required
                                </div>
                            </MDBCol>
                        </MDBRow>
                        <hr className="mb-4" />

                    </div>


                    <MDBCol md='4' className='mb-3'>
                        <div className='custom-control custom-checkbox pl-3'>
                            <input
                                className='custom-control-input'
                                type='checkbox'
                                value=''
                                id='invalidCheck'
                                required
                            />
                            <label className='custom-control-label' htmlFor='invalidCheck' >
                                Agree to terms and conditions
                            </label>
                            <div className='invalid-feedback'>
                                You must agree before submitting.</div>
                            </div>
                    </MDBCol>
                        <MDBBtn color="primary" size="lg" block onClick={() => { this.onFormSubmit() }} type="submit" >
                            Place order
                        </MDBBtn>
                </form>

                </MDBTabContent>
            </div>
        );
    }
}

export default FormsPage;















/**
 * 
 * disabled={!this.state.formControls.name.valid}
 * 
 * 

import React from "react";
import { MDBInput, MDBBtn, MDBCol } from "mdbreact";
import { BrowserRouter as Router, withRouter } from "react-router-dom";

const usersJson = {
  users: {
    testUser: {
      password: "test",
      type: "test"
    }
  }
};

class Login extends React.Component {
  state = {
    userName: "",
    password: "",
    usersJson: {}
  };
  componentDidMount() {
    this.setState({ usersJson });
  }

  getLoginData = (value, type) =>
    this.setState({
      [type]: value
    });

  onFormSubmit = e => {
    e.preventDefault();
    const { usersJson, userName, password } = this.state;
    const filterUserName = Object.keys(usersJson.users).filter(
      e => e === userName
    );
    if (
      filterUserName.length > 0 &&
      usersJson.users[userName].password === password
    ) {
      this.props.history.push("test");
      window.localStorage.setItem(
        "user",
        JSON.stringify(usersJson.users[userName])
      );
    } else {
      alert("Wrong login or password");
    }
  };
  render() {
    return (
      <Router>
        <MDBCol size="3">
          <form onSubmit={this.onFormSubmit}>
            <p className="h5 text-center mb-4">Sign in</p>
            <div className="grey-text">
              <MDBInput
                label="Type your email"
                icon="envelope"
                group
                type="text"
                validate
                error="wrong"
                success="right"
                getValue={value => this.getLoginData(value, "userName")}
              />
              <MDBInput
                label="Type your password"
                icon="lock"
                group
                type="password"
                validate
                getValue={value => this.getLoginData(value, "password")}
              />
            </div>
            <div className="text-center">
              <MDBBtn type="submit" onClick={this.onFormSubmit}>
                Login
              </MDBBtn>
            </div>
          </form>
        </MDBCol>
      </Router>
    );
  }
}

export default withRouter(Login);


*/
