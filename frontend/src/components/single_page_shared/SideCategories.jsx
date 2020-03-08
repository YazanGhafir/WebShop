import React, { Component } from 'react'
import ListGroup from 'react-bootstrap/ListGroup';
import SideCategory from "./SideCategory"



export default class SideCategories extends Component {

  constructor(props) {
    super(props);
    this.state = { categories:  [{'name':'category1'},{'name':'category2'},{'name':'category3'},{'name':'category4'},{'name':'category5'},{'name':'category6'},
                                 {'name':'category7'},{'name':'category8'},{'name':'category9'},{'name':'category10'},{'name':'category11'},{'name':'category12'}] };
  }

  componentDidMount() {
    fetch("http://localhost:8080/orm/webshop/category")
      .then(res => res.json())
      .then((data) => {
        this.setState({ categories: data })
      }).catch(console.log);
  }


  render() {
    return (
         <ListGroup variant="flush" className="mt-4">
           {this.state.categories.map((c, idx) => {return <SideCategory name={c.name} key={idx} /> })}
        </ListGroup>
    );
  }


  /*

  render() {
    console.log(this.state)
    return (
      <div>
        <ListGroup variant="flush" className="mt-4">
          <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
        </ListGroup>
      </div>
    );
  }


 constructor(props) {
     super(props);
     this.state = {
         error: null,
         isLoaded: false,
         items: []
       };
   }
 
   

  
   componentDidMount() {
     fetch("http://localhost:8080/orm/webshop/category/")
       .then(res => res.json())
       .then(
         (result) => {
           this.setState({
             isLoaded: true,
             items: result.items
           });
         },
         // Note: it's important to handle errors here
         // instead of a catch() block so that we don't swallow
         // exceptions from actual bugs in components.
         (error) => {
           this.setState({
             isLoaded: true,
             error
           });
           

         }
       )
   }
 
   render() {
     const { error, isLoaded, items } = this.state;
     if (error) {
       console.log(this.state.items);
       return ( 
                 <ListGroup variant="flush" className="mt-4">
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
                   <ListGroup.Item className="bg-light">T-shirts</ListGroup.Item>
     
                 </ListGroup>
             );
     } else if (!isLoaded) {
       return <div>Loading...</div>;
     } else {
       return (
         <ul>
           {items.map(item => (
             <li key={item.name}>
               {item.name} {item.price}
             </li>
           ))}
         </ul>
       );
     }
   }
   */

}