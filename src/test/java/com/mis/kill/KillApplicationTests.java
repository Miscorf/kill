package com.mis.kill;

import com.mis.kill.pojo.ContourConfig;
import com.mis.kill.service.ContourConfigService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SpringBootTest
class KillApplicationTests {
    @Autowired
    private ContourConfigService contourConfigService;


    public static void main(String[] args) {
        System.out.println(BufferedReader("C:\\Users\\tyler\\Desktop\\input.txt"));
    }

    public static ArrayList<ArrayList<Integer>> BufferedReader(String path) {
        BufferedReader reader;
        String[] perm = new String[10];
        ArrayList<ArrayList<Integer>>  res = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(path));
            String line = null;
            while((line = reader.readLine())!=null){
                perm = line.split("\\s+");
                ArrayList<Integer> temp = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    temp.add(Integer.parseInt(perm[i]));
                }
                res.add(temp);
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;

    }

    @Test
    void contextLoads() {
    }
    @Test
    void testReadFile1() throws IOException {
        //文件内容：Hello World|Hello Zimug
        String fileName = "C:\\Users\\tyler\\Desktop\\input.txt";

//        try (Scanner sc = new Scanner(new FileReader(fileName))) {
//            while (sc.hasNextLine()) {  //按行读取字符串
//                String line = sc.nextLine();
//                System.out.println(line);
//            }
//        }
//
//        try (Scanner sc = new Scanner(new FileReader(fileName))) {
//            sc.useDelimiter("\\|");  //分隔符
//            while (sc.hasNext()) {   //按分隔符读取字符串
//                String str = sc.next();
//                System.out.println(str);
//            }
//        }

        //sc.hasNextInt() 、hasNextFloat() 、基础数据类型等等等等。
        //文件内容：1|2
        // fileName = "D:\\data\\test\\newFile5.txt";
        try (Scanner sc = new Scanner(new FileReader(fileName))) {
            sc.useDelimiter("\\s+");  //分隔符
            while (sc.hasNextInt()) {   //按分隔符读取Int
                int intValue = sc.nextInt();
                System.out.println(intValue);
            }
        }
    }

    @Test
    void ContourConfigTest(){
    contourConfigService.getContourConfig();
    }

    @Test
    void ContourService(){
        ContourConfig contourConfig = new ContourConfig();
        contourConfig.setId(0);
        contourConfigService.setContourConfig(contourConfig);
    }

}
