package com.gazihan;

import java.util.*;

public class Main {

    private static ArrayList<Album> tumAlbumler = new ArrayList<Album>();

    public static void main(String[] args) {
        Album teomaninAlbumu = new Album("17", "teoman");
        teomaninAlbumu.sarkiEkle("hayal perest", 4.10);
        teomaninAlbumu.sarkiEkle("gemiler olsun", 3.50);
        teomaninAlbumu.sarkiEkle("iki yabanci ", 5.10);
        teomaninAlbumu.sarkiEkle("soluk soluga", 2.15);
        tumAlbumler.add(teomaninAlbumu);
        Album yildizTilbeAlbumu = new Album("anca gidersin", "yildiz tilbe");
        yildizTilbeAlbumu.sarkiEkle("bin dereden su getirsen", 3.40);
        yildizTilbeAlbumu.sarkiEkle("delikanlim", 3.30);
        yildizTilbeAlbumu.sarkiEkle("vazgectim", 3.50);
        yildizTilbeAlbumu.sarkiEkle("ama evlesin", 3.54);
        tumAlbumler.add(yildizTilbeAlbumu);

        LinkedList<Sarki> oynatmaListesi = new LinkedList<Sarki>();
        tumAlbumler.get(0).oynatmaListesineEkle("hayal perest", oynatmaListesi);
        tumAlbumler.get(0).oynatmaListesineEkle("gemiler olsun", oynatmaListesi);
        //  tumAlbumler.get(0).oynatmaListesineEkle("asddsad",oynatmaListesi);
        tumAlbumler.get(0).oynatmaListesineEkle("soluk soluga", oynatmaListesi);

        tumAlbumler.get(1).oynatmaListesineEkle(1, oynatmaListesi);
        tumAlbumler.get(1).oynatmaListesineEkle(2, oynatmaListesi);
        tumAlbumler.get(1).oynatmaListesineEkle(3, oynatmaListesi);
        //   tumAlbumler.get(1).oynatmaListesineEkle(5,oynatmaListesi);
        oynat(oynatmaListesi);
    }

    private static void oynat(LinkedList<Sarki> oynatmaListesi) {
        Scanner veri = new Scanner(System.in);
        boolean cikis = false;
        boolean ileriDogrumuGidiliyor = true;
        ListIterator<Sarki> iterator = oynatmaListesi.listIterator();
        if (oynatmaListesi.size() == 0) {
            System.out.println("listeye henüz şarkı eklenmemiş");
            return;
        } else {
            System.out.println("şuan şalan şarkı : " + iterator.next().toString());
        }
        menuGoster();
        while (!cikis) {
            int kullaniciSecimi = veri.nextInt();
            switch (kullaniciSecimi) {
                case 0:
                    System.out.println("uygulamadan çıkılıyor ");
                    cikis = true;
                    break;
                case 1:
                    if (!ileriDogrumuGidiliyor) {
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        ileriDogrumuGidiliyor = true;
                    }
                    if (iterator.hasNext()) {
                        System.out.println("şuan ki çalan şarkı : " + iterator.next());
                    } else {
                        System.out.println("listenin sonuna geldiniz ");
                    }
                    break;
                case 2:

                    if (ileriDogrumuGidiliyor) {
                        if (iterator.hasPrevious()) {
                            iterator.previous();
                        }
                        ileriDogrumuGidiliyor = false;
                    }
                    if (iterator.hasPrevious()) {
                        System.out.println("şuan ki çalan şarkı " + iterator.previous());
                    } else {
                        System.out.println("listenin başına geldiniz ");
                    }
                    break;

                case 3:
                    if (ileriDogrumuGidiliyor) {
                        if (iterator.hasPrevious()) {
                            System.out.println("tekrar çalınan şarkı : " + iterator.previous());
                            ileriDogrumuGidiliyor = false;
                        } else {
                            System.out.println("listenin başındasınız");
                        }
                    } else {
                        if (iterator.hasNext()) {
                            System.out.println("tekrarlanan sarki : " + iterator.next());
                            ileriDogrumuGidiliyor = true;
                        } else {
                            System.out.println("listenin sonundayiz ");
                        }
                    }
                    break;
                case 4:
                    oynatmaListesiGoster(oynatmaListesi);
                    break;
                case 5:
                    menuGoster();
                    break;
            }
        }

    }

    private static void oynatmaListesiGoster(LinkedList<Sarki> oynatmaListesi) {
        Iterator<Sarki> iterator = oynatmaListesi.iterator();
        System.out.println("===============================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }

    private static void menuGoster() {
        System.out.println("Seçiminizi yapiniz");
        System.out.println("0-çıkış");
        System.out.println("1-bir sonraki şarkı");
        System.out.println("2-bir önceki şarkı");
        System.out.println("3-şarkıyı yeniden başlat");
        System.out.println("4-oynatma listesindeki tüm şarkılar ");
        System.out.println("5-menüyü göster");
    }
}
