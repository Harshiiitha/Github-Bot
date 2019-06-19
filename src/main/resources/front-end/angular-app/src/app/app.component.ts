import { Component } from '@angular/core';
import { UserService } from './user.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-app';
  items =[];

  constructor(private userService:UserService){}

ngOnInit() {
  
}
getUser(username:String)
{
  this.userService.getAllUsers(username).subscribe((data:any) => {
    data = data.items;
     console.log(data);
    this.items = data;

  })
}

getAllRepos()
{
  this.userService.getRepos().subscribe((data:any) => {
    //data = data.items;
     console.log(data);
    //this.items = data;

  })
}


}
