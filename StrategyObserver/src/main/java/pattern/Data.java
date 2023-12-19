package pattern;

import java.io.File;

public abstract class Data {
    private File file;

    public Data(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }

}
