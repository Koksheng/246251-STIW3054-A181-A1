

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class crawler {

    public static List<Product> crawlData() throws IOException {
            List<Product> result = new ArrayList<Product>();
            Document doc = Jsoup.connect("https://ms.wikipedia.org/wiki/Malaysia").get();
            Elements trs = doc.select("table[class=wikitable]");
            Element row = trs.get(1);
            for (int i = 0; i <= 23; i++) {
                String th = row.select("th").get(i).text();
                String td = row.select("td").get(i).text();
                result.add(new Product(th, td));
            }
            return result;
    }
}

