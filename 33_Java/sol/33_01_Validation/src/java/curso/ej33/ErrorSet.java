package curso.ej33;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ErrorSet {

    private HashMap<String, List<String>> errors = new HashMap<String, List<String>>();

    public boolean isValid() {
        return errors.isEmpty();
    }

    public List<String> errorsFor(String field) {
        List<String> errorsForField = errors.get(field);

        if (errorsForField == null) {
            errorsForField = new ArrayList<String>();
        }

        return errorsForField;
    }

    public boolean validField(String field) {
        return errors.get(field) == null;
    }

    public void addError(String field, String error) {
        if (!errors.containsKey(field)) {
            errors.put(field, new ArrayList<String>());
        }

        errors.get(field).add(error);
    }

    public String htmlErrorsFor(String field) {
        StringBuilder sb = new StringBuilder();
        if (!validField(field)) {
            sb.append("<ul>");
            for (String error : errorsFor(field)) {
                sb.append("<li>");
                sb.append(field);
                sb.append(" ");
                sb.append(error);
                sb.append("</li>");
            }
            sb.append("</ul>");
        }
        return sb.toString();
    }
}
