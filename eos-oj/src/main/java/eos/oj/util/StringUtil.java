package eos.oj.util;

/**
 * Title: StringUtil
 * Author: yanyuyu
 * Date: 2017-04-18 20:02
 */
public class StringUtil {
    /**
     * 校验传来的字符串组是否全部不为空
     * @param strings
     * @return
     */
    public static boolean isNotEmpty( String ... strings) {
        if(strings == null) {
            return false;
        }
        for(String str : strings)  {
            if(str == null || str.length() == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 校验传来的字符串组是否包含空串或null
     * @param strings
     * @return
     */
    public static boolean hasEmpty( String ... strings) {
        if(strings == null) {
            return true;
        }
        for(String str : strings)  {
            if(str == null || str.length() == 0) {
                return true;
            }
        }
        return false;
    }
}
