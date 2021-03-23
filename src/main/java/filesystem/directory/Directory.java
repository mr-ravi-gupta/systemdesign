package filesystem.directory;

import filesystem.FileComponent;
import filesystem.file.File;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Directory extends FileComponent {

    private List<FileComponent> files;

    public Directory(String name){
        this.name = name;
        files = new LinkedList<>();
    }

    public void addComponent(FileComponent fileComponent){
      files.add(fileComponent);
    }

    public long getSize() {
        return files.stream().map(FileComponent::getSize).reduce((a,b) -> a+b).get();
    }

    public long getAllFileCount(){
        Optional<Long> result = files.stream().filter(file -> file instanceof Directory)
                .map(dir -> ((Directory) dir).getAllFileCount()).reduce((a, b) -> a + b);
        return (result.isPresent()? result.get(): 0) + getImmediateFileCount();
    }
    public long getImmediateFileCount(){
        return files.stream().filter(file -> file instanceof File).count();
    }
    public long getImmediateDirCount(){
        return files.stream().filter(file -> file instanceof Directory).count();
    }
}
