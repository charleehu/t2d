/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-12 上午08:50:20
 * @since 1.0
 */
public class DefaultNameConvertor implements NameConvertor {

    /* (non-Javadoc)
     * @see t2d.util.NameConvertor#convert(java.lang.String)
     */
    @Override
    public String convert(String input) {
        StringBuilder ret = new StringBuilder();
        boolean isUpper = true;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            
            if (i == 0 || c == '_') {
                isUpper = true;
            }
            
            if (c == '_') {
                continue;
            }
            
            ret.append(isUpper ? toUpperCase(c) : c);
            
            isUpper = false;
        }
        
        return ret.toString();
    }

    /**
     * @param c
     * @return
     */
    private char toUpperCase(char c) {
        
        
        return (char) (c >= 97 && c <=123 ? c - 32 : c);
    }

}
