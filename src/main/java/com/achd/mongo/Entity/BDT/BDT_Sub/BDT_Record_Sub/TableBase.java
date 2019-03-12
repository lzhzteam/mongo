package com.achd.mongo.Entity.BDT.BDT_Sub.BDT_Record_Sub;


import java.lang.reflect.Field;

public class TableBase {


    public StringBuilder getTableHtml() {

        StringBuilder resultDiv = new StringBuilder("<div>\n" +
                "<table class=\"table table-bordered table-sm table-striped\">\n");

        Field[] fields = this.getClass().getDeclaredFields();

        try {
            for (int j = 0; j < fields.length; j++) {
                resultDiv.append("<tr>\n");                                                 //tr开始
                fields[j].setAccessible(true);

                resultDiv.append("<th>").append(fields[j].getName()).append("</th>\n");     //拼出th

                if (fields[j].getType().getName().equals(java.lang.String.class.getName())) {
                    // String type
                    resultDiv.append("<td>").append(fields[j].get(this)).append("</td>\n");        //拼出值
                } else if (fields[j].getType().getName().equals(java.lang.Integer.class.getName()) || fields[j].getType().getName().equals("int")) {
                    // Integer type
                    resultDiv.append("<td>").append(fields[j].get(this)).append("</td>\n");      //拼出值
                } else if (fields[j].getType().getName().equals(java.lang.Boolean.class.getName()) || fields[j].getType().getName().equals("boolean")) {
                    // Boolean type
                    resultDiv.append("<td>").append(fields[j].get(this)).append("</td>\n");      //拼出值
                } else if (fields[j].getType().getName().equals(java.util.Date.class.getName())) {
                    // Date type
                    resultDiv.append("<td>").append(fields[j].get(this)).append("</td>\n");      //拼出值

                } else if (fields[j] == null || fields[j].getType() == null || fields[j].getType().getName() == null) {
                    resultDiv.append("<td>").append("空").append("</td>\n");      //拼出值
                } else {

                    resultDiv.append("<td>\n");

                    TableBase t = ((TableBase) fields[j].get(this));
                    if (t != null) {
                        resultDiv.append(t.getTableHtml());
                    } else {
                        resultDiv.append("空");
                    }

                    resultDiv.append("</td>\n");
                }

                resultDiv.append("</tr>\n");                                                //tr结束
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        resultDiv.append("</table>\n" +
                "</div>\n");

        return resultDiv;

    }


}
