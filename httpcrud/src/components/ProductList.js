import React, { Component } from "react";
import { Table } from "react-bootstrap";
import { Link } from "react-router-dom";
import Pagination from "react-js-pagination";

export class ProductList extends Component {
  constructor(props) {
    super(props);

    this.state = {
      list: [],
      activePage: 10 
    };
  }
  handlePageChange(pageNumber) {
    console.log(`active page is ${pageNumber}`);
    this.setState({activePage: pageNumber});
  }
  componentDidMount() {
    fetch("http://localhost:3000/products", { method: "GET" })
      .then((response) => response.json())

      .then((data) => this.setState({ list: data }));
  }

  delete(id) {
    alert("Delete!" + id);
    fetch("http://localhost:3000/products/" + id, {
      method: "DELETE",
    }).then((result) => {
      result.json().then((resp) => {
        alert("Product has been Deleted");
        window.location.replace("http://localhost:3002/list");
      });
    });
  }

  render() {
    return (
      <div className="container">
        <h1 style={{ color: "red" }}>Product List</h1>
        {this.state.list ? (
          <div>
            <Table striped bordered hover>
              <thead>
                <tr>
                  <th>#</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Rating</th>
                  <th>Location</th>
                  <th>Actions</th>
                </tr>
              </thead>
              <tbody>
                {
                this.state.list.map((item, i) => (
                  <tr key={item.id}>
                    <td>{item.id}</td>
                    <td>{item.name}</td>
                    <td>{item.email}</td>
                    <td>{item.rating}</td>
                    <td>{item.address}</td>
                    <td>
                      <span style={{ padding: 5 }}>
                        <Link
                          to={"/update/" + item.id}
                          className="btn btn-info"
                        >
                          Update
                        </Link>
                      </span>
                      <span style={{ padding: 5 }}>
                        <button
                          className="btn btn-danger"
                          onClick={() => this.delete(item.id)}
                        >
                          Delete
                        </button>
                      </span>
                    </td>
                  </tr>
                ))}
              </tbody>
            </Table>
          </div>
        ) : (
          <p>Please wait</p>
        )}
         <Pagination
          activePage={this.state.activePage}
          itemsCountPerPage={this.state.list.length<3}
          totalItemsCount={this.state.list.length}
          pageRangeDisplayed={this.state.list.length}
          onChange={this.handlePageChange.bind(this)}
        />
      </div>
    );
  }
}

export default ProductList;
