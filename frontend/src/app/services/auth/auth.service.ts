import { HttpClient } from '@angular/common/http';
import { effect, inject, Injectable, signal } from '@angular/core';
import { environment } from '../../../environments/environment';
import Auth from '../../models/auth.model';
import User from '../../models/user.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor() {
    effect(() => {
      if (this._auth() == null) this._user.set(null);
    });

    const auth = this.retrieveAuth();
    if (auth) {
      queueMicrotask(() => this.login(auth));
    }
  }

  private readonly http = inject(HttpClient);
  private _auth = signal<Auth | null>(null);
  private _user = signal<User | null>(null);

  readonly auth = this._auth.asReadonly();
  readonly user = this._user.asReadonly();

  retrieveAuth(): Auth | null {
    const auth = localStorage.getItem('auth');
    if (!auth) {
      return null;
    }
    return JSON.parse(auth) as Auth;
  }

  login(auth: Auth): void {
    const url = environment.apiUrl + '/users/me';
    const req = this.http.get<User>(url, {
      headers: {
        Authorization: `Basic ${btoa(`${auth.email}:${auth.password}`)}`,
      },
    });
    req.subscribe({
      next: (user) => {
        this._auth.set(auth);
        this._user.set(user);
        localStorage.setItem('auth', JSON.stringify(auth));
      },
    });
  }

  signup(data: { name: string; email: string; password: string }): void {
    const url = environment.apiUrl + '/users';
    const req = this.http.post<User>(url, data);
    req.subscribe({
      next: () => {
        this.login({
          email: data.email,
          password: data.password,
        });
      },
    });
  }

  logout(): void {
    this._auth.set(null);
    this._user.set(null);
    localStorage.removeItem('auth');
  }
}
