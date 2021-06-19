package questionable.changes.catfacts.models;

import java.util.StringJoiner;

public class UserModel {
    private String _id;
    private NameModel name;

    public String get_id() {
        return this._id;
    }

    public void set_id(final String _id) {
        this._id = _id;
    }

    public NameModel getName() {
        return this.name;
    }

    public void setName(final NameModel name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserModel.class.getSimpleName() + "[", "]")
                .add("_id='" + _id + "'")
                .add("name=" + name)
                .toString();
    }
}
