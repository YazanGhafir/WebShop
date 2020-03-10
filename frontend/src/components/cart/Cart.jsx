import React, { Component } from "react";
import { MDBRow, MDBCard, MDBCardBody, MDBTooltip, MDBTable, MDBTableBody, MDBTableHead, MDBInput, MDBBtn, MDBContainer
} from "mdbreact";
import { Link } from "react-router-dom";

class eCommercePage extends Component {
  state = {
    data: [
      {
        src:
          "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/7.jpg",
        title: "iPhone",
        subTitle: "Apple",
        color: "White",
        price: "800",
        qty: "2"
      },
      {
        src:
          "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/6.jpg",
        title: "Headphones",
        subTitle: "Sony",
        color: "Red",
        price: "200",
        qty: "2"
      },
      {
        src:
          "https://mdbootstrap.com/img/Photos/Horizontal/E-commerce/Products/1.jpg",
        title: "iPad Pro",
        subTitle: "Apple",
        color: "Gold",
        price: "600",
        qty: "1"
      }
    ],
    columns: [
      {
        label: "",
        field: "img"
      },
      {
        label: <strong>Product</strong>,
        field: "product"
      },
      {
        label: <strong>Color</strong>,
        field: "color"
      },
      {
        label: <strong>Price</strong>,
        field: "price"
      },
      {
        label: <strong>QTY</strong>,
        field: "qty"
      },
      {
        label: <strong>Amount</strong>,
        field: "amount"
      },
      {
        label: "",
        field: "button"
      }
    ]
  };

  constructor(props) {
    super(props);
    this.state = {
      data: [
        {
          product_id: "5",
          name: "product2",
          img:
            "https://images.pexels.com/photos/1598505/pexels-photo-1598505.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
          price: "86$"
        },
        {
          product_id: "6",
          name: "product3",
          img:
            "https://images.pexels.com/photos/267320/pexels-photo-267320.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
          price: "86$"
        },
        {
          product_id: "7",
          name: "product3",
          img:
            "https://images.pexels.com/photos/267324/pexels-photo-267324.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
          price: "86$"
        },
        {
          product_id: "8",
          name: "product3",
          img:
            "https://images.pexels.com/photos/267330/pexels-photo-267330.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
          price: "86$"
        }
      ],
      columns: [
        {
          label: "",
          field: "img"
        },
        {
          label: <strong>Product</strong>,
          field: "product"
        },
        {
          label: <strong>Color</strong>,
          field: "color"
        },
        {
          label: <strong>Price</strong>,
          field: "price"
        },
        {
          label: <strong>QTY</strong>,
          field: "qty"
        },
        {
          label: <strong>Amount</strong>,
          field: "amount"
        },
        {
          label: "",
          field: "button"
        }
      ]
    };
  }

  componentDidMount() {
    fetch("http://localhost:8080/orm/webshop/sc")
      .then(res => res.json())
      .then(cdata => {
        this.setState({ data: cdata });
      })
      .catch(console.log);
  }

  removeFromCart() {
    /**add Pid after you fixed cart component*/
    fetch("http://localhost:8080/orm/webshop/sc/", {
      method: "delete",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({})
    });
  }

  render() {
    const rows = [];
    const { columns, data } = this.state;

    data.map(row => {
      return rows.push({
        img: <img src={row.src} alt="" className="img-fluid z-depth-0" />,
        product: [
          <h5 className="mt-3" key={new Date().getDate + 1}>
            <strong>{row.title}</strong>
          </h5>,
          <p key={new Date().getDate} className="text-muted">
            {row.subTitle}
          </p>
        ],
        color: row.color,
        price: `$${row.price}`,
        qty: (
          <MDBInput
            type="number"
            default={row.qty}
            className="form-control"
            style={{ width: "100px" }}
          />
        ),
        amount: <strong>${row.qty * row.price}</strong>,
        button: (
          <MDBTooltip placement="top">
            <MDBBtn color="primary" size="sm">
              X
            </MDBBtn>
            <div>Remove item</div>
          </MDBTooltip>
        )
      });
    });

    return (
      <MDBContainer>
        <MDBRow className="mx-5 my-5" center>
          <MDBCard className="w-100 mx-5 my-5">
            <MDBCardBody>
              <MDBTable className="product-table">
                <MDBTableHead
                  className="font-weight-bold"
                  color="mdb-color lighten-5"
                  columns={columns}
                />
                <MDBTableBody rows={rows} />
              </MDBTable>
              <Link to="/checkout">
                <MDBBtn color="primary" size="lg" block>
                  To Checkout
                </MDBBtn>
              </Link>
            </MDBCardBody>
          </MDBCard>
        </MDBRow>
      </MDBContainer>
    );
  }
}

export default eCommercePage;
