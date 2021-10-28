import { createServer } from "miragejs";
import { RECIPES } from "./data";

createServer({
  routes() {
    this.namespace = "api";
    this.timing = 3000;

    this.get("/recipes", () => {
      return RECIPES;
    });
  },
});
