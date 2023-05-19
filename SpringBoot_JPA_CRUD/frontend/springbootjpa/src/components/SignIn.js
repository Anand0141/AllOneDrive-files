import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import Access from '../service/Access';

function SignIn() {

  const [email, setemail] = useState();
  const [password, setpassword] = useState();
  const [showPassword, setShowPassword] = useState();

  let navigate = useNavigate();

  const [user, setuser] = useState([]);

  const getuserdetails = async (e) => {
    const userdata = await Access.getuser();
    setuser(userdata.data);
    console.log("User list is:" + JSON.stringify(user));
  }

  useEffect(() => {
    getuserdetails();
  }, []);


  function login() {
    // user.map(std => {
    //   if (std.email == email && std.password == password) {
    //     navigate("/list")
    //   } else {
    //     alert("Password correct kootu ra bokuda")
    //   }
    // })
    user.filter((std) => {
      console.log("map data:" + JSON.stringify(std));
      if (std.email == email && std.password == password) {
        navigate("/list")
        alert("login success..");
      } else {
        alert("Password correct kootu ra bokuda")
      }
    })
  }

  function forgot() {
    navigate("/forgot");
    alert("fgsadfa")
  }



  return (
    <div>
      <div className='container'>
        <div className="card text-bg-light mt-3" style={{ maxWidth: "30rem", marginLeft: "200px" }} id="registercard">
          <div className="card-header text-center">Register</div>
          <div className="card-body">
            <div className="mb-3">
              <label htmlFor="formGroupexampleInput" className="form-label float-start">Enter Your email:</label>
              <input type="text" className="form-control" id="formGroupexampleInput" value={email}
                onChange={(e) => setemail(e.target.value)} placeholder="Enter your email" />
            </div>

            <div className="mb-3">
              <label htmlFor="formGroupExampleInput2" className="form-label">Enter Your password:</label>
              <input type="password"
                className="form-control"
                id="formGroupExampleInput2"
                placeholder="Enter your password"
                value={password}
                onChange={(e) => setpassword(e.target.value)} />

              <div className="col-12 d-flex justify-content-between mt-3">
                <button type="submit" className="btn btn-primary" onClick={login}>Sign in</button>


                <button className='btn btn-primary' onClick={forgot}>Forgot Password</button>
              </div>
            </div>
          </div>
        </div>
      </div >
    </div>
  )
}

export default SignIn
