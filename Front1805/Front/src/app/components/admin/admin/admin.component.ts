import { Component,Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  @Input() sideNavStatus: boolean = false;

  userRole: string = "ADMIN"; // or "ADMIN"

  list = [
      {
        number: '1',
        name: 'Home',
        icon: 'fa-solid fa-house',
        navigation: '',
      },

      {
        number: '2',
        name: 'Les demandes',
        icon: 'fa-solid fa-clipboard-check',
        navigation: 'dashboard/demandes',
      },

      {
        number: '3',
        name: 'Liste des employés',
        icon: 'fa-solid fa-users',
        navigation: '',
      },

      {
        number: '4',
        name: 'Statistiques',
        icon: 'fa-solid fa-chart-line',
        navigation: '',
      },

      {
        number: '5',
        name: 'Feedback',
        icon: 'fa-solid fa-comment',
        navigation: '',
      },

      {
        number: '6',
        name: 'Settings',
        icon: 'fa-solid fa-gear',
        navigation: '',
      },

  ]

  list_employee = [
    {
      number: '1',
      name: 'Bienvenue',
      icon: 'fa-solid fa-house',
      navigation: 'dashboard/main',
    },

    {
      number: '2',
      name: 'Demande congé',
      icon: 'fa-sharp fa-solid fa-calendar-days',
      navigation: 'dashboard/demande_de_congé',
    },

    {
      number: '3',
      name: 'Avance sur salaire',
      icon: 'fa-solid fa-money-check-dollar',
      navigation: 'dashboard/demande_d\'avance_sur_salaire',
    },

    {
      number: '4',
      name: 'Déclaration dépenses',
      icon: 'fa-solid fa-money-bill',
      navigation: 'dashboard/déclaration_des_frais_professionnels',
    },

    {
      number: '5',
      name: 'Modif. infos perso',
      icon: 'fa-solid fa-gear',
      navigation: 'dashboard/profile',
    },

    {
      number: '6',
      name: 'Feedback',
      icon: 'fa-solid fa-comment',
      navigation: 'dashboard/feedback',
    },

    {
      number: '6',
      name: 'À propos',
      icon: 'fa-solid fa-circle-info',
      navigation: 'dashboard/about',
    },
]

  constructor(private router: Router) { }

  
  navigateToPage(route: string) {
    this.router.navigate([route]);
  }

  ngOnInit(): void {
  }

}
