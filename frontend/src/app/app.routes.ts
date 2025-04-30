import { Routes } from '@angular/router';
import { LoginPageComponent } from './ui/login-page/login-page.component';
import { authGuard } from './guards/auth/auth.guard';
import { SignupPageComponent } from './ui/signup-page/signup-page.component';
import { QuizzesPageComponent } from './ui/quizzes-page/quizzes-page.component';
import { guestGuard } from './guards/guest/guest.guard';

export const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'quizzes',
  },
  {
    path: 'login',
    component: LoginPageComponent,
    canActivate: [guestGuard],
  },
  {
    path: 'signup',
    component: SignupPageComponent,
    canActivate: [guestGuard],
  },
  {
    path: 'quizzes',
    component: QuizzesPageComponent,
    canActivate: [authGuard],
  },
];
