const { createContext, useState, useContext } = require("react");

const AuthContext = createContext()
export const useAuth = () => useContext(AuthContext)


export default function AuthProvider({children}){

    const [isAuthenticated, setIsAuthenticated] = useState(false)

    function login(username, password){
        if(username==="g4stly" && password==="pwd"){
            setIsAuthenticated(true)
            return true;
        }
        else{
            setIsAuthenticated(false)
            return false;
        }
    }

    function logout(){
        setIsAuthenticated(false)
    }

    const valueToBeShared = {isAuthenticated, setIsAuthenticated, login, logout}
    return(
        <AuthContext.Provider value={valueToBeShared}>
            {children}
        </AuthContext.Provider>
    )
}