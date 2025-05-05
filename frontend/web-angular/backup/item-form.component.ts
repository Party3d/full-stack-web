import { Component } from '@angular/core';
import { ItemService, Item } from '../../services/item.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  standalone: true,
  selector: 'app-item-form',
  templateUrl: './item-form.component.html',
  imports:[
    CommonModule,
    FormsModule,
  ]
})
export class ItemFormComponent {
  item: Item = { nome: '', descricao: '' };

  constructor(private itemService: ItemService) {}

  salvar() {
    this.itemService.create(this.item).subscribe(() => {
      alert('Item salvo com sucesso!');
      this.item = { nome: '', descricao: '' };
    });
  }
}


