package com.driver;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    public ArrayList<Movie> mv=new ArrayList<>();
    public ArrayList<Director> dr=new ArrayList<>();
    public HashMap<Director,ArrayList<Movie>> mp=new HashMap<>();

    public String addMovie(Movie movie){
        for(int i=0;i<mv.size();i++){
            Movie m = mv.get(i);
            if(m.getName().equals(movie.getName()) && m.getDurationInMinutes() == movie.getDurationInMinutes() && m.getImdbRating() == movie.getImdbRating()){
                return "Movie already added.";
            }
        }
        mv.add(movie);
        return "Movie successfully added.";
    }
    public String addDirector(Director director){
        for(int i=0;i<dr.size();i++){
            Director d = dr.get(i);
            if(d.getName().equals(director.getName())){
                return "Director already added.";
            }
        }
        dr.add(director);
        return "Director successfully added.";
    }
    public String addMovieDirectorPair(String movie, String director){
        Movie m = null;
        Director d = null;
        for(int i=0;i<mv.size();i++){
            if(mv.get(i).getName().equals(movie)){
                m = mv.get(i);
            }
        }
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(director)){
                d = dr.get(i);
            }
        }

        if(!mp.containsKey(d)){
            ArrayList<Movie> ar = new ArrayList<>();
            ar.add(m);
            mp.put(d,ar);
            return "Pair added successfully";
        }
        ArrayList<Movie> mov = mp.get(d);
        mov.add(m);
        mp.put(d,mov);
        return "Pair added successfully.";
    }
    public Movie getMovieByName(String movie){

        for(int i=0;i<mv.size();i++){
            if(mv.get(i).getName().equals(movie)){

                return mv.get(i);
            }
        }
        return null;
    }
    public Director getDirectorByName(String director){
        for(int i=0;i<dr.size();i++){
            if(mv.get(i).getName().equals(director)){

                return dr.get(i);
            }
        }
        return null;
    }
    public List<String> getMoviesByDirectorName(String director){

        Director d=null;
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(director)){
                d=dr.get(i);
                break;
            }
        }
        List<String> res=new ArrayList<>();
        ArrayList<Movie> ar=mp.get(d);
        for(int i=0;i<ar.size();i++){
            res.add(ar.get(i).getName());
        }
        return res;
    }
    public List<String> findAllMovies(){
        List<String> res=new ArrayList<>();
        for(int i=0;i<mv.size();i++){
            res.add(mv.get(i).getName());
        }
        return res;
    }
    public String deleteDirectorByName(String name){
        Director d=null;
        for(int i=0;i<dr.size();i++){
            if(dr.get(i).getName().equals(name)){
                d=dr.get(i);
                break;
            }
        }
        dr.remove(d);
        ArrayList<Movie>ar =mp.get(d);
        mp.remove(d);
        for(int i=0;i<ar.size();i++){
            mv.remove(ar.get(i));
        }
        return "movie deleted sucessfully";
    }
    public String deleteAllDirectors(){
        for(int i=0;i<dr.size();i++){
            ArrayList<Movie> ar=mp.get(i);
            for(int j=0;j<ar.size();j++){
                mv.remove(ar.get(j));
            }
        }
        dr.clear();
        mp.clear();
        return "Data cleared sucessfully";
    }
}



