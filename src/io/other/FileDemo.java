package io.other;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileDemo {

    static void p(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) throws IOException {
        File f1 = new File("src/io/.comb.txt");
        p("File name: " + f1.getName());
        p("File path: " + f1.getPath());
        p("File absolute path: " + f1.getAbsolutePath());
        p("File parent directory: " + f1.getParent());
        p("File isExist: " + f1.exists());
        p("File canWrite: " + f1.canWrite());
        p("File canRead: " + f1.canRead());
        p("File canExecute: " + f1.canExecute());
        p("File isDirectory: " + f1.isDirectory());
        p("File isFile: " + f1.isFile());
        p("File isAbsolute: " + f1.isAbsolute());
        p("File isHidden: " + f1.isHidden());
        p("File length: " + f1.length());
        p("File lastModified: " + f1.lastModified());
        p("File toPath: " + f1.toPath());
        p("File setWritable: " + f1.setWritable(true));
        p("File renameTo: " + f1.renameTo(new File("src/io/.new_comb.txt")));
    }
}

class DirList {

    static List<File> files = new ArrayList<>();

    public static void main(String[] args) {
        String dirName = "/home/name/IdeaProjects";
        File f1 = new File(dirName);
        getFiles(f1);
        files.stream().filter(filenmae -> filenmae.getName().endsWith("java"))
                .forEach(System.out::println);
    }

    static List<File> getFiles(File file) {
        if (file.exists() && !file.isDirectory()) {
            files.add(file);
        }
        for (File f : Objects.requireNonNull(file.listFiles())) {
            if (f.exists() && f.isDirectory()) {
                getFiles(f);
            } else files.add(f);
        }
        return files;
    }
}