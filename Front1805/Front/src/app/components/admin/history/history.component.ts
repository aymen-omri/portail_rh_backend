import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

    requests: any[] = [
    { id: 1, type: 'Leave', dateSubmitted: '2021-12-28', startDate: '2022-01-01', endDate: '2022-01-05', status: 'Approved' },
    { id: 2, type: 'Salary Advance', dateSubmitted: '2022-01-10', amount: 1000, status: 'Pending' },
    { id: 3, type: 'Leave', dateSubmitted: '2022-01-22', startDate: '2022-02-15', endDate: '2022-02-17', status: 'Rejected' },
  ];

  selectedRequest: any = null;

  showDetails(request: any): void {
    this.selectedRequest = request;
  }

  hideDetails(): void {
    this.selectedRequest = null;
  }
  constructor() { }

  ngOnInit(): void {
  }

}
