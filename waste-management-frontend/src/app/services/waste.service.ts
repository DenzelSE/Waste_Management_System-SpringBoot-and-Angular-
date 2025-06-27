import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class WasteService {
  private baseUrl = 'http://localhost:8080/api'; // change this if different

  constructor(private http: HttpClient) {}

  getAllWasteItems(): Observable<any> {
    return this.http.get(`${this.baseUrl}/waste-items`);
  }

  getAllCategories(): Observable<any> {
    return this.http.get(`${this.baseUrl}/categories`);
  }

  addWasteItem(item: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/waste-items`, item);
  }
}
