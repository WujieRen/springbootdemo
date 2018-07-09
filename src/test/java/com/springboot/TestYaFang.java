package com.springboot;

import org.junit.Test;

import java.io.*;

/**
 * Created by renwujie on 2018/01/09 at 10:39
 */
public class TestYaFang {
    public static void main(String[] args){

        FileReader reader = null;

        try {
            StringBuffer sb = new StringBuffer("");

            reader = new FileReader("T:\\WorkspaceGithub\\lemon\\demo1\\src\\test\\java\\com\\springboot\\TestYaFang.txt");
            BufferedReader br = new BufferedReader(reader);

            String str = null;
            int i = 0;

            while ((str = br.readLine()) != null) {
                if(i > 1){
                    sb.append(str);
                    //System.out.println(str);
                }
                i++;
            }

            System.out.println(sb);

            String[] fields = sb.toString().split(";");
            for(String field : fields){
                if(!field.contains(">") && field.contains("[")){
                    System.out.println(field.split("\\\\")[0].split("=")[2].trim());
                }
            }





        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean biggerrLess(String value) {
        if(Integer.parseInt(value) < 1.0) {

        } else {

        }
        return false;
    }

    @Test
    public void testSlogan() {
        //\u00A0 is a new line
        System.out.println("\u00A0是一个换行符");
    }
}
