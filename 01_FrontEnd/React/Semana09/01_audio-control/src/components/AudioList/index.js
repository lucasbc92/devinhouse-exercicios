import React from "react";
export class AudioList extends React.Component {

    render() {
        return(
            <ul>
                {this.props.children}
            </ul>
        )
    }
}