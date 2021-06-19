package questionable.changes.catfacts.models;

import java.util.List;
import java.util.StringJoiner;

public class CatFactsModel {

    private List<CatFactModel> all;

    public List<CatFactModel> getAll() {
        return this.all;
    }

    public void setAll(final List<CatFactModel> all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CatFactsModel.class.getSimpleName() + "[", "]")
                .add("all=" + all)
                .toString();
    }
}
