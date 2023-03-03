import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule} from '@angular/common/http';
import { HomeComponent } from './Interfaces/home/home.component';
import { MovieDetailsComponent } from './Interfaces/movie-details/movie-details.component';
import { SearchMovieComponent } from './Interfaces/search-movie/search-movie.component'
import { FormsModule } from '@angular/forms';
import { MoviesComponent } from './Interfaces/movies/movies.component';
import { NavbarComponent } from './Interfaces/navbar/navbar.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    MovieDetailsComponent,
    SearchMovieComponent,
    MoviesComponent,
    NavbarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
