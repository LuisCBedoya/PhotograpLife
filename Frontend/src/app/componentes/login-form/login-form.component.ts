import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {
  loginForm!: FormGroup;
  constructor(private fb: FormBuilder,private LoginService: LoginService ) { }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      userName: [''],
      password:['']
    })
  }
  login(){
    console.log(this.loginForm.value)
    this.LoginService.userlogin(this.loginForm.value).subscribe((data:any)=> {
      
      console.log(data)
    })
  }

}
