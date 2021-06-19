package questionable.changes.catfacts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import questionable.changes.catfacts.models.CatFactsModel;
import questionable.changes.catfacts.models.CatFactsSummary;
import questionable.changes.catfacts.services.ProcessingService;
import questionable.changes.catfacts.services.CatFactsService;
import questionable.changes.catfacts.services.OutputService;

import java.util.List;

@SpringBootApplication
public class CatfactsApplication implements CommandLineRunner {

	@Autowired
	CatFactsService catFactsService;

	@Autowired
	ProcessingService calculationService;

	@Autowired
	OutputService outputService;

	public static void main(String[] args) {
		SpringApplication.run(CatfactsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		CatFactsModel catFacts = catFactsService.getCatFactsSample();
		List<CatFactsSummary> summary = calculationService.summariseCatFactsUpVotes(catFacts);
		outputService.save(summary);
	}
}
