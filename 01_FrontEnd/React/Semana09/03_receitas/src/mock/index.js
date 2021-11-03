// import { createServer, Model } from "miragejs";
// import { RECIPES } from "./data";

// createServer({
//   models: {
//     message: Model
//   },

//   routes() {
//     this.namespace = "api";
//     this.timing = 3000;

//     this.get("/recipes", (schema, request) => {
//       return RECIPES;
//     });

//     this.get("recipes/:id", (schema, request) => {
//       const { id } = request.params;
//       return RECIPES.data.find((recipe) => recipe.id === parseInt(id));
//     });
//   },
// });

import { createServer, Model } from "miragejs";

export function makeServer() {
  let server = createServer({
    models: {
      recipe: Model,
      message: Model,
    },
    seeds(server) {
      server.create("recipe", {
        image:
          "https://p2.trrsf.com/image/fget/cf/648/0/images.terra.com/2020/03/23/bolinho-casca-batata-espinafre.jpg",
        title: "Bolinho de casca de batata",
        subtitle: "Uma receita gostosa, prática e nutritiva!",
        author: "Lucas Bueno Cesario",
        foodInfos: [
          {
            food: "Batata",
            calories: 30,
            carbs: 7.2,
            proteins: 0,
            lipids: 0,
            saturatedFat: 0,
          },
          {
            food: "Espinafre",
            calories: 23,
            carbs: 3.75,
            proteins: 2.97,
            lipids: 0.26,
            saturatedFat: 0,
          },
          {
            food: "Cebola",
            calories: 39,
            carbs: 8.9,
            proteins: 1.17,
            lipids: 0,
            saturatedFat: 0.1,
          },
          {
            food: "Ovo",
            calories: 65.7,
            carbs: 0.27,
            proteins: 6,
            lipids: 4.28,
            saturatedFat: 1.31,
          },
        ],
        text: `
Tempo: 50min
Rendimento: 30 unidades
Dificuldade: fácil

Ingredientes do Bolinho de casca de batata com espinafre
2 xícaras (chá) de casca de batata cozida e escorrida
1/2 xícara (chá) de leite
1/2 xícara (chá) de espinafre cozido, espremido e picado
4 colheres (sopa) de cebola ralada
4 colheres (sopa) de queijo parmesão ralado
2 ovos
Sal e pimenta-do-reino a gosto
1 colher (chá) de fermento em pó
2 xícaras (chá) de farinha de trigo (aproximadamente)
Óleo para fritar

Modo de preparo
Bata no liquidificador a casca com o leite até homogeneizar.
Despeje em uma tigela e misture com o espinafre, a cebola, o queijo, os ovos, sal e pimenta.
Junte o fermento e a farinha, aos poucos, mexendo até desgrudar da lateral da tigela.
Frite colheradas da massa em óleo quente, aos poucos, até dourar. Escorra sobre papel-toalha e sirva.
`,
      });
      server.create("recipe", {
        image:
          "https://p2.trrsf.com/image/fget/cf/648/0/images.terra.com/2020/03/23/whatsapp-image-2020-03-23-at-123428-1024x630.jpeg",
        title: "Mexido caipira",
        subtitle: "Uma receita gostosa, prática e nutritiva!",
        author: "Camilla Lais Amaral",
        foodInfos: [
          {
            food: "Batata",
            calories: 30,
            carbs: 7.2,
            proteins: 0,
            lipids: 0,
            saturatedFat: 0,
          },
          {
            food: "Espinafre",
            calories: 23,
            carbs: 3.75,
            proteins: 2.97,
            lipids: 0.26,
            saturatedFat: 0,
          },
          {
            food: "Cebola",
            calories: 39,
            carbs: 8.9,
            proteins: 1.17,
            lipids: 0,
            saturatedFat: 0.1,
          },
          {
            food: "Ovo",
            calories: 65.7,
            carbs: 0.27,
            proteins: 6,
            lipids: 4.28,
            saturatedFat: 1.31,
          },
        ],
        text: `
Tempo: 15min
Rendimento: 4
Dificuldade: fácil

Ingredientes:
3 colheres (sopa) de óleo
300g de linguiça calabresa fininha fatiada
2 dentes de alho picados
1 maço de couve fatiado
3 xícaras (chá) de arroz branco cozido
2 ovos cozidos e picados
Sal e cheiro-verde picado a gosto

Modo de preparo:
Aqueça uma panela com o óleo, em fogo médio e frite a calabresa até dourar.
Junte o alho e a couve e refogue até murchar. Adicione o arroz, o ovo cozido, sal e cheiro-verde e refogue por 3 minutos.
Transfira para uma travessa e sirva.`,
      });
      server.create("recipe", {
        image:
          "https://p2.trrsf.com/image/fget/cf/648/0/images.terra.com/2020/03/23/empadc3a3o-de-peixe.jpg",
        title: "Empadão de peixe",
        subtitle: "Uma receita gostosa, prática e nutritiva!",
        author: "Douglas de Oliveira Ialamov",
        foodInfos: [
          {
            food: "Peixe",
            calories: 154,
            carbs: 0,
            proteins: 30,
            lipids: 3.6,
            saturatedFat: 1.7,
          },
          {
            food: "Milho",
            calories: 98,
            carbs: 17.1,
            proteins: 3.2,
            lipids: 0,
            saturatedFat: 0.4,
          },
          {
            food: "Azeitona",
            calories: 115,
            carbs: 6.3,
            proteins: 0.8,
            lipids: 0,
            saturatedFat: 1.42,
          },
          {
            food: "Ovo",
            calories: 65.7,
            carbs: 0.27,
            proteins: 6,
            lipids: 4.28,
            saturatedFat: 1.31,
          },
        ],
        text: `
Tempo: 1h10 (+30min de geladeira)
Rendimento: 8 porções
Dificuldade: fácil

Ingredientes do empadão de peixe
3 xícaras (chá) de farinha de trigo
1 colher (chá) de sal
5 colheres (sopa) de manteiga
1 ovo l 1/3 de xícara (chá) de água (aproximadamente)
Margarina e farinha de trigo para untar e enfarinhar
1 gema para pincelar
Recheio
3 colheres (sopa) de manteiga
1 cebola picada
600g de peixe branco em cubos
2 tomates sem sementes picados
1 lata de milho verde escorrido
1/2 xícara (chá) de azeitona verde picada
Sal e salsa picada a gosto
1 xícara (chá) de requeijão cremoso

Modo de preparo
Misture a farinha com o sal e a manteiga até formar uma farofa.
Adicione o ovo e a água, misturando até formar uma massa leve. Se necessário, adicione mais água.
Embrulhe em filme plástico e leve à geladeira por 30 minutos.
Aqueça uma panela com a manteiga, em fogo médio, e frite a cebola e o peixe até dourar levemente.
Adicione o tomate, o milho, a azeitona, sal, salsa e refogue por 3 minutos. Misture o requeijão e desligue.
Abra a massa com um rolo e forre o fundo e a lateral de um refratário redondo médio untado e enfarinhado com 2/3 da massa.
Distribua o recheio e cubra com a massa restante, usando as sobras para decorar.
Pincele com a gema e leve ao forno médio, preaquecido, por 30 minutos. Deixe amornar, desenforme e sirva.
`,
      });
      server.create("recipe", {
        image:
          "https://p2.trrsf.com/image/fget/cf/648/0/images.terra.com/2020/03/23/bolinho-arroz-assado.jpg",
        title: "Bolinho de arroz assado",
        subtitle: "Uma receita gostosa, prática e nutritiva!",
        author: "Daiana Eger Michels",
        foodInfos: [
          {
            food: "Batata",
            calories: 30,
            carbs: 7.2,
            proteins: 0,
            lipids: 0,
            saturatedFat: 0,
          },
          {
            food: "Espinafre",
            calories: 23,
            carbs: 3.75,
            proteins: 2.97,
            lipids: 0.26,
            saturatedFat: 0,
          },
          {
            food: "Cebola",
            calories: 39,
            carbs: 8.9,
            proteins: 1.17,
            lipids: 0,
            saturatedFat: 0.1,
          },
          {
            food: "Ovo",
            calories: 65.7,
            carbs: 0.27,
            proteins: 6,
            lipids: 4.28,
            saturatedFat: 1.31,
          },
        ],
        text: `
Tempo: 40min
Rendimento: 5 porções
Dificuldade: fácil

Ingredientes do bolinho de arroz assado
3 xícaras (chá) de arroz branco cozido
1/4 de xícara (chá) de leite
1 xícara (chá) de espinafre cozido e picado
1 xícara (chá) de queijo parmesão ralado
1 xícara (chá) de farinha de trigo
1 colher (café) de fermento em pó
2 ovos
Sal e pimenta-do-reino a gosto
Óleo para untar

Modo de preparo
Coloque o arroz e o leite em uma tigela e amasse com um garfo.
Adicione o espinafre, o parmesão, a farinha, o fermento, os ovos, sal e pimenta e misture.
Pegue porções da massa com uma colher e modele bolinhos.
Coloque em uma fôrma untada, um do lado do outro, e leve ao forno médio, preaquecido, por 20 minutos ou até assar e dourar.
Retire e coloque em uma travessa para servir.
`,
      });
      server.create("recipe", {
        image:
          "https://p2.trrsf.com/image/fget/cf/648/0/images.terra.com/2020/03/23/fricasse-incrementado.jpg",
        title: "Fricassê incrementado",
        subtitle: "Uma receita gostosa, prática e nutritiva!",
        author: "Henrique Douglas Cavalcante Costa",
        foodInfos: [
          {
            food: "Batata",
            calories: 30,
            carbs: 7.2,
            proteins: 0,
            lipids: 0,
            saturatedFat: 0,
          },
          {
            food: "Espinafre",
            calories: 23,
            carbs: 3.75,
            proteins: 2.97,
            lipids: 0.26,
            saturatedFat: 0,
          },
          {
            food: "Cebola",
            calories: 39,
            carbs: 8.9,
            proteins: 1.17,
            lipids: 0,
            saturatedFat: 0.1,
          },
          {
            food: "Ovo",
            calories: 65.7,
            carbs: 0.27,
            proteins: 6,
            lipids: 4.28,
            saturatedFat: 1.31,
          },
        ],
        text: `
Tempo: 40min
Rendimento: 8 porções
Dificuldade: fácil

Ingredientes do Fricassê incrementado
2 colheres (sopa) de manteiga
1 xícara (chá) de bacon picado
1 cebola picada
3 xícaras (chá) de frango cozido e desfiado
1 lata de milho verde escorrido
1 lata de ervilha escorrida
1 xícara (chá) de brócolis pré-cozido
2 batatas cozidas em cubos
1 caixa de creme de leite (200g)
Sal e pimenta-do-reino a gosto
Manteiga para untar
1 xícara (chá) de queijo mussarela ralado
Batata palha a gosto para polvilhar

Modo de preparo:
Aqueça uma panela com a manteiga e frite o bacon e a cebola até dourar.
Adicione o frango, o milho, a ervilha e refogue por 3 minutos.
Acrescente o brócolis, as batatas, o creme de leite, sal, pimenta e refogue rapidamente.
Transfira para um refratário médio untado e espalhe a mussarela.
Leve ao forno médio, preaquecido, por 15 minutos.
Retire, polvilhe com batata palha e sirva.
`,
      });
      server.create("recipe", {
        image:
          "https://p2.trrsf.com/image/fget/cf/648/0/images.terra.com/2020/03/23/farofa-de-carne-moc3adda.jpg",
        title: "Farofa de carne moída",
        subtitle: "Uma receita gostosa, prática e nutritiva!",
        author: "Silvia Luiza Teixeira Melo",
        foodInfos: [
          {
            food: "Batata",
            calories: 30,
            carbs: 7.2,
            proteins: 0,
            lipids: 0,
            saturatedFat: 0,
          },
          {
            food: "Espinafre",
            calories: 23,
            carbs: 3.75,
            proteins: 2.97,
            lipids: 0.26,
            saturatedFat: 0,
          },
          {
            food: "Cebola",
            calories: 39,
            carbs: 8.9,
            proteins: 1.17,
            lipids: 0,
            saturatedFat: 0.1,
          },
          {
            food: "Ovo",
            calories: 65.7,
            carbs: 0.27,
            proteins: 6,
            lipids: 4.28,
            saturatedFat: 1.31,
          },
        ],
        text: `
Tempo: 30min
Rendimento: 4
Dificuldade: fácil

Ingredientes da farofa de carne moída
2 colheres (sopa) de margarina
200g de carne moída
1/2 cebola pequena picada
1/2 pimentão vermelho picado
1/4 de xícara (chá) de azeitona verde picada
2 xícaras (chá) de farinha de milho
Sal, pimenta-do-reino e cheiro-verde picado a gosto

Modo de preparo
Em uma frigideira, em fogo médio, derreta a margarina, refogue a carne e a cebola por 5 minutos.
Adicione o pimentão, a azeitona e refogue por mais 3 minutos.
Acrescente a farinha e misture por 2 minutos. Tempere com sal, pimenta e cheiro-verde.
Transfira para uma travessa e sirva em seguida. Se desejar, decore com tiras de pimentão vermelho.
`,
      });
    },
    routes() {
      this.namespace = "api";
      this.get("/recipes", (schema) => {
        return schema.recipes.all();
      });
      this.get("/recipes/:id", (schema, request) => {
        let id = request.params.id;
        return schema.recipes.find(id);
      });
      this.get("/messages", (schema) => {
        return schema.messages.all();
      });
      this.post("/messages", (schema, request) => {
        let attrs = request.requestBody;
        return schema.messages.create(attrs);
      });
      // this.patch("/:id", (schema, request) => {
      //   let newAttrs = JSON.parse(request.requestBody);
      //   let id = request.params.id;
      //   let recipe = schema.recipes.find(id);
      //   return recipe.update(newAttrs);
      // });
      // this.delete("/:id", (schema, request) => {
      //   let id = request.params.id;
      //   return schema.recipes.find(id).destroy();
      // });
    },
  });
  return server;
}
