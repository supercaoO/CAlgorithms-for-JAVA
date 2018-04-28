package com.caoO.utils.compress;

import com.caoO.utils.Xmls;

public class Rar {

    /// compress cmd
    private static String rarCmd;

    /// initialization of rarCmd
    static {
        rarCmd = Xmls.parse("./srcdata.xml", "compress/rar/cmd");
    }

    /**
     * Compress a file into RAR format.
     *
     * @param rarName Compressed filename excluding suffix
     * @param fileName File name with absolute path to compress
     * @param destDir Storage path of compressed files
     * @return Compressed filename including suffix
     */
    public static String compress(String rarName, String fileName, String destDir) {
        String absoluteRarCmd = rarCmd + destDir + rarName + ".rar" + " " + fileName;
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(absoluteRarCmd);
            if (p.waitFor() == 0) {
                System.out.println(destDir + rarName + ".rar压缩成功");
                return destDir + rarName + ".rar";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
