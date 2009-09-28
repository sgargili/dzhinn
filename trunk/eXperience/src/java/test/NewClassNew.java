/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Admin4DB2
 */
public class NewClassNew {

    public static final int kEncode = 0;
    public static final int kDecode = 1;
    public static final int kBenchmak = 2;
    public int Command = -1;
    public int NumBenchmarkPasses = 10;
    public int DictionarySize = 1 << 23;
    public boolean DictionarySizeIsDefined = false;
    public int Lc = 3;
    public int Lp = 0;
    public int Pb = 2;
    public int Fb = 128;
    public boolean FbIsDefined = false;
    public boolean Eos = false;
    public int Algorithm = 2;
    public int MatchFinder = 1;
    public String InFile;
    public String OutFile;

    public static void main(String[] arg) throws IOException, Exception {
        boolean eos = false;
        if (true) {
            eos = true;
        }
        File fl = new File("C://testcsv.txt");
        BufferedInputStream inStream = new BufferedInputStream(FileUtils.openInputStream(fl));
        BufferedOutputStream outStream = new BufferedOutputStream(FileUtils.openOutputStream(new File("C://testcsv.7z")));

        if (true) {
            SevenZip.Compression.LZMA.Encoder encoder = new SevenZip.Compression.LZMA.Encoder();
            encoder.SetAlgorithm(0);
            encoder.SetDictionarySize(1 << 24);
            encoder.SetNumFastBytes(128);
            encoder.SetMatchFinder(1);
            encoder.SetLcLpPb(3, 0, 2);
            encoder.SetEndMarkerMode(true);
            encoder.WriteCoderProperties(outStream);
//            long fileSize;
//            if (eos) {
//                fileSize = -1;
//            } else {
//                fileSize = fl.length();
//            }
            for (int i = 0; i < 8; i++) {
                outStream.write((int) (fl.length() >>> (8 * i)) & 0xFF);
            }
            encoder.Code(inStream, outStream, -1, -1, null);
        }

        outStream.flush();

        outStream.close();

        inStream.close();

    }
}
