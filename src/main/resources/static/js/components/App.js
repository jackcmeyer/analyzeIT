import React from "react";
import { Row, Col } from "react-bootstrap";
import browserHistory from "react-router";

export default class App extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        // const childrenWithProps = React.Children.map(this.props.children,
        //     (child) => React.cloneElement(child, {
        //         user: this.user
        //     })
        // );

        return (
            <Row>
                <Col md={6} mdOffset={3}>
                    {this.props.children}
                </Col>
            </Row>
        );
    }
}