import { useState } from "react"

const Event = () => {
    const [count, setCount] = useState(0);
    const [rupee, setRupee] = useState(0);
    const eventHandler = (text) =>{
        alert(text)
    }
    const eventIncreament = (text) =>{
        alert(text);
        setCount(count+1);
    }
    const eventDecrement = (text) =>{
        alert(text);
        setCount(count-1);
    }
    const handleConversion = () => {
        const inr = parseFloat(rupee);
        const conversionRate = 0.011;
        const eur = (inr * conversionRate).toFixed(2);
        alert(`₹${inr} = €${eur}`);
    };
  return (
    <>
        <h3>{count}</h3>
        <button onClick={()=>eventIncreament('Hello Number Incremented')}>Increment</button>
        <button onClick={()=>eventDecrement('Hello Number Decremented')}>Decrement</button>
        <button onClick={()=>eventHandler('Welcome !')}>Say Welcome</button>
        <button onClick={()=>eventHandler('I was clicked !')}>Click on me</button>
        
        <h1 style = {{color:'green'}}>Currency Convertor</h1>
        <span>Amount</span>
        <input 
            type="number"
            onChange={e=>setRupee(e.target.value)}
            value={rupee}
        />
        <br/>
        <span>Currency</span>
        <input defaultValue={'euro'}/>
        <br/>
        <button onClick={handleConversion}>Submit</button>
    </>
  )
}

export default Event
