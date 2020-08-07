package io.char_stream;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class BufferedWriterDemo {
    public static void main(String[] args) {
        List<String> list = null;
        try (BufferedReader br = new BufferedReader(new FileReader("src/.new_comb.txt"))) {
            list = br.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list != null) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("c.txt"))) {
                list.stream().filter(s -> s.contains("CA SA")).forEach(s -> {
                    try {
                        bw.write(s + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
