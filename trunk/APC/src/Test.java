
import com.apc.cache.FileCache;
import com.apc.cache.MemoryCache;
import com.apc.processing.FileUtils;
import com.apc.processing.StringUtils;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author APopov
 */
public class Test {

    public static void main(String[] args) {
        FileCache fileCache = FileCache.getInstance();
        MemoryCache memoryCache = MemoryCache.getInstance();
        FileUtils fileUtils = FileUtils.getInstance();
        StringUtils stringUtils = StringUtils.getInstance();
        int a = 0, b = 1500;
        String tempKey = a + "|" + b;
        String temp = "";
        for (int i = 0; i < 9; i++) {
            tempKey = a + "|" + i;
            if (memoryCache.containsInMemory(tempKey)) {
                temp = memoryCache.getFromMemory(tempKey);
                System.out.println("Читаю из мемори кэша...");
            } else if (fileCache.containsInFile(tempKey)) {
                temp = fileCache.getFromFile(tempKey);
                memoryCache.putInMemory(tempKey, temp);
                System.out.println("Читаю из файла кэша...");
            } else {
                temp = fileUtils.readFileToString("C://111.txt", "Cp1251", a, a + i);
                memoryCache.putInMemory(tempKey, temp);
                fileCache.putInFile(tempKey, temp);
                System.out.println("Читаю из файла...");
            }
        }
//        System.out.println(temp);
        String[] strs = stringUtils.getSortedStringData(temp);
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);
        }
        long[] longs = stringUtils.getSortedNumData(temp);
        for (int i = 0; i < longs.length; i++) {
            System.out.println(longs[i]);
        }
        System.out.println(temp);
    }
}
