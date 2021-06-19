package questionable.changes.catfacts.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import questionable.changes.catfacts.models.CatFactsModel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CatFactsService {

    public CatFactsModel getCatFactsSample() throws URISyntaxException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String sampleData = readSampleData();

        return mapper.readValue(sampleData, CatFactsModel.class);
    }

    private String readSampleData() throws URISyntaxException, IOException {
        String data;

        Path path = Paths.get(getClass().getClassLoader()
                .getResource("sampleData.json").toURI());

        try (Stream<String> lines = Files.lines(path)) {
            data = lines.collect(Collectors.joining("\n"));
        }

        return data;
    }
}
