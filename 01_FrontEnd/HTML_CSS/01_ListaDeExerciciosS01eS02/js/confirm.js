function confirmAction() {
  sweetAlert
    .fire({
      title: "Tem certeza?",
      text: "Deseja passar para a página de imagens?",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Sim",
      cancelButtonText: "Não",
    })
    .then((result) => {
      if (result.isConfirmed) {
        window.location.assign("images.html");
      }
    });
}
