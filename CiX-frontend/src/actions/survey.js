import * as Survey  from '../reducers/survey'
import * as api from '../api';

export const fetchSurvey = surveyId => dispatch => {
  dispatch({
    type: Survey.FETCH_SURVEY_REQUEST,
    surveyId
  });

  api.fetchSurvey(surveyId).then(res => {
    dispatch({
      type: Survey.FETCH_SURVEY_REQUEST_SUCCESS,
      payload: res
    });
  }).catch(err => {
    dispatch({
      type: Survey.FETCH_SURVEY_REQUEST_FAIL,
      payload: err
    });
  });
};

export const submitResult = (uniqueId, result) => dispatch => {
  dispatch({
    type: Survey.SUBMIT_SURVEY,
    uniqueId,
    payload: result
  });

  return api.saveResult(uniqueId, result).then(() => {
    dispatch({
      type: Survey.SUBMIT_SURVEY_SUCCESS
    });
  }).catch((err) => {
    dispatch({
      type: Survey.SUBMIT_SURVEY_FAIL,
      payload: err
    });
  });
};
