/* global location */
/* eslint no-restricted-globals: ["off", "location"] */

import React from 'react';
import Toggle from 'react-toggle';
import { Button } from 'react-bootstrap';
import { fetchData } from '../actions/data';
import { fetchSurvey, updateSurvey, deleteSurvey, resetDeleteState } from '../actions/edit_survey';
import { getSurvey, assembleSurvey } from '../reducers/edit_survey';
import { Path } from '../routes';
import { connect } from 'react-redux';
import SurveyOverview from '../components/SurveyOverview/SurveyOverview'
import './OverviewPage.css';

class OverviewSurveyPage extends React.Component {
  loadData() {
    this.props.fetchData(this.props.surveyId);
    this.props.fetchSurvey(this.props.surveyId);
  }

  componentDidMount() {
    this.loadData();
  }

  componentDidUpdate(prevProps, prevState) {
    if (this.props.surveyId !== prevProps.surveyId) {
      this.loadData();
    }
  }

  componentWillUnmount() {
    this.props.resetDeleteState();
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.isDeleteSuccess) {
      this.props.push(Path.surveyList());
    }
  }

  surveyUrl(survey) {
    return location.origin + location.pathname + '#' + Path.viewSurvey(survey);
  }

  render() {
    let { survey, updateSurvey, results, deleteSurvey } = this.props;
    return (
      <div className="container OverviewPage">
        
        <div className="row">
          <footer className="col-md-12">
            <Button
              className="btn btn-sm btn-danger"
              onClick={() => {
                {
                  if (
                    window.confirm(
                      "Anket silinecektir, devam etmek istiyor musunuz?"
                    )
                  ) {
                    deleteSurvey(survey);
                  }
                }
              }}
            >
              Anketi Sil
            </Button>
          </footer>
        </div>
        <div className="row">
          <div className="container">
            <div className="row SurveyPage">
              <div className="col-md-8 col-md-offset-2 survey">
                <SurveyOverview {...survey} />
              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state, { params, router }) => {
  return {
    surveyId: params.surveyId,
    survey: assembleSurvey(getSurvey(state.edit_survey)),
    results: state.data.results,
    isDeleteSuccess: state.edit_survey.deleteSurvey.isSuccess,
    push: router.push
  };
};

const mapDispatchToProps = {
  fetchData,
  fetchSurvey,
  updateSurvey,
  deleteSurvey,
  resetDeleteState
};

export default connect(mapStateToProps, mapDispatchToProps)(OverviewSurveyPage);
