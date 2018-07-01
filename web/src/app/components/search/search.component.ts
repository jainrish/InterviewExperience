import { Component, OnInit } from '@angular/core';
import { EnumsService } from '../../services/enums.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public interviewTypes;
  public countries;
  public allVisaTypes;
  public visaTypes;
  public consulates;
  public selectedCountry;
  public selectedVisaType;
  constructor(private enumsService: EnumsService) { }

  ngOnInit() {
    this.interviewTypes = ["Visa", "Job"];
    this.countries = ["USA", "UK"];
    this.visaTypes = [];
    this.getVisaTypes();
    this.getConsulates();
  }

  selectCountryChangeHandler (event: any) {
    this.selectedCountry = event.target.value;
    
    var allVisaTypesLocal = [];
    this.allVisaTypes.forEach(function(visaType){
     if(visaType.country == event.target.value) {
      allVisaTypesLocal.push(visaType);
     }
  });
  this.visaTypes = allVisaTypesLocal;
    console.log("selected " + this.selectedCountry);
  }

  getVisaTypes() {
    this.enumsService.getVisaTypes().subscribe( 
      data => {this.allVisaTypes = data},
      err => console.error(err),
      () => console.log("Fetched "+ this.allVisaTypes.length +" visaTypes")
    );
  } 

  getConsulates() {
    this.enumsService.getConsulates().subscribe( 
      data => {this.consulates = data},
      err => console.error(err),
      () => console.log("Fetched "+ this.consulates.length +" consulates")
    );
  }

}
