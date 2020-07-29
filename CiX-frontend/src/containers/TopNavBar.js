/* global location */
/* eslint no-restricted-globals: ["off", "location"] */

import React, { Component } from 'react';
import { connect } from 'react-redux';
import { withRouter } from 'react-router';
import { Navbar, Nav, NavItem, NavDropdown, MenuItem} from 'react-bootstrap';
import './TopNavBar.css';
import Logo from './CiX.png';
import icon from './cix-icon2.png';
class TopNavBar extends Component {
  loginView() {
    let { currentUser } = this.props;
    return (
        <Nav pullRight>
          <NavDropdown className="user" eventKey={3} title="Admin" id="basic-nav-dropdown">
            <MenuItem divider/>
            <MenuItem href="#/logout">Çıkış</MenuItem>
          </NavDropdown>
        </Nav>
    );
  }

  unLoginView() {
    return (
        <Nav pullRight>
          <NavItem eventKey={1} href="#/login">Login</NavItem>
          <NavItem eventKey={1} href="#/register">Register</NavItem>
        </Nav>

    );
  }
  render() {
    //eslint-disable-next-line
    let pathname = location.pathname;
    let { currentUser } = this.props;
    return (
        <Navbar className="TopNavBar">
          <Navbar.Header>
                <Navbar.Brand>
                    <a href={pathname}>
                    <div className="logo">
                        <img src={icon}/>    
                        </div>  
                    </a>
            </Navbar.Brand>
            <Navbar.Brand>
            <a href={pathname} className="homeButton">Ana Sayfa</a>
            </Navbar.Brand>
            <Navbar.Toggle  />
          </Navbar.Header>
          <Navbar.Collapse>
            {currentUser ? this.loginView() : this.unLoginView()}
          </Navbar.Collapse>
            
        </Navbar>
    )
  }
}

var mapStateToProps = (state) => {
  return {
    currentUser: state.session.user
  }
};


TopNavBar = withRouter(connect(mapStateToProps)(TopNavBar));

export default TopNavBar;
