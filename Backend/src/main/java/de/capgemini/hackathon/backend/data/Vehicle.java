package de.capgemini.hackathon.backend.data;

public enum Vehicle
{
    Fahrrad(0),
    Pkw_Benzin_Disel(143),
    Plug_In_Hybrid(90),
    Bus_Nahverkehr(80),
    Bahn_Nahverkehr(55),
    Flugzeug(214),
    Bus_Fernverkehr(29),
    Bahn_Fernverkehr(29);
    public final double co2;
    private Vehicle(double co2){
        this.co2 = co2;
    }
}
