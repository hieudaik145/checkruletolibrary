package vn.tcx.dw.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class ConvertString {

    private ConvertString() {
        throw new IllegalStateException("Utility class");
    }

    private static final String EMPTY_STRING = "";

    public static String generateStringSearch(String str) {
        String a = EMPTY_STRING;
        if (str != null) {
            String temp = Normalizer.normalize(str, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            a = pattern.matcher(temp).replaceAll(EMPTY_STRING).replace("Đ", "D").replace("đ", "d").replace("­", "")
                    .replace("Ð", "D").replaceAll("[^\\p{ASCII}]", "").replaceAll("\\p{M}", "");
        }
        return a;
    }
}
