import React, { Component } from 'react';
import { connect } from 'react-redux';
import './ErrorPage.css';
import errorPhoto from './pngwing.com.png';


class ErrorPage extends React.Component {
    render() {
        return (
            <div className="container2">
                <img className="errorPhoto" src={errorPhoto} />
                <h1 className="errorMsg1">
                    Opss... 
                </h1>

                <h4 className="errorMsg2">
                    Bu sayfaya erişiminiz bulunmamaktadır. Lütfen link sağlayıcısıyla iletişime geçiniz.
                </h4>
            </div>
        )
    }
}



export default connect()(ErrorPage);
