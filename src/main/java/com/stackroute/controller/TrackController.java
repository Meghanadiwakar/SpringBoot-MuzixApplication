package com.stackroute.controller;


import com.stackroute.domain.Track;
import com.stackroute.exceptions.TrackAlreadyExistsException;
import com.stackroute.exceptions.TrackNotFoundException;
import com.stackroute.service.TrackService;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/v1")

public class TrackController {
    private TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    /*
    save track method
     */
    @PostMapping(value = "track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExistsException {
        return new ResponseEntity<Track>(trackService.saveTrack(track),HttpStatus.CREATED);
//        ResponseEntity responseEntity;
//        try {
//            trackService.saveTrack(track);
//            responseEntity = new ResponseEntity<String>("successfully created", HttpStatus.CREATED);
//        } catch (Exception ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
//        }
//        return responseEntity;
    }

    /*
    get all tracks method
     */
    @GetMapping("tracks")
    public ResponseEntity<?> getAllTracks() throws TrackNotFoundException {
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(), HttpStatus.OK);
    }

    /*
    update the tracks method
     */
    @PutMapping(value = "track/{trackId}/{comment}")
    public ResponseEntity<?> updateTrack(@PathVariable int trackId,@PathVariable String comment)throws TrackNotFoundException {
        trackService.updateTrack(trackId,comment);
        return new ResponseEntity<String>("Successfully Updated", HttpStatus.ACCEPTED);

//        ResponseEntity responseEntity;
//        try {
//            trackService.updateTrack(trackId,comment);
//            responseEntity = new ResponseEntity<String>("successfully updated", HttpStatus.ACCEPTED);
//        } catch (Exception ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.NOT_MODIFIED);
//        }
//        return responseEntity;
    }

    /*
    delete the track method
     */
    @DeleteMapping("track/{trackId}")
    public ResponseEntity<?> deleteById(@PathVariable int trackId) throws TrackNotFoundException{
        trackService.deleteById(trackId);
        return new ResponseEntity<String>("Successfully deleted",HttpStatus.OK);

//        ResponseEntity responseEntity;
//        try {
//            trackService.deleteById(trackId);
//            responseEntity = new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
//        } catch (Exception ex) {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
//        }
//        return responseEntity;

    }

    /*
    Get Track by Id Method
     */

    @GetMapping(value = "/track/{trackId}")
    public ResponseEntity<Optional<Track>> getByIdTrack(@PathVariable String trackId) throws TrackNotFoundException
    {
        return new ResponseEntity<Optional<Track>>(trackService.getTrackById(Integer.parseInt(trackId)),HttpStatus.FOUND);
//
//        ResponseEntity responseEntity;
//        try {
//
//            return new ResponseEntity<Optional<Track>>(trackService.getTrackById(Integer.parseInt(trackId)),HttpStatus.FOUND);
//        }
//        catch (Exception ex)
//        {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
//        }
//        return responseEntity;
    }

    /*
    Get Track by track name method
     */

    @GetMapping(value = "tracks/{trackName}")
    public ResponseEntity<Track> getByTrackName(@PathVariable String trackName) throws TrackNotFoundException
    {
        return new ResponseEntity<Track>(trackService.trackByName(trackName),HttpStatus.FOUND);

//        ResponseEntity responseEntity;
//        try {
//            responseEntity = new ResponseEntity<Track>(trackService.trackByName(trackName),HttpStatus.FOUND);
//        }
//        catch (Exception ex)
//        {
//            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
//        }
//        return responseEntity;
    }


}