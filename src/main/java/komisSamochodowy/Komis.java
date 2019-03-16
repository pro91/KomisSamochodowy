package komisSamochodowy;

import java.math.BigDecimal;
import java.util.Scanner;

public class Komis {


    public static void main(String[] args) {


        System.out.println("Witaj w komisie samochodowym! Wybierz jedną z poniższych opcji\n");
        System.out.println("1. Dodawanie nowego samochodu");
        System.out.println("2. Wyświetlanie listy samochodów");
        System.out.println("3. Usuwanie wprowadzonych samochodów");
        Scanner scanner = new Scanner(System.in);
        int wybor = 0;
        do {
            wybor = scanner.nextInt();
            switch (wybor) {
                case 1:
                    System.out.println("Wybrano dodanie nowego samochodu");

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("błędny wybór");
                    break;
            }
        } while (1 > wybor && wybor > 4);

    }

}
