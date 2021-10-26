import React from "react";
import { AudioItem } from "../../components/AudioItem";
import { AudioList } from "../../components/AudioList";

export class Home extends React.Component {
    constructor(props) {
        super(props);
        this.state = {loading: true, audioData: []}
    }

    componentDidMount(){
        setTimeout(() => {
            this.setState({loading: false, audioData: [
                {
                    "type": "volume",
                    "value": 83
                },
                {
                    "type": "treble",
                    "value": 50
                },
                {
                    "type": "mid",
                    "value": 42
                },
                {
                    "type": "bass",
                    "value": 66
                }
            ]})
        })
    }

    render() {
        return(
            <>
                <div>
                    {this.state.loading && "Loading..."}
                    {!this.state.loading && (
                    <AudioList>
                        {this.state.audioData.map(audioItem => (
                            <AudioItem key={audioItem.type} type={audioItem.type} value={audioItem.value} />
                        ))}
                    </AudioList>
                    )}
                </div>
            </>
        )
    }
}