package BusinessLogic;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

//Define the @ColumnOrder annotation



public class ResultSetUtils {

    public static void populateTable(ResultSet rs, DefaultTableModel model, Class<?> objectClass) throws Exception {
        model.setRowCount(0); // Clear the existing rows
        generateHeaderUsingReflection(model, objectClass);

        while (rs.next()) {
            Vector<Object> row = extractObjectValues(rs, objectClass);
            model.addRow(row);
        }
    }

    private static Vector<Object> extractObjectValues(ResultSet rs, Class<?> objectClass) throws Exception {
        ResultSetMetaData rsmd = rs.getMetaData();
        int numColumns = rsmd.getColumnCount();

        Vector<Object> rowData = new Vector<>();
        for (int i = 1; i <= numColumns; i++) {
            String columnName = rsmd.getColumnName(i);
            Field field;
            
            try {
                field = objectClass.getDeclaredField(columnName);
            } catch (NoSuchFieldException e) {
                // Skip columns that don't have a corresponding field in the object class
                continue;
            }

            field.setAccessible(true);

            Object value = null;
            if (field.getType() == String.class) {
                // Handle String field
                value = rs.getString(i);
            } else if (field.getType() == int.class || field.getType() == Integer.class) {
                // Handle int or Integer field
                value = rs.getInt(i);
            } else {
                // Handle other field types
                value = field.get(rs.getObject(i));
            }

            rowData.add(value);
        }

        return rowData;
    }



    public static void generateHeaderUsingReflection(DefaultTableModel model, Class<?> objectClass) {
        Field[] fields = objectClass.getDeclaredFields();
        
        model.setColumnIdentifiers(new Object[0]);
        
        for (Field field : fields) {
            field.setAccessible(true);
            String columnName = field.getName();
            model.addColumn(columnName);
        }
    }
}
