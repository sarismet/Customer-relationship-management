import React from 'react';
import { withRouter, Link } from 'react-router';
import './SurveyNavBar.css';

class SurveyNavBar extends React.Component {
  render() {
    let { params, location } = this.props;

    return (
        <div className="SurveyNavBar">
          <div className="container">
            <ul className="nav nav-pills">
              <NavLink url={`/user/surveys/${params.surveyId}/`} location={location} text="Anket Özeti"/>
              <NavLink url={`/user/surveys/${params.surveyId}/edit`} location={location} text="Sorular"/>
              <NavLink url={`/user/surveys/${params.surveyId}/data`} location={location} text="Veriler"/>
              <NavLink url={`/user/surveys/${params.surveyId}/report`} location={location} text="Rapor"/>
            </ul>
          </div>
        </div>
    );
  }
}

const NavLink = (props) => {
  let { url, location, text } = props;
  return <li role="presentation" className={location.pathname === url ? 'active' : ''}>
    <Link to={url}>{text}</Link>
  </li>
};

SurveyNavBar.propTypes = {};
SurveyNavBar.defaultProps = {};

export default withRouter(SurveyNavBar);

