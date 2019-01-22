package com.stackroute.service;

import com.stackroute.domain.Track;
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
    public Track saveTrack(Track track){
        Track savedTrack=trackRepository.save(track);
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
    public List<Track> deleteById(int trackId){
        trackRepository.deleteById(trackId);
        return trackRepository.findAll();
    }



}
