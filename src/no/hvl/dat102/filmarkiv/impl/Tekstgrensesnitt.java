package no.hvl.dat102.filmarkiv.impl;

import java.util.Scanner;
import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Tekstgrensesnitt {
    Scanner scanner = new Scanner(System.in);
    
    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){
        System.out.println("Skriv inn filmTittel: ");
        String tittel = scanner.nextLine();
        System.out.println("Skriv inn produsent: ");
        String produsent = scanner.nextLine();
        System.out.println("Skriv inn lanseringsår: ");
        int lanseringsAar = Integer.parseInt(scanner.nextLine());
        System.out.println("Skriv inn sjanger: ");

        String sjangerSoek = scanner.nextLine();

        Sjanger sjanger = Sjanger.finnSjanger(sjangerSoek);

        System.out.println("Skriv inn filmselskap: ");

        String filmSelskap = scanner.nextLine();

        return new Film(produsent,tittel,lanseringsAar,sjanger,filmSelskap);
    }

    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {
        System.out.print(film.toString());
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] soekres = arkiv.soekTittel(delstreng);
        for (Film film : soekres) {
            skrivUtFilm(film);
        }
        if (soekres.length <= 0){
            System.out.println("ingen resultat");
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] soekres = arkiv.soekProdusent(delstreng);
        for (Film film : soekres) {
            skrivUtFilm(film);
        }
        if (soekres.length <= 0){
            System.out.println("ingen resultat");
        }
    }

    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
    // og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("antall filmar: " + arkiv.antall());
        for (Sjanger sjanger : Sjanger.values()) {
            System.out.println("antall " + sjanger.name() + " filmar: " + arkiv.antall(sjanger));
        }
    }

    public String getInput(){
        return scanner.nextLine();
    }
}
