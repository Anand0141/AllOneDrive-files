import React from 'react'

function Navbar() {
    return (
        <div>
            {/* <nav classNameName="navbar navbar-expand-lg bg-body-tertiary">
                <div className="container-fluid">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a className="navbar-brand" href="#">
                                <img src="logo.png" height={50} width={100} alt="logo"></img>
                            </a>
                        </li>
                    </ul>

                    <form className="d-flex" role="search">
                        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                        <button className="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </nav > */}
            <nav class="navbar navbar-expand-lg bg-body-tertiary">
                <div class="container ">
                    <a class="navbar-brand" href="#" >
                        <img src="logo.png" height={45} width={100} alt="logo"></img>
                    </a>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                            {/* <li class="nav-item">
                                <a class="nav-link active" aria-current="page" href="#">Home</a>
                            </li> */}
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </div >
    )
}

export default Navbar
