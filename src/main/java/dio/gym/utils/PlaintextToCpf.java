package dio.gym.utils;

import org.springframework.beans.factory.annotation.Value;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlaintextToCpf {

    @Value("${application.cpf-pattern-group:([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})}")
    private static String regex = "([0-9]{3})([0-9]{3})([0-9]{3})([0-9]{2})";

    public static String getRegex() {
        return regex;
    }

    public static void setRegex(String regex) {
        PlaintextToCpf.regex = regex;
    }

    public static String parse(String cpf) {
        Matcher matcher = Pattern.compile(regex).matcher(cpf);
        String result = "";

        if(matcher.find()) {
            String group1 = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(3);
            String group4 = matcher.group(4);
            result = group1+'.'+group2+"."+group3+'-'+group4;
        } else {
            result = cpf;
        }

        return result;
    }
}
