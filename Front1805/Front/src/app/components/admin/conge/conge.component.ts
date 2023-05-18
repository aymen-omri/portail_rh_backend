import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CongeService } from 'src/app/services/conge.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-conge',
  templateUrl: './conge.component.html',
  styleUrls: ['./conge.component.css']
})
export class CongeComponent {

  constructor(private congeService: CongeService, private location: Location) { }

  goBack(): void {
    this.location.back();
  }

  onSubmit(form: NgForm) {
    const formData = {
      dateDebut: form.value['start-date'],
      dateFin: form.value['end-date'],
      type: {
        id: 1,
        label: 'Annuel'
      },
      raison: form.value.reason
    };
    this.congeService.postFormData(formData).subscribe(
      response => {
        console.log(response);
      },
      error => {
        console.error(error);
      }
    );
  }
}