/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;
import java.io.File;
import java.io.IOException;
import java.util.*;
 
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author RALedesma
 */
public class JavaToJSON {
    public static void main(String[] args) {
		JavaToJSON obj = new JavaToJSON();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		NBAPlayer nbaplayer = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			mapper.writeValue(new File("D:\\nbaplayer.json"), nbaplayer);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(nbaplayer);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
//			String prettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nbaplayer);
//			System.out.println(prettyJson);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private NBAPlayer createDummyObject() {

		NBAPlayer nbaplayer = new NBAPlayer();

		nbaplayer.setName("Lebron James");
		nbaplayer.setNickname("The King");
		nbaplayer.setPosition("Small Forward");
		
                List<String> skills = new ArrayList<>();
		skills.add("athletic");
		skills.add("highflyer");
                skills.add("stopper");

		nbaplayer.setSkills(skills);

		return nbaplayer;

	}
}
