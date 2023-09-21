package km.filesoperations;

import java.util.regex.Pattern;

public class Utils {

    public static String FindPathSeperator(){
        if (System.getProperty("os.name").equals("Linux")) return "/";
        return "\\";
    }

    public static String GetName(String pathName, String pathSeperator) {
        String[] final_path = new String[50];
        String final_name;

        if (pathName == null || pathName == "") {
            return "";
        }

        final_path = pathName.split(Pattern.quote(pathSeperator));
        final_name = final_path[final_path.length - 1];
        final_name = final_name.substring(0, final_name.length() - 4);

        return final_name;
    }

    public static String GetExt(String pathName, String pathSeperator) {
        String[] final_path = new String[50];
        String[] ext = new String[50];
        String final_name;
        final_path = pathName.split(Pattern.quote(pathSeperator));
        final_name = final_path[final_path.length - 1];
        ext = final_name.split(Pattern.quote("."));
        final_name = ext[ext.length - 1];

        return final_name;
    }
}
