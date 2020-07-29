import React from 'react';
import { connect } from 'react-redux';
import EditTabView from '../components/EditPanel/EditTab';

import { switchTab } from '../actions/edit_survey';
import tabTypes from '../constants/TabTypes';
import QuestionListPanel from './QuestionListPanel';
import EditQuestionPanel from './EditQuestionPanel';
import EditSurveyPanel from './EditSurveyPanel';

export default connect((state) => {
  return {
    activeTab: state.edit_survey.tab,
    tabs: [
      {
        type: tabTypes.QUESTIONS_TAB,
        text: 'Soru Ekle',
        panel: <QuestionListPanel/>
      },
      {
        type: tabTypes.EDIT_QUESTION_TAB,
        text: 'Soruyu Düzenle',
        panel: <EditQuestionPanel/>
      },
      {
        type: tabTypes.EDIT_SURVEY_TAB,
        text: 'Anketi Düzenle',
        panel: <EditSurveyPanel/>
      }
    ]
  };
}, (dispatch) => {
  return {
    onUpdateTab: (tab) => dispatch(switchTab(tab))
  };
})(EditTabView);
