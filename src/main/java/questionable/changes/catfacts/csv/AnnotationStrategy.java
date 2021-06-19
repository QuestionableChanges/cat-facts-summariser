package questionable.changes.catfacts.csv;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * The following code has been retrieved from https://stackoverflow.com/a/60349917
 * This will make sure our CSV headers aren't all uppercase
 * It will use the annotation on the bean to determine the column names
 */

public class AnnotationStrategy extends HeaderColumnNameTranslateMappingStrategy
{
    private final Map<String, String> columnMap = new HashMap<>();

    public AnnotationStrategy(Class<?> clazz)
    {
        for(Field field:clazz.getDeclaredFields())
        {
            CsvBindByName annotation = field.getAnnotation(CsvBindByName.class);
            if(annotation!=null)
            {
                columnMap.put(field.getName().toUpperCase(), annotation.column());
            }
        }
        setType(clazz);
        setColumnMapping(columnMap);
    }

    @Override
    public String getColumnName(int columnIndex) {
        return headerIndex.getByPosition(columnIndex);
    }

    @Override
    public String[] generateHeader(Object bean) throws CsvRequiredFieldEmptyException
    {
        String[] result = super.generateHeader(bean);
        for(int i=0;i<result.length;i++)
        {
            result[i]=getColumnNameFromAnnotation(i);
        }
        return result;
    }

    private String getColumnNameFromAnnotation(int columnIndex) {
        String fieldName = headerIndex.getByPosition(columnIndex);
        String annotationName = null;
        if(fieldName != null) {
            annotationName = columnMap.get(fieldName);
        }
        return annotationName;
    }
}
