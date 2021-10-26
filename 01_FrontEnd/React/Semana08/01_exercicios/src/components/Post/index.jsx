import React from "react";
import PropTypes from "prop-types";
import "./styles.css";
import Contact from "../ContactList/Contact";
import { FaEllipsisV, FaHeart } from "react-icons/fa";

class Post extends React.Component {
  render() {
    return (
      <div className="post-container">
        <div className="post-author">
          <Contact
            photo={this.props.contact.photo}
            name={this.props.contact.name}
            description={this.props.contact.creationTime}
          />
          <FaEllipsisV />
        </div>
        <p className="post-description">{this.props.description}</p>
        {this.props.postImage && (
          <img className="post-image" src={this.props.postImage} alt="Post" />
        )}
        <div className="post-like-comments-share">
          <div className="post-like-comments">
            <FaHeart />
            <span>Comments</span>
          </div>
          <span className="post-share">Share</span>
        </div>
        {this.props.peopleLikes.length !== 0 && (
          <p className="post-liked-by">
            Liked by{" "}
            <strong className="post-people-likes">
              {this.props.peopleLikes[0]}{" "}
              {this.props.peopleLikes.length > 1 &&
                `& ${this.props.peopleLikes.length - 1} others`}
            </strong>
          </p>
        )}
      </div>
    );
  }
}

Post.propTypes = {
  contact: PropTypes.shape({
    photo: PropTypes.string.isRequired,
    name: PropTypes.string.isRequired,
    creationTime: PropTypes.string.isRequired,
  }).isRequired,
  description: PropTypes.string.isRequired,
  postImage: PropTypes.string,
  peopleLikes: PropTypes.arrayOf(PropTypes.string).isRequired,
};

export default Post;
