import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Category } from 'src/app/Models/category';
import { Movie } from 'src/app/Models/movie';
import { MovieService } from 'src/app/Services/movie.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  allmovies!: Movie[];
  actionMovies: Movie[] = new Array();
  thrillerMovies: Movie[] = new Array();
  animationMovies: Movie[] = new Array();

  constructor(private movieService: MovieService, private router: Router) { }

  ngOnInit(): void {
    this.getMoviesByCategory();
  }

  getMoviesByCategory() {
    this.movieService.getAllMovies().subscribe(res => {
      res.map(m => {
        m.movieImg = "data:image/jpeg;base64," + m.movieImg
      })
      this.allmovies = res;
      this.allmovies.filter(m => {
        if (m.category.cat_name == "Action" && this.actionMovies.length < 6)
          this.actionMovies.push(m);
        else if (m.category.cat_name == "Thriller" && this.thrillerMovies.length < 6)
          this.thrillerMovies.push(m);
        else if (m.category.cat_name == "Animation" && this.animationMovies.length < 6)
          this.animationMovies.push(m);
      })
    })
  }

  navigate(id: number) {
    this.router.navigateByUrl("/movie/" + id)
  }

}


