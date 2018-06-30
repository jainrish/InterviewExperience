import { Component, OnInit } from '@angular/core';
import { EnumsService } from '../../services/enums.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  public visaTypes;
  constructor(private enumsService: EnumsService) { }

  ngOnInit() {
    this.getVisaTypes();
  }


  getVisaTypes() {
    this.enumsService.getVisaTypes().subscribe( 
      data => {this.visaTypes = data},
      err => console.error(err),
      () => console.log(this.visaTypes)
    );
  }

}
