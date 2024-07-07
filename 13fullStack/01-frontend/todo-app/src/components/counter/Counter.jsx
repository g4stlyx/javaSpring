import "../../styles/counter.css"
import { useState } from "react";

export default function Counter(){
    const [count,setCount] = useState(0);

    function increaseCounter(by) {
        setCount(count+by)
    }

    function decreaseCounter(by) {
        setCount(count-by);
    }

    function resetCounter(){
        setCount(0);
    }

    return(
        <>
            <span className="count">{count}</span>
            <CounterButton increaseCounter={increaseCounter} decreaseCounter={decreaseCounter}/>
            <CounterButton by={2} increaseCounter={increaseCounter} decreaseCounter={decreaseCounter}/>
            <CounterButton by={5} increaseCounter={increaseCounter} decreaseCounter={decreaseCounter}/>
            <button className="button resetButton" onClick={resetCounter}>Reset</button>
        </>
    )
}

function CounterButton({by=1,increaseCounter, decreaseCounter}) {
    
    return (
        <div className="Counter">
        <div>
            <button className="button counterButton" onClick={()=>increaseCounter(by)}>+{by}</button>
            <button className="button counterButton" onClick={()=>decreaseCounter(by)}>-{by}</button>
        </div>
        </div>
    );
}
