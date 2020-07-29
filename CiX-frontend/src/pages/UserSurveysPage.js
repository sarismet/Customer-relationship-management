import React from 'react';
import NewSurvey from '../containers/NewSurvey';
import SurveyList from '../containers/SurveyList';
import './UserSurveysPage.css';
import YouTube from 'react-youtube';
import logo from './home-page-logo.png';

class UserSurveysPage extends React.Component {
    render() {

       
    return (
        <div className="container UserSurveysPage">
            <div className="logo">
                <img src={logo} width="100px" height="200px"/>
            </div>
            <h2 className="welcomer">              
                Hoşgeldiniz
            </h2>
            
            <h3 className="info">
                Bu sayfada daha önce oluşturduğunuz anketleri inceleyip düzenleyebilir veya yeni anket oluşturabilirsiniz.


            </h3>
                <NewSurvey />
                <SurveyList />
            </div>
        );
    }
}

export default UserSurveysPage;
