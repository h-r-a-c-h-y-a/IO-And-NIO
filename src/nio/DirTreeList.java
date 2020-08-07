package nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class DirTreeList {
    public static void main(String[] args) {
        String dirname = "/home/name/Documents";
        System.out.println("directory tree, start with " + dirname + ":\n");
        try {
            Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyFileVisitor extends SimpleFileVisitor<Path>{
    @Override
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        if (!path.isAbsolute()){
            return FileVisitResult.CONTINUE;
        }
        System.out.println("path is not absolute");
        return FileVisitResult.TERMINATE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
        e.printStackTrace();
        return super.visitFileFailed(path, e);
    }

    @Override
    public FileVisitResult postVisitDirectory(Path path, IOException e) throws IOException {
        Files.createFile(Paths.get(path + "/created_file.txt"));
        return super.postVisitDirectory(path, e);
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes attributes){
        System.out.println(path);
        return FileVisitResult.CONTINUE;
    }
}
