package questionable.changes.catfacts.models;

import com.opencsv.bean.CsvBindByName;

import java.util.StringJoiner;

public class CatFactsSummary {
    @CsvBindByName(column = "user")
    private String name;
    @CsvBindByName(column = "totalVotes")
    private int upVotes;

    public CatFactsSummary(String name, int upVotes) {
        this.name = name;
        this.upVotes = upVotes;
    }

    public String getName() {
        return name;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(int upVotes) {
        this.upVotes = upVotes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CatFactsSummary.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("upVotes=" + upVotes)
                .toString();
    }
}
