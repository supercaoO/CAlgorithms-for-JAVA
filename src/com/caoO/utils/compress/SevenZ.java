package com.caoO.utils.compress;

import com.caoO.utils.Xmls;

public class SevenZ {

    /// compress cmd
    private static String sevenZCmd;

    /// initialization of sevenZCmd
    static {
        sevenZCmd = Xmls.parse("./srcdata.xml", "compress/sevenZ/cmd");
    }

    /**
     * Compress a file into 7Z format.
     *
     * @param sevenZName Compressed filename excluding suffix
     * @param fileName File name with absolute path to compress
     * @param destDir Storage path of compressed files
     * @return Compressed filename including suffix
     */
    public static String compress(String sevenZName, String fileName, String destDir) {
        String absoluteSevenZCmd = sevenZCmd + destDir + sevenZName + ".7z" + " " + fileName;
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec(absoluteSevenZCmd);
            if (p.waitFor() == 0) {
                System.out.println(destDir + sevenZName + ".7z压缩成功");
                return destDir + sevenZName + ".7z";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
