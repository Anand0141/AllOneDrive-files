import React from "react";
import { BrowserRouter as Router, Route, Link, Switch } from "react-router-dom";
import CreateProduct from "./CreateProduct";
import ProductList from "./ProductList";
import ProductUpdate from "./ProductUpdate";
import {FontAwesomeIcon} from '@fortawesome/react-fontawesome'
import { faHome, faList } from "@fortawesome/free-solid-svg-icons";

function Navbar() {
  return (
    <div className="container">
      <Router>
        <ul>
          <li>
            <Link to={"/create"}><FontAwesomeIcon icon={faHome}/>Create Product</Link>
          </li>
          <li>
            <Link to={"/list"}><FontAwesomeIcon icon={faList} />List Products</Link>
          </li>
        </ul>

        <Switch>
          <Route path="/list">
            <ProductList />
          </Route>
          <Route path="/create">
            <CreateProduct />
          </Route>
          <Route path="/update/:id"  render={props => (
              <ProductUpdate {...props} />
            )}
          />
        </Switch>
      </Router>
    </div>
  );
}

export default Navbar;
