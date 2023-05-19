import './App.css';
import { BrowserRouter, Link, Route, Routes } from 'react-router-dom';
import SignUp from './components/SignUp';
import SignIn from './components/SignIn';
import Home from './components/Home';
import List from './components/List';
import Update from './components/Update';

function App() {
  return (
    <div className='App'>
      <BrowserRouter>
        <nav className="navbar navbar-expand-lg bg-body-tertiary">
          <div className="container-fluid ">
            <a className="navbar-brand" href="#"><Link to="/home" className='text-decoration-none'>Home</Link></a>
            <button className="navbar-toggler " type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <form className="d-flex" role="search">
              <button className="btn btn-outline-success me-2" type="submit"><Link to="/register" className='text-decoration-none'>SignUp</Link></button>
              <button className="btn btn-outline-primary" type="submit"><Link to="/login" className='text-decoration-none'>SignIn</Link></button>
            </form>
          </div>
        </nav >

        <Routes>
          <Route path="/register" element={<SignUp />}></Route>
          <Route path="/login" element={<SignIn />}></Route>
          <Route path="/home" element={<Home />}></Route>
          <Route path="/list" element={<List />}></Route>
          <Route path="/update" element={<Update />}></Route>
          
        </Routes>
      </BrowserRouter>
    </div >
  );
}

export default App;
