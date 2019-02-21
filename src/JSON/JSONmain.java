package JSON_Practice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class JSONmain {

    public static void main(String[] args) throws JsonProcessingException, IOException {

        NBAPlayer nbaPlayer = new NBAPlayer();
        nbaPlayer.setNickname("The King");
        nbaPlayer.setLastname("Lebron");
        nbaPlayer.setFirstname("James");
        nbaPlayer.setNumjersey(23);
        nbaPlayer.setSalary(BigDecimal.valueOf(35000000));

        ObjectMapper mapper = new ObjectMapper();

        // convertir la coleccion Java a JSON 
        String nbaPlayers_json;
        nbaPlayers_json = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(listaNBAPlayers());

        // convertir una lista JSON a Java
        List<NBAPlayer> emps = mapper.readValue(
                nbaPlayers_json,
                new TypeReference<List<NBAPlayer>>() {
                });

        // recorrer la lista de nbaPlayers
        emps.forEach(System.out::println);

        String json = mapper.writerWithDefaultPrettyPrinter()
                .withView(NBAPlayer.View1.class)
                .writeValueAsString(nbaPlayer);
        
        NBAPlayer emp;
        emp = mapper.readerWithView(NBAPlayer.View1.class)
                .forType(NBAPlayer.class)
                .readValue(json);

        System.out.println("OBJECT NBAPLAYER: \n" + emp);
        System.out.println("JSON OUTPUT: \n" + json);
    }

    private static List<NBAPlayer> listaNBAPlayers() {
        
        NBAPlayer nbaPlayer1 = new NBAPlayer();
        nbaPlayer1.setNickname("The Beard");
        nbaPlayer1.setLastname("James");
        nbaPlayer1.setFirstname("Harden");
        nbaPlayer1.setNumjersey(13);
        nbaPlayer1.setSalary(BigDecimal.valueOf(20000000));

        NBAPlayer nbaPlayer2 = new NBAPlayer();
        nbaPlayer2.setNickname("Greek Freak");
        nbaPlayer2.setLastname("Giannis");
        nbaPlayer2.setFirstname("Antetokounmpo");
        nbaPlayer2.setNumjersey(34);
        nbaPlayer2.setSalary(BigDecimal.valueOf(10000000));

        NBAPlayer nbaPlayer3 = new NBAPlayer();
        nbaPlayer3.setNickname("The Black Mamba");
        nbaPlayer3.setLastname("Kobe");
        nbaPlayer3.setFirstname("Bryant");
        nbaPlayer3.setNumjersey(24);
        nbaPlayer3.setSalary(BigDecimal.valueOf(24000000));

        return Arrays.asList(nbaPlayer1, nbaPlayer2, nbaPlayer3);
    }

}
