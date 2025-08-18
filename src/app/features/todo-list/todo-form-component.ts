import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Todo } from '../../core/models/todo.model';

@Component({
  selector: 'app-todo-form',
  standalone: true,
  imports: [FormsModule], 
  templateUrl: './todo-form.component.html',
  styleUrls: ['./todo-form.component.css']
})
export class TodoFormComponent {
  public newTodo: string = ''; 

  @Output() add = new EventEmitter<Todo>();

  submit() {
    if (this.newTodo.trim()) {
      this.add.emit({ title: this.newTodo, completed: false });
      this.newTodo = '';
    }
  }
}
