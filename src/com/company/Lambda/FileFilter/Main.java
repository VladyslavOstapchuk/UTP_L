package com.company.Lambda.FileFilter;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {

    }

    static File[] fileFilter(String dir, String ext, String afterDate) throws ParseException {
        long time = new SimpleDateFormat("yyyy-MM-dd").
                parse(afterDate).
                getTime();

        return new File(dir).
                        listFiles(f -> f.isFile() &&
                                f.getName().endsWith(ext) &&
                                f.lastModified() > time);
    }
}
