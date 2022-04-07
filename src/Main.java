import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Choose one search option: ");
        System.out.println("1. Attribute name");
        System.out.println("2. City and State");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        if (option == 1) {
            System.out.println("Enter the attribute to search:");
            sc.nextLine();
            String attributeName = sc.nextLine();
            System.out.println("Search string:");
            String search = sc.nextLine();
            List<String> output = new ArrayList<>();
            if(attributeName.toLowerCase().equals("bank name")){
                output = searchInCSV(1, search);
            }
            else if(attributeName.toLowerCase().equals("type")){
                output = searchInCSV(2, search);
            }
            else if(attributeName.toLowerCase().equals("city")){
                output = searchInCSV(3, search);
            }
            else if(attributeName.toLowerCase().equals("state")){
                output = searchInCSV(4, search);
            }
            else if(attributeName.toLowerCase().equals("zip code")){
                output = searchInCSV(5, search);
            }
            System.out.println(output);
        } else if(option == 2){
            System.out.println("City name:");
            sc.nextLine();
            String cityName = sc.nextLine();
            System.out.println("State:");
            String stateName = sc.nextLine();
            List<String> output = searchInCSV(3, cityName);
            Iterator<String> listIterator = output.listIterator();
            while(listIterator.hasNext()){
                if(!listIterator.next().contains(stateName)){
                    listIterator.remove();
                }
            }
            System.out.println(output);
        }
    }

    /**
     * Search in csv
     * @param columnIndex
     * @param text
     * @return
     * @throws IOException
     */
    public static List<String> searchInCSV(int columnIndex, String text) throws IOException {
        List<String> result = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/test.csv"));
        String row;
        while ((row = bufferedReader.readLine()) != null) {
            String[] columns = row.split(",");
            if (columns[columnIndex].equals(text)) {
                result.add(row);
            }
        }
        bufferedReader.close();
        return result;
    }
}
