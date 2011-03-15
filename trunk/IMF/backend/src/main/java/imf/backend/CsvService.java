//package imf.backend;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.nio.charset.Charset;
//
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import imf.core.csv.CsvReader;
//
///**
// * Developed by: Andrey Popov
// * Date (time): 07.03.11 (12:05)
// */
//@Repository
//@Service("csvService")
//public class CsvService {
//    private CsvReader reader;
//
//    public CsvService() throws FileNotFoundException {
//        this.reader = new CsvReader("C://map.csv", ';', Charset.forName("utf-8"));
//    }
//
//    @Cacheable("values")
//    public String getValueByKey(String key) throws IOException {
//        this.reader = new CsvReader("C://map.csv", ';', Charset.forName("utf-8"));
//        String value = "";
//        while (reader.readRecord()) {
//            if (reader.get(0).trim().equals(key)) {
//                value = reader.get(1).trim();
//            }
//        }
//        return value;
//    }
//
//    @CacheEvict(value = "values", allEntries = true)
//    public void clear() {
//    }
//}
