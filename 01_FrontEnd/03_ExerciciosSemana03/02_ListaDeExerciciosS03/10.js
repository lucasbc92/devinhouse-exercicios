function retrieveValues() {
    const values = [];
    const initialValue = parseFloat(document.getElementById("initialValue").value);
    const root = parseFloat(document.getElementById("root").value);
    if(isNaN(initialValue) || isNaN(root)){
        alert("Favor definir os valores da progressão.");
		return false;
    }
    values.push(initialValue);
    values.push(root);
    return values;
}

// function calculatePA() {
//     const values = retrieveValues();
//     const initialValue = values[0];
//     const root = values[1];
//     let value = initialValue;
//     const paValues = [];
//     for(let i = 0; i < 10; i++){
//         paValues.push(value);
//         value += raiz;
//     }
//     const resultPA = `Valor inicial: ${initialValue};\n
// 	Raiz: ${root};\n
// 	P.A: ${paValues.join(", ")}.`
// 	document.querySelector("#e10 textarea").innerHTML = resultPA;
// }

// function calculatePG() {
//     const values = retrieveValues();
//     const initialValue = values[0];
//     const root = values[1];
//     let value = initialValue;
//     const pgValues = [];
//     for(let i = 0; i < 10; i++){
//         pgValues.push(value);
//         value *= raiz;
//     }
//     const resultPG = `Valor inicial: ${initialValue};\n
// 	Raiz: ${root};\n
// 	P.G: ${paValues.join(", ")}.`
// 	document.querySelector("#e10 textarea").innerHTML = resultPG;
// }

function calculateProgression(type) {
	const values = retrieveValues();
	if(values === false) {
		return;
	}
    const initialValue = values[0];
    const root = values[1];
    let value = initialValue;
    const progressionValues = [];
	if(type === "P.A") {
		for(let i = 0; i < 10; i++){
			progressionValues.push(value);
			value += root;
		}
	} else if (type === "P.G") {
		for(let i = 0; i < 10; i++){
			progressionValues.push(value);
			value *= root;
		}
	}    
    const resultProgression = `${type}: ${progressionValues.join(", ")}.`;
	document.querySelector("#e10 textarea").innerHTML = resultProgression;
}