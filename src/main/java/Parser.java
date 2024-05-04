import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Parser {
    static List<Country> countries = new ArrayList<>();

    public static List<Country> sortByName(){
        List<Country> sortedByName = countries;
            Collections.sort(sortedByName, Comparator.comparing(Country::getName));
        //TODO
        return  sortedByName;
    }

    public static List<Country> sortByPopulation(){
        List<Country> sortedByPopulation = countries;
        Collections.sort(sortedByPopulation, Comparator.comparing(Country::getPopulation));
        Collections.reverse(sortedByPopulation);
        return sortedByPopulation;
    }

    public static List<Country> sortByArea(){
        List<Country> sortedByArea = countries;
        Collections.sort(sortedByArea, Comparator.comparing(Country::getArea));
        //TODO
        Collections.reverse(sortedByArea);
        return  sortedByArea ;
    }

    public static void setUp() throws IOException {
        try {
            File input = new File("D:\\university\\Term2\\AP\\FourthAssynmentHTML1\\Fourth-Assignment-HTML-Parser\\src\\Resources\\country-list.html"); // Replace with the actual file path
            Document doc = Jsoup.parse(input, "UTF-8");

            Elements countries1 = doc.select(".country");

            for (Element country : countries1) {
                try {
                int population = Integer.parseInt(country.select(".country-population").text());
                double area = Double.parseDouble(country.select(".country-area").text());
                String countryName = country.select(".country-name").text();
                String capital = country.select(".country-capital").text();
                countries.add(new Country(countryName, capital, population, area));
                } catch (NumberFormatException ex) {
                    System.err.println("Error parsing population or area for country: " + country.select(".country-name").text());
                    ex.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Iterate through each country div to extract country data
        //TODO
    }

    public static void main(String[] args) throws IOException {
        setUp();
        for (Country country : countries) {
                String countryName = country.getName();
                String capital = country.getCapital();
                int population = country.getPopulation();
                double area = country.getArea();

                System.out.println("Country: " + countryName);
                System.out.println("Capital: " + capital);
                System.out.println("Population: " + population);
                System.out.println("Area: " + area);
                System.out.println();
            }
        for (int i = 0 ; i < 50 ; i++)
            System.out.println("_______________________________________");
        sortByArea();
        for (Country country : countries) {
            String countryName = country.getName();
            String capital = country.getCapital();
            int population = country.getPopulation();
            double area = country.getArea();

            System.out.println("Country: " + countryName);
            System.out.println("Capital: " + capital);
            System.out.println("Population: " + population);
            System.out.println("Area: " + area);
            System.out.println();
        }
        sortByName() ;
        try {
            File input = new File("D:\\university\\Term2\\AP\\FourthAssynmentHTML\\Fourth-Assignment-HTML-Parser\\src\\Resources\\country-list.html"); // Replace with the actual file path
            Document doc = Jsoup.parse(input, "UTF-8");

            Elements countries2 = doc.select(".country");

            for (Element country : countries2) {
                String countryName = country.select(".country-name").text();
                String capital = country.select(".country-capital").text();
                String population = country.select(".country-population").text();
                String area = country.select(".country-area").text();

                System.out.println("Country: " + countryName);
                System.out.println("Capital: " + capital);
                System.out.println("Population: " + population);
                System.out.println("Area: " + area);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



