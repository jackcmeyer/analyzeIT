import React from "react";
import ReactDOM from "react-dom";
import { Router, Route, IndexRoute, hashHistory, IndexRedirect} from "react-router";
// import $ from "jquery";


import App from "./js/components/App";
import Home from "./js/pages/Home";

const app = document.getElementById('app');

ReactDOM.render(
<Router history={hashHistory}>
    <Route path="/" component={App}>
    <IndexRedirect to="/home" />
    <Route path="home" name="Home" component={Home} />
    </Route>
    </Router>,
    app);