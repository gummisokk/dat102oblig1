package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
    public class LinearNode<T> {
        public T data = null;
        public LinearNode<T> neste = null;
    }

    private int antall = 0;
    private LinearNode<Film> head = null;

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> current = head;
        do {
            if (current.data.getFilmNr() == nr){ 
                return current.data;
            }
            current = current.neste;
        } while (current.neste != null);
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyHead = new LinearNode<>();
        nyHead.neste = head;
        nyHead.data = nyFilm;
        head = nyHead;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> current = head;
        if (head.data.getFilmNr() == filmnr){
            head = head.neste;
            antall--;
            return true;
        }
        while (current != null) {
            if (current.neste.data.getFilmNr() == filmnr){ 
                current.neste = current.neste.neste;
                antall--;
                return true;
            }
            current = current.neste;
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        LinearNode<Film> current = head;
        Filmarkiv2 ret = new Filmarkiv2();
        while (current != null) {
            if (current.data.getTittel().toLowerCase().contains(delstreng.toLowerCase())){ 
                ret.leggTilFilm(current.data);
            }
            current = current.neste;
        }
        return ret.toArray();
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        LinearNode<Film> current = head;
        Filmarkiv2 ret = new Filmarkiv2();
        while (current != null) {
            if (current.data.getProdusent().toLowerCase().contains(delstreng.toLowerCase())){ 
                ret.leggTilFilm(current.data);
            }
            current = current.neste;
        } 
        return ret.toArray();
    }

    @Override
    public int antall(Sjanger sjanger) {
        int telling = 0;
        LinearNode<Film> current = head;
        while (current != null) {
            if (current.data.getSjanger() == sjanger){ 
                telling++;
            }
            current = current.neste;
        }
        return telling;
    }

    @Override
    public int antall() {
        return antall;
    }

    public Film[] toArray(){
        Film[] ret = new Film[antall];
        LinearNode<Film> current = head;
        int i = 0;
        while (current != null) {
            ret[i++] = current.data;
            current = current.neste;
        } 
        return ret;
    }

}