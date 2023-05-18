import { Component, OnInit } from '@angular/core';
import { Employee } from 'src/app/models/employee';
import { NewCompteService } from 'src/app/services/newCompte/new-compte.service';

@Component({
  selector: 'app-demandes',
  templateUrl: './demandes.component.html',
  styleUrls: ['./demandes.component.css']
})
export class DemandesComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private newCompteService: NewCompteService) { }

  ngOnInit() {
    this.getEmployees();
  }

  getEmployees() {
    this.newCompteService.getEmployees().subscribe(
      (data: any) => {
        console.log(data);
        this.employees = data.body;
        this.employees = this.employees.filter((dem: any) => dem.status == 1);
      },
      error => {
        console.log('Error retrieving employees:', error);
      }
    );
  }





}
