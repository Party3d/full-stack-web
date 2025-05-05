import { Component, OnInit } from '@angular/core';
import { ItemService, Item } from '../../services/item.service';
import { CommonModule } from '@angular/common';

@Component({
  standalone: true,
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  imports: [
    CommonModule,
  ]
})
export class ItemListComponent implements OnInit {
  itens: Item[] = [];

  constructor(private itemService: ItemService) {}

  ngOnInit() {
    this.loadItens();
  }

  loadItens() {
    this.itemService.getAll().subscribe(data => this.itens = data);
  }

  deleteItem(id: number) {
    this.itemService.delete(id).subscribe(() => this.loadItens());
  }
}


