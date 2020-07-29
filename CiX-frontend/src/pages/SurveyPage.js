import React from 'react';
import { connect } from 'react-redux';
import { bindActionCreators } from 'redux';
import { Alert } from 'react-bootstrap';
import Survey from '../components/Survey/Survey';
import { getSurvey, getFetchError, getFetchStatus, getSubmitStatus } from '../reducers/survey';
import { submitResult, fetchSurvey } from '../actions/survey';
import './SurveyPage.css';
import { checkAuth } from '../api/index';
import ErrorPage from './ErrorPage';

class SurveyPage extends React.Component {
  constructor() {
    super();
    this.state = { data : [] };
  }
  loadData() {
    this.props.fetchSurvey(this.props.surveyId);
  }

  checkSurvey() {
    checkAuth(this.props.params.surveyId,this.props.params.uniqueId).then((res) => {
      this.setState({ data: res });
    }).catch(()=>{
      this.setState({ data: null });
    });
}

  componentDidMount() {
    this.loadData();
    this.checkSurvey();
  }

  componentDidUpdate(prevProps) {
    if (this.props.surveyId !== prevProps.surveyId) {
      this.loadData();
    }
  }

  render() {
    if(this.state.data !== null){
      return (
        <div className="container">
          <div className="row SurveyPage">
            <div className="col-md-8 col-md-offset-2 survey">
              <Survey {...this.props} />
            </div>
          </div>
        </div>
      );
    }else {
      return (
        <div>
          <ErrorPage/>
        </div>
      )
    }
    
  }
}

const mapStateToProps = (state, { params }) => {

  return {
    survey: getSurvey(state.survey),
    isLoading: getFetchStatus(state.survey),
    error: getFetchError(state.survey),
    uniqueId: params.uniqueId,
    surveyId: params.surveyId,
    isSuccess: getSubmitStatus(state.survey)
  };
};

const mapDispatchToProps = (dispatch) => {
  return {
    onSubmit: bindActionCreators(submitResult, dispatch),
    fetchSurvey: bindActionCreators(fetchSurvey, dispatch)
  };
};

export default connect(mapStateToProps, mapDispatchToProps)(SurveyPage);
