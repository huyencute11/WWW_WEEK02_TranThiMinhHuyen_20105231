package www.week2.www_lab02.converters;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import www.week2.www_lab02.enums.EmployeeStatus;

import java.util.stream.Stream;

@Converter
public class EmployeeStatusConverter implements AttributeConverter<EmployeeStatus, Integer> {
    @Override
    public Integer convertToDatabaseColumn(EmployeeStatus attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.getValue();
    }
    @Override
    public EmployeeStatus convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return null;
        }
        return Stream.of(EmployeeStatus.values())
                .filter(c -> c.getValue() == dbData)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
