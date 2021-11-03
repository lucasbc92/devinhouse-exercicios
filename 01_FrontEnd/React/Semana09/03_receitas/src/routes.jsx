import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Home } from "./pages/Home";
import { RecipePage } from "./pages/RecipePage";
import { Contact } from "./pages/Contact";

const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path="/" component={Home} exact />
      <Route path="/recipe" component={RecipePage} />
      <Route path="/contact" component={Contact} />
    </Switch>
  </BrowserRouter>
);

export default Routes;
