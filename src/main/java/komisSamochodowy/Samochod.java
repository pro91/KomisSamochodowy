package komisSamochodowy;

import java.math.BigDecimal;

public class Samochod {

    private String kolor;
    private BigDecimal cena;
    private int iloscDrzwi;
    private String marka;
    private int przebieg;
    private int rocznik;

    public Samochod(String kolor, BigDecimal cena, int iloscDrzwi, String marka, int przebieg, int rocznik) {
        this.kolor = kolor;
        this.cena = cena;
        this.iloscDrzwi = iloscDrzwi;
        this.marka = marka;
        this.przebieg = przebieg;
        this.rocznik = rocznik;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getIloscDrzwi() {
        return iloscDrzwi;
    }

    public void setIloscDrzwi(int iloscDrzwi) {
        this.iloscDrzwi = iloscDrzwi;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public int getPrzebieg() {
        return przebieg;
    }

    public void setPrzebieg(int przebieg) {
        this.przebieg = przebieg;
    }

    public int getRocznik() {
        return rocznik;
    }

    public void setRocznik(int rocznik) {
        this.rocznik = rocznik;
    }

    @Override
    public String toString() {
        return "Samochod{" +
                "kolor='" + kolor + '\'' +
                ", cena=" + cena +
                ", iloscDrzwi=" + iloscDrzwi +
                ", marka='" + marka + '\'' +
                ", przebieg=" + przebieg +
                ", rocznik=" + rocznik +
                '}';
    }
}
