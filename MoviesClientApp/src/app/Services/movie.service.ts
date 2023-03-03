import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Movie } from '../Models/movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  baseURL = "http://localhost:8080/movie"

  constructor(private http:HttpClient) { }

  getAllMovies()
  {
    return this.http.get<Movie[]>(this.baseURL + "/get-movies")
  }

  getMovie(id:any): Observable<Movie>
  {
    return this.http.get<Movie>(this.baseURL + "/get-movie/" + id)
  }

  searchMoviesByTitle(title : string){

    let queryParam = new HttpParams();
    queryParam = queryParam.append('title', title);
    return this.http.get<Movie[]>(this.baseURL + "/search-by-title", {params: queryParam});
  }

  getMoviesByCat(cat:string)
  {
    return this.http.get<Movie[]>(this.baseURL + "/get-moviesBy-cat/" + cat)
  }

  getMoviePages(pageNo:any)
  {
    let queryParam = new HttpParams();
    queryParam = queryParam.append('page', pageNo);
    return this.http.get<any>(this.baseURL + "/MoviePaging", {params:queryParam});
  }

}
