import React, { useEffect, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom';
import Access from '../service/Access';

function Update() {

    const [empId, setempId] = useState();
    const [empName, setempName] = useState();
    const [empSal, setempSal] = useState();
    // const [user, setuser] = useState([]);

    let navigate = useNavigate();
    let params = useParams();

    
    useEffect(() => {
        Access.getByempId(params.empId).then((res) => {
            console.log(res.data);
            setempId(res.data.empId);
            setempName(res.data.empName);
            setempSal(res.data.empSal);
        });
    }, []);

    let updateUser = {
        empId: empId,
        empName: empName,
        empSal: empSal,
    };
    const updateEmployee = (e) => {
        e.preventDefault();
        Access.UpdateUser(updateUser).then((res) => {
            console.log("update" + res.data);

        });
    };
    

    return (
        <div className="container">
            <div
                className="card text-bg-light mt-4"
                style={{ maxWidth: "35rem" }}
                id="logincard"
            >
                <div className="card-header text-center">Update Product</div>
                <div className="card-body">
                    <div className="mb-3">
                        <label
                            htmlFor="formGroupExampleInput"
                            className="form-label float-start"
                        >
                            Enter your empId:
                        </label>
                        <input
                            type="text"
                            className="form-control"
                            id="formGroupExampleInput"
                            value={empId}
                            onChange={(e) => setempId(e.target.value)}
                            placeholder="Enter your empId"
                        />
                    </div>
                    <div className="mb-3">
                        <label
                            htmlFor="formGroupExampleInput2"
                            className="form-label float-start"
                        >
                            Enter Your empName:
                        </label>
                        <input
                            type="empName"
                            className="form-control"
                            id="formGroupExampleInput2"
                            placeholder="Enter your empName"
                            value={empName}
                            onChange={e => setempName(e.target.value)}
                        />
                    </div>
                    <div className="mb-3">
                        <label
                            htmlFor="formGroupExampleInput2"
                            className="form-label float-start"
                        >
                            Enter Your empSal:
                        </label>
                        <input
                            type="empSal"
                            className="form-control"
                            id="formGroupExampleInput2"
                            placeholder="Enter your empSal"
                            value={empSal}
                            onChange={e => setempSal(e.target.value)}
                        />
                    </div>
                    <div className="col-12 d-flex justify-content-between">
                        <button
                            type="submit"
                            className="btn btn-primary"
                            onClick={updateEmployee}
                        >
                            Update
                        </button>
                        {/* <button className="btn btn-primary" onClick={forgot}>
              Forgot Password
            </button> */}
                    </div>
                </div>
                <div className="card-footer text-muted text-center">
                    Design & Developed By Eshwar Merugu
                </div>
            </div>
        </div>
    );
}
export default Update
