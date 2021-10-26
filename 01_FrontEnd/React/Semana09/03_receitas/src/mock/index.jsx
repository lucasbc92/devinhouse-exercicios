import { createServer } from "miragejs";
import { RECIPES } from "./data";

createServer({
  routes() {
    this.namespace = "api";

    this.get("/recipes", () => {
      return RECIPES;
    });
  },
});
