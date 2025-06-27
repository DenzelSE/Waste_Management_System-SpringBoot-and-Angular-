import { Component, OnInit } from '@angular/core';
import { WasteService } from '../../services/waste.service';

@Component({
  selector: 'app-waste-items',
  templateUrl: './waste-items.component.html'
})
export class WasteItemsComponent implements OnInit {
  wasteItems: any[] = [];

  constructor(private wasteService: WasteService) {}

  ngOnInit(): void {
    this.wasteService.getAllWasteItems().subscribe(data => {
      this.wasteItems = data;
    });
  }
}
