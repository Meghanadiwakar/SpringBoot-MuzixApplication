package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;

    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists");
        }
        Track savedTrack=trackRepository.save(track);
        if(savedTrack==null){
            throw new TrackAlreadyExistsException("track already exists");
        }
        return savedTrack;
    }

    @Override
    public Track updateTrack(Track track){
        Track updatedTrack=trackRepository.save(track);
        return updatedTrack;
    }

    @Override
    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }

    @Override
    public List<Track> deleteById(int trackId) throws TrackNotFoundException{
        if( !trackRepository.existsById(trackId) )
    {
        throw new TrackNotFoundException("ID is not found");
    }

        trackRepository.deleteById(trackId);
        return trackRepository.findAll();
    }

//    @Override
//    public int deleteTrack(int trackId) throws TrackNotFoundException {        if( !trackRepository.existsById(trackId) )
//    {
//        throw new TrackNotFoundException("ID is not found");
//    }
//        trackRepository.deleteById(trackId);
//        return 0;
//    }

    @Override
    public Track findTrackByName(String trackName) {

        Track tracks = trackRepository.findTrackByName(trackName);
        return tracks;
    }

//    @Override
//
//    public List<Track> getTrackByName(String trackName) throws TrackNotFoundException {
//        if( trackRepository.getTrackByName(trackName) == null )
//    {
//        throw new TrackNotFoundException("TrackName doesn't Exist");
//    }
//        return trackRepository.getTrackByName(trackName);
//    }
}




