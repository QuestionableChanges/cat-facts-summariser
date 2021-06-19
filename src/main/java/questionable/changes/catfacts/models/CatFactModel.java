package questionable.changes.catfacts.models;

import java.util.StringJoiner;

public class CatFactModel {
    private String _id;
    private String text;
    private String type;
    private UserModel user;
    private String upvotes;
    private String userUpvoted;

    public String get_id() {
        return this._id;
    }

    public void set_id(final String _id) {
        this._id = _id;
    }

    public String getText() {
        return this.text;
    }

    public void setText(final String text) {
        this.text = text;
    }

    public String getType() {
        return this.type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public UserModel getUser() {
        return this.user;
    }

    public void setUser(final UserModel user) {
        this.user = user;
    }

    public String getUpvotes() {
        return this.upvotes;
    }

    public void setUpvotes(final String upvotes) {
        this.upvotes = upvotes;
    }

    public String getUserUpvoted() {
        return this.userUpvoted;
    }

    public void setUserUpvoted(final String userUpvoted) {
        this.userUpvoted = userUpvoted;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CatFactModel.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("text='" + text + "'")
                .add("type='" + type + "'")
                .add("user=" + user)
                .add("upvotes='" + upvotes + "'")
                .add("userUpvoted='" + userUpvoted + "'")
                .toString();
    }
}
