package nio;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class DirList {
    public static void main(String[] args) {
        String dirname = "/home/name/Documents";
        try (DirectoryStream<Path> directoryStream =
                     Files.newDirectoryStream(Paths.get(dirname))) {
            System.out.println("Directory " + dirname + " " + directoryStream.toString());
            for (Path path : directoryStream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isDirectory()) {
                    System.out.print("<DIR> ");
                } else System.out.print("      ");
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DirList2 {
    public static void main(String[] args) {
        String dirname = "/home/name/Documents";
        DirectoryStream.Filter<Path> how = Files::isExecutable;
        try (DirectoryStream<Path> dirstream =
                     Files.newDirectoryStream(Paths.get(dirname), how)) {
            System.out.println("Directory " + dirname + " " + dirstream.toString());
            for (Path path : dirstream) {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                if (attributes.isDirectory()) {
                    System.out.print("<DIR> ");
                } else System.out.print("      ");
                System.out.println(path.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}