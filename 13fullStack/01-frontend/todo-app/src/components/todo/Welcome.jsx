import { useParams } from "react-router-dom";
import { Link } from "react-router-dom";

export default function Welcome(){
    const {username} = useParams();
    
    return(
        <div className="Welcome">
            <h1>Login successful, welcome back {username}.</h1>
            <h3>Manage your <Link to="/todos">todos.</Link> </h3>
        </div>
    )
}