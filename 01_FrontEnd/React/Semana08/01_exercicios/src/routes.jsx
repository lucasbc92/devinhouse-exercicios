import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Home from "./pages/Home";
import Ex04 from "./pages/Ex04";
import Ex05 from "./pages/Ex05";
import Ex06 from "./pages/Ex06";
import Ex07 from "./pages/Ex07";

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path="/" component={Home} exact />
      <Route path="/ex04" component={Ex04} />
      <Route path="/ex05" component={Ex05} />
      <Route path="/ex06" component={Ex06} />
      <Route path="/ex07" component={Ex07} />
    </Switch>
  </BrowserRouter>
);

export default Routes;
