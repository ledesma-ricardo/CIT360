/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;
import java.io.File;
import java.io.IOException;

 
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
/**
 *
 * @author RALedesma
 */
public class JSONToJava {
    public static void main(String[] args) {
		JSONToJava obj = new JSONToJava();
		obj.run();
	}

	private void run() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
			NBAPlayer nbaplayer = mapper.readValue(new File("D:\\nbaplayer.json"), NBAPlayer.class);
			System.out.println(nbaplayer);

			// Convert JSON string to Object
			String jsonInString = "{\"name\":\"Lebron James\",\"position\":\"Small Forward\",\"skills\":[\"athletic\",\"highflyer\",\"stopper\"]}";
			NBAPlayer nbaplayer1 = mapper.readValue(jsonInString, NBAPlayer.class);
			System.out.println(nbaplayer1);

			//Pretty print
//			String prettyNBAPlayer1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(nbaplayer1);
//			System.out.println(prettyNBAPlayer1);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
