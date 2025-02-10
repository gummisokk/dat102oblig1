package no.hvl.dat102.filmarkiv.test;

import java.io.Console;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public class FilmarkivTest {
    

    private Filmarkiv lagTestData() {
        Filmarkiv arkiv = new Filmarkiv(1);
        arkiv.leggTilFilm(new Film(
            "Yngve Sæther",
            "Mannen som elsket Yngve",
            2008,
            Sjanger.DRAMA,
            "Motlys, Sandrew Metronome"
        ));
        
        arkiv.leggTilFilm(new Film(
            "Jeffrey Katzenberg, Aron Warner, John H. Williams, Steven Spielberg",
            "Shrek",
            2001,
            Sjanger.FANTASY,
            "DreamWorks, Pacific Data Images, DreamWorks Animation"
        ));
        
        arkiv.leggTilFilm(new Film(
            "Tommy Wiseau",
            "The Room",
            2003,
            Sjanger.DRAMA,
            "Wiseau-Films"
        ));

        return arkiv;
    }

    @Test
    public void testAntall() {
        Filmarkiv a = lagTestData();
        assertEquals(a.antall(), 3);
    }

    @Test
    public void testAntall2() {
        Filmarkiv a = lagTestData();
        assertEquals(a.antall(Sjanger.DRAMA), 2);
    }

    @Test
    public void testFinnFilm() {
        Filmarkiv a = lagTestData();
        System.out.println(a.finnFilm(1));
    }

    @Test
    public void testLeggTilFilm() {
        Filmarkiv a = lagTestData();
        a.leggTilFilm(new Film(
            "Adam Sandler, Jack Giarraputo, Neal H. Moritz, Steve Koren, Mark O'Keefe",
            "Click",
            2006,
            Sjanger.KOMEDIE,
            "Columbia Pictures, Revolution Studios, Happy Madison Productions, Original Film, Sony Pictures "
        ));
        assertEquals(a.antall(), 4);
    }

    @Test
    public void testSlettFilm() {
        Filmarkiv a = lagTestData();
        a.slettFilm(2);
        assertEquals(a.antall(), 2);
    }

    @Test
    public void testSoekProdusent() {
        Filmarkiv a = lagTestData();
        for (Film film : a.soekProdusent("Spielberg")) {
            System.out.println(film.toString());
        }
    }

    @Test
    public void testSoekTittel() {
        Filmarkiv a = lagTestData();
        for (Film film : a.soekTittel("Sh")) {
            System.out.println(film.toString());
        }
    }
}
