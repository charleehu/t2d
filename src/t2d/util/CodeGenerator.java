/**
 * $Id$
 * Copyright 2012-2014 Oak Pacific Interactive. All rights reserved.
 */
package t2d.util;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import t2d.util.bean.Class;
import t2d.util.bean.Column;
import t2d.util.bean.Field;
import t2d.util.bean.Table;

/**
 * @author <a href="mailto:xiaowei.hu@renren-inc.com">Xiaowei Hu</a>
 * @version 1.0 2012-10-11 下午06:27:44
 * @since 1.0
 */
public class CodeGenerator {

    private NameConvertor convertor;

    private Table table;

    public CodeGenerator(NameConvertor convertor, Table table) {
        super();
        this.convertor = convertor;
        this.table = table;
    }

    public void generate() {
        Class cls = table2Class(table);
        
        File file = new File("c:/" + cls.getClsName() + ".java");
        if (file.exists()) {
            file.delete();
        }

        PrintWriter out = null;
        try {
            file.createNewFile();
            
            out = new PrintWriter(file);
            out.println("/**");
            out.println(" * generate by t2d");
            out.println(" */");
            
            //package
            
            //import
            out.println();
            for (String importCls : cls.getImportClasses()) {
                out.println("import " + importCls + ";");
            }
            
            //class
            out.println();
            out.println("public class " + cls.getClsName() + " {");
            
            //field
            for (Field field : cls.getListField()) {
                out.println();
                out.println("    private " + field.getType().javaType + " " + field.getFieldName() + ";");
            }
            
            //default constructor
            out.println();
            out.println("    public " + cls.getClsName() + "() {}");
            
            //getter and setter
            for (Field field : cls.getListField()) {
                //setter
                out.println();
                out.println("    public void set" + firstLetterUpper(field.getFieldName()) + "(" + field.getType().javaType + " " + field.getFieldName() + ") {");
                out.println("        this." + field.getFieldName() + " = " + field.getFieldName() + ";");
                out.println("    }");
                
                //getter
                out.println();
                out.println("    public " + field.getType().javaType + " get" + firstLetterUpper(field.getFieldName()) + "() {");
                out.println("        return " + field.getFieldName() + ";");
                out.println("    }");
            }
            
            //end
            out.println();
            out.println("}");
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
    
    public Class table2Class(Table tab) {
        List<Field> listField = new ArrayList<Field>();
        List<String> importClasses = new ArrayList<String>();
        for (Column col : tab.getListColumn()) {
            Field field = new Field(firstLetterLower(convertor.convert(col.getName())), Type.mapping(col.getType()));
            listField.add(field);
            
            if (field.getType() == Type.DATE && !importClasses.contains("java.util.Date")) {
                importClasses.add("java.util.Date");
            }
        }
        
        Class cls = new Class(null, importClasses, convertor.convert(tab.getTableName()), listField);
        
        return cls;
    }
    
    private String firstLetterLower(String input) {
        char c = input.charAt(0);
        return ((char)(c + 32)) + input.substring(1, input.length());
    }
    
    private String firstLetterUpper(String input) {
        char c = input.charAt(0);
        return ((char)(c - 32)) + input.substring(1, input.length());
    }
    
    public static void main(String[] args) {
        
        CodeGenerator cg = new CodeGenerator(new DefaultNameConvertor(), JdbcUtils.getTable("games_kp", "user_gift_box"));
        cg.generate();
    }
}
