package filesystem;

import filesystem.directory.Directory;
import filesystem.file.File;

public class FileSystemTest {
    public static void main(String[] args) {
        FileComponent d = new File("d", 10);
        FileComponent c = new File("c", 20);
        FileComponent b = new File("b", 30);
        Directory A = new Directory("A");
        Directory B = new Directory("B");
        Directory C = new Directory("C");
        C.addComponent(d);
        B.addComponent(C);
        A.addComponent(B);
        A.addComponent(b);
        A.addComponent(c);
        System.out.println(A.getName());
        System.out.println(A.getImmediateDirCount());
        System.out.println(A.getImmediateFileCount());
        System.out.println(A.getAllFileCount());
        System.out.println(A.getSize());

    }
}
