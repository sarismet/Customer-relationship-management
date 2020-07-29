import React from 'react';
import { Link } from 'react-router';
import { Path } from '../../routes';
import './SurveyItem.css';

class SurveyItem extends React.Component {
  render() {
    let { survey, survey: { title } } = this.props;
    return (
      <div className="SurveyItem">
<Link to={Path.survey(survey)} style={{color: '#FF9A00'}}>  <div className="SurveyItem2"> <p>{ title }</p></div></Link>
      </div>


    );
  }
}

SurveyItem.propTypes = {};
SurveyItem.defaultProps = {};

export default SurveyItem;
