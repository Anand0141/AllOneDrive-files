
import React, { useState } from 'react'
import Access from '../service/Access';

function SignUp() {
    const [firstName, setfirstName] = useState();
    const [lastName, setlastName] = useState();
    const [email, setemail] = useState();
    const [password, setpassword] = useState();
    const [conformPassword, setconformPassword] = useState();

    let newUser = {
        firstName: firstName,
        lastName: lastName,
        email: email,
        password: password,
        conformPassword: conformPassword
    }

    const register = () => {
        alert("Data Insert Sucessfully");
        Access.createEmployee(newUser).then((res) => {
            console.log("user list is:" + JSON.stringify(res.data));
        });
    }

    return (
        <div>
            <div className='container'>
                <div className="card text-bg-light mt-3" style={{ maxWidth: "40rem", marginLeft: "300px" }} id="registercard">
                    <div className="card-header text-center">Register</div>
                    <div className="card-body">
                        <div className="mb-3">
                            <label htmlFor="formGroupexampleInput" className="form-label float-start">Enter Your firstName:</label>
                            <input type="text" className="form-control" id="formGroupexampleInput" value={firstName}
                                onChange={(e) => setfirstName(e.target.value)} placeholder="Enter your firstName" />
                        </div>
                        <div className="mb-3 mt-1">
                            <label htmlFor="formGroupexampleInput2" className="form-label float-start">Enter Your lastName:</label>
                            <input type="text" className="form-control" id="formGroupexampleInput2" value={lastName}
                                onChange={(e) => setlastName(e.target.value)} placeholder="Enter your lastName"
                            />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="formGroupexampleInput" className="form-label float-start">Enter Your email:</label>
                            <input type="email" className="form-control" id="formGroupexampleInput" value={email}
                                onChange={(e) => setemail(e.target.value)} placeholder="Enter Your email " />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="formGroupexampleInput" className="form-label float-start">Enter Your password:</label>
                            <input type="password" className="form-control" id="formGroupexampleInput" value={password}
                                onChange={(e) => setpassword(e.target.value)} placeholder="Enter your password" />
                        </div>
                        <div className="mb-3">
                            <label htmlFor="formGroupexampleInput" className="form-label float-start">Enter Your conformPassword :</label>
                            <input type="password" className="form-control" id="formGroupexampleInput" value={conformPassword}
                                onChange={(e) => setconformPassword(e.target.value)} placeholder="Enter your conformPassword" />
                        </div>
                        <div className="col-12">
                            <button type="submit" className="btn btn-primary" onClick={register}>Register</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SignUp
