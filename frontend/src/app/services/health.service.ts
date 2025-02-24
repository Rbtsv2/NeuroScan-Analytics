import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HealthService {
  private apiUrl = 'http://localhost:8080/api/health'; // URL de l'API

  constructor(private http: HttpClient) {}

  getHealthData(): Observable<any> {
    return this.http.get<any>(this.apiUrl);
  }
}