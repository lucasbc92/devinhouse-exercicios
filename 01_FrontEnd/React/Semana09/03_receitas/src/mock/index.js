import { createServer } from "miragejs";
//import { RECIPES } from "./data";

createServer({
  routes() {
    this.namespace = "api";
    this.timing = 3000;

    this.get("/recipes", () => {
      return {
        data: [
          {
            id: 1,
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
          },
          {
            id: 2,
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
          },
          {
            id: 3,
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
          },
          {
            id: 4,
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
          },
          {
            id: 5,
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
          },
          {
            id: 6,
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
          },
        ],
      };
    });

    this.get("/teste", () => {
      return {
        data: []
      }
    })
  },
});
