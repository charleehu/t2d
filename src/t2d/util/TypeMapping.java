/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-11 上午09:13:14
 * @since 1.0
 */
public enum TypeMapping {

    LONG("BIGINT", "long"),
    INT("INT|TINYINT", "int"),
    STRING("VARCHAR", "String"),
    DOUBLE("FLOAT", "double"),
    DATE("DATETIME|TIMESTAMP", "Date"),
    BOOLEAN("BIT", "boolean")
    ;
    
    private TypeMapping(String dbType, String javaType) {
        this.dbType = dbType;
        this.javaType = javaType;
    }
    private String dbType;
    private String javaType;
    
    
}
