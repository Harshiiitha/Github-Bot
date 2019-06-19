import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from  '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  getAllUsers(username1:String) {
     return this.http.get('https://api.github.com/search/users?q='+username1, this.httpOptions);
  }

  getRepos(){
    return this.http.get('https://api.github.com/users/ShahinaSk/repos',this.httpOptions);
  }
}
