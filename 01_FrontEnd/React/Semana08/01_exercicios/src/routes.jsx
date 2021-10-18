import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./pages/Home";
import Ex04 from "./pages/Ex04";
import Ex05 from "./pages/Ex05";

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path="/" component={Home} exact />
      <Route path="/ex04" component={Ex04} />
      <Route path="/ex05" component={Ex05} />
    </Switch>
  </BrowserRouter>
);

export default Routes;
