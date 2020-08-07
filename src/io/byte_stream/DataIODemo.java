package io.byte_stream;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataIODemo {
    public static void main(String[] args) {
        double[] nums = new double[1000];
        Random r = new Random();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (r.nextDouble() * 10);
        }
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("src/nums.txt"))) {
            Arrays.stream(nums).forEach(num -> {
                try {
                    out.writeDouble(num);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DataIODemo2 {
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        try (DataInputStream in = new DataInputStream(new FileInputStream("src/nums.txt"))) {
            double d;
            while (in.available() > 0) {
                doubles.add(in.readDouble());
            }
            doubles.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DataIODemo3 {
    public static void main(String[] args){
        try(DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("src/file.txt"))){
        dataOut.writeUTF("Փողոցները, մեզ կանչում են հետ նորից\n" +
                "Ես էլ քայլում եմ, հագս էլ բռոն շորից\n" +
                "Կողս էլ մարդ չկա, ասում են հարց չկա\n" +
                "Հանդիպում եմ փողոցի հետ  ոնց որ  հանդիպեմ մի աղջկա\n" +
                "Click Clack bang bang փողոցներում լիքը\n" +
                "Մենքէ պտի հարմարվենք ու փորձենք բռնենք ալիքը\n" +
                "Կամ պտի մտնենք ալիքի մեջ, ասենք կամ չէ \n" +
                "Կամ էլ վերցնենք հեռախոսը գրանցենք քաղմաս կանչը\n" +
                "Ժամանակ չկա մեկնենք ձեռը կյանքին \n" +
                "Որտեվ սաղս հիմա պլենենք աշխատանքին\n" +
                "Կամ էլ հարգանքին, կամ էլ լոքշա մոտդ\n" +
                "Չառաջարկես խոտդտ, տունն էս թողէ ամոթդ\n" +
                "Ժամանակը անգինա գրումա գրչիս թանաքը\n" +
                "Մարդիկ էլ փորձում են վաճառեն դաժե ժամանակը\n" +
                "Մենք էլ քո վրա ուղղարկում ենք ռակետներ\n" +
                "Դու մի վախի  փախի փորձի օգտագործես իրենց\n" +
                "Փողոցները ինձ հուշել են հիշել են նշել եմ օրագրումս\n" +
                "Ես եմ էս երգերը հարցրէլ էս ովա գրում էս \n" +
                "Վեկալ վերջին տաբակս, ծխենք կես-կես\n" +
                "Ոնց կիսում եմ միտքս բիթով էս քեզ");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(DataInputStream dataIn = new DataInputStream(new FileInputStream("src/file.txt"))){
           String content;
            while (dataIn.available() > 0){
               content = dataIn.readUTF();
                System.out.print(content + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}