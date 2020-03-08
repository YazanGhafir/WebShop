import React, { Component } from 'react'
import { MDBCol, MDBRow, MDBBtn, MDBNav, MDBNavItem, MDBNavLink, MDBTabPane, MDBTabContent} from "mdbreact";

export default class Forum extends Component {
    state = {
        activePill: "1",
    }

    togglePills = tab => {
        if (this.state.activePill !== tab) {
            this.setState({
                activePill: tab
            });
        }
    }

    selectNextTab = () => {
        this.setState({
            activePill: (+this.state.activePill + 1).toString()
        });
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
                    <MDBTabPane tabId="1">
                        <form>
                            <MDBRow>
                                <MDBCol md="6" className="mb-4">
                                    <label htmlFor="firstName">First name</label>
                                    <input type="text" id="firstName" className="form-control" />
                                </MDBCol>
                                <MDBCol md="6" className="mb-2">
                                    <label htmlFor="lastName">Last name</label>
                                    <input type="text" id="lastName" className="form-control" />
                                </MDBCol>
                                <MDBCol>
                                    <div className="input-group mb-4">
                                        <div className="input-group-prepend">
                                            <span className="input-group-text" id="basic-addon1">@</span>
                                        </div>
                                        <input type="text" className="form-control py-0" placeholder="Username" aria-describedby="basic-addon1" />
                                    </div>
                                    <label htmlFor="email">Email (optional)</label>
                                    <input type="text" id="email" className="form-control mb-4" placeholder="youremail@example.com" />
                                    <label htmlFor="address">Address</label>
                                    <input type="text" id="address" className="form-control mb-4" placeholder="1234 Main St" />
                                    <label htmlFor="address-2">Address 2 (optional)</label>
                                    <input type="text" id="address-2" className="form-control mb-4" placeholder="Apartment or suite" />
                                </MDBCol>
                            </MDBRow>
                            <MDBRow>
                                <MDBCol lg="4" md="12" className="mb-4">
                                    <label htmlFor="country">Country</label>
                                    <select className="custom-select d-block w-100" id="country" required>
                                        <option>Choose...</option>
                                        <option>United States</option>
                                    </select>
                                    <div className="invalid-feedback">
                                        Please select a valid country.
                          </div>
                                </MDBCol>
                                <MDBCol lg="4" md="6" className="mb-4">
                                    <label htmlFor="state">State</label>
                                    <select className="custom-select d-block w-100" id="state" required>
                                        <option>Choose...</option>
                                        <option>California</option>
                                    </select>
                                    <div className="invalid-feedback">
                                        Please provide a valid state.
                          </div>
                                </MDBCol>
                                <MDBCol lg="4" md="6" className="mb-4">
                                    <label htmlFor="zip">Zip</label>
                                    <input type="text" className="form-control" id="zip" required />
                                    <div className="invalid-feedback">
                                        Zip code required.
                          </div>
                                </MDBCol>
                            </MDBRow>
                            <hr />
                            <div className="ml-4">
                                <div className="mb-1">
                                    <input type="checkbox" className="form-check-input filled-in" id="chekboxRules" />
                                    <label className="form-check-label" htmlFor="chekboxRules">I accept the terms and conditions</label>
                                </div>
                                <div className="mb-1">
                                    <input type="checkbox" className="form-check-input filled-in" id="safeTheInfo" />
                                    <label className="form-check-label" htmlFor="safeTheInfo">Save this information for next time</label>
                                </div>
                                <div className="mb-1">
                                    <input type="checkbox" className="form-check-input filled-in" id="subscribeNewsletter" />
                                    <label className="form-check-label" htmlFor="subscribeNewsletter">Subscribe to the newsletter</label>
                                </div>
                            </div>

                            <hr />
                            <MDBBtn color="primary" size="lg" block onClick={this.selectNextTab}>Next step</MDBBtn>
                        </form>
                    </MDBTabPane>

                    <MDBTabPane tabId="2">
                        <div className="d-block my-3">
                            <div className="mb-2">
                                <input name="group2" type="radio" className="form-check-input with-gap" id="radioWithGap4" required />
                                <label className="form-check-label" htmlFor="radioWithGap4">Credit card</label>
                            </div>
                            <div className="mb-2">
                                <input iname="group2" type="radio" className="form-check-input with-gap" id="radioWithGap5"
                                    required />
                                <label className="form-check-label" htmlFor="radioWithGap5">Debit card</label>
                            </div>
                            <div className="mb-2">
                                <input name="group2" type="radio" className="form-check-input with-gap" id="radioWithGap6" required />
                                <label className="form-check-label" htmlFor="radioWithGap6">Paypal</label>
                            </div>
                            <MDBRow>
                                <MDBCol md="6" className="mb-3">
                                    <label htmlFor="cc-name123">Name on card</label>
                                    <input type="text" className="form-control" id="cc-name123" required />
                                    <small className="text-muted">Full name as displayed on card</small>
                                    <div className="invalid-feedback">
                                        Name on card is required
                          </div>
                                </MDBCol>
                                <MDBCol md="6" className="mb-3">
                                    <label htmlFor="cc-number123">Credit card number</label>
                                    <input type="text" className="form-control" id="cc-number123" required />
                                    <div className="invalid-feedback">
                                        Credit card number is required
                          </div>
                                </MDBCol>
                            </MDBRow>
                            <MDBRow>
                                <MDBCol md="3" className="mb-3">
                                    <label htmlFor="cc-name123">Expiration</label>
                                    <input type="text" className="form-control" id="cc-name123" required />
                                    <div className="invalid-feedback">
                                        Name on card is required
                          </div>
                                </MDBCol>
                                <MDBCol md="3" className="mb-3">
                                    <label htmlFor="cc-cvv123">CVV</label>
                                    <input type="text" className="form-control" id="cc-cvv123" required />
                                    <div className="invalid-feedback">
                                        Security code required
                          </div>
                                </MDBCol>
                            </MDBRow>
                            <hr className="mb-4" />
                            <MDBBtn color="primary" size="lg" block>Place order</MDBBtn>
                        </div>
                    </MDBTabPane>
                </MDBTabContent>
            </div>
        )
    }
}
