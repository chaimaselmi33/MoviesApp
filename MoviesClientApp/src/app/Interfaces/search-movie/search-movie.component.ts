import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Movie } from 'src/app/Models/movie';
import { MovieService } from 'src/app/Services/movie.service';

@Component({
  selector: 'app-search-movie',
  templateUrl: './search-movie.component.html',
  styleUrls: ['./search-movie.component.scss']
})
export class SearchMovieComponent implements OnInit {

  //? assertion operator to solve possibly undefined property error
  movies !: Movie[];
  title!:string;

  constructor(private movieService: MovieService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log("title", this.title)
    this.movieService.searchMoviesByTitle(this.title).subscribe(
      (res: any) => {
        this.movies = res.movies
      }
    )
  }

  navigate(id: number) {
    this.router.navigateByUrl("/movie/" + id)
  }

  reset()
  {
   this.title = ''
  }

}
