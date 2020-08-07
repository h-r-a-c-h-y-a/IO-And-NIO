package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;

public class PathDemo {
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("/home/name/IdeaProjects/io_and_nio_package/src/a/s/d/g/h/fhgjrg.txt");
        System.out.println("Filename: " + filePath.getFileName());
        System.out.println("Name1: " + filePath.getName(1));
        System.out.println("Name2: " + filePath.getName(0));
        System.out.println("Filepath: " + filePath);
        System.out.println("Filepath resolve: " + filePath.resolve("src/a/s/d/g/h/fhgjrg.txt"));
        System.out.println("File absolute path: " + filePath.toAbsolutePath());
        System.out.println("File parent path: " + filePath.getParent());
        System.out.println("File file system: " + filePath.getFileSystem().toString());
        System.out.println("Filename count: " + filePath.getNameCount());
        System.out.println("File root: " + filePath.getRoot());
        System.out.println("File normalize: " + filePath.normalize());
        BasicFileAttributes attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
        System.out.println("File is directory: " + attributes.isDirectory());
        System.out.println("File is regular file: " + attributes.isRegularFile());
        System.out.println("File is symbolic link: " + attributes.isSymbolicLink());
        System.out.println("File is other: " + attributes.isOther());
        System.out.println("File last modification time: " + attributes.lastModifiedTime());
        System.out.println("File size: " + attributes.size());
        System.out.println("File last access time: " + attributes.lastAccessTime());
        System.out.println("File creation time: " + attributes.creationTime());
        DosFileAttributes dos  = Files.readAttributes(filePath, DosFileAttributes.class);
        System.out.println("is archive dos: " + dos.isArchive());
        System.out.println("is hidden dos: " + dos.isHidden());
        System.out.println("is read only dos: " + dos.isReadOnly());
        System.out.println("is system dos: " + dos.isSystem());
        PosixFileAttributes posix = Files.readAttributes(filePath, PosixFileAttributes.class);
        System.out.println("group name posix: " + posix.group().getName());
        System.out.println("owner name posix: " + posix.owner().getName());
        posix.permissions().forEach(x -> System.out.print(x + " "));
    }
}
