package com.stackroute.service;

import com.stackroute.domain.Track;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track);

    public List<Track> getAllTracks();

    public Track updateTrack(Track track);

    public List<Track> deleteById(int trackId);

    public Track findTrackByName(String trackName);


}
