import React from "react";
import Post from "../../components/Post";

class Ex06 extends React.Component {
  render() {
    return (
      <div className="container">
        <Post
          contact={{
            photo: "https://github.com/lucasbc92.png",
            name: "Lucas Bueno Cesario",
            creationTime: "1h",
          }}
          description="Lorem ipsum dolor sit amet consectetur adipisicing elit. Sunt,
          numquam. Nostrum eligendi voluptatem modi quibusdam molestiae odit
          dolorem, voluptate cupiditate, quos fugit voluptatum placeat tenetur
          molestias harum dolores aspernatur et."
          postImage="https://terminalroot.com.br/assets/img/dev/lorem-ipsum.jpg"
          peopleLikes={[
            "Henrique Douglas Cavalcante Costa",
            "Camilla Laís Amaral",
            "Douglas de Oliveira Ialamov",
          ]}
        />
      </div>
    );
  }
}

export default Ex06;
