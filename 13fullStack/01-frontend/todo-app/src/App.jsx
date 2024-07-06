import './styles/App.css';
import ClassComponent from './components/intro/ClassComponent'
import FunctionComponent from './components/intro/FunctionComponent'
import LearningJavaScript from './components/intro/ABitJs'

function App() {
  return (
    <div className="App">
      Todo App v0.1
      <FunctionComponent/> <br />
      <ClassComponent/> <br />
      <LearningJavaScript/>
    </div>
  );
}
export default App;
