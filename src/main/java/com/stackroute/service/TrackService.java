package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

    public Track updateTrack(Track track);

    public List<Track> deleteById(int trackId);

    public Track findTrackByName(String trackName);

    public List<Track> getTrackById(int trackId) throws TrackNotFoundException;

    public int deleteTrack(int trackId) throws TrackNotFoundException;


}
