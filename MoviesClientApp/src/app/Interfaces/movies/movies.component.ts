import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Route, Router } from '@angular/router';
import { Category } from 'src/app/Models/category';
import { Movie } from 'src/app/Models/movie';
import { CategoryService } from 'src/app/Services/category.service';
import { MovieService } from 'src/app/Services/movie.service';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.scss']
})
export class MoviesComponent implements OnInit {

  categories!: Category[];
  catParam!: string;
  movies!: Movie[];
  zeroIndex: number = 0;
  totalMoviesPages!: number;
  totalMvByCatPages!: number;
  allmovies!: Movie[];
  catPagesArray!: Number[];
  moviePagesArray !: number[];
  actors:string[]=[]

  constructor(private catService: CategoryService, private movieService: MovieService, private activatedRoute: ActivatedRoute, private router: Router) {

    this.router.routeReuseStrategy.shouldReuseRoute = function () {
      return false;
    };
  }

  ngOnInit(): void {
    this.getAllCat();
    this.catParam = this.activatedRoute.snapshot.params['cat']
    if (!this.catParam) {
      this.getAllMovies(this.zeroIndex);
    }
    else {
      this.getMoviesByCategory()
    }

  }

  getAllCat() {
    this.catService.getAllCategories().subscribe(res => {
      console.log("all categories", res);
      this.categories = res;
    })
  }

  getMoviesByCategory() {
    let size = 6;
    this.movieService.getMoviesByCat(this.catParam).subscribe(res => {
      console.log("movies by cat", res);
      this.movies = res.slice(0, size);
      if (res.length > size) {
        if (res.length % size != 0) {
          this.totalMvByCatPages = Math.trunc(res.length / size) + 1;
        }
        else {
          this.totalMvByCatPages = Math.trunc(res.length / size)
        }
      }
      this.catPagesArray = new Array(this.totalMvByCatPages);
    })
  }

  getCatRequestedPage(pageNo: number) {
    let size = 6;
    let startPos = pageNo * size;
    console.log(startPos);
    this.router.navigateByUrl("/movies/" + this.catParam);
    this.movieService.getMoviesByCat(this.catParam).subscribe(res => {
      if (res.slice(startPos, res.length).length < size) {
        this.movies = res.slice(startPos, res.length);
        console.log("next", res.slice(startPos, res.length))
      }
      else {
        this.movies = res.slice(startPos, startPos + size);
      }
    })
  }

  getAllMovies(pageNo: number) {
    this.movieService.getMoviePages(pageNo).subscribe(
      res => {
        this.movies = res.movies;
        console.log(this.movies)
        this.totalMoviesPages = res.totalPages;
        this.moviePagesArray = new Array(this.totalMoviesPages)
      })
  }

  navigate(id: number) {
    this.router.navigateByUrl("/movie/" + id)
  }

}
