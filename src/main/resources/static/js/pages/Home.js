import React from "react";
import { BarChart, PieChart } from "react-d3-components";
import { PageHeader, Row, Col, FormGroup, FormControl, ControlLabel, Checkbox, Button } from "react-bootstrap";
import $ from "jquery";

export default class Home extends React.Component {
    constructor() {
        super();
        this.state = {
            username: '',
            tags: false,
            mentioned: false,
            time: false,
            emotion: false,
            taxonomy: false,
            data: {}
        };
    }

    getValidationState() {
        const length = this.state.username.length;
        if (length > 5) return 'success';
        else if (length > 5) return 'warning';
        else if (length > 0) return 'error';
    }

    handleChange(field, e) {
        var nextState = {};
        nextState[field] = e.target.checked;
        this.setState(nextState);
    }

    usernameChange(e) {
        this.setState({username: e.target.value})
    }

    loadData() {
        $.ajax({
            url: '/api/v1/data/getData',
            method: 'GET',
            data:{
                username: this.state.username,
                mentionCount: this.state.mentioned,
                hashtagCount: this.state.tags,
                taxonomyAnalysis: this.state.taxonomy,
                emotionAnalysis: this.state.emotion,
                timeAnalysis: this.state.time
            },
            success: function(data) {
                console.log(data);
                this.setState({data: data});
            }.bind(this),
            error: function(err) {
                console.log(err);
            }
        });
    }

    render() {
        var barGraph;
        var timeChart;
        var hashChart;
        var emotionChart;
        var tooltip = function(x, y0, y) {
            return y.toString();
        };
        var tooltipPie = function(x, y) {
            return y.toString();
        };

        if (this.state.data.mentionmodel) {
            var mentionCount = this.state.data.mentionmodel.mentionCount;
            var mentionValues = [];

            for (var key in mentionCount) {
                mentionValues.push({x: key, y: mentionCount[key]});
            }

            function compare(a,b) {
                if (a.y > b.y)
                    return -1;
                if (a.y < b.y)
                    return 1;
                return 0;
            }

            mentionValues.sort(compare);
            mentionValues.splice(5, mentionValues.length - 5);

            barGraph = <BarChart
                data={[{
                    label: 'Mention Count',
                    values: mentionValues
                }]}
                width={800}
                height={400}
                margin={{top: 50, bottom: 50, left: 25, right: 10}}
                colorByLabel={false}
                tooltipHtml={tooltip}
            />;
        } else {
            barGraph = null;
        }

        if(this.state.data.timeModel) {
            var timeList = this.state.data.timeModel.timeList;
            var beforeSix = 0;
            var sixToSix = 0;
            var afterSix = 0;

            timeList.forEach(function(time) {
                var t = parseInt(time.split(' ')[3].split(':'[0]));
                if(t < 6) {
                    beforeSix++;
                }
                else if(t >= 6 && t <= 18) {
                    sixToSix++;
                }
                else {
                    afterSix++;
                }
            });

            timeChart = <BarChart
                data={[{
                    label: 'Time Chart',
                    values: [{x: 'Before 6 am', y: beforeSix}, {x: '6 am to 6 pm', y: sixToSix}, {x: 'After 6 pm', y: afterSix}]
                }]}
                width={800}
                height={400}
                margin={{top: 50, bottom: 50, left: 25, right: 10}}
                tooltipHtml={tooltip}
            />;
        } else {
            timeChart = null;
        }

        if(this.state.data.hashTagModel) {
            var hashTagCount = this.state.data.hashTagModel.hashtagCount;
            var hashTagValues = [];

            for (var key in hashTagCount) {
                hashTagValues.push({x: key, y: hashTagCount[key]});
            }

            function compare(a,b) {
                if (a.y > b.y)
                    return -1;
                if (a.y < b.y)
                    return 1;
                return 0;
            }

            hashTagValues.sort(compare);
            hashTagValues.splice(5, hashTagValues.length - 5);

            hashChart = <BarChart
                data={[{
                    label: 'Hashtag Count',
                    values: hashTagValues
                }]}
                width={800}
                height={400}
                margin={{top: 50, bottom: 50, left: 25, right: 10}}
                colorByLabel={false}
                tooltipHtml={tooltip}
            />;
        }
        else {
            hashChart = null;
        }

        if(this.state.data.emotionModel) {
            var emotionCount = this.state.data.emotionModel.emotionAnalysis.emotion;
            var emotionValues = [];

            for (var key in emotionCount) {
                emotionValues.push({x: key, y: emotionCount[key]});
            }

            var sort = null;

            emotionChart = <PieChart
                data={{
                    label: 'Emotions',
                    values: emotionValues
                }}
                width={600}
                height={400}
                margin={{top: 50, bottom: 50, left: 50, right: 10}}
                sort={sort}
                tooltipHtml={tooltipPie}
            />;
        }
        else {
            emotionChart = null;
        }

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
                            value={this.state.username}
                            placeholder="Enter username"
                            onChange={this.usernameChange.bind(this)} />
                        <FormControl.Feedback />
                    </FormGroup>
                    <Checkbox checked={this.state.tags} onChange={this.handleChange.bind(this, 'tags')}>
                        Most used tags
                    </Checkbox>
                    <Checkbox checked={this.state.mentioned} onChange={this.handleChange.bind(this, 'mentioned')}>
                        Most mentioned users
                    </Checkbox>
                    <Checkbox checked={this.state.time} onChange={this.handleChange.bind(this, 'time')}>
                        Time of activity
                    </Checkbox>
                    <Checkbox checked={this.state.emotion} onChange={this.handleChange.bind(this, 'emotion')}>
                        Emotion Analysis
                    </Checkbox>
                    <Checkbox checked={this.state.taxonomy} onChange={this.handleChange.bind(this, 'taxonomy')}>
                        Taxonomy Analysis
                    </Checkbox>
                    <Button bsStyle="primary" onClick={this.loadData.bind(this)}>
                        AnalyzeIT
                    </Button>
                </form>

                {barGraph}
                {timeChart}
                {hashChart}
                {emotionChart}
            </div>
        );
    }
}

