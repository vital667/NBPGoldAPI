import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter data:");
        String s = scanner.next();

        try {
            String address = "http://api.nbp.pl/api/cenyzlota/" + s + "?format=json";
            URL url = new URL(address);

            JSONTokener tokener = new JSONTokener(url.openStream());
            JSONArray array = new JSONArray(tokener);
            JSONObject object = array.getJSONObject(0);

            System.out.println("Gold price is " + object.getDouble("cena"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.out.println("No data this day");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
