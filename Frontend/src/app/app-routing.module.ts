import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './componentes/homepage/homepage.component';
import { LoginFormComponent } from './componentes/login-form/login-form.component';
import { PublicationsComponent } from './componentes/publications/publications.component';
import { UserRegistrationComponent } from './componentes/user-registration/user-registration.component';

const routes: Routes = [

  {
    path:'',
    component: HomepageComponent
  },
  {
    path:'Registrarse',
    component: UserRegistrationComponent
  },
  {
    path:'Login',
    component: LoginFormComponent
  },
  {
    path:'Publicaciones',
    component: PublicationsComponent
  },
  {
    path: '**',
    redirectTo: ''
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
