import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { LoginComponent } from './components/login/login.component';
import { DashboardParentComponent } from './components/admin/dashboard-parent/dashboard-parent.component';
import { DemandesComponent } from './components/admin/demandes/demandes.component';
import { ProfileComponent } from './components/admin/profile/profile.component';
import { CongeComponent } from './components/admin/conge/conge.component';
import { SalaryComponent } from './components/admin/salary/salary.component';
import { ExpensesComponent } from './components/admin/expenses/expenses.component';
import { FeedbackComponent } from './components/admin/feedback/feedback.component';
import { AboutComponent } from './components/admin/about/about.component';
import { HistoryComponent } from './components/admin/history/history.component';
import { TableComponent } from './components/admin/conge/table/table.component';
import { MainComponent } from './components/admin/conge/main/main.component';
import { SignupComponent } from './components/signup/signup.component';
import { AdminDashboardComponent } from './components/admin/admin/admin-dashboard/admin-dashboard.component';
import { DemandeDetailsComponent } from './components/admin/demande-details/demande-details.component';
import { AdminGuard } from './guards/admin.guard';
import { AuthGuard } from './guards/auth.guard';


const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  {
    path: 'dashboard',
    component: DashboardParentComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: 'demandes',
        component: DemandesComponent,
        canActivate:[AdminGuard]
      },
      {
        path: 'details/:id',
        component: DemandeDetailsComponent,
        canActivate:[AdminGuard]
      },
      {
        path: 'profile',
        component: ProfileComponent
      },
      {
        path: 'demande_de_congé',
        component: MainComponent
      },
      {
        path: 'demande_de_congé_list',
        component: TableComponent,
      },
      {
        path: 'demande_de_congé_new',
        component: CongeComponent
      },
      {
        path: 'demande_d\'avance_sur_salaire',
        component: SalaryComponent
      },
      {
        path: 'déclaration_des_frais_professionnels',
        component: ExpensesComponent
      },
      {
        path: 'feedback',
        component: FeedbackComponent
      },
      {
        path: 'about',
        component: AboutComponent
      },
      {
        path: 'main',
        component: HistoryComponent
      }

    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
