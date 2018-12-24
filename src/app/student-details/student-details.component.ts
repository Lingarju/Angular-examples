import { Component, OnInit } from '@angular/core';
import { Student } from '../../Student';
import { DataService } from '../data.service';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css']
})
export class StudentDetailsComponent implements OnInit {
  student = new Student;
  submitted = false;

  data: any;
  constructor(private dataService: DataService) { }

  ngOnInit() {
    this.dataService.getAllStudents().subscribe(data => {this.data = data;
      console.log(this.data);
    });
  }

}
