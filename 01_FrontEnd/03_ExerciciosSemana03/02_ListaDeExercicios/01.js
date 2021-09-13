function calculateAge() {
  const birthDate = document.getElementById("birthDate").value;
  if (!inputBirthDate) {
    alert("Insira uma data.");
    return;
  }
  const birthDate = new Date(inputBirthDate);
  const now = new Date();
  const arrBirthDate = [
    birthDate.getFullYear(),
    birthDate.getMonth(),
    birthDate.getDate(),
  ];
  const arrNow = [now.getFullYear(), now.getMonth(), now.getDate()];
  console.log(arrNow);
  console.log(arrBirthDate);
  const yearDiff = arrNow[0] - arrBirthDate[0];
  let age;
  if (yearDiff > 0) {
    const monthsDiff = arrNow[1] - arrBirthDate[1];
    if (monthsDiff > 0) {
      age = yearDiff;
    } else if (monthsDiff < 0) {
      age = yearDiff - 1;
    } else {
      const daysDiff = arrNow[2] - arrBirthDate[2];
      if (daysDiff > 0) {
        age = yearDiff;
      } else {
        age = yearDiff - 1;
      }
    }
  } else {
    age = yearDiff;
  }
  const textAge = `Você tem ${age} anos.`;
  document.querySelector("#textAge").innerText = textAge;
}
let button = document.querySelector("#buttonCalculateAge");
button.addEventListener("click", calculateAge);
