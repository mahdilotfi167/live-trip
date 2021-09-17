package co.live.trip.service;

public interface LiveLocationService<K> {
    public void registerLocation(K key);

    public void updateLocationDetails(K key, double lat, double lng);

    public void detachLocation(K key);
}
