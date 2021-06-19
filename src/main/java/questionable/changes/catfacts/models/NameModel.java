package questionable.changes.catfacts.models;

import java.util.StringJoiner;

public class NameModel {
    private String first;
    private String last;

    public String getFirst() {
        return this.first;
    }

    public void setFirst(final String first) {
        this.first = first;
    }

    public String getLast() {
        return this.last;
    }

    public void setLast(final String last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", NameModel.class.getSimpleName() + "[", "]")
                .add("first='" + first + "'")
                .add("last='" + last + "'")
                .toString();
    }
}
