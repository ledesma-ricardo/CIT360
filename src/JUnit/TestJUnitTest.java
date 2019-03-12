/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUnit;


import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author RALedesma
 */
public class TestJUnitTest {
    
     TestJUnit Lebron =new TestJUnit("Lebron James",31,"The King");
    @Test
    public void ewals() throws Exception 
    {
        assertEquals("Lebron James",Lebron.getPlayer());

    }

    @Test
    public void equals() throws Exception
    {
        assertNotEquals(7,Lebron.getAge());
    }

    @Test
    public void notnull() throws Exception 
    {
        assertNotNull(Lebron.getAge());
    }

    @Test
    public void same() throws Exception 
    {
        assertSame("The King",Lebron.isNickname());

    }

    @Test
    public void that() throws Exception 
    {
        assertThat(Lebron.getAge(),is(notNullValue()));
    }
    
}
