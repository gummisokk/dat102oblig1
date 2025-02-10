package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
    Film[] arkiv;
    int len = 0;


    public Filmarkiv (int baseStorrelse){
        arkiv = new Film[baseStorrelse];
    }

    private void utvid(){
        Film[] nyTab = new Film[2 * arkiv.length];
        System.arraycopy(arkiv,0,nyTab,0,arkiv.length);
        arkiv = nyTab;
    }
    
    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < len; i++) {
            if (arkiv[i].getFilmNr() == nr){
                return arkiv[i];
            }
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (len == arkiv.length) {
            utvid();
        }
        arkiv[len++] = nyFilm;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < len; i++) {
            if (arkiv[i].getFilmNr() == filmnr){
                arkiv[i] = arkiv[--len];
                arkiv[len] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] soek = new Film[len];
        int telling = 0;
        for (int i = 0; i < len; i++) {
            if(arkiv[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())){
                soek[telling++] = arkiv[i];
            }
        }
        //compress array
        Film[] ret = new Film[telling];
        System.arraycopy(soek, 0, ret, 0, telling);
        return ret;
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] soek = new Film[len];
        int telling = 0;
        for (int i = 0; i < len; i++) {
            if(arkiv[i].getProdusent().toLowerCase().contains(delstreng.toLowerCase())){
                soek[telling++] = arkiv[i];
            }
        }
        return trimTab(soek);
    }

    private Film[] trimTab(Film[] tab) {
        int telling = 0;
        for (Object film : tab) {
            if (film != null){
                telling++;
            }
        }

        Film[] ret = new Film[telling];
        System.arraycopy(tab, 0, ret, 0, telling);
        return ret;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int telling = 0;
        for (int i = 0; i < len; i++) {
            if(arkiv[i].getSjanger() == sjanger){
                telling++;
            }
        }
        return telling;
    }

    @Override
    public int antall() {
        return len;
    }

}
