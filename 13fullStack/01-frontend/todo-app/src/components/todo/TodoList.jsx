import { useState, useEffect } from "react";
import { retrieveAllTodosByUsernameApi, deleteTodoApi } from "./api/TodoApiService";
import { useAuth } from "./security/AuthContext";
import axios from "axios";
import { useNavigate } from "react-router-dom";

export default function TodoList() {

  useEffect(() =>{
    refreshTodos();
  }, [])
  
  const [todos, setTodos] = useState([]);
  
  const authContext = useAuth();
  const username = authContext.username;
  const navigate = useNavigate();

  function refreshTodos() {
    const username = 'g4stly';
    const password = 'pwd';
    const headers = {
      'Authorization': 'Basic ' + btoa(`${username}:${password}`)
    };

    axios.get('/users/{username}/todos', { headers })
      .then((response) => {
        console.log("API Response:", response);
        if (Array.isArray(response.data)) {
          setTodos(response.data);
        } else {
          console.error("Expected an array but got:", response.data);
        }
      })
      .catch((err) => console.log(err));
  }

  // const today = new Date();
  // const targetDate = new Date(
  //   today.getFullYear() + 12,
  //   today.getMonth(),
  //   today.getDay()
  // );
  // const todos = [
  //   {id: 1, description: "Learn AWS",isDone: false,targetDate: targetDate,},
  //   {id: 2,description: "Learn Spring Boot",isDone: false, targetDate: targetDate,},
  //   {id: 3,description: "Learn Spring Security",isDone: false,targetDate: targetDate,},
  // ];

  function deleteTodo(id){
    deleteTodoApi(username,id)
        .then(() => {
          // setMessage(`Todo with id {id} is deleted successfully!`)
          refreshTodos();
        })
        .catch((err) => console.log(err));
  }

  function updateTodo(id){
      // updateTodoApi(username,id)
      //     .then(() => {
      //       setMessage(`Todo with id ${id} is updated successfully!`)
      //       refreshTodos();
      //     })
      //     .catch((err) => console.log(err))
      navigate(`/todos/${id}`)
  }

  function addNewTodo(){
      navigate(`/todos/-1`)
  }


  return (
    <div className="TodoList container">
      <div>
      <h1>Manage your todos.</h1>
      {/* {message && <div className="alert alert-warning">{message}</div>} */}
      <table className="table">
        <thead>
          <tr>
            {/* <th>Id</th> */}
            <th>Description</th>
            <th>Is Done?</th>
            <th>Target Date</th>
            <th>Delete</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody>
          {todos.map((todo) => (
            <tr key={todo.id}>
              {/* <td>{todo.id}</td> */}
              <td>{todo.description}</td>
              <td>{todo.isDone.toString()}</td>
              <td>{todo.targetDate.toString()}</td>
              <td>
                <button className="btn btn-error" onClick={()=> deleteTodo(todo.id)}>DELETE</button>
              </td>
              <td>
                <button className="btn btn-warning" onClick={()=> updateTodo(todo.id)}>UPDATE</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      </div>
      <div className="btn btn-success m-5" onClick={addNewTodo}>
          Add New Todo
      </div>
    </div>
  );
}
