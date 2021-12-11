import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { UsersService } from 'src/app/services/users.service';
import { usersModels } from 'src/app/models/UsersModels'; 
@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {
  usersModel:usersModels[]=[];
  registrationForm!: FormGroup;
  constructor(private fb: FormBuilder, private UsersService: UsersService) { }

  ngOnInit(): void {
    this.registrationForm = this.fb.group({
      name:[''],
      lastName:[''],
      userName: [''],
      email: [''],
      password:[''],
      description:['']
    })
  }
  register(){ 
    console.log(this.registrationForm.value)
    this.UsersService.usersRegister(this.registrationForm.value).subscribe((data:any)=> {
      
      console.log(data);
      
    })
  }
}
