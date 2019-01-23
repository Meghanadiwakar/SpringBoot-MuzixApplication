package com.stackroute.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Track {
    @Id
    private int trackId;
    private String trackName;
    private String comment;
}
