import React from "react";
import { MDBRow, MDBCol, MDBCard, MDBCardBody, MDBIcon, MDBBtn, MDBInput } from "mdbreact";

class ContactPage extends React.Component {
  state = {    
    name: "",
    email: "",
    subject: "",
    message: ""
};


submitHandler = event => {
    event.preventDefault();
    event.target.className += " was-validated";
};

changeHandler = event => {
    this.setState({ [event.target.name]: event.target.value });
};

onFormSubmit = e => {
    if (
        document.getElementById('materialFormRegisterName').checkValidity() &&
        document.getElementById('materialFormRegisterEmail').checkValidity() &&
        document.getElementById('materialFormRegisterSubject').checkValidity() &&
        document.getElementById('materialFormRegisterMessage').checkValidity()
    ) {

        this.sendMessage();
    } else {
        alert("You need to fix all the wrongs first :) ");
    }
};


sendMessage() {
  const mInfo = this.state.name + '/' + this.state.email + '/' + this.state.subject + '/' + this.state.message;
  const url = 'http://localhost:8080/orm/webshop/cart/cMessage/';
  const both = url + mInfo;
  
  fetch(both)
      .then(function(response) {
          if(response.status === 200) {
              window.location.replace('/MessageSent');
          } else {
              alert("something went wrong, please try again later");
          }
      })
}

render() {
    return(

        <section className="my-5">
          <h2 className="h1-responsive font-weight-bold text-center my-5">
            Contact us
          </h2>
          <MDBRow>
            

          <MDBCol lg="6">
              <div
                id="map-container"
                className="rounded z-depth-1-half map-container"
                style={{ height: "400px" }}
              >
                <iframe
                  src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d2132.5873084510267!2d11.974570916006604!3d57.689491181115464!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x464ff36b628efec3%3A0xc148ed83d6f0a03!2sChalmers%20Tekniska%20H%C3%B6gskola!5e0!3m2!1ssv!2sse!4v1584231615006!5m2!1ssv!2sse"
                  title="This is a unique title"
                  width="100%"  
                  height="100%"
                  frameBorder="0"
                  style={{ border: 0 }}
                />
              </div>
              <br />
              <MDBRow className="text-center">
                <MDBCol md="4">
                  <MDBBtn tag="a" floating color="blue" className="accent-1">
                    <MDBIcon icon="map-marker-alt" />
                  </MDBBtn>
                  <p>Chalmersplatsen 4, 41296</p>
                  <p className="mb-md-0">Gothenburg</p>
                </MDBCol>
                <MDBCol md="4">
                  <MDBBtn tag="a" floating color="blue" className="accent-1">
                    <MDBIcon icon="phone" />
                  </MDBBtn>
                  <p>+ 46 31 799 999</p>
                  <p className="mb-md-0">Mon - Fri, 8:00-22:00</p>
                </MDBCol>
                <MDBCol md="4">
                  <MDBBtn tag="a" floating color="blue" className="accent-1">
                    <MDBIcon icon="envelope" />
                  </MDBBtn>
                  <p>info@challando.se</p>
                  <p className="mb-md-0">sale@challando.se</p>
                </MDBCol>
              </MDBRow>
            </MDBCol>




            
            <MDBCol lg="6" className="lg-0 mb-4">
              <MDBCard>
                <MDBCardBody>
      

                  <form className='needs-validation'
                        onSubmit={this.submitHandler}
                        noValidate>
                  

                    <p className="h4 text-center py-4">Contact Us</p>
                    <div className="grey-text"></div>
                      <MDBInput
                        id="materialFormRegisterName"
                        label="Your name"
                        group
                        name='name'
                        onChange={this.changeHandler}
                        type="text"
                        validate
                        required
                      >
                        <div className='invalid-feedback ml-3 pl-3'>Please provide a valid name.</div>
                      </MDBInput>


                      <MDBInput
                        id="materialFormRegisterEmail"
                        label="Your email"
                        group
                        name='email'
                        onChange={this.changeHandler}
                        type="email"
                        validate
                        required
                      >
                      <div className='invalid-feedback ml-3 pl-3'>Please provide a valid Email.</div>
                    </MDBInput>


                      <MDBInput
                        id="materialFormRegisterSubject"
                        label="Your Subject"
                        group
                        name='subject'
                        onChange={this.changeHandler}
                        type="text"
                        validate
                        required
                      >
                      <div className='invalid-feedback ml-3 pl-3'>Please provide Subject.</div>
                      </MDBInput>
                      
                      
                      <label htmlFor="materialFormRegisterMessage" className="grey-text">
                        Your message
                      </label>

                      <textarea type="text" id="materialFormRegisterMessage" className="form-control" rows="3" required onChange={this.changeHandler}  name='message'/>                  


                      <div className="text-center py-4 mt-3">
                        <MDBBtn color="cyan" type="submit" onClick={() => { this.onFormSubmit() }}>
                          Send
                        </MDBBtn>
                      </div>


                  </form>

         

                </MDBCardBody>
              </MDBCard>
            </MDBCol>

          </MDBRow>
        </section>
    );
  }
}

export default ContactPage;
