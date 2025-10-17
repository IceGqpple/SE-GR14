package model.core.service;


import model.core.port.BrukerRepositoryPort;

public class BrukerService {
    private BrukerRepositoryPort brukerRepositoryPort;

    public BrukerService(BrukerRepositoryPort brukerRepositoryPort){
        this.brukerRepositoryPort = brukerRepositoryPort;
    }


}
