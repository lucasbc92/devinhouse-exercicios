function staticWatch() {
  const now = new Date();
  const hours = now.getHours().toString().padStart(2, "0");
  const minutes = now.getMinutes().toString().padStart(2, "0");
  document.querySelector("#e04 h3").innerHTML = `${hours}:${minutes}`;
}

staticWatch();
