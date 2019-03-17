package komisSamochodowy;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Komis {


    public static void main(String[] args) {
        List<Samochod> samochody = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWitaj w komisie samochodowym!\n");


        int wybor = 0;
        do {
            System.out.println("\n1. Dodawanie nowego samochodu");
            System.out.println("2. Wyświetlanie listy samochodów");
            System.out.println("3. Usuwanie wprowadzonych samochodów");
            System.out.println("4. Wyjscie z programu\n");
            System.out.println("Wybierz jedną z powyzszych opcji");
            wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    dodawaniesamochodu(samochody);
                    break;
                case 2:
                    if (samochody.isEmpty())
                        System.out.println("Lista jest pusta, dodaj samochód");
                    else {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Lista samochodów:\n");
                        System.out.println(samochody.toString() + "\n");
                        int wybor2 = 0;
                        do {
                            System.out.println("Dostępne opcje: ");
                            System.out.println("Sortowanie samochodów - wybierz 1");
                            System.out.println("Filtrowanie samochodów - wybierz 2");
                            wybor2 = scanner2.nextInt();
                            if (wybor2 == 1)
                                sortowaniesamochodow(samochody);
                            if (wybor2 == 2)
                                filtrowaniesamochodow(samochody);
                        } while (wybor2 > 2 || wybor2 < 1);
                    }
                    break;
                case 3:
                    if (samochody.isEmpty())
                        System.out.println("Lista jest pusta, dodaj samochód");
                    else
                        usuwaniesamochodu(samochody);
                    break;
                case 4:
                    break;
            }

        } while (wybor != 4);

    }

    public static void dodawaniesamochodu(List<Samochod> auta) {
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
        System.out.println("Dodano \n" + samochod);
    }

    public static void usuwaniesamochodu(List auta) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Która pozycje z Listy samochodów chcesz usunąc?" +
                " Aktualna ilosc pozycji na liscie: " + auta.size());
        int indeks = scanner.nextInt();
        while (indeks > auta.size() || indeks < 1) {

            System.out.println("Poza granicami listy, sprobuj ponownie");
            indeks = scanner.nextInt();
        }
        auta.remove(indeks - 1);
        System.out.println("Pozycja " + indeks + " usunięta");
    }

    public static void sortowaniesamochodow(List<Samochod> auta) {
        Scanner parametrsorotwania = new Scanner(System.in);
        int parametr = 0;
        do {
            System.out.println("Wybrno sortowanie samochodów, po jakim parametrze chcesz sortowac?");
            System.out.println("1. Kolor \n2. Cena \n3. Ilosc drzwi \n4. Marka \n5. Przebieg \n6. Rocznik");
            parametr = parametrsorotwania.nextInt();
        } while (parametr < 1 || parametr > 6);
        if (parametr == 1) {
            auta.stream()
                    .sorted(Comparator.comparing(Samochod::getKolor))
                    .forEach(System.out::println);
        }
        if (parametr == 2) {
            auta.stream()
                    .sorted((o1, o2) -> o1.getCena().compareTo(o2.getCena()))  // 1 sposob
                    .sorted((Samochod o1, Samochod o2) -> {                 // 2 sposob
                        BigDecimal cena1 = o1.getCena();
                        BigDecimal cena2 = o2.getCena();
                        return cena1.compareTo(cena2);
                    })
                    .forEach(System.out::println);
        }
        if (parametr == 3) {
            auta.stream()
                    .sorted((o1, o2) -> ((Integer) o1.getIloscDrzwi()).compareTo(o2.getIloscDrzwi())) //castowanie na Integera z compareTo
                    .forEach(System.out::println);
        }

        if (parametr == 4) {
            auta.stream()
                    .sorted(Comparator.comparing(Samochod::getMarka))
                    .forEach(System.out::println);
        }
        if (parametr == 5) {
            auta.stream()
                    .sorted(((o1, o2) -> o1.getPrzebieg() - o2.getPrzebieg()))    // sposob z odejmowanie intow
                    .forEach(System.out::println);
        }
        if (parametr == 6) {
            auta.stream()
                    .sorted(Comparator.comparing(Samochod::getRocznik))
                    .forEach(System.out::println);
        }

    }

    public static void filtrowaniesamochodow(List<Samochod> auta) {
        Scanner parametrfiltrowania = new Scanner(System.in);
        Scanner wartosc = new Scanner (System.in);
        int parametr = 0;
        do {
            System.out.println("Wybrano filtrowanie samochodów, Po jakim parametrze chcesz filtorwać?");
            System.out.println("1. Kolor \n2. Cena \n3. Ilosc drzwi \n4. Marka \n5. Przebieg \n6. Rocznik");
            parametr = parametrfiltrowania.nextInt();
        } while (parametr < 1 || parametr > 6);
        if (parametr == 1) {
            System.out.println("Podaj jakiego koloru szukasz");
            String kolor = wartosc.next();
            auta.stream()
                    .filter(samochod -> samochod.getKolor().equals(kolor))
                    .forEach(System.out::println);


        }
        if (parametr == 2) {
            System.out.println("Podaj jakiej ceny szukasz");
            BigDecimal cena = wartosc.nextBigDecimal();
            auta.stream()
                    .filter(samochod -> samochod.getCena() == cena)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        }
        if (parametr == 3) {
            System.out.println("Podaj jakiej ilosc drzwi szukasz");
            int iloscdrzwi = wartosc.nextInt();
            auta.stream()
                    .filter(samochod -> samochod.getIloscDrzwi() == iloscdrzwi)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


        }
        if (parametr == 4) {
            System.out.println("Podaj jakiej marki szukasz");
            String marka = wartosc.next();
            auta.stream()
                    .filter(samochod -> samochod.getMarka().equals(marka))
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        }
        if (parametr == 5) {
            System.out.println("Podaj jakiego przebiegu szukasz");
            int przebieg = wartosc.nextInt();
            auta.stream()
                    .filter(samochod -> samochod.getPrzebieg() == przebieg)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);


        }
        if (parametr == 6) {
            System.out.println("Podaj jakiego roczniku szukasz");
            int rocznik = wartosc.nextInt();
            auta.stream()
                    .filter(samochod -> samochod.getRocznik() == rocznik)
                    .collect(Collectors.toList())
                    .forEach(System.out::println);

        }

    }
}
