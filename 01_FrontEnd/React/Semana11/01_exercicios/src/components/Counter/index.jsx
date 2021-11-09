import { useState } from "react";

import "./styles.css";

export const Counter = () => {
  const [count, setCount] = useState(0);

  return (
    <div className="counter-container">
      <h2>You clicked {count} times!</h2>
      <button onClick={() => setCount(count + 1)}>Increment</button>
    </div>
  );
};
