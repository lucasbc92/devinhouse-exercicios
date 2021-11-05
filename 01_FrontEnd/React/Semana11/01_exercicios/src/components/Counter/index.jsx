import { useState } from "react";

export const Counter = () => {
  const [count, setCount] = useState(0);

  return (
    <div className="counter-container">
      <h2>You clicked {this.state.count} times!</h2>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
};
