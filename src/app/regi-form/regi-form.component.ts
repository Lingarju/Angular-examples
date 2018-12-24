import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators, NgForm } from '../../../node_modules/@angular/forms';
import { DataService } from '../data.service';
import { Observable } from '../../../node_modules/rxjs';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-regi-form',
  templateUrl: './regi-form.component.html',
  styleUrls: ['./regi-form.component.css']
})
export class RegiFormComponent {
  data: any;
  dataService: DataService;
  regiForm: FormGroup;
  firstName: String = '';
  lastName: String = '';
  address: String = '';
  dateOfBirth: String = '';
  gender: String = '';
  email: String = '';
  isAccepted: Number = 0;

  constructor(private fb: FormBuilder) {
    // To initialize FormGroup
    this.regiForm = fb.group({
      'firstName' : [null, Validators.required],
      'lastName' : [null, Validators.required],
      'address' : [null, Validators.compose([Validators.required, Validators.minLength(30), Validators.maxLength(500)])],
      'dateOfBirth' : [null, Validators.required],
      'gender': [null, Validators.required],
      'email': [null, Validators.compose([Validators.required, Validators.email])],
      'isAccepted': [null],
    });
  }
  // On Change event of Toggle Button
  onChange(event: any) {
    if (event.checked === true) {
      this.isAccepted = 1;
    } else {
      this.isAccepted = 0;
    }
  }
  // Executed When Form Is Submitted
  onFormSubmit(form: NgForm) {
    console.log(form);
  }
  registerStudent(): Observable<any> {
    return this.dataService.registerStudent().pipe(map(this.data));
  }
}
