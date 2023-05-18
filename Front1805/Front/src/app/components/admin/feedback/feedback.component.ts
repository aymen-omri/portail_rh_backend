import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-feedback',
  templateUrl: './feedback.component.html',
  styleUrls: ['./feedback.component.css']
})

export class FeedbackComponent {
  feedbackType: string = '';
  suggestion: string = '';
  problem: string = '';
  avis: string = '';
  satisfaction: number = 0;
  title: string = '';
  description: string = '';

  onFeedbackTypeChange(event: any) {
    this.feedbackType = event.target.value;
  }
  
  onSubmit() {
    console.log(this.feedbackType);
    if (this.feedbackType == 'improvement-suggestion') {
      console.log(this.suggestion, this.description);
    } else if (this.feedbackType == 'problem') {
      console.log(this.problem, this.description);
    } else if (this.feedbackType == 'avis') {
      console.log(this.avis, this.description, this.satisfaction);
    } else if (this.feedbackType == 'other') {
      console.log(this.title, this.description);
    }
  }
}