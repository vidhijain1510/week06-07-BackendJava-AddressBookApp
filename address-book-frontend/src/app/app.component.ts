import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router'
import { CommonModule } from '@angular/common'; // Required for standalone components
import { UserListComponent } from './user-list/user-list.component'; // Adjust the path if needed

@Component({
  selector: 'app-root',
  standalone: true, // Mark AppComponent as standalone
  imports: [RouterOutlet,CommonModule, UserListComponent], // Ensure it's an array
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'your-app';
}