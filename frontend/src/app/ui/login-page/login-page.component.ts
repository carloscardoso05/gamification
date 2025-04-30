import { Component, effect, inject, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { Eye, EyeClosed, LucideAngularModule } from 'lucide-angular';
import Auth from '../../models/auth.model';
import { AuthService } from '../../services/auth/auth.service';
@Component({
  selector: 'app-login-page',
  imports: [LucideAngularModule, FormsModule],
  templateUrl: './login-page.component.html',
  styleUrl: './login-page.component.css',
  host: {
    class: 'flex flex-col items-center justify-center h-screen w-screen',
  },
})
export class LoginPageComponent {
  constructor() {
    effect(() => {
      if (this.authService.auth()) {
        this.router.navigate(['/']);
      } 
    });
  }
  private readonly authService = inject(AuthService);
  private readonly router = inject(Router);
  readonly showPassword = signal(false);
  readonly Eye = Eye;
  readonly EyeClosed = EyeClosed;

  readonly auth: Auth = {
    email: '',
    password: '',
  };

  togglePasswordVisibility(): void {
    this.showPassword.update((prev) => !prev);
  }

  login() {
    this.authService.login(this.auth);
  }
}
