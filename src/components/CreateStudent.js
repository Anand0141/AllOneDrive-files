import React, { useState } from "react";
import StudentService from "../services/StudentService";
import {useNavigate} from "react-router-dom";
function CreateStudent() {
  const [student, setStudent] = useState();
  const [id, setId] = useState();
  const [name, setName] = useState();
  const [course, setCourse] = useState(); 
  let navigate = useNavigate();
  const createStudent = (e) => {
    e.preventDefault();
    let obj = {
      id: parseInt(id),
      name: name,
      course: course,
    };
    StudentService.createStudent(obj).then((res) => {
      console.log(res.data);
    });
    navigate("/list");
  };
  return (
    <div className="container">
      <h1>Create Student</h1>
      <hr />
      <form>
        <div className="mb-3">
          <label htmlFor="exampleInputId" className="form-label">
            Student Id
          </label>
          <input
            type="text"
            className="form-control"
            id="exampleInputId"
            value={id}
            onChange={(e) => setId(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputName" className="form-label">
            Student Name
          </label>
          <input
            type="text"
            className="form-control"
            id="exampleInputName"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label htmlFor="exampleInputName" className="form-label">
            Student Course
          </label>
          <select
            className="form-select"
            aria-label="Default select example"
            name="course"
            id="exampleCourse"
            onChange={(e) => setCourse(e.target.value)}
          >
            <option selected>Open this select menu</option>
            <option defaultValue="Reactjs">Reactjs</option>
            <option defaultValue="Java">Java</option>
            <option defaultValue="Testing">Testing</option>
          </select>
        </div>
        <button
          type="submit"
          className="btn btn-primary"
          onClick={createStudent}
        >
          Create
        </button>
      </form>
    </div>
  );
}

export default CreateStudent;
