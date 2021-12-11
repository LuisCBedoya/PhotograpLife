import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule } from '@angular/forms';
import{ HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserRegistrationComponent } from './componentes/user-registration/user-registration.component';
import { HomepageComponent } from './componentes/homepage/homepage.component';
import { NavbarComponent } from './componentes/navbar/navbar.component';
import { FooterComponent } from './componentes/footer/footer.component';
import { UserProfileComponent } from './componentes/user-profile/user-profile.component';
import { LoginFormComponent } from './componentes/login-form/login-form.component';
import { PublicationsComponent } from './componentes/publications/publications.component';


@NgModule({
  declarations: [
    AppComponent,
    UserRegistrationComponent,
    HomepageComponent,
    NavbarComponent,
    FooterComponent,
    UserProfileComponent,
    LoginFormComponent,
    PublicationsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
