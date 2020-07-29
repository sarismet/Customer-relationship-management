import React, { Component } from 'react';
import QuestionWrapper from '../Survey/QuestionWrapper';
import { withFormik } from 'formik';


class SurveyOverview extends Component {
  render() {

    let { title, subTitle, questions } = this.props;
    console.log(this.props);

    return (
      <div className="Survey">
        <form>
          <header>
            <h3>{title}</h3>
            <p>{subTitle}</p>
          </header>
          <ul className="list-unstyled">
            {questions.map((question) => {
              return (
                <li key={question._id}>
                  <QuestionWrapper question={question} />
                </li>
              );
            })}
          </ul>
        </form>
      </div>
    );
  }
}
export default withFormik({
  mapPropsToValues: () => {},
  handleSubmit: ( values, { props }) => {
    props.onSubmit(props.params.uniqueId, values)
  }
})(SurveyOverview);

