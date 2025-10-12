import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () =>
      import('../index/index').then(m => m.Index)
  },
  {
    path: 'citas',
    loadComponent: () =>
      import('../citas/citas').then(m => m.CitasComponent)
  },
  {
    path: 'login',
    loadComponent: () =>
      import('../login/login').then(m => m.LoginComponent)
  },
  {
    path: 'dashboard',
    loadComponent: () =>
      import('../dashboard/dashboard').then(m => m.DashboardComponent)
  },
  { path: '**', redirectTo: '' } // fallback
];
