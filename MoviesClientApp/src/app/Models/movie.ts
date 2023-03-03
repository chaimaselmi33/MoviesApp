import { Actor } from "./actor";
import { Category } from "./category";

export class Movie {
  mv_id:number;
  mvTitle!:string;
  mv_descrip!:string;
  mv_imdbRate!:number;
  mv_pub_date!:Date;
  mv_duration!:Date;
  movieImg!:string;
  mv_poster!:string;
  actors!: Actor[];
  category!: Category;

  constructor(mv_id:number,mv_title:string, mv_descrip:string,mv_imdbRate:number,mv_pub_date:Date,mv_duration:Date,
  actor: Actor[], category: Category)
  {
    this.mv_id = mv_id;
    this.mvTitle = mv_title;
    this.mv_descrip = mv_descrip;
    this.mv_imdbRate = mv_imdbRate;
    this.mv_pub_date = mv_pub_date;
    this.mv_duration = mv_duration;
    this.actors = actor;
    this.category = category;
  }
}
