import { HttpInterceptorFn } from '@angular/common/http';
import { inject } from '@angular/core';
import { environment } from '../../../environments/environment';
import { AuthService } from '../../services/auth/auth.service';

export const authInterceptor: HttpInterceptorFn = (req, next) => {
  const authService = inject(AuthService);
  const auth = authService.auth();
  if (auth && req.url.startsWith(environment.apiUrl)) {
    const cloned = req.clone({
      headers: req.headers.set(
        'Authorization',
        `Basic ${btoa(`${auth.email}:${auth.password}`)}`
      ),
    });
    return next(cloned);
  }
  return next(req);
};
