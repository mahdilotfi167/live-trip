package co.live.trip.controller.api.v1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.live.trip.controller.BaseController;
import co.live.trip.model.Location;
import co.live.trip.security.DriverAuthorization;
import co.live.trip.service.LiveLocationService;

@RestController
@DriverAuthorization
@RequestMapping("/api/v1/drivers")
public class DriverApiController extends BaseController {
    @Autowired
    private LiveLocationService<Integer> locationService;

    @GetMapping("test")
    public Map<Object, Object> test() {
        return Map.of("status", 200);
    }

    @PutMapping("/location") // TODO use oauth2 for authentication
    public Map<Object, Object> registerDriverLocation() {
        locationService.registerLocation(getUser().getId());
        return Map.of("status", 200);
    }

    @PatchMapping("/location")
    public Map<Object, Object> updateDriverLocation() {
        // this.locationService.updateLocationDetails(getUser().getId(), lat, lng);
        return Map.of("status", 200);
    }

    @DeleteMapping("location")
    public Map<Object, Object> deleteDriverLocation() {
        this.locationService.detachLocation(getUser().getId());
        return Map.of("status", 200);
    }
}