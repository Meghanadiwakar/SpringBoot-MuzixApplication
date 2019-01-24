package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;

import java.util.List;
import java.util.Optional;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExistsException;

    public List<Track> getAllTracks();

    public Track updateTrack(int trackId, String comment)throws TrackNotFoundException;

    public List<Track> deleteById(int trackId) throws TrackNotFoundException;

    public Optional<Track> getTrackById(int trackId)throws TrackNotFoundException;

    public Track trackByName(String trackName)throws TrackNotFoundException;

}