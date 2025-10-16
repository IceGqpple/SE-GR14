package org.Gruppe14.core.service;

import org.Gruppe14.core.port.BrukerRepositoryPort;

public class BrukerService {
    private BrukerRepositoryPort brukerRepositoryPort;

    public BrukerService(BrukerRepositoryPort brukerRepositoryPort){
        this.brukerRepositoryPort = brukerRepositoryPort;
    }


}
