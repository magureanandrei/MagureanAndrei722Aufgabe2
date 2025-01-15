package Modelle;

public class Medikamente {
    private String Name;
    private Integer Preis;
    private String Krankheit;

    public Medikamente(String Name, Integer Preis, String Krankheit) {
       this.Name = Name;
       this.Preis = Preis;
       this.Krankheit = Krankheit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getPreis() {
        return Preis;
    }

    public void setPreis(Integer preis) {
        Preis = preis;
    }

    public String getKrankheit() {
        return Krankheit;
    }

    public void setKrankheit(String krankheit) {
        Krankheit = krankheit;
    }

    @Override
    public String toString() {
        return "Medikamente{" +
                "Name='" + Name + '\'' +
                ", Preis=" + Preis +
                ", Krankheit='" + Krankheit + '\'' +
                '}';
    }
}
