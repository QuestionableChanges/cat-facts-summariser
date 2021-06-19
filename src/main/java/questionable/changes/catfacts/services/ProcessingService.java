package questionable.changes.catfacts.services;

import org.springframework.stereotype.Service;
import questionable.changes.catfacts.models.CatFactModel;
import questionable.changes.catfacts.models.CatFactsModel;
import questionable.changes.catfacts.models.CatFactsSummary;
import questionable.changes.catfacts.models.NameModel;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.summingInt;

@Service
public class ProcessingService {

    public List<CatFactsSummary> summariseCatFactsUpVotes(CatFactsModel catFacts) {
        List<CatFactModel> allFacts = catFacts.getAll();

        // Create a map with the user's name as the index and their summed up votes as the value
        Map<String, Integer> summed = allFacts.stream()
                                              .collect(Collectors.groupingBy(this::getFullName,
                                                                             summingInt(f -> Integer.parseInt(f.getUpvotes()))
                                                      ));

        //Convert map to a list of CatFactsSummary objects
        return summed.entrySet().stream()
                                .map(entry -> new CatFactsSummary(entry.getKey() , entry.getValue()))
                                .sorted(Comparator.comparing(CatFactsSummary::getUpVotes, Comparator.reverseOrder()))
                                .collect(Collectors.toList());
    }

    private String getFullName(CatFactModel catFact) {
        NameModel catFactName = catFact.getUser().getName();
        return catFactName.getFirst() + " " + catFactName.getLast();
    }
}
