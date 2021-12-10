const perguntar = (pergunta, sim, nao) => {
  if (confirm(pergunta)) sim();
  else nao();
};

perguntar(
  "Você concorda?",
  () => {
    alert("Você concordou.");
  },
  () => {
    alert("Você não concordou.");
  }
);
