import React from 'react';
import ReactDOM from 'react-dom';
import './css/index.css';
import '@fortawesome/fontawesome-free/css/all.min.css'; 
import 'bootstrap-css-only/css/bootstrap.min.css'; 
import 'mdbreact/dist/css/mdb.css';
import App from './js/App';
import { BrowserRouter as Router } from 'react-router-dom';
import * as serviceWorker from './js/serviceWorker';

ReactDOM.render(
    <Router>
        <App />
    </Router>,
    document.getElementById('root'));

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();