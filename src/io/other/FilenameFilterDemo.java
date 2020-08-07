package io.other;

import java.io.File;
import java.util.Arrays;

public class FilenameFilterDemo {
}

class DirListOnly{
    public static void main(String[] args) {
        String dirname = "/home/name/IdeaProjects/collections/src/util/collection";
        File f1 = new File(dirname);
        if(f1.isDirectory()){
        if (!f1.canRead()) f1.setReadable(true);
            String[] javaes = f1.list((file, name) -> name.endsWith("java"));
        Arrays.stream(javaes).forEach(System.out::println);
        }
    }
}

