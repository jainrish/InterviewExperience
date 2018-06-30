import { Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
  headers : new HttpHeaders({'Content-Type' : 'application/json'})
}

@Injectable()
export class EnumsService{

  private visaTypes;
  private consulates;

  constructor(private http:HttpClient) { this.initialize(); }

  private initialize() {
    this.consulates = this.http.get('/server/enums/consulates');
    this.visaTypes = this.http.get('/server/enums/visaTypes');
  }

  public getVisaTypes() {
    return this.visaTypes;
  }

  public getConsulates() {
    return this.consulates;
  }
}
