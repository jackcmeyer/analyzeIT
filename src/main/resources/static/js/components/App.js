import React from "react";
import { Row, Col } from "react-bootstrap";
import browserHistory from "react-router";

export default class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Row>
                <Col md={6} mdOffset={3}>
                    {this.props.children}
                </Col>
            </Row>
        );
    }
}