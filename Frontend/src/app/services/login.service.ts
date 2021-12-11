import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, tap } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  baseUrl = environment.baseURL;
  constructor(private http: HttpClient) { }


  userlogin(data: any) {
    return this.http.post(`${this.baseUrl}/api/user/login`, data).pipe(
      tap((data: any) => {
        if (data.mensaje == "Se accedió correctamente") {
          localStorage.setItem("token", data.token)
        }
      }),
      map(res => res)
    )
  }
}

