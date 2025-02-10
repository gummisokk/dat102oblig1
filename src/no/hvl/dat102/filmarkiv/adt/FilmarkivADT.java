package no.hvl.dat102.filmarkiv.adt;

import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

public interface FilmarkivADT {
    /**
    * Hentar ein film med gitt nr frå arkivet
    * @param nr nummer på film som skal hentast.
    * @return film med gitt nr. Om nr ikkje finnast, returnerast null.
    */
    Film finnFilm(int nr);

    /**
    * Leggjer til ein ny film.
    * @param nyFilm
    */
    void leggTilFilm(Film nyFilm);

    /**
    * Slettar ein film med gitt nr
    * @param filmnr nr på film som skal slettast
    * @return true dersom filmen vart sletta, false ellers
    */
    boolean slettFilm(int filmnr);

    /**
    * Søkjer og hentar Filmar med ein gitt delstreng i tittelen.
    * @param delstreng som må væra i tittel
    * @return tabell med filmar som har delstreng i tittel
    */
    Film[] soekTittel(String delstreng);

    /**
    * Søkjer og hentar filmer med ein gitt delstreng i filmprodusent
    * @param delstreng
    * @return
    */
    Film[] soekProdusent(String delstreng);

    /**
    * Finner antall filmar med gitt sjanger
    * @param sjanger
    * @return antall filmar av gitt sjanger.
    */
    int antall(Sjanger sjanger);

    /**
    * @return antall filmar i arkivet
    */
    int antall();
}
