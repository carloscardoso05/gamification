import { Component, effect, inject, signal } from '@angular/core';
import Signup from '../../models/signup.model';
import { FormsModule } from '@angular/forms';
import { Eye, EyeClosed, LucideAngularModule } from 'lucide-angular';
import { AuthService } from '../../services/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup-page',
  imports: [FormsModule, LucideAngularModule],
  templateUrl: './signup-page.component.html',
  styleUrl: './signup-page.component.css',
  host: {
    class: 'flex flex-col items-center justify-center h-screen w-screen',
  },
})
export class SignupPageComponent {
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

  readonly signup: Signup = {
    email: '',
    password: '',
    name: '',
  };

  togglePasswordVisibility(): void {
    this.showPassword.update((prev) => !prev);
  }

  submit() {
    this.authService.signup(this.signup);
  }
}
