/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ACP;
import java.util.HashMap;
/**
 *
 * @author RALedesma
 */
public class AppController {
     private HashMap<String,ACPhandler> handlerMap = new HashMap();

    public void handleRequest(String command, HashMap<String,Object> data){
        ACPhandler aCommandHandler = handlerMap.get(command);
        if (aCommandHandler != null){
            aCommandHandler.handleIt(data);
        }
    }

    public void handleCommand(String aCommand, ACPhandler acpHandler){
        handlerMap.put(aCommand,acpHandler);
    }
}
