package utils;

public class GetXpath {

    public static String buildXpath(String value){
        String commonXpath = "//select[@ng-model='sc.selectedRequirement']/option[%s]";
        return String.format(commonXpath,value);
    }
}
