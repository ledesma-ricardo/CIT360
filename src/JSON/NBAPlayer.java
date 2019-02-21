/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSON;

import java.util.*;

/**
 *
 * @author RALedesma
 */
public class NBAPlayer {
 
   private String name;
	private String nickname;
	private String position;
	private List<String> skills;
        
     //getters and setters   

    public NBAPlayer(String name, String nickname, String position, List<String> skills) {
        this.name = name;
        this.nickname = nickname;
        this.position = position;
        this.skills = skills;
    }

    NBAPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPosition() {
        return position;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
