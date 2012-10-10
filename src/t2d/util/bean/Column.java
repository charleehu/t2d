/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util.bean;


/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-10 下午08:24:19
 * @since 1.0
 */
public class Column {

    private String name;
    private String type;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the type
     */
    public String getType() {
        return type;
    }
    
    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    public Column(String name, String type) {
        super();
        this.name = name;
        this.type = type;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Column [name=" + name + ", type=" + type + "]";
    }
    
}
