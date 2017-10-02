package adneom.image_poc.Utils;

/**
 * Created by gtshilombowanticale on 15-05-17.
 */

public class StringUtil {

    public static String replaceSpecialCharacters(String str){
        String nvStr = str;
        if(str.contains("%3A")){
            nvStr = str.replace("%3A",":");
        }
        return nvStr;
    }
}
