package no.hvl.dat102.filmarkiv.impl;

public enum Sjanger {
    DRAMA,
    KOMEDIE,
    FANTASY,
    ACTION,
    HISTORY,
    SCIFI;

    public static Sjanger finnSjanger(String navn) {
        for (Sjanger s : Sjanger.values()) {
            if (s.toString().contains(navn.toUpperCase())) {
                return s;
            }
        }
        return null;
    }
}
