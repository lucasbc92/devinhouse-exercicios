export default class Joke {
  constructor({ created_at, id, icon_url, url, value }) {
    this.createdAt = new Date(created_at);
    this.id = id;
    this.urlIcon = icon_url;
    this.url = url;
    this.joke = value;
  }
}
