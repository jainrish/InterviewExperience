import { Component, OnInit } from '@angular/core';
import { EnumsService } from '../../services/enums.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public visaTypes;
  public consulates;
  constructor(private enumsService: EnumsService) { }

  ngOnInit() {
    this.getVisaTypes();
    this.getConsulates();
  }


  getVisaTypes() {
    this.enumsService.getVisaTypes().subscribe( 
      data => {this.visaTypes = data},
      err => console.error(err),
      () => console.log("Fetched "+ this.visaTypes.length +" visaTypes")
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
