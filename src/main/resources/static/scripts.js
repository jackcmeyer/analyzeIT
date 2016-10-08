import React from "react";
import ReactDOM from "react-dom";
import { Router, Route, IndexRoute, browserHistory, IndexRedirect} from "react-router";
// import $ from "jquery";


import App from "./js/components/App";
import Login from "./js/pages/Login";

const app = document.getElementById('app');

function isLoggedIn() {

}

ReactDOM.render(
<Router history={browserHistory}>
    <Route path="/" component={App}>
    <IndexRedirect to="/login" />
    <Route path="login" name="login" component={Login} />
    {/*<Route path="home" name="home" component={Home} onEnter={isLoggedIn}></Route>*/}
    </Route>
    </Router>,
    app);