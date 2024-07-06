import { Component } from 'react';

class ClassComponent extends Component {
    render(){
      return(
        <>
          <div>Class components use a render to return things</div>
          <div>Function components are used more, they let you use hooks to handle data</div>
        </>
      )
    }
  }

export default ClassComponent;