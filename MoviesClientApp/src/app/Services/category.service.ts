import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Category } from '../Models/category';

@Injectable({
  providedIn: 'root'
})
export class CategoryService {

  baseURL = "http://localhost:8080/category"

  constructor(private http:HttpClient) { }

  getAllCategories()
  {
    return this.http.get<Category[]>(this.baseURL + "/get-cat")
  }

}
