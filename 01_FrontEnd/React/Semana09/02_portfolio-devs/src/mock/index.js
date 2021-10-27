import { createServer } from "miragejs";
import { RANDOM_USERS } from "./data";

createServer({
  routes() {
    this.namespace = "api";

    this.get("/users", () => {
      return RANDOM_USERS;
    });

    this.get("/info", () => {
      return {
        title: "Portfólios",
        description: "As melhores pessoas desenvolvedoras estão aqui!",
      };
    });

    this.get("/expertises", () => {
      return {
        expertises: [
          "React Developer",
          "Java Developer",
          "Vue Developer",
          "Javascript Developer",
        ],
      };
    });
  },
});
