import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        System.out.println("Data collecting...");
        crawler.crawlData();
        convertExcel.convert();
    }
}
