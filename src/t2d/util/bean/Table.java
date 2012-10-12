/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util.bean;

import java.util.List;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-11 下午06:29:08
 * @since 1.0
 */
public class Table {

    private String tableName;

    private List<Column> listColumn;

    public Table(String tableName, List<Column> listColumn) {
        super();
        this.tableName = tableName;
        this.listColumn = listColumn;
    }

    /**
     * @return the tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * @param tableName the tableName to set
     */
    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    /**
     * @return the listColumn
     */
    public List<Column> getListColumn() {
        return listColumn;
    }

    /**
     * @param listColumn the listColumn to set
     */
    public void setListColumn(List<Column> listColumn) {
        this.listColumn = listColumn;
    }

}
