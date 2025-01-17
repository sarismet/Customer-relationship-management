import React, { PropTypes } from 'react';
import PanelButton from './PanelButton';
import './EditFooter.css';

class EditFooter extends React.Component {
  save() {
    this.props.onSave(this.props.survey);
  }

  delete() {
    this.props.onDelete(this.props.survey);
  }

  render() {
    return (
      <div className="EditFooter">
        <PanelButton className="saveButton"
            onClick={this.save.bind(this)}>
          {this.props.isUpdateSuccess ? <span> </span>  : ''}
          { ' ' } Anketi Kaydet
        </PanelButton>
      </div>
    );
  }
}

EditFooter.propTypes = {
  survey: PropTypes.object.isRequired,
  onSave: PropTypes.func.isRequired,
  onDelete: PropTypes.func.isRequired
};

export default EditFooter;
