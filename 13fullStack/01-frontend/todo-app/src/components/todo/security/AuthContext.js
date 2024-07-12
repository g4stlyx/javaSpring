import { executeJwtAuthenticationService } from "../api/AuthenticationApiService";
import { apiClient } from "../api/ApiClient";
const { createContext, useState, useContext } = require("react");

const AuthContext = createContext();
export const useAuth = () => useContext(AuthContext);

export default function AuthProvider({ children }) {

    const [isAuthenticated, setIsAuthenticated] = useState(false);

    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

    // async function login(username, password) {
    //     const baToken = "Basic " + window.btoa(username + ":" + password);

    //     try {
    //         const response = await executeBasicAuthenticationService(baToken)


    //         if (response.status === 200) {
    //             setIsAuthenticated(true);
    //             setUsername(username);
    //             setToken(baToken)

    //             // all of the urls are intercepted and request a auth token
    //             apiClient.interceptors.request.use(
    //                 config=> {
    //                     config.headers.Authorization= baToken
    //                     return config
    //                 }
    //             )

    //             return true;
    //         } else {
    //             logout()
    //             return false;
    //     }
    //     } catch (err) {
    //         logout()
    //         return false
    //     }
    // }

    async function login(username, password) {
        try {
            const response = await executeJwtAuthenticationService(username,password)

            if (response.status === 200) {
                const jwtToken = 'Bearar '+ response.date.token
                setIsAuthenticated(true);
                setUsername(username);
                setToken(jwtToken)

                // all of the urls are intercepted and request a auth token
                apiClient.interceptors.request.use(
                    config=> {
                        config.headers.Authorization= jwtToken
                        return config
                    }
                )

                return true;
            } else {
                logout()
                return false;
        }
        } catch (err) {
            logout()
            return false
        }
    }

    function logout() {
        setIsAuthenticated(false);
        setToken(null);
        setUsername(null);
    }

    const valueToBeShared = {
        isAuthenticated,
        setIsAuthenticated,
        login,
        logout,
        username,
        token,
    };
    return (
        <AuthContext.Provider value={valueToBeShared}>
        {children}
        </AuthContext.Provider>
    );
}
