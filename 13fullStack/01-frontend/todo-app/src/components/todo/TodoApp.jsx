import Login from "./Login";
import Welcome from "./Welcome";
import Error from "./Error";
import TodoList from "./TodoList";
import Footer from "./Footer";
import Header from "./Header";
import Logout from "./Logout";
import Todo from "./Todo";
import "../../styles/todoApp.css";
import { Routes, Route, Navigate } from "react-router-dom";
import { useAuth } from "./security/AuthContext";

function AuthenticatedRoute({ children }) {
  const authContext = useAuth();

  if (authContext.isAuthenticated) return children;
  return <Navigate to="/" />
}

export default function TodoApp() {
  return (
    <div className="TodoApp">
      <Header />
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/login" element={<Login />} />
        <Route
          path="/welcome/:username"
          element={
            <AuthenticatedRoute>
              <Welcome />
            </AuthenticatedRoute>
          }
        />
        <Route
          path="/todos"
          element={
            <AuthenticatedRoute>
              <TodoList />
            </AuthenticatedRoute>
          }
        />
        <Route
          path="/todos/:id"
          element={
            <AuthenticatedRoute>
              <Todo />
            </AuthenticatedRoute>
          }
        />
        <Route
          path="/logout"
          element={
            <AuthenticatedRoute>
              <Logout />
            </AuthenticatedRoute>
          }
        />
        <Route path="*" element={<Error />} />
      </Routes>
      <Footer />
    </div>
  );
}
