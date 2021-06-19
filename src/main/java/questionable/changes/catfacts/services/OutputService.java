package questionable.changes.catfacts.services;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import questionable.changes.catfacts.csv.AnnotationStrategy;
import questionable.changes.catfacts.models.CatFactsSummary;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class OutputService {
    @Autowired
    private Environment env;

    public <T> void save(List<T> outputObjects) throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        String fileLocation = env.getProperty("output.file.location");

        Writer writer = new FileWriter(fileLocation);
        StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).withMappingStrategy(new AnnotationStrategy(CatFactsSummary.class)).build();
        beanToCsv.write(outputObjects);
        writer.close();
    }
}
