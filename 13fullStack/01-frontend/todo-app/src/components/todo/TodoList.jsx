export default function TodoList() {
  const today = new Date();
  const targetDate = new Date(
    today.getFullYear() + 12,
    today.getMonth(),
    today.getDay()
  );

  const todos = [
    {
      id: 1,
      description: "Learn AWS",
      isDone: false,
      targetDate: targetDate,
    },
    {
      id: 2,
      description: "Learn Spring Boot",
      isDone: false,
      targetDate: targetDate,
    },
    {
      id: 3,
      description: "Learn Spring Security",
      isDone: false,
      targetDate: targetDate,
    },
  ];

  return (
    <div className="TodoList container">
        <h1>Manage your todos.</h1>
        <table className="table">
            <thead>
            <tr>
                <td>Id</td>
                <td>Description</td>
                <td>Is Done?</td>
                <td>Target Date</td>
            </tr>
            </thead>
            <tbody>
            {todos.map((todo) => (
                <tr key={todo.id}>
                <td>{todo.id}</td>
                <td>{todo.description}</td>
                <td>{todo.isDone.toString()}</td>
                <td>{todo.targetDate.toDateString()}</td>
                </tr>
            ))}
            </tbody>
        </table>
    </div>
  );
}
