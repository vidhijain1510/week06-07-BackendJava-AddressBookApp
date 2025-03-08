import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../user.model'; // Adjust the path as necessary

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl = 'http://localhost:8080/addressbook'; // Adjust the base URL as necessary

  constructor(private httpClient: HttpClient) { }

  // Method to get all users
  getUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(`${this.baseUrl}/all`);
  }

  // Method to create a new user
  createUser (user: User): Observable<User> {
    return this.httpClient.post<User>(`${this.baseUrl}/add`, user);
  }

  // Method to get a user by ID
  getUserById(id: number): Observable<User> {
    return this.httpClient.get<User>(`${this.baseUrl}/get/${id}`);
  }

  // Method to update a user
  updateUser (id: number, user: User): Observable<User> {
    return this.httpClient.put<User>(`${this.baseUrl}/update/${id}`, user);
  }

  // Method to delete a user
  deleteUser (id: number): Observable<void> {
    return this.httpClient.delete<void>(`${this.baseUrl}/delete/${id}`);
  }
}