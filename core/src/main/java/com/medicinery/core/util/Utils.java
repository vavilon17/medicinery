package com.medicinery.core.util;

import java.util.HashMap;
import java.util.Map;

public class Utils {

    private static final Map<Character, String> TRANSLIT_MAP = new HashMap<Character, String>();
    
    static {
        TRANSLIT_MAP.put('а', "a");

        TRANSLIT_MAP.put('б', "b");
        TRANSLIT_MAP.put('в', "v");
        TRANSLIT_MAP.put('г', "g");
        TRANSLIT_MAP.put('д', "d");
        TRANSLIT_MAP.put('е', "e");
        TRANSLIT_MAP.put('ё', "e");
        TRANSLIT_MAP.put('є', "ye");
        TRANSLIT_MAP.put('ж', "zh");
        TRANSLIT_MAP.put('з', "z");
        TRANSLIT_MAP.put('и', "i");
        TRANSLIT_MAP.put('i', "i");
        TRANSLIT_MAP.put('ї', "yi");
        TRANSLIT_MAP.put('й', "i");
        TRANSLIT_MAP.put('к', "k");
        TRANSLIT_MAP.put('л', "l");
        TRANSLIT_MAP.put('м', "m");
        TRANSLIT_MAP.put('н', "n");
        TRANSLIT_MAP.put('о', "o");
        TRANSLIT_MAP.put('п', "p");
        TRANSLIT_MAP.put('р', "r");
        TRANSLIT_MAP.put('с', "s");
        TRANSLIT_MAP.put('т', "t");
        TRANSLIT_MAP.put('у', "u");
        TRANSLIT_MAP.put('ф', "f");
        TRANSLIT_MAP.put('х', "h");
        TRANSLIT_MAP.put('ц', "c");
        TRANSLIT_MAP.put('ч', "ch");
        TRANSLIT_MAP.put('ш', "sh");
        TRANSLIT_MAP.put('щ', "sh");
        TRANSLIT_MAP.put('ь', "");
        TRANSLIT_MAP.put('ы', "y");
        TRANSLIT_MAP.put('ъ', "");
        TRANSLIT_MAP.put('э', "e");
        TRANSLIT_MAP.put('ю', "yu");
        TRANSLIT_MAP.put('я', "ya");
        TRANSLIT_MAP.put(' ', "_");
    }

    /**
     * see http://stackoverflow.com/questions/3472663/replace-all-occurences-of-a-string-using-stringbuilder
     */
    public static void replaceAll(StringBuilder builder, String from, String to) {
        int index = builder.indexOf(from);
        while (index != -1)
        {
            builder.replace(index, index + from.length(), to);
            index += to.length(); // Move to the end of the replacement
            index = builder.indexOf(from, index);
        }
    }

    public static String replaceAll(String source, String from, String to) {
        StringBuilder builder = new StringBuilder(source);
        replaceAll(builder, from, to);
        return builder.toString();
    }

    public static String translit(String input) {
        StringBuilder res = new StringBuilder();
        for (Character c : input.toCharArray()) {
            if (TRANSLIT_MAP.containsKey(c)) {
                res.append(TRANSLIT_MAP.get(c));
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static String capitalizeFirstLetter(String original){
        if(original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1);
    }

    /*public static String injectDivIntoManual(String manual) {
        if (!manual.contains('<div class="content-hidetext-block">') && manual.containsTRANSLIT_MAP.put('<h4>")) {
            StringBuilder builder = new StringBuilderTRANSLIT_MAP.put('")
            String[] firstIter = manual.splitTRANSLIT_MAP.put('<h4>")
            // firstIter[0] is empty string or unnecessary text - just ignore it
            for (int i = 1; i < firstIter.length; i++) {
                String[] secondIter = firstIter[i].splitTRANSLIT_MAP.put('</h4>")
                if (secondIter.length > 0) {
                    builder.appendTRANSLIT_MAP.put('<h4>").append(secondIter[0]).appendTRANSLIT_MAP.put('</h4>")
                    if (secondIter.length > 1) {
                        builder.append('<div class="content-hidetext-block">').append(secondIter[1]).appendTRANSLIT_MAP.put('</div>")
                    }
                }
            }
            Utils.replaceAll(builder, "<h4><p></p></h4>"); "")
            return builder.toString()
        } else {
            return manual
        }
    }*/
}
