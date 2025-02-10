package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    
    public void start(){
        lagData();

        while (true){
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("Velg kva du vil gjere: ");
            System.out.println("    1. legg til film");
            System.out.println("    2. søk etter filmtittel");
            System.out.println("    3. søk etter filmprodusent");
            System.out.println("    4. sjå statestikk");
    
            int valg = Integer.parseInt(tekstgr.getInput());
            switch(valg){
                case 1 -> {
                    Film film = tekstgr.lesFilm();
                    this.filmarkiv.leggTilFilm(film);
                    System.out.println("Film lagt til");
                }
                case 2 -> {
                    System.out.println("skriv inn nøkkelord");
                    tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tekstgr.getInput());
                }
                case 3 -> {
                    System.out.println("skriv inn nøkkelord");
                    tekstgr.skrivUtFilmProdusent(filmarkiv, tekstgr.getInput());
                }
                case 4 -> tekstgr.skrivUtStatistikk(filmarkiv);
            }

            tekstgr.getInput();//vent til input før spør på nytt
        }
    }

    void lagData() {
        this.filmarkiv.leggTilFilm(new Film(
            "Yngve Sæther",
            "Mannen som elsket Yngve",
            2008,
            Sjanger.DRAMA,
            "Motlys, Sandrew Metronome"
        ));
        
        this.filmarkiv.leggTilFilm(new Film(
            "Jeffrey Katzenberg, Aron Warner, John H. Williams, Steven Spielberg",
            "Shrek",
            2001,
            Sjanger.FANTASY,
            "DreamWorks, Pacific Data Images, DreamWorks Animation"
        ));
        
        this.filmarkiv.leggTilFilm(new Film(
            "Tommy Wiseau",
            "The Room",
            2003,
            Sjanger.DRAMA,
            "Wiseau-Films"
        ));

        this.filmarkiv.leggTilFilm(new Film(
            "Adam Sandler, Jack Giarraputo, Neal H. Moritz, Steve Koren, Mark O'Keefe",
            "Click",
            2006,
            Sjanger.KOMEDIE,
            "Columbia Pictures, Revolution Studios, Happy Madison Productions, Original Film, Sony Pictures "
        ));
    }
}
    
