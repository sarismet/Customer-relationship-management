import * as React from 'react';
import QuestionWrapper from './QuestionWrapper';
import { withFormik } from 'formik';
import './Survey.css';
import ErrorPage from '../../pages/ErrorPage';

type Props = {
  survey: object,
  isLoading: bool,
  error: object,
  onSubmit: func,
  isSuccess: bool
};

class Survey extends React.Component<Props> {

  renderError() {
    return <div>Hata!</div>
  }

  renderLoading() {
    return <div>Yükleniyor...</div>
  }

  renderSuccess() {
    return (
    <div className="succes-page">
      <h1>Kayıt Başarılı!</h1>
      <br></br>
      <h3>Anketimize katıldığınız için teşekkür ederiz.</h3>
      
    </div>
    );
  }

  render() {
    let { survey, isLoading, error, handleSubmit, isSuccess } = this.props;

    if(survey === null){
      return <ErrorPage/>
    }

    let { title, subTitle, questions } = survey;


    if (isLoading) {
      return this.renderLoading();
    }

    if (error) {
      return this.renderError();
    }
    if (!survey) {
      return <div/>;
    }

    if (isSuccess) {
      return this.renderSuccess();
    }


    return (
        <div className="Survey">
          <form onSubmit= {(e) => {if(window.confirm("Cevaplarınız kaydedilecektir, devam etmek istiyor musunuz?")) { handleSubmit(e) }}}>
            <header>
              <h3>{title}</h3>
              <p>{subTitle}</p>
            </header>
            <ul className="list-unstyled">
              {questions.map(question => {
                return <li key={question._id}><QuestionWrapper question={question}/></li>
              })}
            </ul>
                <div className="form-group">
              <input type="submit" className="btn"/>
              </div>
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
})(Survey);
