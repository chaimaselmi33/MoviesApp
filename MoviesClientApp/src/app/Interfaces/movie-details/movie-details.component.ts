import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Movie } from 'src/app/Models/movie';
import { MovieService } from 'src/app/Services/movie.service';

@Component({
  selector: 'app-movie-details',
  templateUrl: './movie-details.component.html',
  styleUrls: ['./movie-details.component.scss']
})
export class MovieDetailsComponent implements OnInit {

  id!: number;
  movie!: Movie;
  matchedCategoryMovies!: Movie[];
  similarMovies: Movie[] = [];
  hours!:string;
  minutes!:string;
  actors:string[] = []

  constructor(private activatedRoute: ActivatedRoute, private movieService: MovieService, private router: Router) {
    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit(): void {
    this.getMovie();
    this.getSimilarMovies();
  }

  getMovie() {
    let time:string[];
    this.id = this.activatedRoute.snapshot.params['id'];
    this.movieService.getMovie(this.id).subscribe(res => {
      res.movieImg = "data:image/jpeg;base64," + res.movieImg;
      this.movie = res;
      this.movie.actors.forEach(ac => {
        this.actors.push(ac.ac_name)
        })
      time = this.movie.mv_duration.toLocaleString().split(':')
      this.hours = time[0].slice(1,2);
      this.minutes = time[2]
    })
  }

  getSimilarMovies() {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.movieService.getMovie(this.id).subscribe(mvRes => {
      this.movieService.getAllMovies().subscribe(res => {
        this.matchedCategoryMovies = res.filter(m => m.category.cat_name == mvRes.category.cat_name)
        for (let i = 0; i < 3; i++) {
          this.similarMovies.push(this.matchedCategoryMovies[Math.floor(Math.random() * this.matchedCategoryMovies.length)])
        }
      })
    })

  }

  navigate(id: number) {
    this.router.navigateByUrl("/movie/" + id)
  }

}
