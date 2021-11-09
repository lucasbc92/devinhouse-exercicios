// export const Selector = (props) => {
//   return (
//     <ul class="selector-container">
//       <p>{props.label}</p>
//       {props.options.map((option) => (
//         <li onClick={() => props.onChange(option)}>
//           <label for={option}>
//             <input type="radio" id={option} name="amount" />
//             {option}
//           </label>
//         </li>
//       ))}
//     </ul>
//   );
// };

export const Selector = ({ label, options, onChange, value }) => {
  return (
    <>
      <p>{label}</p>
      <div className="selector-container">
        {options.map((item) => (
          <div
            style={{
              background: value === item ? "tomato" : "var(--color-background)",
            }}
            className="option-selector"
            onClick={() => onChange(item)}
          >
            <span>{item}</span>
          </div>
        ))}
      </div>
    </>
  );
};
