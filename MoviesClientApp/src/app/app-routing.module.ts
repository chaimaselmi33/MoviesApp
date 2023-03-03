import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Interfaces/home/home.component';
import { MovieDetailsComponent } from './Interfaces/movie-details/movie-details.component';
import { MoviesComponent } from './Interfaces/movies/movies.component';
import { SearchMovieComponent } from './Interfaces/search-movie/search-movie.component';

const routes: Routes = [
  {path:"", component:HomeComponent},
  {path:"movie/:id", component:MovieDetailsComponent},
  {path:"search", component:SearchMovieComponent},
  {path:"movies", component:MoviesComponent},
  {path:"movies/:cat", component:MoviesComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
