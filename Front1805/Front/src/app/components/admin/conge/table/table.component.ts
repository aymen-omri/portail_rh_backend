import { Component, OnInit } from '@angular/core';
import { DemandeConge } from 'src/app/models/demande-conge';
import { GetCongeService } from 'src/app/services/conge/get-conge.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {
  demandesConge: DemandeConge[] = [];
  currentPage = 1;
  pageSize = 10;

  constructor(private getCongeService: GetCongeService, private location: Location) { }

  goBack(): void {
    this.location.back();
  }
  
  ngOnInit(): void {
    this.getAllDemandeConge();
  }

  getAllDemandeConge(): void {
    this.getCongeService.getAllDemandeConge()
      .subscribe(
        (demandesConge: DemandeConge[]) => {
          this.demandesConge = demandesConge.map((demande: DemandeConge) => {
            demande.dateDebut = new Date(demande.dateDebut);
            demande.dateFin = new Date(demande.dateFin);
            demande.dateSoumission = new Date(demande.dateSoumission);
            demande.dateAcceptation = new Date(demande.dateAcceptation);
            demande.dateRejet = new Date(demande.dateRejet);
            return demande;
          });
        },
        (error) => {
          console.log(error);
        }
      );
  }
  deleteDemandeConge(id: number): void {
    this.getCongeService.deleteDemandeConge(id)
      .subscribe(
        () => {
          // Remove the deleted demandeConge from the array
          this.demandesConge = this.demandesConge.filter(demande => demande.id !== id);
        },
        (error) => {
          console.log(error);
        }
      );
  }
}