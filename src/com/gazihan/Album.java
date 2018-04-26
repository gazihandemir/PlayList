package com.gazihan;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {

    private String albumAdi;
    private String sanatciAdi;
    private ArrayList<Sarki> sarkilar;

    public Album(String albumAdi, String sanatciAdi) {
        this.albumAdi = albumAdi;
        this.sanatciAdi = sanatciAdi;
        sarkilar = new ArrayList<Sarki>();
    }

    public boolean sarkiEkle(String sarkiAdi, Double sarkiSuresi) {
        if (sarkiBul(sarkiAdi) == null) {
            Sarki s = new Sarki(sarkiAdi, sarkiSuresi);
            this.sarkilar.add(s);
            return true;
        } else {
            System.out.println("eklemek istediginiz şarki zaten var ");
            return false;
        }
    }

    private Sarki sarkiBul(String sarkiAdi) {
        for (Sarki oAnkiSarki : sarkilar) {
            if (oAnkiSarki.getSarkiAdi().equals(sarkiAdi)) {
                return oAnkiSarki;
            }
        }
        return null;
    }

    public boolean oynatmaListesineEkle(String sarkiAdi, LinkedList<Sarki> oynatmaListesi) {
        Sarki eklencekSarki = sarkiBul(sarkiAdi);
        if (eklencekSarki != null) {
            oynatmaListesi.add(eklencekSarki);
            return true;
        } else {
            System.out.println(sarkiAdi + "bir albümde kayıtlı degil ");
            return false;
        }
    }

    public boolean oynatmaListesineEkle(int sarkiNumarasi, LinkedList<Sarki> oynatmaListesi) {
        int index = sarkiNumarasi - 1;
        if ((index >= 0) && (index <= this.sarkilar.size())) {
            oynatmaListesi.add(this.sarkilar.get(index));
            return true;
        } else {
            System.out.println("bu albümde belirtilen sarkı yok ");
            return false;
        }
    }

}
