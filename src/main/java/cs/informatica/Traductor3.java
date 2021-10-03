package cs.informatica;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
//1 er:por defecto mi cuenta utec es predeterminada y las otras dos(tbn abiertas) no. Cerre todas menos utec
//2do :en la web de appscript esta usando el function que viene por defecto como error, lo borre y ahora
//3ro: devolvia html indicando que no encontraba la funcition doGet. Edite la implementacion hecha en appscript, pero cree una nueva y listo
//https://script.google.com/home/projects/1Z4MrimQmuw2dshaOFMhMA6v7rdQ5hYjMjnyxIp3xGqNvkZKirdSp3WHD/edit
public class Traductor3 {
    public static void main(String[] args) throws IOException {
        String text = "Hello world!";
        //Translated text: Hallo Welt!
        System.out.println("Translated text: " + translate("en", "es", text));
    }

    private static String translate(String langFrom, String langTo, String text) throws IOException {
        // INSERT YOU URL HERE
        String urlStr = "https://script.google.com/macros/s/AKfycbxa-LrvLxIgzkM6-BplfPD5ng0jBvEOlTpdQVivhsC_UvYwkRCHlYc10V0ahuhBPt4u/exec" +
                "?q=" + URLEncoder.encode(text, "UTF-8") +
                "&target=" + langTo +
                "&source=" + langFrom;
        URL url = new URL(urlStr);
        StringBuilder response = new StringBuilder();
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
}
