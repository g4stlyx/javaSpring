import { useParams, Link } from "react-router-dom";
import { useAuth } from "./security/AuthContext";
import { useState } from "react";

export default function Welcome(){
    const {username} = useParams();
    const authContext = useAuth();
    const [message, setMessage] = useState(null)
    
    return(
        <div className="Welcome">
            <h1>Login successful, welcome back {username}.</h1>
            <h3>Manage your <Link to="/todos">todos.</Link> </h3>
        </div>
    )
}