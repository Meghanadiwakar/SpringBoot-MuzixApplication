package com.stackroute.service;

import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
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
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        if( trackRepository.existsById(track.getTrackId()))
        {
            throw new TrackAlreadyExistsException("Track Already Exist");
        }
        Track savedTrack=trackRepository.save(track);
        if( savedTrack == null )
        {
            throw new TrackAlreadyExistsException("Track list empty");
        }

        return savedTrack;
    }

    //update lists of tracks
    @Override
    public Track updateTrack(int trackId, String comment) throws TrackNotFoundException {
        Optional<Track> track=trackRepository.findById(trackId);
        Track track1=track.get();
        track1.setComment(comment);
        if( !trackRepository.existsById(trackId))
        {
            throw new TrackNotFoundException("Track Not Found for Updation ");
        }
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
    public List<Track> deleteById(int trackId) throws TrackNotFoundException{
        if( !trackRepository.existsById(trackId) )
        {
            throw new TrackNotFoundException("Track Not Found by Id!!");
        }
        trackRepository.deleteById(trackId);
        return trackRepository.findAll();
    }

    //get or retrieve track by id
    @Override
    public Optional<Track> getTrackById(int trackId) throws TrackNotFoundException
    {

        if(trackRepository.existsById(trackId))
        {
            return trackRepository.findById(trackId);
        }
        else {
            throw new TrackNotFoundException("Track is not present of given Id");
        }

    }
    //retrieve or get track by name
    @Override
    public Track trackByName(String trackName) throws TrackNotFoundException{
        if( trackRepository.findByTrackName(trackName) == null )
        {
            throw new TrackNotFoundException("Track with this TrackName does not Exist!!");
        }
        return trackRepository.findByTrackName(trackName);
    }


}