import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Animes } from "./pages/Animes";
import { CounterPage } from "./pages/CounterPage";
import { Home } from "./pages/Home";
import { Login } from "./pages/Login";

export const Routes = () => (
  <BrowserRouter>
    <Switch>
      <Route path="/" component={Home} exact />
      <Route path="/login" component={Login} />
      <Route path="/counter" component={CounterPage} />
      <Route path="/animes" component={Animes} />
    </Switch>
  </BrowserRouter>
);
