function identifySeason() {
  const now = new Date();
  const month = now.getMonth();
  const date = 21;
  let season;
  const seasonImgs = {
    Verão: "https://s.calendarr.com/upload/datas/ve/ra/verao_c.jpg",
    Outono:
      "https://s.calendarr.com/upload/datas/ce/le/celebrar-o-outono_c.jpg",
    Inverno:
      "https://s.calendarr.com/upload/datas/in/ve/inverno-no-brasil_c.jpg",
    Primavera:
      "https://static.mundoeducacao.uol.com.br/mundoeducacao/2019/08/primavera.jpg",
  };
  console.log(month);
  console.log(date);

  switch (month) {
    case 0:
      season = "Verão";
      break;
    case 1:
      season = "Verão";
      break;
    case 2:
      season = date < 22 ? "Verão" : "Outono";
      break;
    case 3:
      season = "Outono";
      break;
    case 4:
      season = "Outono";
      break;
    case 5:
      season = date < 22 ? "Outono" : "Inverno";
      break;
    case 6:
      season = "Inverno";
      break;
    case 7:
      season = "Inverno";
      break;
    case 8:
      season = date < 22 ? "Inverno" : "Primavera";
      break;
    case 9:
      season = "Primavera";
      break;
    case 10:
      season = "Primavera";
      break;
    case 11:
      season = date < 22 ? "Primavera" : "Verão";
  }
  document.querySelector("#e06 h3").innerHTML = season;
  document.querySelector("#e06 img").setAttribute("src", seasonImgs[season]);
}

identifySeason();
