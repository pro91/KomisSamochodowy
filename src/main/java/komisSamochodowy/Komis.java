package komisSamochodowy;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Komis {


    public static void main(String[] args) {
        List<Samochod> samochody = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Witaj w komisie samochodowym!\n");


        int wybor = 0;
        do {
            System.out.println("\n1. Dodawanie nowego samochodu");
            System.out.println("2. Wyświetlanie listy samochodów");
            System.out.println("3. Usuwanie wprowadzonych samochodów");
            System.out.println("4. Wyjscie z programu");
            System.out.println("Wybierz jedną z powyzszych opcji");
            wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    dodawaniesamochodu(samochody);
                    break;
                case 2:
                    if(samochody.isEmpty())
                        System.out.println("Lista jest pusta, dodaj samochód");
                        else
                    System.out.println(samochody.toString());
                    break;
                case 3:
                    if(samochody.isEmpty())
                        System.out.println("Lista jest pusta, dodaj samochód");
                    else
                    usuwaniesamochodu(samochody);
                    break;
                case 4:
                    break;
            }

        } while ( wybor != 4);

    }
        public static void dodawaniesamochodu(List auta){
            Samochod samochod = new Samochod();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Wybrano dodanie nowego samochodu");
            System.out.println("podaj kolor");
            samochod.setKolor(scanner.next());
            System.out.println("podaj cene");
            samochod.setCena(scanner.nextBigDecimal());
            System.out.println("podaj ilosc drzwi");
            samochod.setIloscDrzwi(scanner.nextInt());
            System.out.println("podaj marke");
            samochod.setMarka(scanner.next());
            System.out.println("podaj przebieg");
            samochod.setPrzebieg(scanner.nextInt());
            System.out.println("podaj rocznik");
            samochod.setRocznik(scanner.nextInt());
            auta.add(samochod);
            System.out.println(samochod);
    }
    public static void usuwaniesamochodu(List auta){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Która pozycje z Listy samochodów chcesz usunąc?" +
                " Aktualna ilosc pozycji na liscie: " + auta.size());
        int indeks = scanner.nextInt();
        while(indeks > auta.size() || indeks < 1){

            System.out.println("Poza granicami listy, sprobuj ponownie");
            indeks = scanner.nextInt();
        }
        auta.remove(indeks - 1);
        System.out.println("Pozycja " + indeks+ " usunięta");
    }
}
