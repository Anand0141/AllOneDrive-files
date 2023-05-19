import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom';
import Access from '../service/Access';

function List() {
    const [Employee, setEmployee] = useState([]);

    const navigate = useNavigate();

    const getAllEmployee = async () => {
        const arrdata = await Access.getAllEmployee();
        setEmployee(arrdata.data);
    };

    useEffect(() => {
        getAllEmployee();
    }, []);

    const editemployee = (empId) => {
        // Access.getByempId(empId);
        navigate(`/update/${empId}`);
    };

    const deleteemployee = async (empId) => {
        alert("delete" + `${empId}`);
        await Access.deleteuser(empId);
        getAllEmployee(); //to c remaining records..
    };

    return (
        <div className="container text-center" >
            <h1>ProductList</h1>
            <table className="table table-bordered">
                <thead className="table-dark">
                    <tr>
                        <th scope="col">empId</th>
                        <th scope="col">empName</th>
                        <th scope="col">empSal</th>
                        <th colSpan={"2"}>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {Employee.map((emp) => {
                        return (
                            <tr key={emp.empId}>
                                <td scope="col">{emp.empId}</td>
                                <td scope="col">{emp.empName}</td>
                                <td scope="col">{emp.empSal}</td>
                                <td>
                                    <button className="btn btn-primary "
                                        onClick={() => editemployee(emp.empId)}>
                                        Edit
                                    </button>

                                    <button className="btn btn-danger  ms-4"
                                        onClick={() => deleteemployee(emp.empId)}>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        );
                    })}
                </tbody>
            </table >
        </div>

    )
}

export default List
