package no.hvl.dat102.filmarkiv.impl;

public class Film {
    static int filmsmade = 0;
    private int filmNr;
    private String produsent;
    private String tittel;
    private int lanseringsAar;
    private Sjanger sjanger;
    private String filmSelskap;

    public Film(){

    }

    public Film(
        String produsent,
        String tittel,
        int lanseringsAar,
        Sjanger sjanger,
        String filmSelskap
    ){
        filmsmade++;
        this.filmNr = filmsmade;
        this.produsent = produsent;
        this.tittel = tittel;
        this.lanseringsAar = lanseringsAar;
        this.sjanger = sjanger;
        this.filmSelskap = filmSelskap;
    }

    public int getFilmNr() {
        return filmNr;
    }

    public String getProdusent() {
        return produsent;
    }

    public String getTittel() {
        return tittel;
    }

    public int getLanseringsAar() {
        return lanseringsAar;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public String getFilmSelskap() {
        return filmSelskap;
    }

    public void setFilmNr(int filmNr) {
        this.filmNr = filmNr;
    }

    public void setProdusent(String produsent) {
        this.produsent = produsent;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public void setLanseringsAar(int lanseringsAar) {
        this.lanseringsAar = lanseringsAar;
    }

    public void setFilmSelskap(String filmSelskap) {
        this.filmSelskap = filmSelskap;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    @Override
    public int hashCode() {
        return filmNr * 31 * "Film".hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Film)) return false;
        return this.hashCode() == obj.hashCode();
    }

    @Override 
    public String toString(){
        return
            tittel + "(" +lanseringsAar+ ")\n" +
            "   produsent: " + produsent + "\n" +
            "   filmselskap: " + filmSelskap + "\n" +
            "   sjanger: " + sjanger.name() + "\n";
    }
}
