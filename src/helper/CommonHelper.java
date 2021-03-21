package helper;

import java.util.List;

public class CommonHelper {

    //This class is not meant for instantiated. Hence throw error when try to instantiate.
    private CommonHelper() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    //This function takes list of integer and return comma separated string of integers.
    public static String convertIntegerListToCommaSeparatedString(List<Integer> list) {
        StringBuilder s = new StringBuilder("");
        for(int i=0;i<list.size();i++) {
            s.append(list.get(i));
            s.append(i==list.size()-1 ? "":",")  ;
        }
        return s.toString();
    }

    //This function takes list of String and return comma separated string of integers.
    public static String convertStringListToCommaSeparatedString(List<String> list) {
        StringBuilder s = new StringBuilder("");
        for(int i=0;i<list.size();i++) {
            s.append(list.get(i));
            s.append(i==list.size()-1 ? "":",")  ;
        }
        return s.toString();
    }
}
