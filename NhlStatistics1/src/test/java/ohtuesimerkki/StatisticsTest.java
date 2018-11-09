/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johyry
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    public StatisticsTest() {
        
    }

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchPlayerTest() {
        Player palautus = stats.search("Semenko");
        
        assertEquals(palautus.getName(), "Semenko");
    }
    
    @Test
    public void searchPlayerTestNotFound() {
        Player palautus = stats.search("Aho");
        
        assertEquals(palautus, null);
    }
    
    @Test
    public void playersOnTeamTest() {
        List<Player> lista = stats.team("PIT");
        
        assertEquals(lista.get(0).getName(), "Lemieux");
    }
    
    @Test
    public void topScorersTest() {
        List<Player> lista = stats.topScorers(1);
        
        assertEquals(lista.get(0).getGoals(), 35);
    }
}
