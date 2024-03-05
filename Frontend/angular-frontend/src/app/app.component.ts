import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit{
  title = 'angular-frontend';
  csvForm: FormGroup = this.fb.group({
    csvFile: ['', [Validators.required, this.validateFileExtension]],
  });
  constructor(private fb: FormBuilder) {}
  ngOnInit(): void {}

  validateFileExtension(control: any): { [key: string]: any } | null {
    const allowedExtensions = ['csv'];
    const fileName: string = control.value;
    const extension = fileName?.split('.').pop()?.toLowerCase();

    if (!allowedExtensions.includes(extension)) {
      return { invalidExtension: true };
    }

    return null;
  }
  
  onSubmit(): void {
    if (this.csvForm.valid) {
      // Process the form data here
      console.log('Submitted CSV file:', this.csvForm.get('csvFile').value);
    }
  }
}
