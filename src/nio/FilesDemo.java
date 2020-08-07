package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.util.concurrent.TimeUnit;

public class FilesDemo {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("/home/name/IdeaProjects/io_and_nio_package/src/tennisLink");

        System.out.println("File exist: " + Files.exists(filePath));
        System.out.println("File is hidden: " + Files.isHidden(filePath));
        System.out.println("File is Writable: " + Files.isWritable(filePath));
        System.out.println("File is readable: " + Files.isReadable(filePath));
        System.out.println("File prob content type: " + Files.probeContentType(filePath));
        System.out.println("File size: " + Files.size(filePath));
        System.out.println("File store: " + Files.getFileStore(filePath));
        System.out.println("File owner name: " + Files.getOwner(filePath).getName());

        BasicFileAttributeView attributeView = Files.getFileAttributeView(filePath, BasicFileAttributeView.class, LinkOption.NOFOLLOW_LINKS);
//        attributeView.setTimes(FileTime.fromMillis(123253624252L), FileTime.fromMillis(384761764L), FileTime.from(467L, TimeUnit.SECONDS));
        System.out.println(attributeView.name());
//
//        Files.lines(filePath).parallel().forEach(System.out::println);
//        Files.lines(Paths.get(filePath.getParent() + "/.new_comb.txt")).
//                filter(line -> line.contains("CA SA")).map(result -> result.trim().replace(" ", "-")).forEach(System.out::println);
//        Files.createSymbolicLink(Paths.get(filePath.getParent() + "/tennisLink"), Paths.get("/home/name/Documents/changes/application/games/combination.txt"));
    }
}
