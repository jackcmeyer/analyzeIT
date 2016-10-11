import React from "react";
import { PageHeader, Row, Col, FormGroup, FormControl, ControlLabel, Checkbox, Button } from "react-bootstrap";

export default class Home extends React.Component {
    constructor() {
        super();
        this.state = {
            value: ''
        }
    }

    getValidationState() {
        const length = this.state.value.length;
        if (length > 5) return 'success';
        else if (length > 5) return 'warning';
        else if (length > 0) return 'error';
    }

    handleChange(e) {
        this.setState({ value: e.target.value });
    }

    render() {
        return (
            <div>
                <PageHeader>
                    AnalyzeIT
                </PageHeader>
                <form>
                    <FormGroup
                        controlId="formBasicText"
                        validationState={this.getValidationState()}>
                        <ControlLabel>Enter the username of a twitter user</ControlLabel>
                        <FormControl
                            type="text"
                            value={this.state.value}
                            placeholder="Enter username"
                            onChange={this.handleChange.bind(this)} />
                        <FormControl.Feedback />
                    </FormGroup>
                    <FormGroup>
                        <Checkbox inline>
                            Most used tags
                        </Checkbox>
                        <Checkbox inline>
                            Most mentioned users
                        </Checkbox>
                        <Checkbox inline>
                            Time of activity
                        </Checkbox>
                    </FormGroup>
                    <Button bsStyle="primary">
                        AnalyzeIT
                    </Button>
                </form>
            </div>
        );
    }
}

