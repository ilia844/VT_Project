package com.lowcostairline.beans.airline.lowCostAirline;


import com.lowcostairline.beans.Entity;
import com.lowcostairline.beans.aircraft.Aircraft;
import com.lowcostairline.beans.crew.AircraftCrew;

import java.util.Objects;

/**
 * A class, which describe specific
 * characteristics of low cost airlines and
 * includes basic characteristics of all types
 * of the airlines. Such specific characteristics are:
 * <ul>
 *     <li>Category</li>
 *     <li>Information about the baggage (is payed or not)</li>
 *     <li>Information about the food (is payed or not)</li>
 * </ul>
 * @author Marta Gulida
 * @version 1.0
 */
public class LowCostAirlineTrip extends Entity {
    /** Field, that describes the category of the low cost airline(Ultra Lowcost, Middle Lowcost, Low Fare).*/
    private String category;

    private AircraftCrew pilot;
    private AircraftCrew steward;
    private Aircraft aircraft;


    /**
     * Get the category of the LowCost airline
     * {@link LowCostAirlineTrip#category}
     *
     * @return  String value, which describes the category
     */
    public String getCategory() {

        return category;
    }

    /**
     * Set the category of the LowCost airline
     * {@link LowCostAirlineTrip#category}
     *
     * @param category  String value, which describes the category
     */
    public void setCategory(String category) {

        this.category = category;
    }


    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public AircraftCrew getPilot() {
        return pilot;
    }

    public void setPilot(AircraftCrew pilot) {
        this.pilot = pilot;
    }

    public AircraftCrew getSteward() {
        return steward;
    }

    public void setSteward(AircraftCrew steward) {
        this.steward = steward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LowCostAirlineTrip that = (LowCostAirlineTrip) o;
        return Objects.equals(category, that.category) &&
                Objects.equals(pilot, that.pilot) &&
                Objects.equals(steward, that.steward) &&
                Objects.equals(aircraft, that.aircraft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), category, pilot, steward, aircraft);
    }
}
