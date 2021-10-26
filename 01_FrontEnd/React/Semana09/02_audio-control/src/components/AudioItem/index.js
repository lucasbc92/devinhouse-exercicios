import React from "react";
export class AudioItem extends React.Component {
    constructor(props){
        super(props);
        this.state = {
            value: this.props.value
        }
    }

    render() {
        return(
            <li>
                <button onClick={() => this.subtract()}>-</button>
                <span>{this.props.type}</span>
                <span>{" : "}</span>
                <span>{this.state.value}</span>
                <button onClick={() => this.add()}>+</button>
            </li>
        )
    }

    add(){
        console.log(this);
        if(this.state.value <= 100) {
            this.setState({value: this.state.value + 1});
        }        
    }

    subtract(){
        if(this.state.value > 0) {
            this.setState({value: this.state.value - 1});
        }  
    }
}