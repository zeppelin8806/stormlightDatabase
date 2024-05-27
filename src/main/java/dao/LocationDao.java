package dao;

import model.Location;

import java.util.List;

public interface LocationDao {

    Location getLocationById(int locationId);
    List<Location> getLocations();
    Location getLocationByPopulation(int population);
}
