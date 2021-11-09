import React from "react";
import { BrowserRouter, Switch, Route } from "react-router-dom";
import { Account } from "./pages/Account";
import { Animes } from "./pages/Animes";
import { Cards } from "./pages/Cards";
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
      <Route path="/cards" component={Cards} />
      <Route path="/account" component={Account} />
    </Switch>
  </BrowserRouter>
);
