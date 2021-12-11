import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsersService {
  baseUrl = environment.baseURL;
  constructor(private http: HttpClient) { }
  
   /**
 * Formulario de registro 
 * Esos datos deben ser enviado por la petición
 */
    usersRegister(data:any){
      return this.http.post(`${this.baseUrl}/api/user`,data)
    }
}
