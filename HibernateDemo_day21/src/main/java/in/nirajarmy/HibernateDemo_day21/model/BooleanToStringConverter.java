package in.nirajarmy.HibernateDemo_day21.model;

import jakarta.persistence.AttributeConverter;

public class BooleanToStringConverter
        implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute == null) return null;

        return attribute? "YES" : "NO";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        if (dbData == null) return null;

        return dbData.equals("YES");
    }
}
