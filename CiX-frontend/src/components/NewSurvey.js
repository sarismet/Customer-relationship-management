import React, { Component } from 'react';
import './NewSurvey.css';

class NewSurvey extends Component {
  render() {
    return <button
        className="button"
        onClick={this.props.onClick}
        disabled={this.props.isLoading}>{this.props.isLoading ? 'Yükleniyor...' : 'Yeni Anket'}</button>
  }
}

NewSurvey.propTypes = {
  onClick: React.PropTypes.func.isRequired,
  isLoading: React.PropTypes.bool.isRequired
};

export default NewSurvey;

