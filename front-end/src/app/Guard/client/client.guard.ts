import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientGuard implements CanActivate {

  constructor(private router: Router) {}

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
    const userRole = localStorage.getItem('role');
    if (userRole === 'client') {
      return true; // Allow navigation to the route
    } else {
      // Redirect to another route or show an error message
      this.router.navigate(['/']); // Redirect to the home page or another route
      return false; // Prevent navigation to the route
    }
  }
}
