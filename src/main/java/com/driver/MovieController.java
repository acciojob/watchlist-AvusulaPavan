package com.driver;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.directory.SearchResult;
import java.util.List;

@RestController
public class MovieController {

    MovieService movieService;

    @PostMapping("/movies/add-movie")
    public ResponseEntity<String> addMovie(Movie movie){

        String msg=movieService.addMovie(movie);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
    @PostMapping("/movies/add-director")
    public ResponseEntity<String> addDirector(Director director){
        String msg=movieService.addDirector(director);
        return new ResponseEntity<>(msg,HttpStatus.CREATED);
    }
    @PutMapping("/movies/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(String movie, String director){

        String msg=movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(String movie){
        Movie m=movieService.getMovieByName(movie);
        return new ResponseEntity<>(m, HttpStatus.CREATED);
    }
    @GetMapping(" /movies/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(String director){
        Director d=movieService.getDirectorByName(director);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(String director){
        List<String> ar=movieService.getMoviesByDirectorName(director);
        return new ResponseEntity<>(ar, HttpStatus.CREATED);
    }
    @GetMapping("/movies/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> ar=movieService.findAllMovies();
        return new ResponseEntity<>(ar, HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(String name){

        String msg=movieService.deleteDirectorByName(name);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
    @DeleteMapping("/movies/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        String msg=movieService.deleteAllDirectors();
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }
}
