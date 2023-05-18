import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './components/admin/navbar/navbar.component';
import { SidebarComponent } from './components/admin/sidebar/sidebar.component';
import { LoginComponent } from './components/login/login.component';
import { DashboardParentComponent } from './components/admin/dashboard-parent/dashboard-parent.component';
import { DemandesComponent } from './components/admin/demandes/demandes.component';

import { AuthInterceptor } from './auth.interceptor';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { HttpClientModule } from '@angular/common/http';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ProfileComponent } from './components/admin/profile/profile.component';
import { CongeComponent } from './components/admin/conge/conge.component';
import { SalaryComponent } from './components/admin/salary/salary.component';
import { ExpensesComponent } from './components/admin/expenses/expenses.component';
import { FeedbackComponent } from './components/admin/feedback/feedback.component'
import { CommonModule } from '@angular/common';
import { AboutComponent } from './components/admin/about/about.component';
import { HistoryComponent } from './components/admin/history/history.component';
import { TableComponent } from './components/admin/conge/table/table.component';
import { MainComponent } from './components/admin/conge/main/main.component';
import { SignupComponent } from './components/signup/signup.component';
import { AdminComponent } from './components/admin/admin/admin.component';
import { AdminDashboardComponent } from './components/admin/admin/admin-dashboard/admin-dashboard.component';
import { DemandeDetailsComponent } from './components/admin/demande-details/demande-details.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    LoginComponent,
    DashboardParentComponent,
    DemandesComponent,
    ProfileComponent,
    CongeComponent,
    SalaryComponent,
    ExpensesComponent,
    FeedbackComponent,
    AboutComponent,
    HistoryComponent,
    TableComponent,
    MainComponent,
    SignupComponent,
    AdminComponent,
    AdminDashboardComponent,
    DemandeDetailsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    FormsModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
