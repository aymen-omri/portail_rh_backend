import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { error } from 'console';
import { Employee } from 'src/app/models/employee';
import { NewCompteService } from 'src/app/services/newCompte/new-compte.service';

@Component({
  selector: 'app-demande-details',
  templateUrl: './demande-details.component.html',
  styleUrls: ['./demande-details.component.css']
})
export class DemandeDetailsComponent implements OnInit {

  constructor(private route: ActivatedRoute, private demandeService: NewCompteService) { }

  ngOnInit(): void {
    this.getDemandeById();
  }

  id = Number(this.route.snapshot.paramMap.get('id'));
  demande: Employee | undefined;

  getDemandeById() {
    this.demandeService.getDemandeById(this.id).subscribe({
      next: (value: any) => {
        this.demande = value;
        console.log(value);
      },
      error: (err) => {
        alert("Demande not found");
      },
      complete: () => {
        console.log("Complete!")
      }
    })
  }

  acceptDemande() {
    this.demandeService.acceptDemande(this.id).subscribe({
      next: (value: any) => {
        alert("Demande acceptée!")
      },
      error: (err) => {
        console.log(err);
      }
    })
  }

  declineDemande() {
    this.demandeService.declineDemande(this.id).subscribe({
      next: (value: any) => {
        alert("Demande rejetée!")
      },
      error: (err) => {
        console.log(err);
      }
    })
  }
}
