package com.caoO.utils.compress;

import com.caoO.utils.Xmls;

public class Zip {

    /// compress cmd
    private static String zipCmd;

    /// initialization of sevenZCmd
    static {
        zipCmd = Xmls.parse("./srcdata.xml", "compress/zip/cmd");
    }

    /**
     * Compress a file into ZIP format.
     *
     * @param zipName Compressed filename excluding suffix
     * @param fileName File name with absolute path to compress
     * @param destDir Storage path of compressed files
     * @return Compressed filename including suffix
     */
    public static String compress(String zipName, String fileName, String destDir) {
        String absoluteZip = zipCmd + destDir + zipName + ".zip" + " " + fileName;
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(absoluteZip);
            if (p.waitFor() == 0) {
                System.out.println(destDir + zipName + ".zip压缩成功");
                return destDir + zipName + ".zip";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
