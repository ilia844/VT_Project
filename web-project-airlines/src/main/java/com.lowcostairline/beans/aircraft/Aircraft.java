package com.lowcostairline.beans.aircraft;


import com.lowcostairline.beans.Entity;

import java.util.Objects;

/**
 * aircraft is a class that implements basic
 * characteristics for all aircraft.
 * An aircraft object encapsulates the state information,
 * such as:
 * <ul>
 *    <li>Model of the current aircraft</li>
 *    <li>Amount of the seats</li>
 *    <li>Type of the current aircraft</li>
 *    <li>Fuel supply</li>
 *    <li>Information about the presence of the luggage compartment</li>
 *    <li>Amount of the emergence exits</li>
 * </ul>
 * @author Marta Gulida
 * @version 1.0
 */
public class Aircraft extends Entity implements java.io.Serializable {
    /** Field model */
    private String model;

    /** Field amount of the seats*/
    private int seatAmount;

    /** Field fuel supply */
    private int tankCapacity;

    /**
     * Set the model field in the value given in the brackets
     * {@link Aircraft#model}
     *
     * @param model model of the aircraft
     */
    public void setModel(String model){
        this.model = model;
    }

    /**
     *  Get the model of the aircraft
     *  {@link Aircraft#model}
     *
     * @return  string  Return model name
     */
    public String getModel(){
        return model;
    }

    /**
     * Set the amount of the seats field
     * {@link Aircraft#seatAmount}
     *
     * @param seatAmount    amount of the seats
     */
    public void setSeatAmount(int seatAmount){
        this.seatAmount = seatAmount;
    }

    /**
     * Get the amount of the seats in the aircraft
     * {@link Aircraft#seatAmount}
     *
     * @return  int Returns amount of the seats
     */
    public int getSeatAmount(){
        return seatAmount;
    }


    /**
     * Set the fuel supply field
     * {@link Aircraft#tankCapacity}
     *
     * @param tankCapacity    amount of the fuel, which is needed for aircraft
     */
    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    /**
     * Get the fuel supply
     * {@link Aircraft#tankCapacity}
     *
     * @return  float   Returns fuel supply for aircraft
     */
    public int getTankCapacity() {
        return tankCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Aircraft aircraft = (Aircraft) o;
        return seatAmount == aircraft.seatAmount &&
                tankCapacity == aircraft.tankCapacity &&
                Objects.equals(model, aircraft.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), model, seatAmount, tankCapacity);
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "model='" + model + '\'' +
                ", seatAmount=" + seatAmount +
                ", tankCapacity=" + tankCapacity +
                '}';
    }
}
