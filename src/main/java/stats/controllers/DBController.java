package stats.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stats.services.ConstructorService;
import stats.services.DriverService;
import stats.services.RaceService;

import java.io.IOException;

@RestController()
public class DBController {

    @Autowired
    private DriverService driverService;

    @Autowired
    private ConstructorService constructorService;

    @Autowired
    private RaceService raceService;

    @RequestMapping(path = "/api/db/load/drivers")
    public void setupDrivers() throws IOException {
        driverService.loadData();
    }

    @RequestMapping(path = "/api/db/load/constructors")
    public void setupConstructors() throws IOException {
        constructorService.loadData();
    }

    @RequestMapping(path = "/api/db/load/races")
    public void setupRaces() throws IOException {
        raceService.loadData();
    }
}
