package myLabrairy;

import java.io.File;

public class FileFilter implements java.io.FilenameFilter {
    private String mask;

    public FileFilter (String mask) {
        setMask (mask);
    }

    public String getMask () {
        return mask;
    }

    public void setMask (String mask) {
        this.mask = mask;
    }

    @Override
    public boolean accept(File f, String name) {
        return name.indexOf (mask) > 0;
    }
}
