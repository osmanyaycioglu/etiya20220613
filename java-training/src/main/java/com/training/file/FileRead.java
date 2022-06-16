package com.training.file;

import com.training.Araba;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileRead {
    public static void main(String[] args) {
        try {
            List<Araba> collect = Files.readAllLines(Paths.get("araba.txt"))
                                       .stream()
                                       .map(s -> s.split(","))
                                       .filter(sa -> sa.length == 4)
                                       .map(sa -> new Araba(sa[0],
                                                            sa[1],
                                                            Integer.parseInt(sa[2]),
                                                            Integer.parseInt(sa[3])))
                                       .collect(Collectors.toList());

            System.out.println(collect);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            FileInputStream inputStream = new FileInputStream(new File("araba.txt"));
//            byte[] bytes = new byte[1024];
//            int read = inputStream.read(bytes);
//        } catch (IOException e) {
//        }
//        try {
//            FileReader fileReader = new FileReader(new File("araba.txt"));
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            bufferedReader.readLine();
//        } catch (FileNotFoundException e) {
//        } catch (IOException e) {
//        }
//
//
//        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
//        try {
//            int read = inputStream.getChannel()
//                                  .read(byteBuffer);
//            long aLong = byteBuffer.getLong();
//        } catch (IOException e) {
//        }
    }
}
