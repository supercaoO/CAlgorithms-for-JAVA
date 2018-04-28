package com.caoO.test;

import com.caoO.algorithms.CByte;
import com.caoO.algorithms.CMath;
import com.caoO.std.StdDraw;
import com.caoO.utils.compress.Rar;
import com.caoO.utils.compress.SevenZ;
import com.caoO.utils.compress.Zip;
import com.caoO.utils.Xmls;

import java.io.*;
import java.math.BigDecimal;

public class InfoEntropys {

    /// the absolute path of the source file
    private static String absolutePath;
    /// the source file's name
    private static String srcFileName;
    private static int step = 0;

    public static void main(String[] args) {
        // Create the samples
        String[] samples = createSamples();
        // Print the information entropy of all samples
        double[] infoEntropys = new double[samples.length];
        for (int i = 0; i < samples.length; i++) {
            System.out.println("的信息熵H(s)为" + (infoEntropys[i] = getInfoEntropy(samples[i])));
        }
        // Draw the histogram of result
        infoEntroyHistogram(infoEntropys);
    }

    /**
     * Create the samples from source file.
     */
    public static String[] createSamples() {
        // Set the absolute path and name
        setAbsolutePathAndName();
        // Compress source file into a 7z file
        String b = SevenZ.compress("B", absolutePath + srcFileName, absolutePath);
        // Compress 7z file into a zip file
        String c = Zip.compress("C", b, absolutePath);
        // Compress 7z file into a rar file
        String d = Rar.compress("D", b, absolutePath);
        // Compress 7z file into a another 7z file
        String e = SevenZ.compress("E", b, absolutePath);
        // return samples
        return new String[] { absolutePath + srcFileName, b, c, d, e };
    }

    /// Set the absolute path and source file's name
    private static void setAbsolutePathAndName() {
        absolutePath = Xmls.parse("./srcdata.xml", "source-file/url");
        srcFileName = Xmls.parse("./srcdata.xml", "source-file/name");
    }

    /**
     * Calculate the information entropy of the specified file.
     *
     * @param filePath the full path of file
     * @return the information entropy
     */
    public static double getInfoEntropy(String filePath) {
        try (InputStream is = new BufferedInputStream(new FileInputStream(new File(filePath)))) {
            // Read and count bits
            BigDecimal[] num = { BigDecimal.ZERO, BigDecimal.ZERO };
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = is.read(flush))) {
                for (int i = 0; i < len; i++) {
                    String binaryStr = CByte.toBinaryString(flush[i]);
                    for (int j = 0; j < binaryStr.length(); j++) {
                        if (binaryStr.charAt(j) == '0')
                            num[0] = num[0].add(BigDecimal.ONE);
                        else
                            num[1] = num[1].add(BigDecimal.ONE);
                    }
                }
            }

            // Calculate the information entropy
            BigDecimal total = num[0].add(num[1]);
            System.out.print(filePath + "(0的个数:" + num[0] + ", " + "1的个数为:" + num[1] + ", " + "总数为" + total + ")");
            probabilityHistogram(num);
            double hs = 0;
            for (int i = 0; i < num.length; i++) {
                hs += num[i].divide(total, 16, BigDecimal.ROUND_HALF_UP).multiply(BigDecimal.valueOf(
                        CMath.log(total.divide(num[i], 16, BigDecimal.ROUND_HALF_UP).doubleValue(), 2))).doubleValue();
            }
            return hs;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /// Show data visually by histogram and so on
    private static void infoEntroyHistogram(double[] infoEntropys) {
        for (int i = 0; i < infoEntropys.length; i++) {
            // Draw the histogram
            StdDraw.setPenColor(StdDraw.BOOK_BLUE);
            StdDraw.filledRectangle(1.0 / infoEntropys.length * (i + 0.25 + 0.5 * 5 / 6), infoEntropys[i] / 2,
                    1.0 / infoEntropys.length / 4 / 3, infoEntropys[i] / 2);
            // Draw the data
            StdDraw.setPenColor();
            StdDraw.text(1.0 / infoEntropys.length * (i + 0.8), infoEntropys[i] / 2,
                    Double.toString(infoEntropys[i]), 270);
            // Draw the line
            StdDraw.setPenColor(StdDraw.RED);
            if (i != 0)
                StdDraw.line(1.0 / infoEntropys.length * (i - 0.25 - 0.5 / 6), infoEntropys[i - 1],
                        1.0 / infoEntropys.length * (i + 0.25 + 0.5 * 5 / 6), infoEntropys[i]);
        }
    }

    /// Show probability data visually by histogram and so on
    private static void probabilityHistogram(BigDecimal[] num) {
        BigDecimal total = num[0].add(num[1]);
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.filledRectangle(0.2 * (step + 0.25 + 0.5 / 6), num[0].divide(total.multiply(BigDecimal.valueOf(2)),
                16, BigDecimal.ROUND_HALF_UP).doubleValue(), 0.2 / 4 / 3,
                num[0].divide(total.multiply(BigDecimal.valueOf(2)), 16, BigDecimal.ROUND_HALF_UP).doubleValue());
        StdDraw.text(0.2 * (step + 0.25 + 0.5 / 6), num[0].divide(total, 16, BigDecimal.ROUND_HALF_UP).doubleValue() + 0.01, "0");
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.filledRectangle(0.2 * (step + 0.25 + 0.5 / 2), num[1].divide(total.multiply(BigDecimal.valueOf(2)),
                16, BigDecimal.ROUND_HALF_UP).doubleValue(), 0.2 / 4 / 3,
                num[1].divide(total.multiply(BigDecimal.valueOf(2)), 16, BigDecimal.ROUND_HALF_UP).doubleValue());
        StdDraw.text(0.2 * (step + 0.25 + 0.5 / 2), num[1].divide(total, 16, BigDecimal.ROUND_HALF_UP).doubleValue() + 0.01, "1");
        step++;
    }
}
