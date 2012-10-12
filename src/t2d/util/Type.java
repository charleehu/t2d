/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util;

import java.util.regex.Pattern;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-11 上午09:13:14
 * @since 1.0
 */
public enum Type {

    LONG("^BIGINT", "long"),
    INT("^(INT|TINYINT)", "int"),
    STRING("^VARCHAR", "String"),
    DOUBLE("^FLOAT", "double"),
    DATE("^(DATETIME|TIMESTAMP)", "Date"),
    BOOLEAN("^BIT", "boolean")
    ;
    
    private Type(String dbType, String javaType) {
        this.dbTypePattern = dbType;
        this.javaType = javaType;
    }
    
    private String dbTypePattern;
    public final String javaType;
    
    /**
     * @param type
     * @return
     */
    public static Type mapping(String dbType) {
        for (Type t : values()) {
            Pattern pattern = Pattern.compile(t.dbTypePattern);
            if (pattern.matcher(dbType).find()) return t;
        }
        
        throw new IllegalArgumentException("unsupport dbType: " + dbType);
    }
    
}
