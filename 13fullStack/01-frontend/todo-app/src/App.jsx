import './styles/App.css';
// import ClassComponent from './components/intro/ClassComponent'
// import FunctionComponent from './components/intro/FunctionComponent'
// import LearningJavaScript from './components/intro/ABitJs'
// import Counter from './components/counter/Counter'
import TodoApp from './components/todo/TodoApp'

function App() {
  return (
    <div className="App">
      {/* Todo App v0.1, intro
      <FunctionComponent/> <br />
      <ClassComponent/> <br />
      <LearningJavaScript/> 
      
      <PlayingWithProperties prop1="value1" prop2="value2"/>
      
      // counter app
      <Counter /> */}

      <TodoApp/>

    </div>
  );
}

// function PlayingWithProperties({prop1,prop2}){
//     return(
//       <>{prop1} & {prop2} are passed by the App component to this component.</>
//     )
// }

export default App;