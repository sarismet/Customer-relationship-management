import newId from '../util/idGenerator';
import axios from 'axios';
import { hashHistory } from 'react-router';
import decode from 'jwt-decode';

import currentUser from './dummyUser.json';
//Heroku server -->"https://agile-mesa-13349.herokuapp.com/"
const fetcher = axios.create({
  baseURL:"https://cix-container-app.azurewebsites.net/",
  headers: {
    'Content-Type': 'application/json',
    'Authorization': localStorage.session
  }
});

//Not Working yet
export const createUser = (params) => {

  return fetcher.post("/users", params).then(res => res.data);
  
};

//Not Working yet
export const login = (email, password) => {
  return fetcher.post("/login", {
    email,
    password
  }).then(res => {
    localStorage.session = res.data.auth;
    fetcher.defaults.headers.common['Authorization'] = res.data.auth;
    return decode(res.data.auth);
  });
};

//Not Working yet
export const logout = () => {
  delete localStorage.session;
  return Promise.resolve();
};

//it works but not completely done.
export const fetchCurrentUser = () => {
  
  return Promise.resolve(currentUser);
};

//done
export const fetchUserSurveys = (user) => {

  return fetcher.get(`/survey`).then(res =>res.data);
  
};

//done
export const fetchResults = (surveyId) => {
  
  
  return fetcher.get(`/keep/result?survey_id=${surveyId}`).then(res => {
    
    return res.data
  });

};

//done
export const createSurvey = (userId, initSurvey) => {
  return fetcher.post(`/survey/newSurvey`, initSurvey).then(res =>{
    return res.data});

};

// done
export const saveResult = (uniqueId, result) => {
 
  
  return fetcher.put(`keep/save/?id=${uniqueId}`, result);

};

//done
export const fetchSurvey = (surveyId) => {

  return fetcher.get(`/survey/id=${surveyId}`).then(res => res.data);

};

//done
export const deleteSurvey = survey => {
  
  fetcher.delete(`survey/delete_survey/id=${survey.id}`,survey.id).then(res => res.data);

  return Promise.resolve();
};

//done
export const updateSurvey = (survey) => {
  
  return fetcher.put(`/survey/update_survey/id=${survey.id}`, survey,survey.id).then(res => res.data);
};


//Not Working Yet
export const deleteResults = (surveyId, results) => {

  return Promise.all(results.map(result => fetcher.delete(`/surveys/${surveyId}/results/${result.id}`)));

};

export const checkAuth = (surveyId,uniqueId) => {
  return fetcher.get(`/keep/get?survey_id=${surveyId}&unique_id=${uniqueId}`).then(res => res.data);
};

