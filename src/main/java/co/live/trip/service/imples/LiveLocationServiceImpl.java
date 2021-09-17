package co.live.trip.service.imples;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Service;

import co.live.trip.exception.Http400;
import co.live.trip.model.Location;
import co.live.trip.service.LiveLocationService;

/**
 * Live location service for handle concurrent update of locations each location
 * must be registered before call update
 */
@Service
public class LiveLocationServiceImpl<K> implements LiveLocationService<K> {

    private Map<K, Location> liveLocationMap;

    public LiveLocationServiceImpl() {
        this.liveLocationMap = new ConcurrentHashMap<>();
    }

    @Override
    public void registerLocation(K key) {
        this.liveLocationMap.put(key, new Location());
    }

    @Override
    public void updateLocationDetails(K key, double lat, double lng) {
        Location location = this.liveLocationMap.get(key);
        if (location == null)
            throw new Http400(); // TODO this error must be change to http independent error
        location.setLat(lat); // TODO concurrent problem : set and get methods must be synchronized
        location.setLng(lng); // TODO concurrent problem : set and get methods must be synchronized
    }

    @Override
    public void detachLocation(K key) {
        this.liveLocationMap.remove(key);
    }
}
