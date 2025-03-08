import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface User {
  id: number;
  name: string;
  phoneNumber: string;
  email: string;
  address: string;
  city: string;
  state: string;
  zipcode: string;
}

@Component({
  selector: 'app-user-list',
  standalone: true, // Ensure this is present
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users = [
    { id: 1, name: 'John Doe', phoneNumber: '1234567890', email: 'john@example.com', address: '123 Street', city: 'New York', state: 'NY', zipcode: '10001' },
    { id: 2, name: 'Jane Doe', phoneNumber: '9876543210', email: 'jane@example.com', address: '456 Avenue', city: 'Los Angeles', state: 'CA', zipcode: '90001' }
  ];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchUsers();
  }

  fetchUsers() {
    this.http.get<User[]>('http://localhost:8080/addressbook/all').subscribe(data => {
      this.users = data;
    });
  }

  editUser(id: number) {
    // Redirect to edit form with the selected user's ID
    console.log(`Editing user with ID: ${id}`);
    // You can navigate to an edit component or open a modal
  }

  deleteUser(id: number) {
    if (confirm('Are you sure you want to delete this user?')) {
      this.http.delete(`http://localhost:8080/addressbook/delete/${id}`).subscribe(() => {
        this.fetchUsers(); // Refresh the list after deletion
      });
    }
  }
}