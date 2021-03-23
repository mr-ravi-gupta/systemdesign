package filesystem;

public abstract class FileComponent {
    protected String name;

    public String getName() {
        return name;
    }

    public abstract long getSize();
}
