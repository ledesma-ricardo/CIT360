/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;

/**
 *
 * @author RALedesma
 */
public class TestJUnit {
      String player;
    int age =0;
    String nickname;


    public TestJUnit(String player, int age, String nickname) 
    {
        this.player = player;
        this.age = age;
        this.nickname = nickname;
    }

    public void setPlayer(String player) 
    {

        this.player = player;
    }

    public void setAge(int age) 
    {
        this.age = age;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }

    public String getPlayer() 
    {

        return player;
    }

    public int getAge() 
    {
        return age;
    }

    public String isNickname() 
    {
        return nickname;
    }
}
