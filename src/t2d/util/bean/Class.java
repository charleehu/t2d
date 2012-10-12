/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util.bean;

import java.util.List;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-12 上午09:20:46
 * @since 1.0
 */
public class Class {

    private String packageName;

    private List<String> importClasses;

    private String clsName;

    private List<Field> listField;

    public Class(String packageName, List<String> importClasses, String tabName,
            List<Field> listField) {
        super();
        this.packageName = packageName;
        this.importClasses = importClasses;
        this.clsName = tabName;
        this.listField = listField;
    }

    /**
     * @return the packageName
     */
    public String getPackageName() {
        return packageName;
    }

    /**
     * @param packageName the packageName to set
     */
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    /**
     * @return the importClasses
     */
    public List<String> getImportClasses() {
        return importClasses;
    }

    /**
     * @param importClasses the importClasses to set
     */
    public void setImportClasses(List<String> importClasses) {
        this.importClasses = importClasses;
    }

    /**
     * @return the listField
     */
    public List<Field> getListField() {
        return listField;
    }

    /**
     * @param listField the listField to set
     */
    public void setListField(List<Field> listField) {
        this.listField = listField;
    }

    /**
     * @return the clsName
     */
    public String getClsName() {
        return clsName;
    }

    /**
     * @param clsName the clsName to set
     */
    public void setClsName(String clsName) {
        this.clsName = clsName;
    }

}
