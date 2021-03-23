package filesystem.file;

import filesystem.FileComponent;

public class File extends FileComponent {

    protected long size;

    public File(String name, long size) {
        this.size = size;
        this.name = name;
    }

    public long getSize() {
        return size;
    }
}
