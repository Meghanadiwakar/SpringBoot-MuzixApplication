package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackServiceImpl implements TrackService {

    TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;

    }
//save track
    @Override
    public Track saveTrack(Track track){
        Track savedTrack=trackRepository.save(track);
        return savedTrack;
    }

    //update lists of tracks
    @Override
    public Track updateTrack(int trackId, String comment){

        Optional<Track> track=trackRepository.findById(trackId);
        Track track1=track.get();
        track1.setComment(comment);
        Track savedTrack=trackRepository.save(track1);
        return savedTrack;
    }
//get all tracks
    @Override
    public List<Track> getAllTracks(){
        return trackRepository.findAll();
    }


    //delete track by id
    @Override
    public List<Track> deleteById(int trackId){
        trackRepository.deleteById(trackId);
        return trackRepository.findAll();
    }

    //get or retrieve track by id
    @Override
    public Optional<Track> getTrackById(int trackId)
    {

        if(trackRepository.existsById(trackId))
        {
            return trackRepository.findById(trackId);
        }
        return null;

    }
//retrieve or get track by name
    @Override
    public Track trackByName(String trackName) {
        return trackRepository.findByTrackName(trackName);
    }


}
